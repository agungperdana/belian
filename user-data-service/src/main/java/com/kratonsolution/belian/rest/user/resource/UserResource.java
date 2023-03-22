package com.kratonsolution.belian.rest.user.resource;

import com.kratonsolution.belian.user.api.UserData;
import com.kratonsolution.belian.user.api.UserService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserResource {

    private UserService userService;

    @GetMapping
    @Produces()
    public List<UserData> list(@PathVariable(name = "offset", required = false) Integer offset, @PathVariable(name = "limit", required = false) Integer limit) {

        if(offset != null && limit != null) {
            return userService.findAll(offset, limit);
        }

        return userService.findAll();
    }
}
