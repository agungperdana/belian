package com.kratonsolution.belian.companystructure.api.application;

import java.util.List;

import com.kratonsolution.belian.companystructure.api.CompanyStructureData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
public interface CompanyStructureService {

	CompanyStructureData create(@NonNull CompanyStructureCreateCommand command);

	CompanyStructureData update(@NonNull CompanyStructureUpdateCommand command);

	CompanyStructureData delete(@NonNull CompanyStructureDeleteCommand command);

	CompanyStructureData getByCode(@NonNull String code);

	List<CompanyStructureData> getAllCompanyStructures();

	List<CompanyStructureData> getAllCompanyStructureRoots();

	List<CompanyStructureData> getAllCompanyStructures(@NonNull CompanyStructureFilter filter);

	int count(@NonNull CompanyStructureFilter filter);
}
