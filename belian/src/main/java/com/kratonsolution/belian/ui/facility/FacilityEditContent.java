/**
 * 
 */
package com.kratonsolution.belian.ui.facility;

import java.util.Iterator;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Container;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.svc.ContainerService;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.Refreshable;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class FacilityEditContent extends FormContent implements Refreshable
{	
	private final FacilityService service = Springs.get(FacilityService.class);
	
	private final ContainerService containerService = Springs.get(ContainerService.class);
	
	private Textbox code = new Textbox();
	
	private Textbox name = new Textbox();
	
	private Textbox note = new Textbox();
	
	private Listbox types = new Listbox();
	
	private Row row;
	
	private Tree tree;
	
	public FacilityEditContent(Row row)
	{
		super();
		this.row = row;
		
		initToolbar();
		initForm();
		initCToolbar();
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
				FacilityWindow window = (FacilityWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(code.getText()))
					throw new WrongValueException(code,"Code cannot be empty");
			
				if(Strings.isNullOrEmpty(name.getText()))
					throw new WrongValueException(name,"Name cannot be empty");
				
				Facility facility = service.findOne(RowUtils.string(row, 4));
				if(facility != null)
				{
					facility.setCode(code.getText());
					facility.setName(name.getText());
					facility.setNote(note.getText());
					
					service.edit(facility);
				}
				
				FacilityWindow window = (FacilityWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		code.setConstraint("no empty");
		code.setText(RowUtils.string(this.row,1));
		code.setWidth("250px");
		
		name.setConstraint("no empty");
		name.setWidth("300px");
		name.setText(RowUtils.string(row, 2));
		
		note.setText(RowUtils.string(row, 4));
		note.setWidth("350px");
		
		types.setMold("select");
		for(Facility.Type type:Facility.Type.values())
		{
			Listitem listitem = new Listitem(type.name(),type.name());
			types.appendChild(listitem);
			if(type.name().equals(RowUtils.string(row,3)))
				types.setSelectedItem(listitem);
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Code"));
		row1.appendChild(code);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Name"));
		row2.appendChild(name);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Type"));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Note"));
		row4.appendChild(note);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	protected void initCToolbar()
	{
		Toolbar toolbar = new Toolbar();
		toolbar.setWidth("100%");
		toolbar.setHeight("35px");
		
		Toolbarbutton create = new Toolbarbutton("New Container","/icons/container.png");
		create.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(tree.getSelectedItem() == null)
					appendChild(new ContainerForm(service.findOne(RowUtils.string(row,5)), null));
				else
					appendChild(new ContainerForm(service.findOne(RowUtils.string(row,5)), containerService.findOne(tree.getSelectedItem().getId())));
			}
		});
		
		Toolbarbutton delete = new Toolbarbutton("Delete","/icons/delete.png");
		delete.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Messagebox.show("Are you sure want to remove the data(s) ?","Warning",Messagebox.CANCEL|Messagebox.OK, Messagebox.QUESTION,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						if(event.getName().equals("onOK"))
						{
							if(tree.getSelectedItem() != null)
								remove(containerService.findOne(tree.getSelectedItem().getId()));
							
							refresh();
						}
					}
				});
			}
		});
		
		toolbar.appendChild(create);
		toolbar.appendChild(delete);
		
		appendChild(toolbar);
	}
	
	protected void initTree()
	{
		Treecols headers = new Treecols();
		headers.appendChild(new Treecol("Facility Container"));
		
		tree = new Tree();
		tree.setWidth("100%");
		tree.appendChild(headers);
		tree.appendChild(new Treechildren());
		
		final Facility facility = service.findOne(RowUtils.string(row,5));
		for(final Container container:facility.getContainers())
		{
			Treeitem treeitem = new Treeitem(container.getCode()+" - "+container.getName()+", "+container.getType());
			treeitem.setId(container.getId());
			treeitem.setImage("/icons/leaf.png");
			treeitem.appendChild(new Treechildren());
			treeitem.addEventListener(Events.ON_DOUBLE_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					appendChild(new ContainerEditForm(container));
				}
			});
			
			tree.getTreechildren().appendChild(treeitem);
			
			extract(container, treeitem.getTreechildren());
		}
		
		appendChild(tree);
	}
	
	protected void extract(Container container,Treechildren treechildren)
	{
		if(!container.getMembers().isEmpty())
		{
			for(final Container member:container.getMembers())
			{
				Treerow treerow = new Treerow();
				treerow.appendChild(new Treecell(member.getCode()+" - "+member.getName()+", "+member.getType()));
				treerow.setImage("/icons/leaf.png");
				
				Treeitem item = new Treeitem();
				item.setId(member.getId());
				item.appendChild(treerow);
				item.addEventListener(Events.ON_DOUBLE_CLICK,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event event) throws Exception
					{
						appendChild(new ContainerEditForm(containerService.findOne(event.getTarget().getId())));
					}
				});
				
				treechildren.appendChild(item);
				
				Treechildren next = new Treechildren();
				item.appendChild(next);
				
				extract(member, next);
			}
		}
	}

	@Override
	public void refresh()
	{
		removeChild(tree);
		initTree();
	}
	
	protected void remove(Container container)
	{
		if(!container.getMembers().isEmpty())
		{
			Iterator<Container> iterator = container.getMembers().iterator();
			while (iterator.hasNext())
			{
				Container member = (Container) iterator.next();
				iterator.remove();
			
				remove(member);
			}
		}
		
		if(container.getParent() != null)
		{
			Container parent = containerService.findOne(container.getParent().getId());
			Iterator<Container> iterator = parent.getMembers().iterator();
			while (iterator.hasNext())
			{
				Container member = (Container) iterator.next();
				if(member.getId().equals(container.getId()))
				{
					iterator.remove();
					break;
				}
			}
			
			containerService.edit(parent);
		}
		else if(container.getFacility() != null)
		{
			Facility facility = service.findOne(container.getFacility().getId());
			Iterator<Container> iterator = facility.getContainers().iterator();
			while (iterator.hasNext())
			{
				Container member = (Container) iterator.next();
				if(member.getId().equals(container.getId()))
				{
					iterator.remove();
					break;
				}
			}
			
			service.edit(facility);
		}
		
		containerService.delete(container.getId());
	}
}
