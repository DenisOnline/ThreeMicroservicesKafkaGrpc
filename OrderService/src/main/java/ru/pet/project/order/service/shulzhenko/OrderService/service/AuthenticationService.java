package ru.pet.project.order.service.shulzhenko.OrderService.service;


import ru.pet.project.order.service.shulzhenko.OrderService.dto.JwtAuthenticationDto;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.RefreshTokenDto;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.UserCredentialsDto;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.UserFullDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.UserShortDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.exeption.CustomJwtException;
import ru.pet.project.order.service.shulzhenko.OrderService.exeption.UserException;
import ru.pet.project.order.service.shulzhenko.OrderService.security.CustomUserDetails;

public interface AuthenticationService {

    /**
     * Выполняет аутентификацию пользователя по имени и паролю.
     *
     * @param userCredentialsDto учетные данные пользователя
     * @return JWT-токены аутентификации
     * @throws UserException если учетные данные некорректны
     */
    JwtAuthenticationDto login(UserCredentialsDto userCredentialsDto) throws UserException;

    /**
     * Регистрирует нового пользователя в системе.
     *
     * @param userCredentialsDto данные для регистрации
     * @return краткое представление зарегистрированного пользователя без пароля
     */
    UserShortDtoResponse register(UserCredentialsDto userCredentialsDto);

    /**
     * Возвращает профиль текущего аутентифицированного пользователя.
     *
     * @param userDetails данные текущего пользователя
     * @return полное представление пользователя с его заказами без пароля
     * @throws UserException если пользователь не найден
     */
    UserFullDtoResponse me(CustomUserDetails userDetails) throws UserException;

    /**
     * Обновляет access-токен на основе refresh-токена.
     *
     * @param refreshTokenDto refresh-токен
     * @return новые JWT-токены
     * @throws CustomJwtException если refresh-токен некорректен
     */
    JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) throws CustomJwtException;
}