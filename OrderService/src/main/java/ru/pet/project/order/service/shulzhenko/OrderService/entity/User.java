package ru.pet.project.order.service.shulzhenko.OrderService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.UUID;

/**
 * Сущность пользователя.
 *
 * <p>Отображается в таблице "users". Хранит учетные данные пользователя, его роль
 * и связанные заказы.</p>
 *
 * <p>Связи:</p>
 * <ul>
 *     <li>{@link Order} — список заказов пользователя (OneToMany, каскадное удаление)</li>
 * </ul>
 *
 * <p>Основные поля:</p>
 * <ul>
 *     <li>id — уникальный идентификатор пользователя</li>
 *     <li>username — уникальное имя пользователя</li>
 *     <li>password — хэш пароля пользователя</li>
 *     <li>role — роль пользователя (USER, ADMIN)</li>
 *     <li>orders — список заказов пользователя</li>
 * </ul>
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Setter
    @Column(nullable = false)
    private String password;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}