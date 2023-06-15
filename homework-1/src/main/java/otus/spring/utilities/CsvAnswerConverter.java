package otus.spring.utilities;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import otus.spring.domain.Answer;

public class CsvAnswerConverter extends AbstractCsvConverter {
    @Override
    public String convertToWrite(Object value) throws CsvDataTypeMismatchException {
        Answer answer = (Answer) value;
        return String.format("%s.%s.%s", answer.getIndex(), answer.getAnswerText(), answer.isCorrect());
    }

    @Override
    public Object convertToRead(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        String[] split = s.split("\\|");
        int i = Integer.parseInt (split[0]);
        boolean isCorrect = Boolean.parseBoolean(split[2]);
        Answer answer = new Answer(i, split[1], isCorrect);
        return answer;
    }
}
