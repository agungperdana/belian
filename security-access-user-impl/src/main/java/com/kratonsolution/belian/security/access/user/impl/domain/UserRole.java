package com.kratonsolution.belian.security.access.user.impl.domain;

import com.kratonsolution.belian.shared.kernel.valueobject.Email;
import com.kratonsolution.belian.shared.kernel.valueobject.Enabled;
import com.kratonsolution.belian.shared.kernel.valueobject.Name;
import com.kratonsolution.belian.shared.kernel.valueobject.Validateable;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class UserRole implements Validateable<UserRole> {

    @NonNull
    private Name roleName;

    @Builder.Default
    private Enabled enabled = Enabled.NO;

    @Override
    public UserRole validate() {

        roleName.validate();
        enabled.validate();

        return this;
    }
}
