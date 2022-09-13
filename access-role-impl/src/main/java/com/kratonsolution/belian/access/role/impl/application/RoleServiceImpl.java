package com.kratonsolution.belian.access.role.impl.application;

import com.kratonsolution.belian.access.role.api.RoleData;
import com.kratonsolution.belian.access.role.api.application.RoleCreateCommand;
import com.kratonsolution.belian.access.role.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.access.role.api.application.RoleService;
import com.kratonsolution.belian.access.role.api.application.RoleUpdateCommand;
import com.kratonsolution.belian.access.role.impl.entity.R2DBCRoleEntity;
import com.kratonsolution.belian.access.role.impl.entity.R2DBCRoleModuleEntity;
import com.kratonsolution.belian.access.role.impl.repository.RoleModuleRepository;
import com.kratonsolution.belian.access.role.impl.repository.RoleRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 * @version 2.0.1
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repo;

	@Autowired
	private RoleModuleRepository moduleRepository;

	public Mono<RoleData> create(Mono<RoleCreateCommand> command) {

		return command.flatMap(com -> {

			R2DBCRoleEntity role = R2DBCRoleEntity.builder()
				.id(UUID.randomUUID().toString())
				.code(com.getCode())
				.name(com.getName())
				.note(com.getNote())
				.enabled(com.isEnabled())
				.build();

			repo.save(role).subscribe(r -> {

				com.getModules().stream().forEach(mod -> {
					R2DBCRoleModuleEntity module = R2DBCRoleModuleEntity.builder()
							.id(UUID.randomUUID().toString())
							.add(mod.isAdd())
							.edit(mod.isEdit())
							.print(mod.isPrint())
							.read(mod.isRead())
							.delete(mod.isDelete())
							.moduleCode(mod.getModuleCode())
							.moduleName(mod.getModuleName())
							.moduleGroup(mod.getModuleGroup())
							.roleCode(com.getCode())
							.build();

					moduleRepository.save(module).subscribe();
				});
			});

			return Mono.just(RoleMapper.INSTANCE.toData(role));
		});
	}

	@Override
	public Mono<RoleData> update(@NonNull Mono<RoleUpdateCommand> command) {

		return command.flatMap(com -> {

			return repo.findOneByCode(com.getCode()).flatMap(role -> {

				role.setNote(com.getNote());
				role.setEnabled(com.isEnabled());

				repo.save(role).subscribe(r -> {

					com.getModules().stream().forEach(mod -> {

						moduleRepository.findOneByRoleCodeAndModuleCode(r.getCode(), mod.getModuleCode())
								.flatMap(m -> {

									m.setRead(mod.isRead());
									m.setAdd(mod.isAdd());
									m.setEdit(mod.isEdit());
									m.setDelete(mod.isDelete());
									m.setPrint(mod.isPrint());

									moduleRepository.save(m).subscribe();
									return Mono.just(m);
								});
					});
				});

				return Mono.just(RoleMapper.INSTANCE.toData(role));
			});
		});
	}

	public Mono<RoleData> delete(@NonNull Mono<RoleDeleteCommand> command) {

		return command.flatMap(com -> repo.findOneByCode(com.getCode()))
					  .flatMap(entity -> {
							repo.deleteById(entity.getId()).subscribe(e -> {

								moduleRepository.findAllByRoleCode(entity.getCode())
										.flatMap(mod -> moduleRepository.deleteByRoleAndModule(mod.getRoleCode(), mod.getModuleCode()));
							});

							return Mono.just(RoleMapper.INSTANCE.toData(entity));
						});
	}

	public Mono<RoleData> getById(@NonNull String id) {

		return repo.findById(id).flatMap(mod -> Mono.just(RoleMapper.INSTANCE.toData(mod)));
	}

	public Mono<RoleData> getByCode(@NonNull String code) {

		return repo.findOneByCode(code).flatMap(entity->Mono.just(RoleMapper.INSTANCE.toData(entity)));
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
