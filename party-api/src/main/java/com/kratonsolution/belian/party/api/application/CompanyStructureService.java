package com.kratonsolution.belian.party.api.application;

import java.util.List;

import com.kratonsolution.belian.party.api.CompanyStructureData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface CompanyStructureService {

	public CompanyStructureData create(@NonNull CompanyStructureCreateCommand command);

	public CompanyStructureData update(@NonNull CompanyStructureUpdateCommand command);

	public CompanyStructureData delete(@NonNull CompanyStructureDeleteCommand command);

	public CompanyStructureData getById(@NonNull String id);

	public CompanyStructureData getByCode(@NonNull String code);

	public List<CompanyStructureData> getAllRoot(@NonNull CompanyStructureFilter filter);

	public List<CompanyStructureData> getAll(@NonNull CompanyStructureFilter filter);
}
