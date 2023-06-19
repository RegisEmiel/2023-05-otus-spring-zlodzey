package otus.spring.service;

import lombok.RequiredArgsConstructor;
import otus.spring.dao.QuestionRepository;
import otus.spring.domain.Question;
import lombok.Getter;
import lombok.Setter;
import otus.spring.utilities.QuestionToStringConverter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionRepository questionRepository;

    private final ConsoleOutputService consoleOutputService;

    private final boolean fShowAnswer;

    private final QuestionToStringConverter questionToStringConverter = new QuestionToStringConverter();

    @Override
    public void runTest() {
        List<Question> questions = questionRepository.getAll();

        questions.stream()
                .map(q -> questionToStringConverter.questionToString(q, fShowAnswer))
                .forEach(consoleOutputService::outputString);
    }
}
