package com.kratonsolution.belian.party.api.application;

import java.util.List;
import java.util.Optional;

import com.kratonsolution.belian.party.api.OrganizationData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface OrganizationService {

	public void add(OrganizationCreateCommand command);

	public void edit(OrganizationUpdateCommand organization);

	public void delete(OrganizationDeleteCommand command);
	
	public int count();

	public int count(@NonNull OrganizationFilter filter);

	Optional<OrganizationData> getByCode(@NonNull String code);

	List<OrganizationData> getAllOrganizations();

	List<OrganizationData> getAllOrganizations(int page, int size);

	List<OrganizationData> getAllOrganizations(@NonNull OrganizationFilter filter, int page, int size);
}
