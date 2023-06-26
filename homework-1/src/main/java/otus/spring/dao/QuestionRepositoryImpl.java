package otus.spring.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import otus.spring.domain.Question;
import otus.spring.dto.QuestionDTO;
import otus.spring.dto.QuestionDTOListConverter;


import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {

    private final String fileName;

    private final char separator;


    @Override
    public List<Question> getAll() {
        List<QuestionDTO> questionDTOList = getQuestionsFromFile();

        List<Question> questions = QuestionDTOListConverter.convert(questionDTOList);

        return questions;
    }

    private List<QuestionDTO> getQuestionsFromFile() {
        List<QuestionDTO> questions = null;


        try(InputStreamReader inputStreamReader = new InputStreamReader(Objects
                .requireNonNull(getClass()
                        .getResourceAsStream(fileName), "File not found: " + fileName))) {

            questions = new CsvToBeanBuilder<QuestionDTO>(inputStreamReader)
                    .withSeparator(separator)
                    .withType(QuestionDTO.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return questions;
    }
}