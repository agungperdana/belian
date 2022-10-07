package com.kratonsolution.belian.gateway.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRestResponse {

    private boolean success = false;

    private User user;
}
