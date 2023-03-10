package com.kratonsolution.belian.common.core;

import java.util.Optional;

public interface Query {

    Optional<Integer> getOffset();

    Optional<Integer> getLimit();
}
