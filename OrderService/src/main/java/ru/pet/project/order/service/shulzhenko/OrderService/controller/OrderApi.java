package ru.pet.project.order.service.shulzhenko.OrderService.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.request.OrderDtoRequest;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.ErrorResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.OrderDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.security.CustomUserDetails;

/**
 * Документация эндпоинтов для OrderController через Swagger
 */
public interface OrderApi {

    @Operation(
            summary = "Создание заказа",
            description = "Endpoint создаёт заказ для текущего авторизованного пользователя. От пользователя требуется авторизация. Создать заказ может пользователь с любой ролью (USER, ADMIN)",
            security = @SecurityRequirement(name = "bearer-jwt"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные для создания заказа",
                    required = true,
                    content = @Content(schema = @Schema(implementation = OrderDtoRequest.class))
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Заказ создан успешно",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = OrderDtoResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректные данные запроса",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class),
                                    examples = @ExampleObject(value = """
                                                {
                                                    "code": "VALIDATION_FAILED",
                                                    "message": "description: не должно быть пустым",
                                                    "status": 400,
                                                    "path": "/api/orders",
                                                    "timestamp": "2025-12-17T07:03:51.928750200Z"
                                                }
                                            """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован, требуется авторизация",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class),
                                    examples = @ExampleObject(value = """
                                                {
                                                    "code": "JWT_VALIDATION_FAILED",
                                                    "message": "JWT validation failed",
                                                    "status": 401,
                                                    "path": "/api/orders",
                                                    "timestamp": "2025-12-17T07:03:51.928750200Z"
                                                }
                                            """)
                            )
                    )
            }
    )
    ResponseEntity<OrderDtoResponse> creatingOrder(
            @Valid @RequestBody OrderDtoRequest orderDto,
            @AuthenticationPrincipal CustomUserDetails userDetails
    );

}