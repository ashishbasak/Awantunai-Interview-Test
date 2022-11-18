package id.jx.service.awan.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ref_id", nullable = false, updatable = false)
	private String refId;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private boolean isActive;
}
