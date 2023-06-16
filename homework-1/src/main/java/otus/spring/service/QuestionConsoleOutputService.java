package otus.spring.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.PrintStream;

@Setter
@Getter
@NoArgsConstructor
public class QuestionConsoleOutputService implements QuestionOutputService {
    private final PrintStream printStream = System.out;

    @Override
    public void outQuestion(String st) {
        printStream.println(st);
    }
}
