/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.organizationaccount;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Treeitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationAccountFormContent extends FormContent
{	
	private OrganizationAccountService service = Springs.get(OrganizationAccountService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private CompanyStructureService unitService = Springs.get(CompanyStructureService.class);
	
	private GLAccountService accountService = Springs.get(GLAccountService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Textbox name = Components.mandatoryTextBox(false);
	
	private Textbox note = Components.stdTextBox(null, false);
	
	private Checkbox status = new Checkbox("Active");
	
	private OrganizationList companys = new OrganizationList();
	
	private OAccountTree tree = new OAccountTree(null);
		
	public OrganizationAccountFormContent()
	{
		super();
		initToolbar();
		initForm();
		
		appendChild(tree);
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				OrganizationAccountWindow window = (OrganizationAccountWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,lang.get("message.field.empty"));
			
				OrganizationAccount organization = new OrganizationAccount();
				organization.setName(name.getText());
				organization.setNote(note.getText());
				organization.setActive(status.isChecked());
				organization.setOrganization(companys.getOrganization());
				
				for(Treeitem treeitem:tree.getTreechildren().getItems())
				{
					GLAccount account = accountService.findOne(treeitem.getId());
					
					OGLAccount oglAccount = new OGLAccount();
					oglAccount.setAccount(account);
					oglAccount.setSelected(treeitem.isSelected());
					oglAccount.setParent(organization);
					
					organization.getAccounts().add(oglAccount);
				}
				
				service.add(organization);
				
				OrganizationAccountWindow window = (OrganizationAccountWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("ogl.grid.column.name")));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("ogl.grid.column.company")));
		row2.appendChild(companys);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("ogl.grid.column.note")));
		row3.appendChild(note);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("ogl.grid.column.status")));
		row4.appendChild(status);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
}
