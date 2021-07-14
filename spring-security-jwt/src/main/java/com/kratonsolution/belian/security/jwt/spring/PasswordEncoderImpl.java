package com.kratonsolution.belian.security.jwt.spring;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class PasswordEncoderImpl implements PasswordEncoder
{
	private StrongPasswordEncryptor encrypt = new StrongPasswordEncryptor();
	
	@Override
	public String encode(CharSequence rawPassword)
	{
		return encrypt.encryptPassword(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword)
	{
		return encrypt.checkPassword(rawPassword.toString(),encodedPassword);
	}
}
