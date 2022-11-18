package id.jx.service.awan.service;

import id.jx.service.awan.dto.LoginDTO;
import id.jx.service.awan.dto.UserDTO;

import java.security.GeneralSecurityException;

public interface UserManagementService {
	void create(UserDTO userDTO) throws GeneralSecurityException;
	
	boolean login(LoginDTO loginDTO);
}
