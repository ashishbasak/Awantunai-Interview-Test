package id.jx.service.awan.controller;

import id.jx.service.awan.dto.UserDTO;
import id.jx.service.awan.response.ApiResponse;
import id.jx.service.awan.service.UserManagementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.GeneralSecurityException;

@RestController
@AllArgsConstructor
public class SignUpController {
	private final UserManagementService userManagementService;
	
	@PostMapping("/sign-up")
	public ApiResponse<?> signUp(@RequestBody UserDTO userDTO) throws GeneralSecurityException {
		userManagementService.create(userDTO);
		
		return ApiResponse.noContent();
	}
}
