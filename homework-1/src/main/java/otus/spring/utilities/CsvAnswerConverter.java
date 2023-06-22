package otus.spring.utilities;

import com.opencsv.bean.AbstractCsvConverter;
import otus.spring.domain.Answer;

public class CsvAnswerConverter extends AbstractCsvConverter {

    @Override
    public Object convertToRead(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Answer is empty!");
        }

        String[] split = s.split("\\|");
        int i = Integer.parseInt (split[0]);
        boolean isCorrect = Boolean.parseBoolean(split[2]);
        Answer answer = new Answer(i, split[1], isCorrect);

        return answer;
    }
}
