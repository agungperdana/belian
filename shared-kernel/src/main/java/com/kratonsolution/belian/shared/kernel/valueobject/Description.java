package com.kratonsolution.belian.shared.kernel.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Description extends ValueObject<String> implements Validateable<Description> {

    public static final Description EMPTY = new Description(null);

    @Getter
    private String value;

    public static Description is(String description) {

        if(description != null)
            return new Description(description);

        return null;
    }

    @Override
    public Description validate() {

        return this;
    }
}
