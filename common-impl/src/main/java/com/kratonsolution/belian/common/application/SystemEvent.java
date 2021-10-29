package com.kratonsolution.belian.common.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
public class SystemEvent {

	public static final String ADD = "ADD";
	
	public static final String UPDATE = "UPDATE";
	
	public static final String DELETE = "DELETE";
	
	public static final String PRINT = "PRINT";
	
	public static final String PAYLOAD_CODE = "CODE";
	
	public static final String PAYLOAD_NAME = "NAME";
	
	@Getter
	private String source;

	@Getter
	private String type = ADD;

	private Map<String, Object> payload = new HashMap<>();

	public SystemEvent(@NonNull String source, @NonNull String type) {
		this(source, type, null);
	}
	
	SystemEvent(@NonNull String source, @NonNull String type, Map<String, Object> payload) {

		this.source = source;
		
		this.type = type;
		if(payload != null)
			this.payload.putAll(payload);
	}
	
	public void add(@NonNull String key, @NonNull Object value) {
		
		this.payload.put(key, value);
	}
	
	public Optional<Object> get(@NonNull String key) {

		return Optional.ofNullable(this.payload.get(key));
	}
	
	public Optional<String> getAsString(@NonNull String key) {

		if(this.payload.containsKey(key) && this.payload.get(key) instanceof String) {
			return Optional.ofNullable(this.payload.get(key).toString());
		}
		
		return Optional.ofNullable(null);
	}
}
