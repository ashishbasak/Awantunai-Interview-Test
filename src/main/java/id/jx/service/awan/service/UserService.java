package id.jx.service.awan.service;

import id.jx.service.awan.dto.UserDTO;
import id.jx.service.awan.model.User;

public interface UserService {
	void create(User user);
	
	boolean login(UserDTO userDTO);
}
