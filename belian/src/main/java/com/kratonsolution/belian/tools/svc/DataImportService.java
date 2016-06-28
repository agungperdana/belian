/**
 * 
 */
package com.kratonsolution.belian.tools.svc;

import java.io.InputStream;
import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.accounting.dm.CurrencyRepository;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductCategory;
import com.kratonsolution.belian.inventory.dm.ProductCategoryRepository;
import com.kratonsolution.belian.inventory.dm.ProductCost;
import com.kratonsolution.belian.inventory.dm.ProductCostType;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.ProductPriceType;
import com.kratonsolution.belian.inventory.dm.ProductRepository;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;
import com.kratonsolution.belian.inventory.dm.UnitOfMeasureRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DataImportService
{
	@Autowired
	private ProductCategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private InventoryItemRepository itemRepository;
	
	@Autowired
	private UnitOfMeasureRepository measureRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	public void insert(InputStream excelfile) throws Exception
	{
		Workbook book = new XSSFWorkbook(excelfile);
		FormulaEvaluator evaluator = book.getCreationHelper().createFormulaEvaluator();
		
		for(int idx=1;idx<book.getSheetAt(0).getPhysicalNumberOfRows();idx++)
		{
			Row row = book.getSheetAt(0).getRow(idx);

			ProductCategory category = categoryRepository.findOneByName(row.getCell(1).getStringCellValue());
			if(category == null)
			{
				category = new ProductCategory();
				category.setCode(row.getCell(1).getStringCellValue());
				category.setName(row.getCell(1).getStringCellValue());
				category.setSegmentation(IndustrySegmentation.MEDICAL);
				
				categoryRepository.save(category);
			}
			
			UnitOfMeasure uom = measureRepository.findOneByName(row.getCell(2).getStringCellValue());
			if(uom == null)
			{
				uom = new UnitOfMeasure();
				uom.setCode(row.getCell(2).getStringCellValue());
				uom.setName(row.getCell(2).getStringCellValue());
				
				measureRepository.save(uom);
			}
			
			Product product = new Product();
			product.setCategory(category);
			product.setCode(row.getCell(0).getStringCellValue());
			product.setName(row.getCell(0).getStringCellValue());
			product.setStart(DateTimes.currentDate());
			product.setMinStok((int)row.getCell(11).getNumericCellValue());
			product.setType(ProductType.FINISHGOOD);
			product.setUom(uom);
			
			ProductCost cost = new ProductCost();
			cost.setCurrency(currencyRepository.findOne("85c90912-97ff-47ce-9d6a-7d1650ab3ea9"));
			cost.setFrom(DateTimes.currentDate());
			cost.setProduct(product);
			cost.setType(ProductCostType.PURCHASE);
			cost.setEstimated(BigDecimal.valueOf(row.getCell(3).getNumericCellValue()));
			
			product.getCosts().add(cost);
			
			evaluator.evaluate(row.getCell(4));
			evaluator.evaluate(row.getCell(5));
			evaluator.evaluate(row.getCell(6));
			evaluator.evaluate(row.getCell(7));
			evaluator.evaluate(row.getCell(8));
			
			ProductPrice basic = new ProductPrice();
			basic.setCurrency(currencyRepository.findOne("85c90912-97ff-47ce-9d6a-7d1650ab3ea9"));
			basic.setFrom(product.getStart());
			basic.setProduct(product);
			basic.setType(ProductPriceType.BASE);
			basic.setPrice(BigDecimal.valueOf(row.getCell(5).getNumericCellValue()));
			
			product.getPrices().add(basic);
			
			ProductPrice ref = new ProductPrice();
			ref.setCurrency(currencyRepository.findOne("85c90912-97ff-47ce-9d6a-7d1650ab3ea9"));
			ref.setFrom(product.getStart());
			ref.setProduct(product);
			ref.setType(ProductPriceType.REFERENCE);
			ref.setPrice(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()));
			
			product.getPrices().add(ref);
			
			ProductPrice klinik = new ProductPrice();
			klinik.setCurrency(currencyRepository.findOne("85c90912-97ff-47ce-9d6a-7d1650ab3ea9"));
			klinik.setFrom(product.getStart());
			klinik.setProduct(product);
			klinik.setType(ProductPriceType.CLINIC);
			klinik.setPrice(BigDecimal.valueOf(row.getCell(6).getNumericCellValue()));
			
			product.getPrices().add(klinik);
			
			productRepository.save(product);
			
			InventoryItem item = new InventoryItem();
			item.setFacility(facilityRepository.findOne("f68e2747-3c78-40e5-9cd3-57f72d0febc8"));
			item.setProduct(product);
			item.setExpiredDate(DateTimes.sql(row.getCell(10).getDateCellValue()));
			item.setOnhand(BigDecimal.valueOf(row.getCell(9).getNumericCellValue()));
			
			itemRepository.save(item);
		}
		
		book.close();
	}
}
