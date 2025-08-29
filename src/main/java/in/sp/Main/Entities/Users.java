package in.sp.Main.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="QuizUsers")
public class Users {
@jakarta.persistence.Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int id;
@Column

private String username;
@Column
private String email;
@Column
private String password;

public Users() {}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
