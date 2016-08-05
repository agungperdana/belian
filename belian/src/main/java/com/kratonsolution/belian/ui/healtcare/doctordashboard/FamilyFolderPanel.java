/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctordashboard;

import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.healtcare.dm.DoctorAppointment;
import com.kratonsolution.belian.healtcare.dm.FamilyFolder;
import com.kratonsolution.belian.healtcare.dm.FamilyMember;
import com.kratonsolution.belian.healtcare.dm.Patient;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FamilyFolderPanel extends Vlayout
{
	private Language lang = Springs.get(Language.class);
	
	private Tabbox box = new Tabbox();
	
	public FamilyFolderPanel(Patient patient)
	{
		setWidth("100%");
		setStyle("overflow:auto;");
		
		box.setWidth("100%");
		box.setHeight("97%");
		box.appendChild(new Tabpanels());
		box.appendChild(new Tabs());
		
		appendChild(box);
		
		initMembers(patient);
	}
	
	private void initMembers(Patient patient)
	{
		box.getTabs().getChildren().clear();
		box.getTabpanels().getChildren().clear();
		
		if(!patient.getMembers().isEmpty())
		{
			FamilyFolder folder = null;
			
			for(FamilyMember member:patient.getMembers())
			{
				folder = member.getFolder();
				break;
			}
			
			for(FamilyMember member:folder.getMembers())
			{
				if(!member.getPatient().getId().equals(patient.getId()))
				{
					Grid grid = new Grid();
					grid.setWidth("100%");
					grid.setEmptyMessage(lang.get("message.grid.empty"));
					grid.appendChild(new Columns());
					grid.appendChild(new Rows());
					grid.getColumns().appendChild(new Column(null,null,"0px"));
					grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.date"),null,"85px"));
					grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.company"),null,"150px"));
					grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.doctor"),null,"150px"));
					grid.getColumns().appendChild(new Column(lang.get("doctordashboard.grid.column.diagnosis"),null,"150px"));
					grid.getColumns().getLastChild().setVisible(false);
					grid.setSpan("4");
					
					for(DoctorAppointment app:member.getPatient().getAppointments())
					{
						Row row = new Row();
						row.appendChild(new Label(app.getId()));
						row.appendChild(new Label(DateTimes.format(app.getDate())));
						row.appendChild(new Label(app.getCompany().getName()));
						row.appendChild(new Label(app.getDoctor().getPerson().getName()));
						row.appendChild(new Label(app.getRecord()!=null?app.getRecord().getDiagnosis():""));
						
						grid.getRows().appendChild(row);
					}
					
					Tabpanel tabpanel = new Tabpanel();
					tabpanel.appendChild(grid);
					
					box.getTabs().appendChild(new Tab(member.getPatient().getPerson().getName()));
					box.getTabpanels().appendChild(tabpanel);
				}
			}
		}
		else
		{
			Tabpanel panel = new Tabpanel();
			panel.appendChild(new Label(lang.get("doctordashboard.message.emptylink")));
			
			box.getTabs().appendChild(new Tab(lang.get("doctordashboard.grid.column.info")));
			box.getTabpanels().appendChild(panel);
		}
	}
}
