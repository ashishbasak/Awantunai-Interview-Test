package id.jx.service.awan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralServiceException extends RuntimeException {
	private final String message;
}
