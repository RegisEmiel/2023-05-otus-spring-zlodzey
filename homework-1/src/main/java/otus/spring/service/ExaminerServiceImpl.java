package otus.spring.service;

import otus.spring.dao.QuestionRepository;
import otus.spring.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionRepository questionRepository;

    private final QuestionOutputService questionOutputService;

    private final boolean fShowAnswer;

    @Override
    public void runTest() {
        List<Question> questions = questionRepository.getAll();

        questions.stream().map(q -> q.getStringRepresentation(fShowAnswer)).forEach(questionOutputService::outQuestion);
    }
}
