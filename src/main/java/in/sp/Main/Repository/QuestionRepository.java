package in.sp.Main.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import in.sp.Main.Entities.QuizQuestions;

public interface QuestionRepository extends JpaRepository<QuizQuestions, Integer>{
  List<QuizQuestions> findByCategory(String Category);
  
}

