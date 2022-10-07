package com.kratonsolution.belian.security.access.role.impl.application;

import com.google.gson.Gson;
import com.kratonsolution.belian.security.access.role.api.RoleData;
import com.kratonsolution.belian.security.access.role.api.application.RoleCreateCommand;
import com.kratonsolution.belian.security.access.role.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.security.access.role.api.application.RoleService;
import com.kratonsolution.belian.security.access.role.api.application.RoleUpdateCommand;
import com.kratonsolution.belian.security.access.role.impl.domain.AccessRole;
import com.kratonsolution.belian.security.access.role.impl.domain.Modules;
import com.kratonsolution.belian.security.access.role.impl.entity.R2DBCRoleEntity;
import com.kratonsolution.belian.security.access.role.impl.repository.RoleRepository;
import com.kratonsolution.belian.shared.kernel.valueobject.Description;
import com.kratonsolution.belian.shared.kernel.valueobject.Enabled;
import com.kratonsolution.belian.shared.kernel.valueobject.Group;
import com.kratonsolution.belian.shared.kernel.valueobject.Name;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.GsonJsonParser;
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
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

	private RoleRepository repo;

	public Mono<RoleData> create(@NonNull Mono<RoleCreateCommand> command) {

		GsonJsonParser parser = new GsonJsonParser();

		return command.map(com -> {

					AccessRole role = AccessRole.builder()
							.name(Name.is(com.getName()))
							.enabled(Enabled.is(com.isEnabled()))
							.description(Description.is(com.getDescription()))
							.build();

					com.getModules().forEach(mod->role.addModule(
							Name.is(mod.getName()),
							Group.is(mod.getGroup()),
							Enabled.is(mod.isRead()),
							Enabled.is(mod.isAdd()),
							Enabled.is(mod.isEdit()),
							Enabled.is(mod.isDelete()),
							Enabled.is(mod.isPrint())));

					R2DBCRoleEntity entity = RoleMapper.INSTANCE.domainToEntity(role.validate());
					entity.setId(UUID.randomUUID().toString());
					return entity;
				})
				.flatMap(repo::save)
				.map(RoleMapper.INSTANCE::toData);
	}

	@Override
	public Mono<RoleData> update(@NonNull Mono<RoleUpdateCommand> command) {

		return command.flatMap(com -> {

			return repo.findOneByName(com.getName()).flatMap(entity -> {

				entity.setEnabled(com.isEnabled());
				entity.setDescription(com.getDescription());

				Modules modules = new Gson().fromJson(entity.getModules().asString(), Modules.class);
				com.getModules().forEach(m->{
					modules.update(
							Name.is(m.getName()),
							Enabled.is(m.isRead()),
							Enabled.is(m.isAdd()),
							Enabled.is(m.isEdit()),
							Enabled.is(m.isDelete()),
							Enabled.is(m.isPrint())
					);
				});

				modules.validate();
				entity.setModules(RoleMapper.INSTANCE.modulesToJson(modules));
				return repo.save(entity).thenReturn(entity);
			});
		})
		.map(RoleMapper.INSTANCE::toData);

	}

	public Mono<Void> delete(@NonNull Mono<RoleDeleteCommand> command) {

		return command.flatMap(com -> repo.deleteByName(com.getName())).then();
	}

	public Mono<RoleData> getByName(@NonNull String name) {

		return repo.findOneByName(name).map(RoleMapper.INSTANCE::toData);
	}

	public Flux<RoleData> getAll() {

		return repo.getAll().map(RoleMapper.INSTANCE::toData);
	}

	public Flux<RoleData> getAll(int offset, int limit) {

		return repo.getAll(offset, limit).map(RoleMapper.INSTANCE::toData);
	}

	public Mono<Long> count() {

		return repo.count();
	}

	public Mono<Long> count(@NonNull String key) {

		return repo.count(key+"%");
	}

	@Override
	public Flux<RoleData> filter(@NonNull String key) {
		return repo.filter(key+"%").map(RoleMapper.INSTANCE::toData);
	}

	public Flux<RoleData> filter(@NonNull String key, int offset, int limit) {

		return repo.filter(key+"%", offset, limit).map(RoleMapper.INSTANCE::toData);
	}
}
