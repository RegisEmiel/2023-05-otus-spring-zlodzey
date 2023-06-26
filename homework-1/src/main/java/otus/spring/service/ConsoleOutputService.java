package otus.spring.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.PrintStream;

@Setter
@Getter
@NoArgsConstructor
public class ConsoleOutputService implements OutputService {
    private final PrintStream printStream = System.out;

    @Override
    public void outputString(String st) {
        printStream.println(st);
    }
}
