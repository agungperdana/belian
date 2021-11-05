package com.kratonsolution.belian.companystructure.impl.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.companystructure.api.CompanyStructureType;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
@Getter
@Entity
@Table(name = "company_structure")
public class CompanyStructure {

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name = "start")
	private Date start;

	@Column(name = "end")
	private Date end;

	@Column(name = "party_code")
	private String partyCode;

	@Column(name = "party_name")
	private String partyName;

	@Column(name = "parent_party_code")
	private String parentPartyCode;

	@Column(name = "parent_party_name")
	private String parentPartyName;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private CompanyStructureType type;

	@Version
	private Long version;

	CompanyStructure() {}

	public CompanyStructure(@NonNull Date start, @NonNull String partyCode, @NonNull String partyName, 
			@NonNull CompanyStructureType type) {

		this(start, partyCode, partyName, type, null, null, null);
	}

	public CompanyStructure(@NonNull Date start, @NonNull String partyCode, @NonNull String partyName, 
			@NonNull CompanyStructureType type, String parentPartyCode, String parentPartyName) {

		this(start, partyCode, partyName, type, parentPartyCode, parentPartyName, null);
	}

	public CompanyStructure(@NonNull Date start, @NonNull String partyCode, @NonNull String partyName, 
			@NonNull CompanyStructureType type, String parentPartyCode, String parentPartyName, Date end) {

		this.start = start;
		this.partyCode = partyCode;
		this.partyName = partyName;
		this.type = type;
		this.parentPartyCode = parentPartyCode;
		this.parentPartyName = parentPartyName;
		this.end = end;
	}

	public void update(Date end, String parentPartyCode, String parentPartyName) {

		this.end = end;
		this.parentPartyCode = parentPartyCode;
		this.parentPartyName = parentPartyName;
	}
}
