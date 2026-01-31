package ru.pet.project.order.service.shulzhenko.OrderService.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.pet.project.order.service.shulzhenko.OrderService.exeption.UserException;
import ru.pet.project.order.service.shulzhenko.OrderService.repository.UserRepository;
import ru.pet.project.order.service.shulzhenko.OrderService.utils.ErrorType;

/**
 * Сервис для загрузки пользовательских данных по имени пользователя.
 *
 * <p>Реализует {@link UserDetailsService} для интеграции с Spring Security.
 * Используется для аутентификации пользователей по username.</p>
 */
@Service
@RequiredArgsConstructor
public class CustomUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Загружает пользователя по имени пользователя.
     *
     * @param username имя пользователя
     * @return объект {@link CustomUserDetails}, содержащий информацию о пользователе
     * @throws UserException если пользователь не найден
     */
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UserException(ErrorType.FAILED_RETRIEVE_USER_BY_USERNAME, username));
    }
}
