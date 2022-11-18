package id.jx.service.awan.mapper;

import id.jx.service.awan.dto.UserDTO;
import id.jx.service.awan.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
	public abstract User toModel(UserDTO dto);
}
