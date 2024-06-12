package com.kratonsolution.belian.common.app;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Referenceable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Component
public class SessionUtil implements Referenceable {

    // TODO: 6/7/2024 dummy method, please fix
    public SessionUtil getOrganization()
    {
        return this;
    }

    // TODO: 6/7/2024 dummy method, please fix
    public String getId()
    {
        return UUID.randomUUID().toString();
    }

    // TODO: 6/7/2024 dummy method, please fix
    public boolean isEmpty()
    {
        return true;
    }

    // TODO: 6/7/2024 dummy method, please fix
    public List<String> getOrganizationIds()
    {
        return new ArrayList();
    }

    // TODO: 6/7/2024 dummy method, please fix
    public String getUserName()
    {
        return UUID.randomUUID().toString();
    }

    // TODO: 6/7/2024 dummy method, please fix
    public SessionUtil getUser()
    {
        return this;
    }

    public SessionUtil getPerson()
    {
        return this;
    }

    public SessionUtil getCurrency()
    {
        return this;
    }

    public SessionUtil getFacility()
    {
        return this;
    }

    @Override
    public String getLabel() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getValue() {
        return UUID.randomUUID().toString();
    }

    @Override
    public IDValueRef toRef() {
        return Referenceable.super.toRef();
    }

    @Override
    public boolean isValid(IDValueRef ref) {
        return Referenceable.super.isValid(ref);
    }
}
