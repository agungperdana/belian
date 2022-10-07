package com.kratonsolution.belian.security.access.role.impl.domain;

import com.kratonsolution.belian.shared.kernel.valueobject.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0.1
 * @version 2.0.1
 */
@Getter
@Builder
public class RoleModule implements Validateable<RoleModule> {

    @NonNull
    private Name name;

    @NonNull
    private Group group;

    @Builder.Default
    private Enabled add = Enabled.NO;

    @Builder.Default
    private Enabled read = Enabled.NO;

    @Builder.Default
    private Enabled edit = Enabled.NO;

    @Builder.Default
    private Enabled delete = Enabled.NO;

    @Builder.Default
    private Enabled print = Enabled.NO;

    @Override
    public RoleModule validate() {

        name.validate();
        group.validate();
        add.validate();
        read.validate();
        edit.validate();
        delete.validate();
        print.validate();

        return this;
    }

    public void update(@NonNull Enabled read,
                       @NonNull Enabled add,
                       @NonNull Enabled edit,
                       @NonNull Enabled delete,
                       @NonNull Enabled print) {

        this.read = read;
        this.add = add;
        this.edit = edit;
        this.delete = delete;
        this.print = print;
    }
}
