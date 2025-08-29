package in.sp.Main.Services;

import java.util.List;
import java.util.Optional;
import in.sp.Main.Entities.QuizQuestions;
import in.sp.Main.Entities.QuizResults;
import in.sp.Main.Entities.Users;

public interface ServicesInterface {
  public List getQuestions(String Category);
  public List getallQuestions();
  public Users SaveUsers(Users users) throws Exception;
  public Users getUserbyEmail(String email,String password);
  public Optional<QuizQuestions> getQuestionsById(int num);
 public QuizResults saveQuiz(QuizResults result);
  public List<QuizResults> getAllQuizProfiles(String username);
  
  
}

