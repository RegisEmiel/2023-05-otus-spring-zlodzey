package otus.spring.domain;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @CsvBindByName(required = true)
    private int number;

    @CsvBindByName(required = true)
    private String questionText;

    @CsvBindAndSplitByName(elementType = String.class, collectionType = ArrayList.class, splitOn = "\\,", required = true)
    private List<String> answers;

    @CsvBindAndSplitByName(elementType = Integer.class, collectionType = ArrayList.class, splitOn = "\\,", required = true)
    private  List<Integer> rightNumbers;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Вопрос №");
        sb.append(number);
        sb.append(System.lineSeparator());
        sb.append(questionText);
        sb.append(System.lineSeparator());

        int answerNumber = 0;
        for (String answer: answers) {
            sb.append(++answerNumber).append(". ");
            sb.append(answer);

            if (rightNumbers.contains(answerNumber))
                sb.append("\t*");

            sb.append(System.lineSeparator());
        }

        return  sb.toString();
    }
}
