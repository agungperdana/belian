/**
 * 
 */
package com.kratonsolution.belian.ui.hr.paygrade;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.hr.dm.PayGrade;
import com.kratonsolution.belian.hr.svc.PayGradeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PayGradeEditContent extends FormContent
{	
	private PayGradeService service = Springs.get(PayGradeService.class);

	private Textbox name = Components.mandatoryTextBox();
	
	private Textbox comment = new Textbox();
	
	private Row row;
	
	public PayGradeEditContent(Row row)
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
				PayGradeWindow window = (PayGradeWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PayGrade grade = service.findOne(RowUtils.string(row, 7));
				if(grade != null)
				{
					grade.setName(name.getText());
					grade.setComment(comment.getText());

					service.edit(grade);
				}
				
				PayGradeWindow window = (PayGradeWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		PayGrade grade = service.findOne(RowUtils.string(row, 3));
		if(grade != null)
		{
			name.setText(grade.getName());
			comment.setText(grade.getComment());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Name"));
			row1.appendChild(name);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Comment"));
			row2.appendChild(comment);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
		}
	}
}
