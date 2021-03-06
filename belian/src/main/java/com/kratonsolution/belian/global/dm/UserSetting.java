/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="user_setting")
public class UserSetting implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="organization_id")),
		@AttributeOverride(name="value",column=@Column(name="organization_value"))
	})
	private IDValueRef organization;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="location_id")),
		@AttributeOverride(name="value",column=@Column(name="location_value"))
	})
	private IDValueRef location;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="facility_id")),
		@AttributeOverride(name="value",column=@Column(name="facility_value"))
	})
	private IDValueRef facility;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="currency_id")),
		@AttributeOverride(name="value",column=@Column(name="currency_value"))
	})
	private IDValueRef currency;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="tax_id")),
		@AttributeOverride(name="value",column=@Column(name="tax_value"))
	})
	private IDValueRef tax;
	
	@Column(name="language")
	private String language;
	
	@Column(name="row_per_page")
	private int rowPerPage = 25;
	
	@Enumerated(EnumType.STRING)
	@Column(name="printer_type")
	private PrinterType printer = PrinterType.STANDARD;
	
	@Version
	private Long version;

	public UserSetting()
	{
		setOrganization(new IDValueRef());
		setLocation(new IDValueRef());
		setCurrency(new IDValueRef());
		setTax(new IDValueRef());
		setLanguage("in_ID");
	}
}
