/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="organization")
public class Organization extends Party
{
}
