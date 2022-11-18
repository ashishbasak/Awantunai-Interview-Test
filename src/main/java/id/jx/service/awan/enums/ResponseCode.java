package id.jx.service.awan.enums;

import lombok.Getter;

@Getter
public enum ResponseCode {
	SUCCESS(200, "Success"),
	ACCEPTED(202, "Accepted"),
	NO_CONTENT(204, "Success"),
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	FORBIDDEN(403, "Forbidden"),
	GENERAL_ERROR(500, "General Error");

	private final int code;
	private final String message;

	ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
