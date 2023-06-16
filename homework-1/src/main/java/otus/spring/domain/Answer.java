package otus.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private int index;

    private String answerText;

    private boolean correct;


    public String getStringRepresentation(boolean showCorrectAnswer) {
        StringBuilder stringBuilder = new StringBuilder();

        if (showCorrectAnswer) {
            stringBuilder.append(correct ? "* \t" : "\t");
        }

        stringBuilder.append(String.format("%s.%s", index, answerText))
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }
}
