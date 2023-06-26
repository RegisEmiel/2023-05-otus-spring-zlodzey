package otus.spring.service;

import lombok.RequiredArgsConstructor;
import otus.spring.dao.QuestionRepository;
import otus.spring.domain.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionRepository questionRepository;

    private final OutputService outputService;

    private final QuestionToStringConverter questionToStringConverter;

    private final boolean fShowAnswer;


    @Override
    public void runTest() {
        List<Question> questions = questionRepository.getAll();

        questions.stream()
                .map(q -> questionToStringConverter.questionToString(q, fShowAnswer))
                .forEach(outputService::outputString);
    }
}
