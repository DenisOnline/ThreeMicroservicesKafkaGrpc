package ru.pet.project.order.service.shulzhenko.OrderService.exeption;

import lombok.Getter;
import ru.pet.project.order.service.shulzhenko.OrderService.utils.ErrorType;

/**
 * Базовое сервисное исключение для всех ошибок бизнес-логики.
 *
 * <p>Содержит {@link ErrorType} и аргументы для форматирования сообщения.</p>
 */
@Getter
public class ServiceException extends RuntimeException {

    private final ErrorType errorType;
    private final Object[] args;

    /**
     * Конструктор исключения.
     *
     * @param errorType тип ошибки
     * @param args аргументы для форматирования сообщения
     */
    public ServiceException(ErrorType errorType, Object... args) {
        super(String.format(errorType.getMessage(), args));
        this.errorType = errorType;
        this.args = args;
    }
}