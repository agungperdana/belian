package com.kratonsolution.belian.tools.svc;

import com.kratonsolution.belian.accounting.dm.CurrencyRepository;
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.facility.impl.repository.FacilityRepository;
import com.kratonsolution.belian.inventoryitem.impl.repository.InventoryItemRepository;
import com.kratonsolution.belian.product.impl.orm.Product;
import com.kratonsolution.belian.product.impl.orm.ProductCategoryClassification;
import com.kratonsolution.belian.product.impl.orm.ProductType;
import com.kratonsolution.belian.product.impl.repository.ProductRepository;
import com.kratonsolution.belian.productcategory.impl.orm.ProductCategory;
import com.kratonsolution.belian.productcategory.impl.repository.ProductCategoryRepository;
import com.kratonsolution.belian.uom.impl.orm.UnitOfMeasure;
import com.kratonsolution.belian.uom.impl.repository.UnitOfMeasureRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class DataImportService
{
	private ProductCategoryRepository categoryRepository;

	private ProductRepository productRepository;

	private InventoryItemRepository itemRepository;
	
	private UnitOfMeasureRepository measureRepository;
	
	private CurrencyRepository currencyRepository;
	
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
				
				UnitOfMeasure uom = measureRepository.findByName(row.getCell(2).getStringCellValue());
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
					ProductCategory category = categoryRepository.findByName(cat);
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
