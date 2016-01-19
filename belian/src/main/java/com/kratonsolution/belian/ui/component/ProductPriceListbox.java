/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.sql.Date;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.healtcare.svc.PatientService;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductPriceListbox extends Listbox
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	public static ProductPriceListbox newInstance(String productName,EconomicAgent customer,Geographic location,Date date)
	{
		return new ProductPriceListbox(productName, customer, location,date);
	}
	
	private ProductPriceListbox(String product,EconomicAgent customer,Geographic location,Date date)
	{
		setWidth("100%");
		setMold("select");
		
		ProductService service = Springs.get(ProductService.class);
		init(service.findOneByNameOrId(product), customer, location, date);
	}

	private void init(Product product,EconomicAgent customer,Geographic location,Date date)
	{

		if(product != null)
		{
			Listitem base = null;
			Listitem bpjs = null;
			Listitem spesific = null;
			
			for(ProductPrice price:product.getPrices())
			{
				if(date.after(price.getFrom()) && (price.getTo() == null || date.before(price.getTo())))
				{
					if(price.getType().equals(ProductPrice.Type.BASE) && price.getGeographic() == null && price.getParty() == null && product.getSegmentation().equals(IndustrySegmentation.MEDICAL))
						base = new Listitem("BASE - "+Numbers.format(price.getPrice()),price.getPrice());
					else if(price.getType().equals(ProductPrice.Type.BPJS))
						bpjs = new Listitem("BPJS - "+Numbers.format(price.getPrice()),price.getPrice());
					else if(price.getType().equals(ProductPrice.Type.BASE) 
							&& price.getGeographic() != null && price.getGeographic().getId().equals(location.getId())
							&& price.getParty() != null && price.getParty().getId().equals(customer.getId()))
					{
						spesific = new Listitem("Special - "+Numbers.format(price.getPrice()),price.getPrice());
					}
				}
			}
			
			PatientService patientService = Springs.get(PatientService.class);
			
			Patient patient = patientService.findOne(customer.getId(),utils.getOrganization().getId());
			if(patient != null && patient.getBpjs() != null && product.getSegmentation().equals(IndustrySegmentation.MEDICAL) && bpjs != null)
			{
				appendChild(bpjs);
				setSelectedItem(bpjs);
			}
			
			if(spesific != null)
				appendChild(spesific);
			
			if(base != null)
			{
				appendChild(base);
				if(getSelectedCount() == 0)
					setSelectedItem(base);
			}
		}
	}
}
