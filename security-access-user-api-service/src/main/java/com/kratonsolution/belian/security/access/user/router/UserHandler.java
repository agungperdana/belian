package com.kratonsolution.belian.security.access.user.router;

import com.kratonsolution.belian.common.PagedResponse;
import com.kratonsolution.belian.common.util.PagingHelper;
import com.kratonsolution.belian.common.util.ResultHelper;
import com.kratonsolution.belian.security.access.user.api.UserData;
import com.kratonsolution.belian.security.access.user.api.application.UserCreateCommand;
import com.kratonsolution.belian.security.access.user.api.application.UserDeleteCommand;
import com.kratonsolution.belian.security.access.user.api.application.UserService;
import com.kratonsolution.belian.security.access.user.api.application.UserUpdateCommand;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.1
 */
@Service
@AllArgsConstructor
public class UserHandler {

    private UserService userService;

    private final Logger log = LoggerFactory.getLogger(UserHandler.class);

    Mono<ServerResponse> create(ServerRequest request) {

        return  ServerResponse.status(HttpStatus.CREATED).body(
                    userService.create(request.bodyToMono(UserCreateCommand.class))
                            .flatMap(data -> ResultHelper.success().put("user", data).mono())
                            .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                    Map.class);
    }

    Mono<ServerResponse> update(ServerRequest request) {

        return ServerResponse.ok().body(
                userService.update(request.bodyToMono(UserUpdateCommand.class))
                            .flatMap(data -> ResultHelper.success().put("user", data).mono())
                            .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                    Map.class);
    }

    Mono<ServerResponse> delete(ServerRequest request) {

        return ServerResponse.ok().body(
                userService.delete(request.bodyToMono(UserDeleteCommand.class))
                        .flatMap(data -> ResultHelper.success().mono())
                        .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                Map.class);
    }

    Mono<ServerResponse> getByEmail(ServerRequest request) {

        return ServerResponse.ok().body(
                userService.getByEmail(request.pathVariable("email"))
                        .flatMap(data -> ResultHelper.success().put("user", data).mono())
                        .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                UserData.class);
    }

    @PreAuthorize("hasRole('ROLE_USER_READ')")
    Mono<ServerResponse> getAll(ServerRequest request) {

        return ServerResponse.ok().body(userService.getAll(), UserData.class);
    }

    Mono<ServerResponse> getAllPaged(ServerRequest request) {

        return ServerResponse.ok().body(
                userService.getAll(PagingHelper.getOffset(request), PagingHelper.getLimit(request))
                        .collectList()
                        .zipWith(userService.count())
                        .map(p -> {

                            return new PagedResponse<UserData>(
                                    p.getT1(),
                                    PagingHelper.getPage(request),
                                    PagingHelper.getLimit(request),
                                    PagingHelper.getTotalPage(p.getT2().intValue(), request),
                                    null
                            );
                        }), PagedResponse.class
        );
    }

    Mono<ServerResponse> filter(ServerRequest request) {

        return ServerResponse.ok().body(
                userService.filter(request.pathVariable("key")),
                UserData.class);
    }

    Mono<ServerResponse> filterPaged(ServerRequest request) {

        return ServerResponse.ok().body(
                userService.filter(request.pathVariable("key"), PagingHelper.getOffset(request), PagingHelper.getLimit(request))
                        .collectList()
                        .zipWith(userService.count(request.pathVariable("key")))
                        .map(p -> {

                            return new PagedResponse<UserData>(
                                    p.getT1(),
                                    PagingHelper.getPage(request),
                                    PagingHelper.getLimit(request),
                                    PagingHelper.getTotalPage(p.getT2().intValue(), request),
                                    request.pathVariable("key")
                            );
                        }), PagedResponse.class
        );
    }
}
