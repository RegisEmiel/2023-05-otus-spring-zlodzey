package otus.spring.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import otus.spring.domain.Question;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {

    private String fileName;
    private char separator;


    @Override
    public List<Question> getAll() {
        InputStream inputStream = Objects.requireNonNull(
                this.getClass().getResourceAsStream(fileName), "Файл не найден!");

        List<Question> questions = null;

        try (Reader reader = new InputStreamReader(inputStream)) {

            questions = new CsvToBeanBuilder<Question>(reader)
                    .withSeparator(separator)
                    .withType(Question.class)
                    .build()
                    .parse();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return questions;
    }
}
