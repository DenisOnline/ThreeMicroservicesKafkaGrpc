package ru.pet.project.order.service.shulzhenko.OrderService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.UserCredentialsDto;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.UserFullDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.UserShortDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.entity.User;

/**
 * Mapper для преобразования сущности {@link User} в DTO и обратно.
 *
 * <p>Использует {@link OrderMapper} для преобразования заказов пользователя.</p>
 */
@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface UserMapper {

    /**
     * Преобразует сущность пользователя в полный DTO с заказами.
     *
     * @param user сущность пользователя
     * @return полный DTO пользователя
     */
    UserFullDtoResponse toFullDto(User user);

    /**
     * Преобразует сущность пользователя в краткий DTO.
     *
     * @param user сущность пользователя
     * @return краткий DTO пользователя
     */
    UserShortDtoResponse toShortDto(User user);

    /**
     * Преобразует DTO с учетными данными в сущность пользователя.
     *
     * @param userCredentialsDto DTO с данными пользователя
     * @return сущность пользователя
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toEntity(UserCredentialsDto userCredentialsDto);
}