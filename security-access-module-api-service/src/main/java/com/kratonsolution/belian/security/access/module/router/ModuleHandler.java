package com.kratonsolution.belian.security.access.module.router;

import com.kratonsolution.belian.common.PagedResponse;
import com.kratonsolution.belian.common.util.PagingHelper;
import com.kratonsolution.belian.common.util.ResultHelper;
import com.kratonsolution.belian.security.access.module.api.ModuleData;
import com.kratonsolution.belian.security.access.module.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.security.access.module.api.application.ModuleService;
import com.kratonsolution.belian.security.access.module.api.application.ModuleUpdateCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class ModuleHandler {

    private ModuleService moduleService;

    Mono<ServerResponse> create(ServerRequest request) {

        return  ServerResponse.status(HttpStatus.CREATED).body(
                    moduleService.create(request.bodyToMono(ModuleCreateCommand.class))
                            .flatMap(data -> ResultHelper.success().put("module", data).mono())
                            .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                    Map.class);
    }

    Mono<ServerResponse> update(ServerRequest request) {

        return ServerResponse.ok().body(
                moduleService.update(request.bodyToMono(ModuleUpdateCommand.class))
                            .flatMap(data -> ResultHelper.success().put("module", data).mono())
                            .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                    Map.class);
    }

    Mono<ServerResponse> delete(ServerRequest request) {

        return ServerResponse.noContent().build();
    }

    Mono<ServerResponse> getByName(ServerRequest request) {

        return ServerResponse.ok().body(
                moduleService.getByName(request.pathVariable("name"))
                        .flatMap(data -> ResultHelper.success().put("module", data).mono())
                        .onErrorResume(e -> ResultHelper.failed(e.getMessage()).mono()),
                ModuleData.class);
    }

    Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(moduleService.getAll(), ModuleData.class);
    }

    Mono<ServerResponse> getAllPaged(ServerRequest request) {

        return ServerResponse.ok().body(
                moduleService.getAll(PagingHelper.getOffset(request), PagingHelper.getLimit(request))
                        .collectList()
                        .zipWith(moduleService.count())
                        .map(p -> {

                            return new PagedResponse<ModuleData>(
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
                moduleService.filter(request.pathVariable("key")),
                ModuleData.class);
    }

    Mono<ServerResponse> filterPaged(ServerRequest request) {

        return ServerResponse.ok().body(
                moduleService.filter(request.pathVariable("key"), PagingHelper.getOffset(request), PagingHelper.getLimit(request))
                        .collectList()
                        .zipWith(moduleService.count())
                        .map(p -> {

                            return new PagedResponse<ModuleData>(
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
