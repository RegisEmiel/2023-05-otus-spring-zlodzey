package otus.spring.dto;

import otus.spring.domain.Question;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionDTOListConverter {
    static public List<Question> convert(List<QuestionDTO> questionDTOList) {
        List<Question> questions = questionDTOList.stream()
                .map(Question::new)
                .toList();

        return questions;
    }
}
