/**
 * 
 */
package com.kratonsolution.belian.ui.hr.benefittype;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.hr.dm.BenefitType;
import com.kratonsolution.belian.hr.svc.BenefitTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BenefitTypeEditContent extends FormContent
{	
	private BenefitTypeService service = Springs.get(BenefitTypeService.class);

	private Textbox code = Components.mandatoryTextBox();
	
	private Textbox name = Components.mandatoryTextBox();
	
	private Textbox note = new Textbox();
	
	private Row row;
	
	public BenefitTypeEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new BenefitTypeGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				BenefitType grade = service.findOne(RowUtils.id(row));
				if(grade != null)
				{
					grade.setCode(code.getText());
					grade.setName(name.getText());
					grade.setNote(note.getText());

					service.edit(grade);
				}
				
				Flow.next(getParent(), new BenefitTypeGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		BenefitType grade = service.findOne(RowUtils.id(row));
		if(grade != null)
		{
			code.setText(grade.getCode());
			name.setText(grade.getName());
			note.setText(grade.getNote());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Code"));
			row1.appendChild(code);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Name"));
			row2.appendChild(name);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Note"));
			row3.appendChild(note);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
		}
	}
}