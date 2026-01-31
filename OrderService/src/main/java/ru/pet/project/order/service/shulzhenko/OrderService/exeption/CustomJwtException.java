package ru.pet.project.order.service.shulzhenko.OrderService.exeption;

import ru.pet.project.order.service.shulzhenko.OrderService.utils.ErrorType;

/**
 * Исключение, связанное с обработкой JWT-токенов.
 *
 * <p>Наследует {@link ServiceException} и используется для обработки ошибок
 * при валидации и обновлении JWT-токенов.</p>
 */
public class CustomJwtException extends ServiceException {
    public CustomJwtException(ErrorType errorType) {
        super(errorType);
    }

    public CustomJwtException(ErrorType errorType, Object... args) {
        super(errorType, args);
    }
}