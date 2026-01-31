package ru.pet.project.order.service.shulzhenko.OrderService.service;

import ru.pet.project.order.service.shulzhenko.OrderService.dto.UserCredentialsDto;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.UserShortDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.entity.Role;
import ru.pet.project.order.service.shulzhenko.OrderService.exeption.UserException;

import java.util.List;
import java.util.UUID;

public interface UserService {

    /**
     * Создаёт нового пользователя на основе переданных учетных данных.
     * <p>
     * В рамках выполнения:
     * <ol>
     *     <li>Проверяется уникальность имени пользователя;</li>
     *     <li>Кодирование пароля;</li>
     *     <li>Пользователю назначается дефолтная роль {@link Role#USER};</li>
     *     <li>Пользователь сохраняется в базе данных.</li>
     * </ol>
     *
     * @param userCredentialsDto данные для регистрации пользователя
     * @return краткое представление созданного пользователя без пароля
     * @throws UserException, если пользовать с этим username именем уже существует
     */
    UserShortDtoResponse createUser(UserCredentialsDto userCredentialsDto) throws UserException;

    /**
     * Возвращает список всех пользователей.
     * @return страница пользователей
     */
    List<UserShortDtoResponse> findAllUsers();

    /**
     * Удаляет пользователя по его уникальному идентификатору.
     *
     * @param userId идентификатор пользователя
     * @throws UserException если пользователь с переданным идентификатором не найден
     */
    void deleteUserById(UUID userId) throws UserException;
}
