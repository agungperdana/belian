package com.kratonsolution.belian.security.access.role.impl.domain;

import com.kratonsolution.belian.shared.kernel.valueobject.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Modules extends ValueObject<List<RoleModule>> implements Validateable<Modules> {

    private List<RoleModule> values = new ArrayList<>();

    public RoleModule add(@NonNull Name name,
                          @NonNull Group group,
                          @NonNull Enabled read,
                          @NonNull Enabled add,
                          @NonNull Enabled edit,
                          @NonNull Enabled delete,
                          @NonNull Enabled print) {

        if(values.stream().noneMatch(m -> m.getName().equals(name))) {

            RoleModule module = RoleModule
                    .builder()
                    .name(name)
                    .group(group)
                    .read(read)
                    .add(add)
                    .edit(edit)
                    .delete(delete)
                    .print(print)
                    .build();

            module.validate();
            values.add(module);

            return module;
        }

        return null;
    }

    public void update(
            @NonNull Name name,
            @NonNull Enabled read,
            @NonNull Enabled add,
            @NonNull Enabled edit,
            @NonNull Enabled delete,
            @NonNull Enabled print) {

        values.stream()
                .filter(m->m.getName().equals(name))
                .findFirst()
                .ifPresent(mod -> mod.update(read, add, edit, delete, print));
    }

    @Override
    public List<RoleModule> getValue() {
        return this.values;
    }

    @Override
    public Modules validate() {

        values.forEach(RoleModule::validate);
        return this;
    }
}
