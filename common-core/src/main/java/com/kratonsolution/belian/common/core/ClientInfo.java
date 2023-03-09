package com.kratonsolution.belian.common.core;

public interface ClientInfo {

    String INTERNAL = "INTERNAL";
    String THRID_PARTY = "THRID_PARTY";

    String getName();

    String getType();

    void setType();
}
