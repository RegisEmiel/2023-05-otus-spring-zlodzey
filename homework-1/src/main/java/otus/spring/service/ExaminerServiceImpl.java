package otus.spring.service;

import otus.spring.dao.QuestionRepository;
import otus.spring.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionRepository questionRepository;
    @Override
    public void runTest() {
        List<Question> questions = questionRepository.getAll();

        questions.forEach(System.out::println);
    }
}
