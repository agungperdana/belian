package com.kratonsolution.belian.partys.ui.organization;

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
import com.kratonsolution.belian.party.api.OrganizationData;
import com.kratonsolution.belian.party.api.application.OrganizationService;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class OrganizationModel implements ListModel<OrganizationData>, Sortable<OrganizationData>, Pageable
{
	private List<OrganizationData> data;
	
	private Vector<ListDataListener> listeners;
	
	private int page = 0;
	
	private OrganizationModel() {
		
		this.data = new ArrayList<>(Springs.get(OrganizationService.class).getAllOrganizations(0, UIHelper.getSetting().getMaxRow()));
		this.listeners = new Vector<>();
	}
	
	@Override
	public void sort(Comparator<OrganizationData> cmpr, boolean ascending) {
	}

	@Override
	public String getSortDirection(Comparator<OrganizationData> cmpr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizationData getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return Springs.get(OrganizationService.class).count();
	}

	@Override
	public void addListDataListener(@NonNull ListDataListener l) {
		
		this.listeners.add(l);
	}

	@Override
	public void removeListDataListener(@NonNull ListDataListener l) {
		this.listeners.remove(l);
	}
	
	public static OrganizationModel build() {
		
		return new OrganizationModel();
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
