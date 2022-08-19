package com.kratonsolution.belian.access.role.impl.application;

import com.kratonsolution.belian.access.role.api.RoleData;
import com.kratonsolution.belian.access.role.api.RoleEntity;
import com.kratonsolution.belian.access.role.api.application.RoleCreateCommand;
import com.kratonsolution.belian.access.role.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.access.role.api.application.RoleService;
import com.kratonsolution.belian.access.role.api.application.RoleUpdateCommand;
import com.kratonsolution.belian.access.role.impl.domain.AccessRole;
import com.kratonsolution.belian.access.role.impl.entity.R2DBCRoleEntity;
import com.kratonsolution.belian.access.role.impl.repository.RoleRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 * @version 2.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repo;

	@Autowired
	private DatabaseClient db;

	public Mono<RoleData> create(RoleCreateCommand command) {

		R2DBCRoleEntity role = R2DBCRoleEntity.builder()
				.id(UUID.randomUUID().toString())
				.code(command.getCode())
				.name(command.getName())
				.note(command.getNote())
				.enabled(command.isEnabled())
				.build();

		repo.save(role).subscribe();
		return Mono.just(RoleMapper.INSTANCE.toData(role));
	}

	@Override
	public Mono<RoleData> update(RoleUpdateCommand command) {

		return repo.findOneByCode(command.getCode())
				.map(entity -> {
					AccessRole.withEntity(entity)
							.changeNote(command.getNote())
							.changeActiveStatus(command.isEnabled());
					repo.save(entity).subscribe();
					return RoleMapper.INSTANCE.toData(entity);
				});
	}

	public Mono<RoleData> delete(RoleDeleteCommand command) {

		return repo.findOneByCode(command.getCode())
				.map(role -> {
					repo.deleteById(role.getId()).subscribe();
					return RoleMapper.INSTANCE.toData(role);
				});
	}

	public Mono<RoleData> getById(@NonNull String id) {

		return repo.findById(id).map(mod -> RoleMapper.INSTANCE.toData(mod));
	}

	public Mono<RoleData> getByCode(@NonNull String code) {

		return repo.findOneByCode(code).map(Role -> RoleMapper.INSTANCE.toData(Role));
	}

	public Flux<RoleData> getAll() {

		return repo.getAll();
	}

	public Flux<RoleData> getAll(int offset, int limit) {

		return repo.getAll(offset, limit);
	}

	public Mono<Long> count() {

		return repo.count();
	}

	public Mono<Long> count(@NonNull String key) {

		return repo.count(key+"%");
	}

	@Override
	public Flux<RoleData> filter(@NonNull String key) {
		return repo.filter(key+"%");
	}

	public Flux<RoleData> filter(@NonNull String key, int offset, int limit) {

		return repo.filter(key+"%", offset, limit);
	}

}
