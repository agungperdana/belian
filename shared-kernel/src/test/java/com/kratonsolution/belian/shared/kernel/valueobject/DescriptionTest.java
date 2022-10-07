package com.kratonsolution.belian.shared.kernel.valueobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DescriptionTest {

    @Test
    public void descriptionEquals() {
        Description description = new Description("ok");
        Assertions.assertEquals("ok", description.toString());
    }
}
