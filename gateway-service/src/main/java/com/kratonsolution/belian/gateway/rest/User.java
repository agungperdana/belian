package com.kratonsolution.belian.gateway.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;

    private String email;

    private String source;

    private boolean enabled;
}
