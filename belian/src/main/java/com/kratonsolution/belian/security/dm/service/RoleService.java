/**
 * 
 */
package com.kratonsolution.belian.security.dm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.security.dm.ModuleRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class RoleService
{
	@Autowired
	private ModuleRepository moduleRepository;
}
