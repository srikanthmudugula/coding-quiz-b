package in.sp.Main.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.Main.Entities.Users;
import in.sp.Main.Services.ServiceIntImpl;

@RestController
@RequestMapping("/user/auth")
public class UsersController {
	@Autowired
	private ServiceIntImpl seriml;
	
	@PostMapping("/signup")
	public ResponseEntity<String> saveUsers(@RequestBody Users user) {
		 
		try {
			Users savedUser = seriml.SaveUsers(user);
	         return ResponseEntity.ok("User registered successfully");
	    } catch (Exception e) {
	    	if(e.getMessage().equals("Email already registered"))
	    		return ResponseEntity.badRequest().body("Email already registered");
	    	else if(e.getMessage().equals("username already used"))
	    		return ResponseEntity.badRequest().body("username already used");
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("user not registered ");
	    }
		}
	@PostMapping("/login")
	public ResponseEntity<?> getUser(@RequestBody Users user) {
		try {
		 Users validUser = seriml.getUserbyEmail(user.getEmail(), user.getPassword());
		 if(validUser != null) {
		  return ResponseEntity.ok(validUser);
		 }
		 else {
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		 }
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("server error");
		}
	}
	}

