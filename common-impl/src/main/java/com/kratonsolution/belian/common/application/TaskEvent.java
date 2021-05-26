package com.kratonsolution.belian.common.application;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Getter
@Setter
public class TaskEvent {

	private String target;

	private EventType type;

	private Map<String, Object> payload = new HashMap<>();

	public TaskEvent(@NonNull String target, @NonNull EventType type) {

		this.target = target;
		this.type = type;
	}
	
	TaskEvent(@NonNull String target, @NonNull EventType type, @NonNull Map<String, Object> payload) {

		this.target = target;
		this.type = type;
		this.payload.putAll(payload);
	}

	public static TaskEvent get(@NonNull String target, @NonNull EventType type) {

		return new TaskEvent(target, type);
	}

	public static TaskEvent get(@NonNull String target, @NonNull EventType type, @NonNull Map<String, Object> payload) {

		return new TaskEvent(target, type, payload);
	}
}
