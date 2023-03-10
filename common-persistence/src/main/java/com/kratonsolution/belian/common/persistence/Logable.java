
package com.kratonsolution.belian.common.persistence;

import java.io.Serializable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface Logable extends Serializable
{
	public void setLog(AuditLog log);
	
	public AuditLog getLog();
}
