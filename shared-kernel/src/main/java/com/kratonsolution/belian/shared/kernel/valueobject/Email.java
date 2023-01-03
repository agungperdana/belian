package com.kratonsolution.belian.shared.kernel.valueobject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.regex.Pattern;

@AllArgsConstructor
public class Email extends ValueObject<String> implements Validateable<Email> {

    public static final Pattern pattern =
            Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    @NonNull
    @Getter
    private String value;

    public static Email is(@NonNull String email) {
        return new Email(email);
    }

    @Override
    public Email validate() {
        if(!pattern.matcher(this.value).matches())
            throw new RuntimeException(String.format("%s is not valid email format", this.value));

        return this;
    }
}
