package otus.spring.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import otus.spring.domain.Question;
import otus.spring.dto.QuestionDTO;
import otus.spring.dto.QuestionDTOListConverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {

    private String fileName;
    private char separator;


    @Override
    public List<Question> getAll() {
        List<QuestionDTO> questionDTOList = getQuestions();

        List<Question> questions = QuestionDTOListConverter.convert(questionDTOList);

        return questions;
    }

    private List<QuestionDTO> getQuestions() {
        InputStream inputStream = Objects.requireNonNull(
                this.getClass().getResourceAsStream(fileName), "Файл не найден!");

        List<QuestionDTO> questions = null;

        try (Reader reader = new InputStreamReader(inputStream)) {

            questions = new CsvToBeanBuilder<QuestionDTO>(reader)
                    .withSeparator(separator)
                    .withType(QuestionDTO.class)
                    .build()
                    .parse();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return questions;
    }
}
