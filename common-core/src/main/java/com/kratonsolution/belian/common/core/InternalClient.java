package com.kratonsolution.belian.common.core;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@AllArgsConstructor
public class InternalClient implements ClientInfo {

    private String name;

    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return Type.INTERNAL;
    }
}
