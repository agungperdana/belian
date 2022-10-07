package com.kratonsolution.belian.shared.kernel.valueobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void emailCannotBeNull() {
        Assertions.assertThrows(NullPointerException.class, ()->new Email(null));
    }

    @Test
    public void emailShouldThrowInvalidFormat() {
        Email email = new Email("rudi");
        Assertions.assertThrows(RuntimeException.class, ()->email.validate());
    }

    @Test
    public void emailShouldBeInValidFormat() {
        Email email = new Email("rudi@gmail.com");
        Assertions.assertDoesNotThrow(()->email.validate());
    }
}
