package com.kratonsolution.belian.access.role.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.kratonsolution.belian.access.role.api.RoleData;
import com.kratonsolution.belian.access.role.api.application.RoleCreateCommand;
import com.kratonsolution.belian.access.role.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.access.role.api.application.RoleFilter;
import com.kratonsolution.belian.access.role.api.application.RoleModuleCommand;
import com.kratonsolution.belian.access.role.api.application.RoleService;
import com.kratonsolution.belian.access.role.api.application.RoleUpdateCommand;
import com.kratonsolution.belian.access.role.impl.model.Role;
import com.kratonsolution.belian.access.role.impl.model.RoleModule;
import com.kratonsolution.belian.access.role.impl.repository.RoleRepository;
import com.kratonsolution.belian.common.application.EventSourceName;
import com.kratonsolution.belian.common.application.SystemEvent;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private ApplicationEventPublisher publisher;

	public RoleData create(RoleCreateCommand command) {

		Role role = new Role(command.getCode(), command.getName(), command.getNote(), command.isEnabled());

		command.getModules().forEach(m -> {

			RoleModule module = new RoleModule(role, m.getModuleCode(), m.getModuleName(), m.getModuleGroup(),
					m.isRead(), m.isAdd(), m.isEdit(), m.isDelete(), m.isPrint());

			role.addRoleModule(module);
		});

		
		roleRepo.save(role);

		SystemEvent event = new SystemEvent(EventSourceName.ACCESS_ROLE, SystemEvent.ADD);
		event.add("code", role.getCode());

		publisher.publishEvent(event);
		
		log.info("Creating & publishing new Role data {}", role);

		return RoleMapper.INSTANCE.toData(role);
	}

	public RoleData update(RoleUpdateCommand command) {

		Optional<Role> opt = roleRepo.findOneByCode(command.getCode());
		Preconditions.checkState(opt.isPresent(), "Role does not exist");

		opt.get().setEnabled(command.isEnabled());
		opt.get().setNote(command.getNote());

		if(!Strings.isNullOrEmpty(command.getName())) {
			opt.get().setName(command.getName());
		}

		opt.get().getModules().forEach(mod -> {

			Optional<RoleModuleCommand> cmd = command.getModules().stream()
					.filter(p->p.getModuleCode().equals(mod.getModuleCode()))
					.findFirst();

			if(cmd.isPresent()) {

				mod.setAdd(cmd.get().isAdd());
				mod.setDelete(cmd.get().isDelete());
				mod.setEdit(cmd.get().isEdit());
				mod.setPrint(cmd.get().isPrint());
				mod.setRead(cmd.get().isRead());
			}
		});

		roleRepo.save(opt.get());

		SystemEvent event = new SystemEvent(EventSourceName.ACCESS_ROLE, SystemEvent.UPDATE);
		event.add("code", opt.get().getCode());
		
		log.info("Updating role {}", opt.get());

		return RoleMapper.INSTANCE.toData(opt.get());
	}

	public RoleData delete(RoleDeleteCommand command) {

		Optional<Role> opt = roleRepo.findOneByCode(command.getCode());
		
		Preconditions.checkState(opt.isPresent(), "Role does not exist");

		roleRepo.delete(opt.get());

		SystemEvent event = new SystemEvent(EventSourceName.ACCESS_ROLE, SystemEvent.DELETE);
		event.add("code", opt.get().getCode());
		
		log.info("Deleting role {}", opt.get());

		return RoleMapper.INSTANCE.toData(opt.get());
	}

	public RoleData getByCode(String code) {

		return RoleMapper.INSTANCE.toData(roleRepo.findOneByCode(code).orElse(null));
	}

	public List<RoleData> getAllRoles() {

		return RoleMapper.INSTANCE.toRoleDatas(roleRepo.findAll());
	}

	public List<RoleData> getAllRoles(int page, int size) {

		return RoleMapper.INSTANCE.toRoleDatas(roleRepo.findAll(PageRequest.of(page, size)).getContent());
	}

	public List<RoleData> getAllRoles(@NonNull RoleFilter filter, int page, int size) {

		ExampleMatcher matcher = ExampleMatcher.matchingAny();
		matcher.withMatcher("code", GenericPropertyMatchers.contains().ignoreCase());
		matcher.withMatcher("name", GenericPropertyMatchers.contains().ignoreCase());

		return RoleMapper.INSTANCE.toRoleDatas(
				roleRepo.findAll(Example.of(new Role(filter.getKey(), filter.getKey()), matcher), 
						PageRequest.of(page, size)).getContent());
	}


	public List<RoleData> getAllRoles(@NonNull RoleFilter filter) {

		if(Strings.isNullOrEmpty(filter.getKey())) {
			return getAllRoles(filter.getPage(), filter.getSize());
		}
		
		return RoleMapper.INSTANCE.toRoleDatas(
				roleRepo.getAll("%"+filter.getKey()+"%", PageRequest.of(filter.getPage(), filter.getSize())));
	}

	public int count() {

		return (int)roleRepo.count();
	}

	public int count(@NonNull RoleFilter filter) {

		return roleRepo.count("%"+filter.getKey()+"%").intValue();
	}
}
