package ru.pet.project.order.service.shulzhenko.OrderService.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.pet.project.order.service.shulzhenko.OrderService.controller.UserApi;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.UserFullDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.UserShortDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.security.CustomUserDetails;
import ru.pet.project.order.service.shulzhenko.OrderService.service.AuthenticationService;
import ru.pet.project.order.service.shulzhenko.OrderService.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserControllerImpl implements UserApi {

    //TODO: CRUD операции добавить
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Override
    @GetMapping("/me")
    public UserFullDtoResponse me(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return authenticationService.me(userDetails);
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<List<UserShortDtoResponse>> getAllUsers() {
        List<UserShortDtoResponse> allUsers = userService.findAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}