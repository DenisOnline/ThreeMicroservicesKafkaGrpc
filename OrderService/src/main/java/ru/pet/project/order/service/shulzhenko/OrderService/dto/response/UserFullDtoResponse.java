package ru.pet.project.order.service.shulzhenko.OrderService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pet.project.order.service.shulzhenko.OrderService.entity.Role;

import java.util.List;
import java.util.UUID;

/**
 * Полный DTO для передачи информации о пользователе.
 *
 * <p>Содержит все данные пользователя, включая список его заказов.</p>
 *
 * <p>Поля:</p>
 * <ul>
 *     <li>id — уникальный идентификатор пользователя</li>
 *     <li>username — имя пользователя</li>
 *     <li>role — роль пользователя ({@link Role})</li>
 *     <li>orders — список заказов пользователя ({@link OrderDtoResponse})</li>
 * </ul>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFullDtoResponse {
    UUID id;
    String username;
    Role role;
    List<OrderDtoResponse> orders;
}