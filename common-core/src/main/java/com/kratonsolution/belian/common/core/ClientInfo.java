package com.kratonsolution.belian.common.core;

/**
 * @author ADODI
 * @since 1.0.1
 *
 * Not realy usefull for now, the purpose of this class is for identification.
 * for example if the request came from internal like web(client) or another application module.
 * or else if this communication came from third party application, maybe we can check for license key
 * or something like that.
 */
public interface ClientInfo {

    enum Type {INTERNAL, EXTERNAL, THRID_PARTY}

    String getName();

    Type getType();
}
