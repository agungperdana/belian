/**
 * 
 */
package com.kratonsolution.belian.ui.coa;

import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.accounting.svc.GLAccountService;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class CoATree extends Tree
{
	private Treecols headers = new Treecols();

	private Treechildren roots = new Treechildren();
	
	private GLAccountService service = Springs.get(GLAccountService.class);
	
	private GLAccount rootAccount;
	
	public CoATree(GLAccount rootAccount)
	{
		this.rootAccount = rootAccount;
		initHeader();
		initRoot();
	}
	
	protected void initHeader()
	{
		Treecol header = new Treecol("General Ledger Account");
		Treecol action = new Treecol(null,null,"50px");
		
		headers.appendChild(header);
		headers.appendChild(action);
		
		appendChild(headers);
	}
	
	protected void initRoot()
	{
		for(GLAccount account:rootAccount.getMembers())
		{
			Treeitem treeitem = new Treeitem(account.getName());
			treeitem.setImage("/icons/coasmall.png");
			
			roots.appendChild(treeitem);
		}
		
		appendChild(roots);
	}
}
