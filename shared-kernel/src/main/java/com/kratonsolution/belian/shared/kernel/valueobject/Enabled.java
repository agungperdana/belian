package com.kratonsolution.belian.shared.kernel.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class Enabled extends ValueObject<Boolean> implements Validateable<Enabled> {

    public static final Enabled YES = new Enabled(Boolean.TRUE);

    public static final Enabled NO = new Enabled(Boolean.FALSE);

    @NonNull
    @Getter
    private Boolean value = Boolean.FALSE;

    private Enabled(){}

    public static Enabled is(@NonNull Boolean enabled) {
        return new Enabled(enabled);
    }

    @Override
    public Enabled validate() {

        return this;
    }
}
