package com.kratonsolution.belian.security.access.module.impl.domain;

import com.kratonsolution.belian.shared.kernel.valueobject.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class AccessModule implements Validateable<AccessModule> {

    @NonNull
    private Name name;

    @NonNull
    @Builder.Default
    private Group group = Group.general();

    @NonNull
    @Builder.Default
    private Enabled enabled = Enabled.YES;

    @Builder.Default
    private Description description = Description.EMPTY;

    @Override
    public AccessModule validate() {

        name.validate();
        group.validate();
        enabled.validate();
        description.validate();

        return this;
    }
}
