package ru.pet.project.order.service.shulzhenko.OrderService.exeption;


import ru.pet.project.order.service.shulzhenko.OrderService.entity.Order;
import ru.pet.project.order.service.shulzhenko.OrderService.utils.ErrorType;

/**
 * Исключение, связанное с операциями над заказами.
 *
 * <p>Наследует {@link ServiceException} и используется для обработки ошибок
 * при работе с сущностью {@link Order}.</p>
 */
public class OrderException extends ServiceException {
  public OrderException(ErrorType errorType) {
    super(errorType);
  }

  public OrderException(ErrorType errorType, Object... args) {
    super(errorType, args);
  }
}