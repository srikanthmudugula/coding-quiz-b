package in.sp.Main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.Main.Entities.QuizResults;

public interface QuizRepository extends JpaRepository<QuizResults, Long>{
	List<QuizResults> findByUsername(String username);
}

