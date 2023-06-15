package otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тесты доступа к репозиторию вопросов")
class QuestionRepositoryTest {
    @Test
    @DisplayName("Проверка исключения при несуществующем имени файла с вопросами")
    void wrongFileNameExceptionText() {
        QuestionRepository questionRepository = new QuestionRepositoryImpl("wrong.csv", ';');

        NullPointerException thrown = assertThrows(NullPointerException.class, questionRepository::getAll);
        
        assertTrue(thrown.getMessage().contentEquals("Файл не найден!"));
    }
}
