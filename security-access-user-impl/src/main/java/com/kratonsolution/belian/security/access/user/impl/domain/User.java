package com.kratonsolution.belian.security.access.user.impl.domain;

import com.google.gson.Gson;
import com.kratonsolution.belian.shared.kernel.valueobject.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Builder.Default
    private List<UserRole> roles = new ArrayList<>();

    @Override
    public User validate() {

        name.validate();
        email.validate();
        enabled.validate();
        source.validate();

        roles.forEach(UserRole::validate);

        return this;
    }
}
