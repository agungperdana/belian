package com.kratonsolution.belian.security.access.module.impl.application;

import lombok.NonNull;
import org.springframework.context.ApplicationEvent;

public class ModuleEvent extends ApplicationEvent {

    public ModuleEvent(@NonNull String[] source) {
        super(source);
    }
}
