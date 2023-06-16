package otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import otus.spring.dto.QuestionDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private int number;

    private String questionText;

    private List<Answer> answers;

    public Question(QuestionDTO questionDTO) {
        this.number = questionDTO.getNumber();
        this.questionText = questionDTO.getQuestionText();
        this.answers = questionDTO.getAnswers();
    }

    public String getStringRepresentation(boolean showCorrectAnswer) {

        StringBuilder stringBuilder = new StringBuilder("Вопрос №");
        stringBuilder.append(number);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(questionText);
        stringBuilder.append(System.lineSeparator());

        answers.stream().map(a -> a.getStringRepresentation(showCorrectAnswer)).forEach(stringBuilder::append);

        return  stringBuilder.toString();
    }
}
