package otus.spring.utilities;

import otus.spring.domain.Answer;
import otus.spring.domain.Question;

public class QuestionToStringConverter {

    public String answerToString(Answer answer, boolean showCorrectAnswer) {
        StringBuilder stringBuilder = new StringBuilder();

        if (showCorrectAnswer) {
            stringBuilder.append(answer.isCorrect() ? "* \t" : "\t");
        }

        stringBuilder.append(String.format("%s.%s", answer.getIndex(), answer.getAnswerText()))
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }

    public String questionToString(Question question, boolean showCorrectAnswer) {

        StringBuilder stringBuilder = new StringBuilder("Вопрос №");
        stringBuilder.append(question.getNumber());
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(question.getQuestionText());
        stringBuilder.append(System.lineSeparator());

        question.getAnswers().stream()
                .map(answer -> answerToString(answer, showCorrectAnswer))
                .forEach(stringBuilder::append);

        return  stringBuilder.toString();
    }
}
