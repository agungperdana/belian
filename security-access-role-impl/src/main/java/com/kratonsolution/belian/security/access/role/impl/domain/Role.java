package com.kratonsolution.belian.security.access.role.impl.domain;

import com.kratonsolution.belian.shared.kernel.valueobject.Validateable;
import com.kratonsolution.belian.shared.kernel.valueobject.ValueObject;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Role extends ValueObject<String> implements Validateable<Role> {

    private String value;

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public Role validate() {
        return this;
    }
}
