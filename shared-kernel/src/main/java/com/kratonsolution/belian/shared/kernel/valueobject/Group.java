package com.kratonsolution.belian.shared.kernel.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class Group extends ValueObject<String> implements Validateable<Group> {

    @NonNull
    @Getter
    private String value;

    public static Group general() {
        return new Group("General");
    }

    public static Group is(@NonNull String group) {

        return new Group(group);
    }

    @Override
    public Group validate() {
        return this;
    }
}
