package com.kratonsolution.belian.party.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.common.spring.SpecificationBuilder;
import com.kratonsolution.belian.common.spring.SpecificationBuilder.Operator;
import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.party.api.OrganizationData;
import com.kratonsolution.belian.party.api.application.OrganizationCreateCommand;
import com.kratonsolution.belian.party.api.application.OrganizationDeleteCommand;
import com.kratonsolution.belian.party.api.application.OrganizationFilter;
import com.kratonsolution.belian.party.api.application.OrganizationService;
import com.kratonsolution.belian.party.api.application.OrganizationUpdateCommand;
import com.kratonsolution.belian.party.impl.model.Organization;
import com.kratonsolution.belian.party.impl.model.PartyGeographicInfo;
import com.kratonsolution.belian.party.impl.repository.OrganizationRepository;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor=Exception.class)
public class OrganizationServiceImpl implements OrganizationService
{	
	@Autowired
	private OrganizationRepository repo;

	@Autowired
	private GeographicService geoService;

	@Override
	public OrganizationData create(@NonNull OrganizationCreateCommand command) {

		Optional<Organization> ondb = repo.findByCode(command.getCode());
		Preconditions.checkState(!ondb.isPresent(), "Organization with code {} already exist", command.getCode());

		Organization organization = new Organization(command.getCode(), command.getName());

		if(command.getTaxCode().isPresent()) {

			organization.getParty().setTaxCode(command.getTaxCode().get());
		}

		if(command.getBirthDate().isPresent()) {

			organization.getParty().setBirthDate(command.getBirthDate().get());
		}

		if(command.getBirthPlace().isPresent() && geoService.getByCode(command.getBirthPlace().get()) != null) {

			GeographicData geo = geoService.getByCode(command.getBirthPlace().get());
			organization.getParty().setBirthPlace(new PartyGeographicInfo(geo.getCode(), geo.getName()));
		}

		repo.save(organization);
		log.info("Create new organization data {}", organization);

		return OrganizationMapper.INSTANCE.toData(organization);
	}

	@Override
	public OrganizationData update(@NonNull OrganizationUpdateCommand command) {

		Optional<Organization> opt = repo.findByCode(command.getCode());
		Preconditions.checkState(opt.isPresent(), "Organization with code {} does not exist", command.getCode());

		if(command.getBirthDate().isPresent()) {
			opt.get().getParty().setBirthDate(command.getBirthDate().get());
		}

		if(command.getBirthPlace().isPresent() && geoService.getByCode(command.getBirthPlace().get()) != null) {
			
			GeographicData geo = geoService.getByCode(command.getBirthPlace().get());
			opt.get().getParty().setBirthPlace(new PartyGeographicInfo(geo.getCode(), geo.getName()));
		}

		if(command.getName().isPresent()) {
			opt.get().getParty().setName(command.getName().get());
		}

		if(command.getTaxCode().isPresent()) {
			opt.get().getParty().setTaxCode(command.getTaxCode().get());
		}

		repo.save(opt.get());
		log.info("Updating organization data {}", opt.get());

		return OrganizationMapper.INSTANCE.toData(opt.get());

	}

	@Override
	public OrganizationData delete(@NonNull OrganizationDeleteCommand command) {

		Optional<Organization> ondb = repo.findByCode(command.getCode());
		Preconditions.checkState(!ondb.isPresent(), "Organization with code {} already exist", command.getCode());

		repo.delete(ondb.get());
		log.info("Removing organization data {}", ondb.get());

		return OrganizationMapper.INSTANCE.toData(ondb.get());
	}

	@Override
	public int count() {
		return Long.valueOf(repo.count()).intValue();
	}

	@Override
	public int count(@NonNull OrganizationFilter filter) {
		
		if(filter.isValid()) {

			SpecificationBuilder<Organization> builder = new SpecificationBuilder<>();

			if(filter.getCode().isPresent()) {

				builder.combine((root, query, cb) -> {return cb.like(root.get("party.code"), filter.getCode().get());}, Operator.OR);
			}

			if(filter.getName().isPresent()) {

				builder.combine((root, query, cb) -> {return cb.like(root.get("party.name"), filter.getName().get());}, Operator.OR);
			}

			if(builder.getParent().isPresent()) {

				return Long.valueOf(repo.count(Specification.where(builder.getParent().get()))).intValue();
			}
		}
		
		return 0;
	}

	@Override
	public Optional<OrganizationData> getByCode(@NonNull String code) {
		return Optional.ofNullable(OrganizationMapper.INSTANCE.toData(repo.findByCode(code).orElse(null)));
	}

	@Override
	public List<OrganizationData> getAllOrganizations() {
		// TODO Auto-generated method stub
		return OrganizationMapper.INSTANCE.toDatas(repo.findAll());
	}

	@Override
	public List<OrganizationData> getAllOrganizations(int page, int size) {
		return OrganizationMapper.INSTANCE.toDatas(repo.findAll(PageRequest.of(page, size)).getContent());
	}

	@Override
	public List<OrganizationData> getAllOrganizations(@NonNull OrganizationFilter filter, int page, int size) {

		if(filter.isValid()) {

			SpecificationBuilder<Organization> builder = new SpecificationBuilder<>();

			if(filter.getCode().isPresent()) {

				builder.combine((root, query, cb) -> {return cb.like(root.get("party.code"), filter.getCode().get());}, Operator.OR);
			}

			if(filter.getName().isPresent()) {

				builder.combine((root, query, cb) -> {return cb.like(root.get("party.name"), filter.getName().get());}, Operator.OR);
			}

			if(builder.getParent().isPresent()) {

				return OrganizationMapper.INSTANCE.toDatas(repo.findAll(Specification.where(builder.getParent().get()), PageRequest.of(page, size)).getContent());
			}
		}

		return getAllOrganizations(page, size);
	}
}