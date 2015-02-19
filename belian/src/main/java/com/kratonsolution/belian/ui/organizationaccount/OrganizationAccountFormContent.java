/**
 * 
 */
package com.kratonsolution.belian.ui.organizationaccount;

import java.util.UUID;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Treeitem;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.accounting.svc.OrganizationAccountService;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class OrganizationAccountFormContent extends FormContent
{	
	private final OrganizationAccountService service = Springs.get(OrganizationAccountService.class);
	
	private final OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private final GLAccountService accountService = Springs.get(GLAccountService.class);
	
	private Textbox name = new Textbox();
	
	private Textbox note = new Textbox();
	
	private Checkbox status = new Checkbox("Active");
	
	private Listbox organizations = new Listbox();
	
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
					throw new WrongValueException(name,"Name cannot be empty");
			
				OrganizationAccount org = new OrganizationAccount();
				org.setId(UUID.randomUUID().toString());
				org.setName(name.getText());
				org.setNote(note.getText());
				org.setActive(status.isChecked());
				org.setOrganization(organizationService.findOne(organizations.getSelectedItem().getValue().toString()));
				
				for(Treeitem treeitem:tree.getTreechildren().getItems())
				{
					GLAccount account = accountService.findOne(treeitem.getId());
					
					OGLAccount oglAccount = new OGLAccount();
					oglAccount.setId(account.getId());
					oglAccount.setAccount(account);
					oglAccount.setSelected(treeitem.isSelected());
					
					org.getAccounts().add(oglAccount);
				}
				
				service.add(org);
				
				OrganizationAccountWindow window = (OrganizationAccountWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		name.setConstraint("no empty");
		name.setWidth("350px");

		note.setWidth("400px");
		
		status.setChecked(true);
		organizations.setMold("select");
		
		for(Organization organization:organizationService.findAll())
			organizations.appendChild(new Listitem(organization.getName(),organization.getId()));
		
		organizations.setSelectedIndex(0);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Name"));
		row1.appendChild(name);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Organization"));
		row2.appendChild(organizations);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Note"));
		row3.appendChild(note);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Status"));
		row4.appendChild(status);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
}