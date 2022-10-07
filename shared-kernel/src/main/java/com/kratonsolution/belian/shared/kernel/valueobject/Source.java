package com.kratonsolution.belian.shared.kernel.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class Source extends ValueObject<String> implements Validateable<Source> {

    public static final Source LOCAL = Source.is("Local");
    public static final Source GOOGLE = Source.is("Google");
    public static final Source FACEBOOK = Source.is("Facebook");
    public static final Source GITHUB = Source.is("Github");
    public static final Source LINKEDIN = Source.is("LinkedIn");

    @NonNull
    @Getter
    private String value;

    private Source(){}

    public static Source is(@NonNull String source) {
        return new Source(source);
    }

    @Override
    public Source validate() {

        if(value.equals(""))
            throw new RuntimeException("Source cannot be empty");

        return this;
    }
}
