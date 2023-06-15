package otus.spring.dto;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import otus.spring.domain.Answer;
import otus.spring.utilities.CsvAnswerConverter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    @CsvBindByName(required = true)
    private int number;

    @CsvBindByName(required = true)
    private String questionText;

    @CsvBindAndSplitByName(
            elementType = Answer.class,
            writeDelimiter = ";",
            splitOn = "\\;",
            collectionType = ArrayList.class,
            converter = CsvAnswerConverter.class
    )
    private List<Answer> answers;
}
