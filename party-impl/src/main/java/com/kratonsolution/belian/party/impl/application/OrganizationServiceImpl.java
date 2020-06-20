package com.kratonsolution.belian.party.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.party.api.OrganizationData;
import com.kratonsolution.belian.party.api.application.OrganizationCreateCommand;
import com.kratonsolution.belian.party.api.application.OrganizationDeleteCommand;
import com.kratonsolution.belian.party.api.application.OrganizationFilter;
import com.kratonsolution.belian.party.api.application.OrganizationService;
import com.kratonsolution.belian.party.api.application.OrganizationUpdateCommand;
import com.kratonsolution.belian.party.impl.repository.OrganizationRepository;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class OrganizationServiceImpl implements OrganizationService
{	
	@Autowired
	private OrganizationRepository repository;

	@Override
	public void add(OrganizationCreateCommand command) {
		
	}

	@Override
	public void edit(OrganizationUpdateCommand organization) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrganizationDeleteCommand command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count(@NonNull OrganizationFilter filter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<OrganizationData> getByCode(@NonNull String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizationData> getAllOrganizations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizationData> getAllOrganizations(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizationData> getAllOrganizations(@NonNull OrganizationFilter filter, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}
}