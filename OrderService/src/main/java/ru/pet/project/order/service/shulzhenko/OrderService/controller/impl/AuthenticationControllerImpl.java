package ru.pet.project.order.service.shulzhenko.OrderService.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.pet.project.order.service.shulzhenko.OrderService.controller.AuthenticationApi;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.JwtAuthenticationDto;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.RefreshTokenDto;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.UserCredentialsDto;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.UserShortDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.service.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationControllerImpl implements AuthenticationApi {

    private final AuthenticationService authenticationService;

    @Override
    @PostMapping("/register")
    public UserShortDtoResponse register(@Valid @RequestBody UserCredentialsDto userCredentialsDto) {
        return authenticationService.register(userCredentialsDto);
    }

    @Override
    @PostMapping("/login")
    public JwtAuthenticationDto login(@Valid @RequestBody UserCredentialsDto userCredentialsDto) {
        return authenticationService.login(userCredentialsDto);
    }

    @Override
    @PostMapping("/refresh")
    public JwtAuthenticationDto refresh(@Valid @RequestBody RefreshTokenDto refreshTokenDto) {
        return authenticationService.refreshToken(refreshTokenDto);
    }
}