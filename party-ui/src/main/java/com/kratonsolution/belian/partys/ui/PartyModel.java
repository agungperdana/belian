package com.kratonsolution.belian.partys.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.ListDataListener;
import org.zkoss.zul.ext.Pageable;
import org.zkoss.zul.ext.Sortable;

import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.common.ui.util.UIHelper;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.application.PartyService;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class PartyModel implements ListModel<PartyData>, Sortable<PartyData>, Pageable
{
	private List<PartyData> data;
	
	private Vector<ListDataListener> listeners;
	
	private int page = 0;
	
	private PartyModel() {
		
		this.data = new ArrayList<>(Springs.get(PartyService.class).getAllPartys(0, UIHelper.getSetting().getMaxRow()));
		this.listeners = new Vector<>();
	}
	
	@Override
	public void sort(Comparator<PartyData> cmpr, boolean ascending) {
	}

	@Override
	public String getSortDirection(Comparator<PartyData> cmpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartyData getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return Springs.get(PartyService.class).count();
	}

	@Override
	public void addListDataListener(@NonNull ListDataListener l) {
		
		this.listeners.add(l);
	}

	@Override
	public void removeListDataListener(@NonNull ListDataListener l) {
		this.listeners.remove(l);
	}
	
	public static PartyModel build() {
		
		return new PartyModel();
	}

	@Override
	public int getPageSize() {
		return UIHelper.getSetting().getMaxRow();
	}

	@Override
	public void setPageSize(int size) throws WrongValueException {
		
	}

	@Override
	public int getPageCount() {
		
		int size = getSize();
		
		if(size <= UIHelper.getSetting().getMaxRow())
			return 1;
		else {
			
			int _mod = size % getPageSize();
			return ((size-_mod)/getPageSize())+1;
		}
	}

	@Override
	public int getActivePage() {
		return this.page;
	}

	@Override
	public void setActivePage(int pg) throws WrongValueException {
		this.page = pg;
	}
}
