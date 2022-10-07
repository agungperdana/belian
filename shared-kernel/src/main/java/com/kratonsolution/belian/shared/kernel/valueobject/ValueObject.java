package com.kratonsolution.belian.shared.kernel.valueobject;

public abstract class ValueObject<V> {

    public abstract V getValue();

    @Override
    public String toString() {
        return getValue()!=null?getValue().toString():"";
    }
}
