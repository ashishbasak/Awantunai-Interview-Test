package id.jx.service.awan.service;

import id.jx.service.awan.dto.UserDTO;
import id.jx.service.awan.model.User;
import id.jx.service.awan.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
	@Override
	public void create(User user) {
		userRepository.save(user);
	}
	
	@Override
	public boolean login(UserDTO userDTO) {
		return userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
	}
}
