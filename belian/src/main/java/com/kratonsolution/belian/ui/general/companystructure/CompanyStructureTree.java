/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import java.util.Collection;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureTree extends Tree implements CompanyStructureDataListener
{
	private CompanyStructureService service = Springs.get(CompanyStructureService.class);
	
	private Component container;
	
	public CompanyStructureTree(Component contentArea)
	{
		this.container = contentArea;
		
		setWidth("100%");
		setHeight("100%");
		appendChild(new Treecols());
		appendChild(new Treechildren());
		getTreecols().appendChild(new Treecol("Facilitys(s)"));
		getTreechildren().appendChild(CompanyStructureTreeItem.New(contentArea,this));
		
		Collection<CompanyStructureTreeItem> items = CompanyStructureTreeItem.list(contentArea,service.findAllParent());
		getTreechildren().getChildren().addAll(items);
		
		for(CompanyStructureTreeItem item:items)
			populate(item);
	}
	
	@Override
	public void fireDataAdded(CompanyStructure company)
	{
		if(company.getParent() == null)
			getTreechildren().appendChild(CompanyStructureTreeItem.in(container,company));
		else
			extract(company);
	}

	@Override
	public void fireDataUpdated(CompanyStructure company)
	{
	}

	@Override
	public void fireDataRemoved(CompanyStructure company)
	{
	}

	public void extract(CompanyStructure company)
	{
		Iterator<Treeitem> iterator = getItems().iterator();
		while (iterator.hasNext())
		{
			Treeitem treeitem = (Treeitem) iterator.next();
			if(treeitem.getId().equals(company.getParent().getId()))
			{
				treeitem.getTreechildren().appendChild(CompanyStructureTreeItem.in(container, company));
				break;
			}
		}
	}
	
	public void populate(CompanyStructureTreeItem parent)
	{
		for(CompanyStructure company:parent.getCompany().getChilds())
		{
			if(company.getOrganization() != null)
			{
				CompanyStructureTreeItem item = CompanyStructureTreeItem.in(container, company);
				parent.getTreechildren().appendChild(item);
				if(!company.getChilds().isEmpty())
					populate(item);
			}
		}
	}
}
