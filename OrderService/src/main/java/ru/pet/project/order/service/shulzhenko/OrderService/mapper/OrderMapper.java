package ru.pet.project.order.service.shulzhenko.OrderService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.request.OrderDtoRequest;
import ru.pet.project.order.service.shulzhenko.OrderService.dto.response.OrderDtoResponse;
import ru.pet.project.order.service.shulzhenko.OrderService.entity.Order;

/**
 * Mapper для преобразования сущности {@link Order} в DTO и обратно.
 */
@Mapper(componentModel = "spring")
public interface OrderMapper {

    /**
     * Преобразует сущность заказа в DTO.
     *
     * @param order сущность заказа
     * @return DTO заказа
     */
    @Mapping(source = "user.id", target = "userId")
    OrderDtoResponse toDto(Order order);

    /**
     * Преобразует DTO заказа в сущность.
     *
     * @param dto DTO заказа
     * @return сущность заказа
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Order toEntity(OrderDtoRequest dto);
}