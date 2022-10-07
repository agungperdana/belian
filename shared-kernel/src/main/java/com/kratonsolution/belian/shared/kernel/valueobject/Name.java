package com.kratonsolution.belian.shared.kernel.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class Name extends ValueObject<String> implements Validateable<Name> {

    @NonNull
    @Getter
    private String value;

    private int minLength = 1;

    private int maxLength = 150;

    private Name(){}

    public static Name is(@NonNull String name) {
        return new Name(name);
    }

    public Name(String value) {
        this.value = value;
    }

    @Override
    public Name validate() {

        if(value.length() < minLength || value.length() > maxLength)
            throw new RuntimeException(String.format("Name length must be between %s and %s", minLength, maxLength));

        return this;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Name))
            return false;

        return this.value.equals(((Name) obj).getValue());
    }
}
