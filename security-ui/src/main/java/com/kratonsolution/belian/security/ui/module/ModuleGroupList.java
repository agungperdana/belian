package com.kratonsolution.belian.security.ui.module;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.event.ListDataListener;
import org.zkoss.zul.ext.Selectable;
import org.zkoss.zul.ext.SelectionControl;

import com.kratonsolution.belian.security.api.ModuleGroup;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ModuleGroupList extends Listbox {

	private static final long serialVersionUID = 1L;

	public ModuleGroupList() {
		
		setModel(new Model());
		setItemRenderer(new ListitemRenderer<ModuleGroup>() {

			@Override
			public void render(Listitem item, ModuleGroup data, int index) throws Exception {
				
				item.setLabel(data.name());
				item.setValue(data);
			}
		});
		setMold("select");
		setMultiple(false);
	}
	
	private class Model implements ListModel<ModuleGroup> , Selectable<ModuleGroup>{

		private ModuleGroup data[] = ModuleGroup.values();
		
		private Set<ModuleGroup> selected = new HashSet<>();
		
		@Override
		public ModuleGroup getElementAt(int index) {

			if(index < data.length) {
				return data[index];
			}
			
			return null;
		}

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return data.length;
		}

		@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Set<ModuleGroup> getSelection() {
			// TODO Auto-generated method stub
			return this.selected;
		}

		@Override
		public void setSelection(Collection<? extends ModuleGroup> selection) {
			// TODO Auto-generated method stub
			this.selected.clear();
			this.selected.addAll(selection);
		}

		@Override
		public boolean isSelected(Object obj) {
			// TODO Auto-generated method stub
			return selected.contains(obj);
		}

		@Override
		public boolean isSelectionEmpty() {
			// TODO Auto-generated method stub
			return selected.isEmpty();
		}

		@Override
		public boolean addToSelection(ModuleGroup obj) {
			// TODO Auto-generated method stub
			return selected.add(obj);
		}

		@Override
		public boolean removeFromSelection(Object obj) {
			// TODO Auto-generated method stub
			return selected.remove(obj);
		}

		@Override
		public void clearSelection() {
			// TODO Auto-generated method stub
			this.selected.clear();
		}

		@Override
		public void setMultiple(boolean multiple) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isMultiple() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setSelectionControl(SelectionControl ctrl) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public SelectionControl getSelectionControl() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public void setSelected(@NonNull ModuleGroup group) {

		getItems().forEach(item -> {
			
			if(item.getValue() != null && item.getValue().equals(group)) {
				setSelectedItem(item);
				return;
			}
		});
	}
}
