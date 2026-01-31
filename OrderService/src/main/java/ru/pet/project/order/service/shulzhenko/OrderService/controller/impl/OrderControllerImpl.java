package ru.pet.project.order.service.shulzhenko.OrderService.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.pet.project.order.service.shulzhenko.OrderService.controller.OrderApi;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.request.OrderDtoRequest;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.OrderDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.security.CustomUserDetails;
import ru.pet.project.order.service.shulzhenko.OrderService.service.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderControllerImpl implements OrderApi {

    private final OrderService orderService;

    @Override
    @PostMapping
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public ResponseEntity<OrderDtoResponse> creatingOrder(
            @Valid @RequestBody OrderDtoRequest orderDto,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        OrderDtoResponse creatingOrder = orderService.createOrder(orderDto, userDetails);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(creatingOrder);
    }
}