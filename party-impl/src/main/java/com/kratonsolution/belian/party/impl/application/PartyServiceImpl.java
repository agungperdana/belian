package com.kratonsolution.belian.party.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.application.PartyService;
import com.kratonsolution.belian.party.impl.repository.PartyRepository;

import lombok.NonNull;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
@Transactional(readOnly = true)
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyRepository repo;
	
	@Override
	public Optional<PartyData> getByCode(@NonNull String code) {
		return Optional.ofNullable(PartyMapper.INSTANCE.toData(repo.findOneByCode(code)));
	}

	@Override
	public List<PartyData> getAllParty() {
		return PartyMapper.INSTANCE.toDatas(repo.findAll());
	}

}
