package in.sp.Main.Controllers;

import java.util.Collections;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.Main.Entities.AnswersDto;
import in.sp.Main.Entities.QuizQuestions;
import in.sp.Main.Entities.QuizResults;
import in.sp.Main.Services.ServicesInterface;


@RestController
@RequestMapping("question")
public class questionController {
	@Autowired
	private ServicesInterface serint;
	
	@GetMapping("/category/{category}")
	public  ResponseEntity<List<QuizQuestions>> getQuestionByCategory(@PathVariable String category) {
		
	return new ResponseEntity<List<QuizQuestions>>(serint.getQuestions(category),HttpStatus.OK);	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<QuizQuestions>>getallQuestions(){
		return new ResponseEntity<List<QuizQuestions>>(serint.getallQuestions(),HttpStatus.OK);
	}
	
	@PostMapping("/submitAns")
	public ResponseEntity<Integer>submitAnwsers(@RequestBody List<AnswersDto> answer){
		int score = 0;
		for(AnswersDto ans : answer) {
		QuizQuestions questions = serint.getQuestionsById(ans.getQuestionId()).orElse(null);
		if(questions != null && questions.getAnswer().equals(ans.getSelectedOption())) {
			score++;
		}
		}
		return new ResponseEntity<Integer>(score,HttpStatus.OK);
	}
	@PostMapping("/saveQuiz")
	public ResponseEntity<?>saveQuiz(@RequestBody QuizResults result){
		serint.saveQuiz(result);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@GetMapping("/userProfile/{username}")
	public ResponseEntity<?> getuserProfile(@PathVariable String username) {
	    List<QuizResults> results = serint.getAllQuizProfiles(username);
	    if (results.isEmpty()) {
	        return  ResponseEntity.ok(Collections.emptyList());
	    }
	    return  ResponseEntity.ok(results);
	}
	
}






