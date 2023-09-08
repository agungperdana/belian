package com.kratonsolution.belian.common.persistence;

import lombok.NonNull;

import java.util.Optional;

public interface BasicCodeAndNameRepository <M> {

    public Optional<M> getOneByCode(@NonNull String code);

    public Optional<M> getOneByName(@NonNull String name);
}
