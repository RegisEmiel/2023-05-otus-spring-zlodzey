package otus.spring.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import otus.spring.domain.Question;
import otus.spring.dto.QuestionDTO;
import otus.spring.dto.QuestionDTOListConverter;


import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

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

        InputStream inputStream = getClass().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        List<QuestionDTO> questions = null;

        questions = new CsvToBeanBuilder<QuestionDTO>(inputStreamReader)
                .withSeparator(separator)
                .withType(QuestionDTO.class)
                .build()
                .parse();

        return questions;
    }
}