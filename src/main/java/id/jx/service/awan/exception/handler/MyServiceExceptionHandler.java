package id.jx.service.awan.exception.handler;

import id.jx.service.awan.enums.ResponseCode;
import id.jx.service.awan.exception.BadRequestException;
import id.jx.service.awan.response.ApiResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class MyServiceExceptionHandler {
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(AccessDeniedException.class)
	public ApiResponse<?> handleAccessDeniedException() {
		return new ApiResponse<>(false, HttpStatus.FORBIDDEN.value(), "Access Denied", HttpStatus.FORBIDDEN.getReasonPhrase());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ConstraintViolationException.class})
	public ApiResponse<?> handleConstraintViolation(ConstraintViolationException ex) {
		return new ApiResponse<>(false, ResponseCode.BAD_REQUEST.getCode(), ex.getCause().getMessage(),
				ResponseCode.BAD_REQUEST.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ApiResponse<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();

		List<String> errors = new ArrayList<>();
		fieldErrors.forEach(fieldError ->
				errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage())
		);

		return new ApiResponse<>(false, ResponseCode.BAD_REQUEST.getCode(), errors,
				ResponseCode.BAD_REQUEST.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({BadRequestException.class})
	public ApiResponse<?> handleBadRequestException(BadRequestException ex) {
		return new ApiResponse<>(false, ResponseCode.BAD_REQUEST.getCode(), ex.getMessage(),
				ResponseCode.BAD_REQUEST.getMessage());
	}

}
