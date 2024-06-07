
package com.kratonsolution.belian.ui.orders;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.West;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.common.app.NumberGenerator;
import com.kratonsolution.belian.orders.svc.SalesOrderService;
import com.kratonsolution.belian.core.party.impl.application.PartyService;
import com.kratonsolution.belian.core.party.impl.application.PersonService;
import com.kratonsolution.belian.products.svc.ProductCategoryService;
import com.kratonsolution.belian.products.svc.ProductService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class POSOrder extends Borderlayout
{
	protected SessionUtils utils = Springs.get(SessionUtils.class);

	protected Language lang = Springs.get(Language.class);
	
	protected NumberGenerator gen = Springs.get(NumberGenerator.class);
	
	protected ProductCategoryService categoryService = Springs.get(ProductCategoryService.class);

	protected ProductService productService = Springs.get(ProductService.class);

	protected PartyService partyService = Springs.get(PartyService.class);
	
	protected SalesOrderService salesOrderService = Springs.get(SalesOrderService.class);
	
	protected PersonService personService = Springs.get(PersonService.class);

	protected West left = new West();

	protected Center right = new Center();
	
	protected Button pay = new Button(lang.get("label.component.generic.pay"),"/icons/cash48.png");
}
