package com.kratonsolution.belian.authentication;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
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
