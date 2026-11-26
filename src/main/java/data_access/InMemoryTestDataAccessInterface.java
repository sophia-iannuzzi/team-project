package data_access;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import use_case.MemoryTest.MemoryTestDataAccessInterface;

public class InMemoryTestDataAccessInterface implements MemoryTestDataAccessInterface {

    private final List<String> words;

    public InMemoryTestDataAccessInterface() {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("memory_words.json");

            if (input == null) {
                throw new RuntimeException("memory_words.json not found");
            }

            String json = new String(input.readAllBytes(), StandardCharsets.UTF_8);

            String wordList = json.substring(
                    json.indexOf("[") + 1,
                    json.indexOf("]")
            );

            this.words = Arrays.stream(wordList.split(","))
                    .map(word -> word.replace("\"", "").trim())
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getRandomWords(int count) {

        List<String> shuffled = new ArrayList<>(words);
        Collections.shuffle(shuffled);

        return shuffled.subList(0, Math.min(count, shuffled.size()));
    }
}
