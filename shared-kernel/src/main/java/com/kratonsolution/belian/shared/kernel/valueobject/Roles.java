package com.kratonsolution.belian.shared.kernel.valueobject;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Roles extends ValueObject<String> implements Validateable<Roles> {

    @NonNull
    private String value = "{}";

    @Override
    public Roles validate() {

        return this;
    }
}
