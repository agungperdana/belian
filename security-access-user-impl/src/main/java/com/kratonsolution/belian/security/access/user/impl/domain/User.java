package com.kratonsolution.belian.security.access.user.impl.domain;

import com.kratonsolution.belian.security.access.user.impl.entity.R2DBCUserEntity;
import com.kratonsolution.belian.shared.kernel.valueobject.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class User implements Validateable<User> {

    @NonNull
    private Name name;

    @NonNull
    private Email email;

    @Builder.Default
    private Source source = Source.LOCAL;

    @NonNull
    @Builder.Default
    private Enabled enabled = Enabled.YES;

    @Override
    public User validate() {

        name.validate();
        email.validate();
        enabled.validate();
        source.validate();
        return this;
    }
}
