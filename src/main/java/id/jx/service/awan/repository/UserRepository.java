package id.jx.service.awan.repository;

import id.jx.service.awan.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsernameAndPassword(String username, String password);
}
