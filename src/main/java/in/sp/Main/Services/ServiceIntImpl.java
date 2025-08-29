package in.sp.Main.Services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.Main.Entities.QuizQuestions;
import in.sp.Main.Entities.QuizResults;
import in.sp.Main.Entities.Users;
import in.sp.Main.Repository.QuestionRepository;
import in.sp.Main.Repository.QuizRepository;
import in.sp.Main.Repository.UserRepository;

@Service
public class ServiceIntImpl implements ServicesInterface{
	
	@Autowired
	private QuestionRepository Querep;
	@Autowired
	private UserRepository userRep;
	@Autowired
	private QuizRepository quizrepo;
	
	@Override
	public List getQuestions(String category) {
	 try{
		 return Querep.findByCategory(category);
	 } catch(Exception e ){
		 e.printStackTrace();
	 }
	 return null;
	}
	
	@Override
	public List getallQuestions() {
		return Querep.findAll();
	}
	
	@Override
	public Users SaveUsers(Users user) throws Exception {
		Users ExistingUser = userRep.findByEmail(user.getEmail()); 
		if(ExistingUser != null) {
	        throw new Exception("Email already registered");
	    }
		Users ExistingUserByUserName = userRep.findByUsername(user.getUsername());
		if(ExistingUserByUserName != null) {
			 throw new Exception("username already used");
		}
	    return userRep.save(user);
	}

	
	@Override
	public Users getUserbyEmail(String email, String password) {
		try {
		Users Validuser = userRep.findByEmail(email);
		if(Validuser != null && Validuser.getPassword().equals(password)) {
			return Validuser;
		}else {
			return null;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Optional<QuizQuestions> getQuestionsById(int num) {
		return Querep.findById(num);
	}

	@Override
	public QuizResults saveQuiz(QuizResults result) {
		return quizrepo.save(result);
		}

	@Override
    public List<QuizResults> getAllQuizProfiles(String username) {
        return quizrepo.findByUsername(username);
    }
		
	
}
