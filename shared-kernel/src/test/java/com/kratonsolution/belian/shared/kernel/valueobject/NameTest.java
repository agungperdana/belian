package com.kratonsolution.belian.shared.kernel.valueobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void nameCannotBeNull() {
        Name name = new Name(null);
        Assertions.assertThrows(RuntimeException.class, ()->name.validate());
    }

    @Test
    public void nameCannotBeEmpty() {
        Name name = new Name("", 1, 10);
        Assertions.assertThrows(RuntimeException.class, ()->name.validate());
    }

    @Test
    public void nameValidationTest() {
        Name name = new Name("rudy");
        Assertions.assertDoesNotThrow(()->name.validate());
    }

    @Test
    public void nameNotValidTest() {

        Name name = new Name("hallo", 10, 100);
        Assertions.assertThrows(RuntimeException.class, ()->name.validate(), "error");
    }
}
