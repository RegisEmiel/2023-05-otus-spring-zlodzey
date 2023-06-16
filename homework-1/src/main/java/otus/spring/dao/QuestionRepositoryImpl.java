package otus.spring.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import otus.spring.domain.Question;
import otus.spring.dto.QuestionDTO;
import otus.spring.dto.QuestionDTOListConverter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {

    private String fileName;

    private char separator;


    @Override
    public List<Question> getAll() {
        List<QuestionDTO> questionDTOList = getQuestionsFromFile();

        List<Question> questions = QuestionDTOListConverter.convert(questionDTOList);

        return questions;
    }

    private Reader getFileReader(String fileName) {
        InputStream inputStream = getClass().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        return inputStreamReader;
    }

    private List<QuestionDTO> getQuestionsFromFile() {

        Reader reader = getFileReader(fileName);

        List<QuestionDTO> questions = null;

        questions = new CsvToBeanBuilder<QuestionDTO>(reader)
                .withSeparator(separator)
                .withType(QuestionDTO.class)
                .build()
                .parse();

        return questions;
    }
}