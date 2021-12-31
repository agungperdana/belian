package com.kratonsolution.belian.access.module.impl.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kratonsolution.belian.access.module.api.ModuleGroup;
import com.kratonsolution.belian.access.module.impl.model.Module;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ModuleRepositoryTest {

//	@Autowired
//	private ModuleRepository repo;
//
//	@Test
//	public void create() {
//
//		Module module = new Module("TEST", "TEST MODUL", ModuleGroup.GLOBAL);
//		repo.save(module);
//		assertTrue(repo.findOneByCode("TEST").isPresent());
//	}
//
//	@Test
//	public void update() {
//
//		Optional<Module> opt = repo.findOneByCode("MDL 1");
//		assertThat(opt).isPresent();
//
//		opt.get().setLastUpdatedBy("Joni su joni");
//		opt.get().setLastUpdatedDate(LocalDateTime.now());
//
//		repo.save(opt.get());
//
//		opt = repo.findOneByCode("MDL 1");
//		assertThat(opt).isPresent();
//		assertNotNull(opt.get().getLastUpdatedBy());
//		assertNotNull(opt.get().getLastUpdatedDate());
//	}
//
//	@Test
//	public void count() {
//		assertEquals(repo.count(), 5);
//	}
//
//	@Test
//	public void loadALl() {
//
//		List<Module> list = repo.findAll();
//		assertTrue(!list.isEmpty() && list.stream().filter(p->p.getCode().equals("MDL 1")).findFirst().isPresent());
//	}
}
