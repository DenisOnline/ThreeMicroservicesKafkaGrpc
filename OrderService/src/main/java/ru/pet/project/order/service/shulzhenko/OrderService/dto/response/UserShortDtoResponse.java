package ru.pet.project.order.service.shulzhenko.OrderService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pet.project.order.service.shulzhenko.OrderService.entity.Role;

import java.util.UUID;

/**
 * Краткий DTO для передачи информации о пользователе.
 *
 * <p>Используется, когда необходимо предоставить минимальные данные о пользователе,
 * например, в списках пользователей.</p>
 *
 * <p>Поля:</p>
 * <ul>
 *     <li>id — уникальный идентификатор пользователя</li>
 *     <li>username — имя пользователя</li>
 *     <li>role — роль пользователя ({@link Role})</li>
 * </ul>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserShortDtoResponse {
    private UUID id;
    private String username;
    private Role role;
}