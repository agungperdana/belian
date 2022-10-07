package com.kratonsolution.belian.security.access.role.impl.domain;

import com.kratonsolution.belian.shared.kernel.valueobject.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0.1
 * @version 2.0.1
 */
@Getter
@Builder
public class AccessRole implements Validateable<AccessRole> {

    @NonNull
    private Name name;

    @Builder.Default
    private Description description = Description.EMPTY;

    @Builder.Default
    private Enabled enabled = Enabled.YES;

    @Builder.Default
    private Modules modules = new Modules();

    public RoleModule addModule(@NonNull Name name,
                          @NonNull Group group,
                          @NonNull Enabled read,
                          @NonNull Enabled add,
                          @NonNull Enabled edit,
                          @NonNull Enabled delete,
                          @NonNull Enabled print) {

        return modules.add(name, group, read, add, edit, delete, print);
    }

    public void updateModule(@NonNull Name name,
                             @NonNull Enabled read,
                             @NonNull Enabled add,
                             @NonNull Enabled edit,
                             @NonNull Enabled delete,
                             @NonNull Enabled print) {

        modules.update(name, read, add, edit, delete, print);
    }

    @Override
    public AccessRole validate() {

        modules.validate();
        this.description.validate();
        this.enabled.validate();
        this.name.validate();

        return this;
    }
}
