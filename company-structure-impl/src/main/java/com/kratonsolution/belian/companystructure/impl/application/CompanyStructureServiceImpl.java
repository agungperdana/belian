package com.kratonsolution.belian.companystructure.impl.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.companystructure.api.CompanyStructureData;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureCreateCommand;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureDeleteCommand;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureFilter;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureService;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureUpdateCommand;
import com.kratonsolution.belian.companystructure.impl.model.CompanyStructure;
import com.kratonsolution.belian.companystructure.impl.repository.CompanyStructureRepository;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyStructureServiceImpl implements CompanyStructureService {

	@Autowired
	private CompanyStructureRepository repo;
	
	public CompanyStructureData create(@NonNull CompanyStructureCreateCommand command) {
		
		CompanyStructure company = new CompanyStructure(command.getStart(), 
														command.getPartyCode(), 
														command.getPartyName(), 
														command.getType(), 
														command.getParentPartyCode(), 
														command.getParentPartyName(),
														command.getEnd());
		
		repo.save(company);
		log.info("creating new company structure data {}", command.getPartyCode());
		
		return CompanyStructureMapper.INSTANCE.toData(company);
	}

	public CompanyStructureData update(@NonNull CompanyStructureUpdateCommand command) {
		
		Optional<CompanyStructure> opt = repo.findOneByPartyCode(command.getPartyCode());
		if(opt.isPresent()) {
			
			opt.get().update(command.getEnd(), command.getParentPartyCode(), command.getParentPartyName());
			repo.save(opt.get());
			log.info("updating company structure {}", command.getPartyCode());
			return CompanyStructureMapper.INSTANCE.toData(opt.get());
		}
		
		return CompanyStructureMapper.INSTANCE.toData(null);
	}

	public CompanyStructureData delete(@NonNull CompanyStructureDeleteCommand command) {

		Optional<CompanyStructure> opt = repo.findOneByPartyCode(command.getPartyCode());
		if(opt.isPresent()) {
			
			repo.delete(opt.get());
			log.info("updating company structure {}", command.getPartyCode());
			return CompanyStructureMapper.INSTANCE.toData(opt.get());
		}
		
		return CompanyStructureMapper.INSTANCE.toData(null);
	}

	@Override
	public CompanyStructureData getByCode(@NonNull String code) {
		return CompanyStructureMapper.INSTANCE.toData(repo.findOneByPartyCode(code).orElse(null));
	}

	@Override
	public List<CompanyStructureData> getAllCompanyStructures() {
		return CompanyStructureMapper.INSTANCE.toDatas(repo.findAll());
	}

	@Override
	public List<CompanyStructureData> getAllCompanyStructureRoots() {

		return CompanyStructureMapper.INSTANCE.toDatas(repo.findAllRoots());
	}

	@Override
	public List<CompanyStructureData> getAllCompanyStructures(@NonNull CompanyStructureFilter filter) {

		Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize());
		
		if(Strings.isNullOrEmpty(filter.getKey())) {
			return CompanyStructureMapper.INSTANCE.toDatas(repo.findAll(pageable).getContent());
		}
		else {
			
			return CompanyStructureMapper.INSTANCE.toDatas(repo.findAll(filter.getKey(), pageable));
		}

	}

	@Override
	public int count(@NonNull CompanyStructureFilter filter) {
		
		
		if(Strings.isNullOrEmpty(filter.getKey()))
			return Long.valueOf(repo.count()).intValue();
		
		return repo.count(filter.getKey()).intValue();
	}

	@Override
	public List<CompanyStructureData> getAllStructure(@NonNull String topLevelCode) {
		
		List<CompanyStructureData> list = new ArrayList<>();
		
		Optional<CompanyStructure> cs = repo.findOneByPartyCode(topLevelCode);
		if(cs.isPresent()) {
			list.add(CompanyStructureMapper.INSTANCE.toData(cs.get()));
			populate(list, cs);
		}
		
		return null;
	}
	
	private void populate(List<CompanyStructureData> list, Optional<CompanyStructure> parent) {
		
		if(parent.isEmpty()) {
			
			repo.findAllChild(parent.get().getPartyCode()).stream().forEach(kid -> {
				
				list.add(CompanyStructureMapper.INSTANCE.toData(kid));
				populate(list, Optional.ofNullable(kid));
			});
		}
	}
}
