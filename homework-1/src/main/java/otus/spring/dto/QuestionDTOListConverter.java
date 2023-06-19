package otus.spring.dto;

import otus.spring.domain.Question;

import java.util.List;

public class QuestionDTOListConverter {

    public static Question convertToQuestion(QuestionDTO questionDTO) {
        Question question = new Question(
                questionDTO.getNumber(),
                questionDTO.getQuestionText(),
                questionDTO.getAnswers()
        );

        return question;
    }

    public static List<Question> convert(List<QuestionDTO> questionDTOList) {
        List<Question> questions = questionDTOList.stream()
                .map(QuestionDTOListConverter::convertToQuestion)
                .toList();

        return questions;
    }
}
