package com.kratonsolution.belian.common.core;

import lombok.Data;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Data
public class ThirdPartyClient implements ClientInfo {

    private String name;

    @Override
    public String getType() {
        return THRID_PARTY;
    }
}
