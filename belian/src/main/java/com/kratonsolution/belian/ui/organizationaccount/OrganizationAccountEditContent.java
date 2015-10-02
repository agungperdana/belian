/**
 * 
 */
package com.kratonsolution.belian.ui.organizationaccount;

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
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class OrganizationAccountEditContent extends FormContent
{	
	private final OrganizationAccountService service = Springs.get(OrganizationAccountService.class);

	private final OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private final GLAccountService accountService = Springs.get(GLAccountService.class);

	private Textbox name = new Textbox();

	private Textbox note = new Textbox();

	private Checkbox status = new Checkbox("Active");

	private Listbox organizations = new Listbox();

	private OAccountTree tree;

	private Row row;

	public OrganizationAccountEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		
		tree = new OAccountTree(service.findOne(RowUtils.string(row, 5)));
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
				window.removeEditForm();
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

				OrganizationAccount org = service.findOne(RowUtils.string(row,5));
				org.setName(name.getText());
				org.setActive(status.isChecked());
				org.setNote(note.getText());

				org.getAccounts().clear();
				
				for(Treeitem treeitem:tree.getTreechildren().getItems())
				{
					GLAccount account = accountService.findOne(treeitem.getId());
					
					OGLAccount oglAccount = new OGLAccount();
					oglAccount.setId(account.getId());
					oglAccount.setAccount(account);
					oglAccount.setSelected(treeitem.isSelected());
					oglAccount.setParent(org);
					
					org.getAccounts().add(oglAccount);
				}
					
				service.edit(org);

				OrganizationAccountWindow window = (OrganizationAccountWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		OrganizationAccount account = service.findOne(RowUtils.string(row, 5));
		
		name.setConstraint("no empty");
		name.setWidth("350px");
		name.setText(account.getName());

		note.setText(account.getNote());
		note.setWidth("400px");
		
		status.setChecked(account.isActive());
		
		organizations.setMold("select");
		organizations.appendChild(new Listitem(account.getOrganization().getName(),account.getOrganization().getId()));
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
