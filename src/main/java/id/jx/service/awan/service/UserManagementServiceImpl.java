package id.jx.service.awan.service;

import id.jx.service.awan.dto.LoginDTO;
import id.jx.service.awan.dto.UserDTO;
import id.jx.service.awan.mapper.UserMapper;
import id.jx.service.awan.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {
	private final UserService userService;
	
	@Override
	public void create(UserDTO userDTO) throws GeneralSecurityException {
		
		User user = new User();
		user.setUsername(userDTO.getUsername());
		
		String password = generatePassword(userDTO.getPassword());
		user.setPassword(password);
		
		user.setEmail(userDTO.getEmail());
		user.setRefId(generateRefId());
		user.setActive(userDTO.isActive());
		
		userService.create(user);
	}
	
	@Override
	public boolean login(LoginDTO loginDTO) {
		return false;
	}
	
	private String generateRefId() {
		String refId = UUID.randomUUID().toString();
		return refId.substring(refId.length() - 16);
	}
	
	private String generatePassword(String password) throws GeneralSecurityException {
		try
		{
			/* MessageDigest instance for MD5. */
			MessageDigest m = MessageDigest.getInstance("MD5");
			
			/* Add plain-text password bytes to digest using MD5 update() method. */
			m.update(password.getBytes());
			
			/* Convert the hash value into bytes */
			byte[] bytes = m.digest();
			
			/* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
			StringBuilder s = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			/* Complete hashed password in hexadecimal format */
			return s.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new GeneralSecurityException("Oops Something wrong");
		}
		
	}
}
