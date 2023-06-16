package otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import otus.spring.domain.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты доступа к репозиторию вопросов")
class QuestionRepositoryTest {
    static private int QUESTION_COUNT = 2;

    @Test
    @DisplayName("Проверка исключения при несуществующем имени файла с вопросами")
    void wrongFileNameExceptionText() {
        QuestionRepository questionRepository = new QuestionRepositoryImpl("/wrong.csv", ',');

        assertThrows(IllegalArgumentException.class, questionRepository::getAll);
    }

    @Test
    @DisplayName("Проверка исключения при пустом файле с вопросами")
    void emptyCsvFileText() {
        QuestionRepository questionRepository = new QuestionRepositoryImpl("/emptytest.csv", ',');

        RuntimeException thrown = assertThrows(RuntimeException.class, questionRepository::getAll);

        assertTrue(thrown.getMessage().contentEquals("Error capturing CSV header!"));
    }

    @Test
    @DisplayName("Проверка получения вопросов")
    void questionsAllRightText() {
        QuestionRepository questionRepository = new QuestionRepositoryImpl("/questionlisttest.csv", ',');

        List<Question> questions = questionRepository.getAll();

        assertEquals(questions.size(), QUESTION_COUNT);
    }
}
