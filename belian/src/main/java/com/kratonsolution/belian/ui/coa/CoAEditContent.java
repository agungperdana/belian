/**
 * 
 */
package com.kratonsolution.belian.ui.coa;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CoAEditContent extends FormContent
{	
	private final GLAccountService service = Springs.get(GLAccountService.class);

	private Textbox number = new Textbox();

	private Textbox name = new Textbox();

	private Textbox note = new Textbox();

	private Row row;
	
	private CoaToolbar coaToolbar = new CoaToolbar();
	
	private CoATree coATree;

	public CoAEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initTree();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CoAWindow window = (CoAWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(number.getText()))
					throw new WrongValueException(number,"Number cannot be empty");

				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");

				GLAccount coa = new GLAccount();
				coa.setId(RowUtils.rowValue(row, 4));
				coa.setNumber(number.getText());
				coa.setName(name.getText());
				coa.setNote(note.getText());

				service.edit(coa);

				CoAWindow window = (CoAWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		number.setConstraint("no empty");
		number.setWidth("200px");
		number.setText(RowUtils.rowValue(this.row,1));

		name.setConstraint("no empty");
		name.setWidth("300px");
		name.setText(RowUtils.rowValue(row, 2));

		note.setText(RowUtils.rowValue(row, 3));
		note.setWidth("400px");
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label("Number"));
		row1.appendChild(number);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Description"));
		row3.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
	}
	
	public void initTree()
	{
		appendChild(coaToolbar);
		
		GLAccount rootAccount = service.findOne(RowUtils.rowValue(row, 4));
		if(rootAccount != null)
		{
			if(coATree != null)
				removeChild(coATree);
			
			coATree = new CoATree(rootAccount);
			appendChild(new CoATree(rootAccount));
		}
	}
}
