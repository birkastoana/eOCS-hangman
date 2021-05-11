package service;

import static org.junit.jupiter.api.Assertions.*;

class WordGeneratorUtilTest {

    WordGeneratorUtil wgu;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        wgu = new WordGeneratorUtil();
    }

    @org.junit.jupiter.api.Test
    void getRandomWordCharArray() {
        char[] charArray1 = wgu.getRandomWordCharArray();
        char[] charArray2 = wgu.getRandomWordCharArray();
        char[] charArray3 = wgu.getRandomWordCharArray();

        assertFalse( charArray1 == charArray2 && charArray1 == charArray3 && charArray2 == charArray3);
    }
}
