
package com.kratonsolution.belian.tools.svc;

import java.io.InputStream;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.accounting.dm.CurrencyRepository;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.FacilityRepository;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductCategory;
import com.kratonsolution.belian.products.dm.ProductCategoryClassification;
import com.kratonsolution.belian.products.dm.ProductCategoryRepository;
import com.kratonsolution.belian.products.dm.ProductRepository;
import com.kratonsolution.belian.products.dm.ProductType;
import com.kratonsolution.belian.products.dm.UnitOfMeasure;
import com.kratonsolution.belian.products.dm.UnitOfMeasureRepository;

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
		try
		{
			Workbook book = new XSSFWorkbook(excelfile);
			
			for(int idx=0;idx<book.getSheetAt(0).getPhysicalNumberOfRows();idx++)
			{
				System.out.println("#### "+idx);
				
				Row row = book.getSheetAt(0).getRow(idx);
				
				UnitOfMeasure uom = measureRepository.getOneByName(row.getCell(2).getStringCellValue());
				if(uom == null)
				{
					uom = new UnitOfMeasure();
					uom.setName(row.getCell(2).getStringCellValue());
					
					measureRepository.saveAndFlush(uom);
				}
				
				Product product = new Product();
				product.setId(UUID.randomUUID().toString());
				product.setComment("Auto Import");
				product.setIntroductionDate(DateTimes.currentDate());
				product.setName(row.getCell(0).getStringCellValue());
				product.setType(ProductType.FINISH_GOODS);
				product.setUom(uom.toRef());

				String raw = row.getCell(1).getStringCellValue();
				System.out.println("raw --> "+raw);
				for(String cat:raw.split(","))
				{
					ProductCategory category = categoryRepository.getOneByName(cat);
					if(category == null)
					{
						category = new ProductCategory();
						category.setName(cat);
						
						categoryRepository.saveAndFlush(category);
					}
					
					ProductCategoryClassification classification = new ProductCategoryClassification();
					classification.setCategory(category.toRef());
					classification.setStart(DateTimes.currentDate());
					classification.setProduct(product);
					
					product.getClassifications().add(classification);
				}

				
				productRepository.saveAndFlush(product);
			
				book.close();
			}
		} 
		catch (Exception e){e.printStackTrace();}
		

	}
}
