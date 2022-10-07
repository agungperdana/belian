package com.kratonsolution.belian.security.access.module.router;

import com.kratonsolution.belian.security.access.module.api.ModuleData;
import com.kratonsolution.belian.security.access.module.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.security.access.module.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.security.access.module.api.application.ModuleUpdateCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
@Configuration
public class ModuleRouterConfiguration {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v2/access-module",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = ModuleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getAll",
                    operation = @Operation(
                                    operationId = "getAll",
                                    responses = {
                                        @ApiResponse(
                                                responseCode = "200",
                                                description = "successful operation",
                                                content = @Content(schema = @Schema(implementation = ModuleData.class))
                                        ),
                                        @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                                    }
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-module/{page}/{limit}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = ModuleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getAllPaged",
                    operation = @Operation(
                            operationId = "getAllPaged",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = ModuleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "page"),
                                    @Parameter(in = ParameterIn.PATH, name = "limit")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-module/{key}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = ModuleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getAllPaged",
                    operation = @Operation(
                            operationId = "getAllPaged",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = ModuleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {@Parameter(in = ParameterIn.PATH, name = "key")}
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-module/{key}/{page}/{limit}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = ModuleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "filterPaged",
                    operation = @Operation(
                            operationId = "filterPaged",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = ModuleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "key"),
                                    @Parameter(in = ParameterIn.PATH, name = "page"),
                                    @Parameter(in = ParameterIn.PATH, name = "limit")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-module/detail/{name}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = ModuleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getByCode",
                    operation = @Operation(
                            operationId = "getByCode",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = ModuleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {@Parameter(in = ParameterIn.PATH, name = "code")}
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-module",
                    produces = {
                        MediaType.APPLICATION_JSON_VALUE},
                        method = RequestMethod.POST,
                        beanClass = ModuleHandler.class,
                        beanMethod = "create",
                        operation = @Operation(
                                operationId = "create",
                                responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = ModuleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                                },
                                requestBody = @RequestBody(
                                        content = @Content(schema = @Schema(implementation = ModuleCreateCommand.class))
                                )
                        )
            ),
            @RouterOperation(
                    path = "/api/v2/access-module",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.PUT,
                    beanClass = ModuleHandler.class,
                    beanMethod = "update",
                    operation = @Operation(
                            operationId = "update",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = ModuleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(implementation = ModuleUpdateCommand.class))
                            )
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-module",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.DELETE,
                    beanClass = ModuleHandler.class,
                    beanMethod = "delete",
                    operation = @Operation(
                            operationId = "delete",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = ModuleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(implementation = ModuleDeleteCommand.class))
                            )
                    )
            )
    })
    public RouterFunction<ServerResponse> registerAccessModuleRouter(ModuleHandler handler) {

        return RouterFunctions
                .route(GET("/api/v2/access-module"), handler::getAll)
                .andRoute(POST("/api/v2/access-module"), handler::create)
                .andRoute(PUT("/api/v2/access-module"), handler::update)
                .andRoute(DELETE("/api/v2/access-module"), handler::delete)
                .andRoute(GET("/api/v2/access-module/{page}/{limit}"), handler::getAllPaged)
                .andRoute(GET("/api/v2/access-module/{key}"), handler::filter)
                .andRoute(GET("/api/v2/access-module/{key}/{page}/{limit}"), handler::filterPaged)
                .andRoute(GET("/api/v2/access-module/detail/{name}"), handler::getByName);
    }
}