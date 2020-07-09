package com.kratonsolution.belian.geographic.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.kratonsolution.belian.common.spring.SpecificationBuilder;
import com.kratonsolution.belian.common.spring.SpecificationBuilder.Operator;
import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.GeographicType;
import com.kratonsolution.belian.geographic.api.application.GeographicCreateCommand;
import com.kratonsolution.belian.geographic.api.application.GeographicDeleteCommand;
import com.kratonsolution.belian.geographic.api.application.GeographicFilter;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.geographic.api.application.GeographicUpdateCommand;
import com.kratonsolution.belian.geographic.impl.model.Geographic;
import com.kratonsolution.belian.geographic.impl.repository.GeographicRepository;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class GeographicServiceImpl implements GeographicService {

	@Autowired
	private GeographicRepository repo;

	@Secured("ROLE_GEOGRAPHIC_ADD")
	public GeographicData create(GeographicCreateCommand command) {

		Geographic geographic = null;

		if(!Strings.isNullOrEmpty(command.getParent())) {

			Optional<Geographic> opt = repo.findOneByCode(command.getParent());
			Preconditions.checkState(opt.isPresent(), "Parent geographic does not exist");
			geographic = new Geographic(opt.get(), command.getCode(), command.getName(), command.getType());
		}
		else {
			geographic = new Geographic(command.getCode(), command.getName(), command.getType());
		}

		geographic.setNote(command.getNote());

		log.info("Creating new Geographic {}", geographic);

		repo.save(geographic);

		return GeographicMapper.INSTANCE.toData(geographic);
	}

	@Override
	@Secured("ROLE_GEOGRAPHIC_UPDATE")
	public GeographicData update(GeographicUpdateCommand command) {

		Optional<Geographic> opt = repo.findOneByCode(command.getCode());
		Preconditions.checkState(opt.isPresent(), "Geographic does not exist");

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
		log.info("Updating Geographic {}", opt.get());

		return GeographicMapper.INSTANCE.toData(opt.get());
	}

	@Secured("ROLE_GEOGRAPHIC_DELETE")
	public GeographicData delete(GeographicDeleteCommand command) {

		Optional<Geographic> opt = repo.findOneByCode(command.getCode());
		if(opt.isPresent()) {
			
			repo.delete(opt.get());
			log.info("Deleting Geographic {}", opt.get());
		}

		return GeographicMapper.INSTANCE.toData(opt.orElse(null));
	}

	@Secured("ROLE_GEOGRAPHIC_READ")
	public GeographicData getByCode(String code) {

		return GeographicMapper.INSTANCE.toData(repo.findOneByCode(code).orElse(null));
	}

	@Secured("ROLE_GEOGRAPHIC_READ")
	public List<GeographicData> getAllGeographics() {

		return GeographicMapper.INSTANCE.toDatas(repo.findAll());
	}

	@Secured("ROLE_GEOGRAPHIC_READ")
	public List<GeographicData> getAllGeographics(int page, int size) {

		return GeographicMapper.INSTANCE.toDatas(repo.findAll(PageRequest.of(page, size)).getContent());
	}

	@Secured("ROLE_GEOGRAPHIC_READ")
	public List<GeographicData> getAllGeographics(@NonNull GeographicFilter filter, int page, int size) {

		if(filter.isValid()) {
			
			SpecificationBuilder<Geographic> builder = new SpecificationBuilder<>();

			if(filter.getCode().isPresent()) {

				builder.combine((root, query, cb) -> {return cb.like(root.get("code"), filter.getCode().get());}, Operator.OR);
			}

			if(filter.getName().isPresent()) {

				builder.combine((root, query, cb) -> {return cb.like(root.get("name"), filter.getName().get());}, Operator.OR);
			}

			if(filter.getType().isPresent()) {

				builder.combine((root, query, cb) -> {return cb.equal(root.get("type"), filter.getType().get());}, Operator.OR);
			}
			
			if(builder.getParent().isPresent()) {
				
				repo.findAll(Specification.where(builder.getParent().get()), PageRequest.of(page, size));
			}
		}

		return getAllGeographics(page, size);
	}

	@Secured("ROLE_GEOGRAPHIC_READ")
	public int count() {

		log.info("Count {}", repo.count());
		return (int)repo.count();
	}

	@Secured("ROLE_GEOGRAPHIC_READ")
	public int count(@NonNull GeographicFilter filter) {

		SpecificationBuilder<Geographic> builder = new SpecificationBuilder<>();

		if(filter.getCode().isPresent()) {

			builder.combine((root, query, cb) -> {return cb.like(root.get("code"), filter.getCode().get());}, Operator.OR);
		}

		if(filter.getName().isPresent()) {

			builder.combine((root, query, cb) -> {return cb.like(root.get("name"), filter.getName().get());}, Operator.OR);
		}

		if(filter.getType().isPresent()) {

			builder.combine((root, query, cb) -> {return cb.equal(root.get("type"), filter.getType().get());}, Operator.OR);
		}
		
		return Long.valueOf(repo.count(builder.getParent().get())).intValue();
	}

	@Secured("ROLE_GEOGRAPHIC_READ")
	public List<GeographicData> getAllGeographicRoots() {
		return GeographicMapper.INSTANCE.toDatas(repo.findAllRoots());
	}

	@Override
	public List<GeographicData> getAllByType(@NonNull GeographicType type) {
		return GeographicMapper.INSTANCE.toDatas(repo.findAllByType(type));
	}
}
