package com.kratonsolution.belian.security.access.role.router;

import com.kratonsolution.belian.security.access.role.api.RoleData;
import com.kratonsolution.belian.security.access.role.api.application.RoleCreateCommand;
import com.kratonsolution.belian.security.access.role.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.security.access.role.api.application.RoleUpdateCommand;
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

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 * @version 2.0.1
 */
@Configuration
public class RoleRouterConfiguration {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v2/access-role",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = RoleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getAll",
                    operation = @Operation(
                                    operationId = "getAll",
                                    responses = {
                                        @ApiResponse(
                                                responseCode = "200",
                                                description = "successful operation",
                                                content = @Content(schema = @Schema(implementation = RoleData.class))
                                        ),
                                        @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                                    }
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-role/{offset}/{limit}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = RoleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getAllPaged",
                    operation = @Operation(
                            operationId = "getAllPaged",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = RoleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "offset"),
                                    @Parameter(in = ParameterIn.PATH, name = "limit")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-role/{key}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = RoleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getAllPaged",
                    operation = @Operation(
                            operationId = "getAllPaged",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = RoleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {@Parameter(in = ParameterIn.PATH, name = "key")}
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-role/{key}/{offset}/{limit}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = RoleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "filterPaged",
                    operation = @Operation(
                            operationId = "filterPaged",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = RoleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "key"),
                                    @Parameter(in = ParameterIn.PATH, name = "offset"),
                                    @Parameter(in = ParameterIn.PATH, name = "limit")
                            }
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-role/detail/{name}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = RoleHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getByName",
                    operation = @Operation(
                            operationId = "getByName",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = RoleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {@Parameter(in = ParameterIn.PATH, name = "name")}
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-role",
                    produces = {
                        MediaType.APPLICATION_JSON_VALUE},
                        method = RequestMethod.POST,
                        beanClass = RoleHandler.class,
                        beanMethod = "create",
                        operation = @Operation(
                                operationId = "create",
                                responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = RoleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                                },
                                requestBody = @RequestBody(
                                        content = @Content(schema = @Schema(implementation = RoleCreateCommand.class))
                                )
                        )
            ),
            @RouterOperation(
                    path = "/api/v2/access-role",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.PUT,
                    beanClass = RoleHandler.class,
                    beanMethod = "update",
                    operation = @Operation(
                            operationId = "update",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = RoleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(implementation = RoleUpdateCommand.class))
                            )
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/access-role",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.DELETE,
                    beanClass = RoleHandler.class,
                    beanMethod = "delete",
                    operation = @Operation(
                            operationId = "delete",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = RoleData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(implementation = RoleDeleteCommand.class))
                            )
                    )
            )
    })
    public RouterFunction<ServerResponse> registerAccessRoleRouter(RoleHandler handler) {

        return RouterFunctions
                .route(GET("/api/v2/access-role"), handler::getAll)
                .andRoute(POST("/api/v2/access-role"), handler::create)
                .andRoute(PUT("/api/v2/access-role"), handler::update)
                .andRoute(DELETE("/api/v2/access-role"), handler::delete)
                .andRoute(GET("/api/v2/access-role/detail/{name}"), handler::getByName)
                .andRoute(GET("/api/v2/access-role/{offset}/{limit}"), handler::getAllPaged)
                .andRoute(GET("/api/v2/access-role/{key}"), handler::filter)
                .andRoute(GET("/api/v2/access-role/{key}/{offset}/{limit}"), handler::filterPaged);
    }
}