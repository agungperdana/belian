package com.kratonsolution.belian.party.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.kratonsolution.belian.party.api.CompanyStructureData;
import com.kratonsolution.belian.party.api.application.CompanyStructureCreateCommand;
import com.kratonsolution.belian.party.api.application.CompanyStructureDeleteCommand;
import com.kratonsolution.belian.party.api.application.CompanyStructureFilter;
import com.kratonsolution.belian.party.api.application.CompanyStructureService;
import com.kratonsolution.belian.party.api.application.CompanyStructureUpdateCommand;
import com.kratonsolution.belian.party.impl.model.CompanyStructure;
import com.kratonsolution.belian.party.impl.repository.CompanyStructureRepository;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class CompanyStructureServiceImpl implements CompanyStructureService {

	@Autowired
	private CompanyStructureRepository repo;

	@Override
	public CompanyStructureData create(@NonNull CompanyStructureCreateCommand command) {

		CompanyStructure structure = new CompanyStructure();
		structure.setCode(command.getCode());
		structure.setName(command.getName());
		structure.setNote(command.getNote());

		if(!Strings.isNullOrEmpty(command.getParent())) {

			Optional<CompanyStructure> opt = repo.getOneByCode(command.getParent());
			if(opt.isPresent()) {

				structure.setParent(opt.get());
				opt.get().getChildren().add(structure);

				repo.save(opt.get());
			}
			else {

				repo.save(structure);
			}
		}
		else {

			repo.save(structure);
		}

		return CompanyStructureMapper.INSTANCE.toData(structure);
	}

	@Override
	public CompanyStructureData update(@NonNull CompanyStructureUpdateCommand command) {

		Optional<CompanyStructure> opt = exist(command.getCode());

		if(!Strings.isNullOrEmpty(command.getName())) {
			opt.get().setName(command.getName());
		}

		if(!Strings.isNullOrEmpty(command.getNote())) {
			opt.get().setNote(command.getNote());
		}

		if(command.getType() != null) {
			opt.get().setType(command.getType());
		}

		repo.save(opt.get());

		return CompanyStructureMapper.INSTANCE.toData(opt.get());
	}

	@Override
	public CompanyStructureData delete(@NonNull CompanyStructureDeleteCommand command) {

		return CompanyStructureMapper.INSTANCE.toData(exist(command.getCode()).get());
	}

	@Override
	public CompanyStructureData getById(@NonNull String id) {
		return CompanyStructureMapper.INSTANCE.toData(repo.getOne(id));
	}

	@Override
	public CompanyStructureData getByCode(@NonNull String code) {

		return CompanyStructureMapper.INSTANCE.toData(repo.getOneByCode(code).orElse(null));
	}

	@Override
	public List<CompanyStructureData> getAllRoot(@NonNull CompanyStructureFilter filter) {

		if(Strings.isNullOrEmpty(filter.getKey())) {
			return CompanyStructureMapper.INSTANCE.toDatas(
					repo.loadAllRoot(PageRequest.of(filter.getPage(), filter.getSize())));
		}
		else {

			return CompanyStructureMapper.INSTANCE.toDatas(
					repo.loadAllRoot(filter.getKey(), 
							PageRequest.of(filter.getPage(), filter.getSize())));
		}
	}

	@Override
	public List<CompanyStructureData> getAll(@NonNull CompanyStructureFilter filter) {

		if(Strings.isNullOrEmpty(filter.getKey())) {
			return CompanyStructureMapper.INSTANCE.toDatas(
					repo.loadAll(PageRequest.of(filter.getPage(), filter.getSize())));
		}
		else {

			return CompanyStructureMapper.INSTANCE.toDatas(
					repo.loadAll(filter.getKey(), 
							PageRequest.of(filter.getPage(), filter.getSize())));
		}
	}

	private Optional<CompanyStructure> exist(@NonNull String code) {
		Optional<CompanyStructure> opt = repo.getOneByCode(code);
		Preconditions.checkState(opt.isPresent(), "Company structure with code {} does not exist", code);
		return opt;
	}
}
