/**
 * 
 */
package com.kratonsolution.belian.ui.organizationaccount;

import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OAccountTree extends Tree
{
	private GLAccountService service = Springs.get(GLAccountService.class);
	
	private OrganizationAccount edited;
	
	public OAccountTree(OrganizationAccount edited)
	{
		setWidth("100%");
		setMultiple(true);
		setCheckmark(true);
	
		this.edited = edited;
		
		initHeaders();
		initLeaf();
	}
	
	protected void initHeaders()
	{
		Treecols headers = new Treecols();
		headers.appendChild(new Treecol("General Ledger Account"));
		
		appendChild(headers);
	}
	
	protected void initLeaf()
	{
		Treechildren root = new Treechildren();
		
		for(GLAccount account:service.findAllRoot())
		{
			Treeitem item = new Treeitem(account.getNumber()+" - "+account.getName());
			item.setId(account.getId());
			item.setImage("/icons/leaf.png");
			item.appendChild(new Treechildren());
			
			if(edited != null)
			{
				for(OGLAccount ondb:edited.getAccounts())
				{
					if(account.getId().equals(ondb.getAccount().getId()))
					{
						item.setSelected(ondb.isSelected());
						break;
					}
				}
			}
			
			root.appendChild(item);
			
			extract(account, item.getTreechildren());
		}
		
		appendChild(root);
	}
	
	protected void extract(GLAccount account,Treechildren treechildren)
	{
		if(!account.getMembers().isEmpty())
		{
			for(final GLAccount member:account.getMembers())
			{
				Treerow treerow = new Treerow();
				treerow.appendChild(new Treecell(member.getNumber()+" - "+member.getName()));
				treerow.setImage("/icons/leaf.png");
				
				Treeitem item = new Treeitem();
				item.setId(member.getId());
				item.appendChild(treerow);
				
				if(edited != null)
				{
					for(OGLAccount ondb:edited.getAccounts())
					{
						if(member.getId().equals(ondb.getAccount().getId()))
						{
							item.setSelected(ondb.isSelected());
							break;
						}
					}
				}
				
				treechildren.appendChild(item);
				
				Treechildren next = new Treechildren();
				item.appendChild(next);
				
				extract(member, next);
			}
		}
	}
}
