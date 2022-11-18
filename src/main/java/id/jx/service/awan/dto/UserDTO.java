package id.jx.service.awan.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String username;
	private String email;
	private String password;
	private boolean isActive;
}
