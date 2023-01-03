package com.kratonsolution.belian.security.access.user.router;

import com.kratonsolution.belian.security.access.user.api.UserData;
import com.kratonsolution.belian.security.access.user.api.application.UserCreateCommand;
import com.kratonsolution.belian.security.access.user.api.application.UserDeleteCommand;
import com.kratonsolution.belian.security.access.user.api.application.UserUpdateCommand;
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
 * @since 2.0.1
 */
@Configuration
public class UserRouterConfiguration {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v2/users",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = UserHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getAll",
                    operation = @Operation(
                                    operationId = "getAll",
                                    responses = {
                                        @ApiResponse(
                                                responseCode = "200",
                                                description = "successful operation",
                                                content = @Content(schema = @Schema(implementation = UserData.class))
                                        ),
                                        @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                                    }
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/users/{page}/{limit}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = UserHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getAllPaged",
                    operation = @Operation(
                            operationId = "getAllPaged",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = UserData.class))
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
                    path = "/api/v2/users/{key}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = UserHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getAllPaged",
                    operation = @Operation(
                            operationId = "getAllPaged",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = UserData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {@Parameter(in = ParameterIn.PATH, name = "key")}
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/users/{key}/{page}/{limit}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = UserHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "filterPaged",
                    operation = @Operation(
                            operationId = "filterPaged",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = UserData.class))
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
                    path = "/api/v2/user/detail/{email}",
                    produces = {MediaType.APPLICATION_JSON_VALUE},
                    beanClass = UserHandler.class,
                    method = RequestMethod.GET,
                    beanMethod = "getByEmail",
                    operation = @Operation(
                            operationId = "getByEmail",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = UserData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            parameters = {@Parameter(in = ParameterIn.PATH, name = "email")}
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/users",
                    produces = {
                        MediaType.APPLICATION_JSON_VALUE},
                        method = RequestMethod.POST,
                        beanClass = UserHandler.class,
                        beanMethod = "create",
                        operation = @Operation(
                                operationId = "create",
                                responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = UserData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                                },
                                requestBody = @RequestBody(
                                        content = @Content(schema = @Schema(implementation = UserCreateCommand.class))
                                )
                        )
            ),
            @RouterOperation(
                    path = "/api/v2/users",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.PUT,
                    beanClass = UserHandler.class,
                    beanMethod = "update",
                    operation = @Operation(
                            operationId = "update",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = UserData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(implementation = UserUpdateCommand.class))
                            )
                    )
            ),
            @RouterOperation(
                    path = "/api/v2/users",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.DELETE,
                    beanClass = UserHandler.class,
                    beanMethod = "delete",
                    operation = @Operation(
                            operationId = "delete",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "successful operation",
                                            content = @Content(schema = @Schema(implementation = UserData.class))
                                    ),
                                    @ApiResponse(responseCode = "500", description = "Something wrong with the code")
                            },
                            requestBody = @RequestBody(
                                    content = @Content(schema = @Schema(implementation = UserDeleteCommand.class))
                            )
                    )
            )
    })
    public RouterFunction<ServerResponse> registerAccessUserRouter(UserHandler handler) {

        return RouterFunctions
                .route(GET("/api/v2/users"), handler::getAll)
                .andRoute(POST("/api/v2/users"), handler::create)
                .andRoute(PUT("/api/v2/users"), handler::update)
                .andRoute(DELETE("/api/v2/users"), handler::delete)
                .andRoute(GET("/api/v2/users/{page}/{limit}"), handler::getAllPaged)
                .andRoute(GET("/api/v2/users/{key}"), handler::filter)
                .andRoute(GET("/api/v2/users/{key}/{page}/{limit}"), handler::filterPaged)
                .andRoute(GET("/api/v2/user/detail/{email}"), handler::getByEmail)
                .andRoute(GET("/api/v2/auth/find/{email}"), handler::getByEmail);
    }
}