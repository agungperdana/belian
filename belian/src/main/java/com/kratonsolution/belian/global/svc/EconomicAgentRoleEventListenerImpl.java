/**
 * 
 */
package com.kratonsolution.belian.global.svc;

import java.util.Iterator;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.PartyRole;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.global.dm.EconomicAgentRoleEventListener;
import com.kratonsolution.belian.security.dm.AccessibleOrganization;
import com.kratonsolution.belian.security.dm.AccessibleOrganizationRepository;
import com.kratonsolution.belian.security.dm.Role;
import com.kratonsolution.belian.security.svc.RoleService;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EconomicAgentRoleEventListenerImpl implements EconomicAgentRoleEventListener
{
	@Autowired
	private AccessibleOrganizationRepository repository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private OrganizationService organizationService;

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.global.dm.EconomicAgentRoleEventListener#fireRoleAdded(com.kratonsolution.belian.general.dm.PartyRole)
	 */
	@Override
	public void fireRoleAdded(PartyRole role)
	{
		if(role.getType().getName().equals("Company Structure") && (role.getParty() instanceof Organization))
		{
			for(Role role2:roleService.findAll())
			{
				AccessibleOrganization organization = new AccessibleOrganization();
				organization.setId(UUID.randomUUID().toString());
				organization.setOrganization(organizationService.findOne(role.getParty().getId()));
				organization.setRole(role2);

				role2.getOrganizations().add(organization);

				roleService.edit(role2);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.global.dm.EconomicAgentRoleEventListener#fireRoleRemoved(com.kratonsolution.belian.general.dm.PartyRole)
	 */
	@Override
	public void fireRoleRemoved(PartyRole role)
	{
		if(role.getType().getName().equals("Company Structure") && (role.getParty() instanceof Organization))
		{
			for(Role db:roleService.findAll())
			{
				Iterator<AccessibleOrganization> iterator = db.getOrganizations().iterator();
				while (iterator.hasNext())
				{
					AccessibleOrganization org = (AccessibleOrganization) iterator.next();
					if(org.getOrganization().getId().equals(role.getParty().getId()))
						iterator.remove();
				}
				
				roleService.edit(db);
			}
		}
	}
}
