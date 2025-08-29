package in.sp.Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.Main.Entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	public Users findByEmail(String email);
	public Users findByUsername(String username);
}

