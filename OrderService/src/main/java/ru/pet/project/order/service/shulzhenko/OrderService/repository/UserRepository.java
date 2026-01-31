package ru.pet.project.order.service.shulzhenko.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.project.order.service.shulzhenko.OrderService.entity.User;

import java.util.Optional;
import java.util.UUID;

/**
 * Репозиторий для работы с сущностью {@link User}.
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Находит пользователя по имени.
     *
     * @param username имя пользователя
     * @return {@link Optional} с пользователем или пустой, если пользователь не найден
     */
    Optional<User> findByUsername(String username);

    /**
     * Проверяет, существует ли пользователь с указанным именем.
     *
     * @param username имя пользователя
     * @return {@code true}, если пользователь существует, иначе {@code false}
     */
    boolean existsByUsername(String username);

}