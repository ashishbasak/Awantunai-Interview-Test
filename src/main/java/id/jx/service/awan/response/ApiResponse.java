package id.jx.service.awan.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static id.jx.service.awan.enums.ResponseCode.NO_CONTENT;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
	private boolean success;
	private int status;
	private T result;
	private String message;
	
	public static ApiResponse<?> noContent() {
		return new ApiResponse<>(true, NO_CONTENT.getCode(), null, NO_CONTENT.getMessage());
	}
}
