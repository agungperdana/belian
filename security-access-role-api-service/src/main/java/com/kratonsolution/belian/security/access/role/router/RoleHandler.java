package com.kratonsolution.belian.security.access.role.router;

import com.kratonsolution.belian.common.util.NumberHelper;
import com.kratonsolution.belian.common.util.ResultHelper;
import com.kratonsolution.belian.security.access.role.api.RoleData;
import com.kratonsolution.belian.security.access.role.api.application.RoleCreateCommand;
import com.kratonsolution.belian.security.access.role.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.security.access.role.api.application.RoleService;
import com.kratonsolution.belian.security.access.role.api.application.RoleUpdateCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 * @version 2.0.1
 */
@Service
@AllArgsConstructor
public class RoleHandler {

    private RoleService roleService;

    Mono<ServerResponse> create(ServerRequest request) {

        return  ServerResponse.ok().body(
                    roleService.create(request.bodyToMono(RoleCreateCommand.class))
                            .flatMap(data -> ResultHelper.success().put("role", data).mono())
                            .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                    Map.class);
    }

    Mono<ServerResponse> update(ServerRequest request) {

        return ServerResponse.ok().body(
                    roleService.update(request.bodyToMono(RoleUpdateCommand.class))
                            .flatMap(data -> ResultHelper.success().put("role", data).mono())
                            .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                    Map.class);
    }

    Mono<ServerResponse> delete(ServerRequest request) {

        return ServerResponse.ok().body(
                roleService.delete(request.bodyToMono(RoleDeleteCommand.class))
                        .flatMap(data -> ResultHelper.success().put("role", data).mono())
                        .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                Map.class);
    }

    Mono<ServerResponse> getByName(ServerRequest request) {

        return ServerResponse.ok().body(
                roleService.getByName(request.pathVariable("name"))
                        .flatMap(data -> ResultHelper.success().put("role", data).mono())
                        .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                RoleData.class);
    }

    Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(roleService.getAll(), RoleData.class);
    }

    Mono<ServerResponse> getAllPaged(ServerRequest request) {

        return ServerResponse.ok().body(
                roleService.getAll(
                        NumberHelper.toInt(request.pathVariable("offset")),
                        NumberHelper.toInt(request.pathVariable("limit"))
                ),RoleData.class);
    }

    Mono<ServerResponse> filter(ServerRequest request) {

        return ServerResponse.ok().body(
                roleService.filter(request.pathVariable("key")),
                RoleData.class);
    }

    Mono<ServerResponse> filterPaged(ServerRequest request) {

        return ServerResponse.ok().body(
                roleService.filter(
                        request.pathVariable("key"),
                        NumberHelper.toInt(request.pathVariable("offset")),
                        NumberHelper.toInt(request.pathVariable("limit"))
                ),
                RoleData.class);
    }
}
