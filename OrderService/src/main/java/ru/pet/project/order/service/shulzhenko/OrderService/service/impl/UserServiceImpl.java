package ru.pet.project.order.service.shulzhenko.OrderService.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.UserCredentialsDto;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.UserShortDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.entity.Role;
import ru.pet.project.order.service.shulzhenko.OrderService.entity.User;
import ru.pet.project.order.service.shulzhenko.OrderService.exeption.UserException;
import ru.pet.project.order.service.shulzhenko.OrderService.mapper.UserMapper;
import ru.pet.project.order.service.shulzhenko.OrderService.repository.UserRepository;
import ru.pet.project.order.service.shulzhenko.OrderService.service.UserService;
import ru.pet.project.order.service.shulzhenko.OrderService.utils.ErrorType;
import ru.pet.project.order.service.shulzhenko.OrderService.utils.LogType;

import java.util.List;
import java.util.UUID;

/**
 * Сервисный слой, отвечающий за управление пользователями системы.
 * <p>
 * Предоставляет операции:
 * <ul>
 *     <li>Регистрация пользователей;</li>
 *     <li>Получение списка пользователей с пагинацией;</li>
 *     <li>Удаление пользователей.</li>
 * </ul>
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserShortDtoResponse createUser(UserCredentialsDto userCredentialsDto) {
        log.info(LogType.USER_CREATE_START.getMessage(), userCredentialsDto.getUsername());

        if (userRepository.existsByUsername(userCredentialsDto.getUsername())) {
            throw new UserException(ErrorType.USERNAME_ALREADY_EXISTS, userCredentialsDto.getUsername());
        }
        User user = userMapper.toEntity(userCredentialsDto);
        user.setPassword(passwordEncoder.encode(userCredentialsDto.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);

        log.info(LogType.USER_CREATED.getMessage(), user.getId(), user.getUsername());
        return userMapper.toShortDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserShortDtoResponse> findAllUsers() {
        log.debug(LogType.USER_FETCH_ALL_START.getMessage());

        List<UserShortDtoResponse> users = userRepository
                .findAll()
                .stream()
                .map(userMapper::toShortDto)
                .toList();

        log.debug(LogType.USER_FETCH_ALL_RESULT.getMessage(), users.size());

        return users;
    }

    @Transactional()
    public void deleteUserById(UUID userId) {
        log.info(LogType.USER_DELETE_START.getMessage(), userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(ErrorType.NO_SUCH_USER_BY_UUID, userId));
        userRepository.delete(user);

        log.info(LogType.USER_DELETED.getMessage(), userId);
    }
}