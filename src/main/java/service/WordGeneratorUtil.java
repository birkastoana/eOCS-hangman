package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordGeneratorUtil {

    public char[] getRandomWordCharArray () {
        List<String> words = new ArrayList<>();
        words.add("Eurofunk");
        words.add("Kappacher");
        words.add("eOCS");
        words.add("Pongau");
        words.add("Salzburg");
        words.add("Ils");
        words.add("Austria");

        // choose random one
        String word = words.get(ThreadLocalRandom.current().nextInt(0, words.size()));

        return word.toCharArray();
    };
}
