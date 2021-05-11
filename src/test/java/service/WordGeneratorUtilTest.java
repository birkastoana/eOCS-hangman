package service;

import static org.junit.jupiter.api.Assertions.*;

class WordGeneratorUtilTest {

    WordGeneratorUtil wgu;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        wgu = new WordGeneratorUtil();
    }

    /**
     * Only for demonstration purpose, does not make sense in this case!
     */
    @org.junit.jupiter.api.Test
    void getRandomWordCharArray() {
        char[] charArray1 = wgu.getRandomWordCharArray();
        char[] charArray2 = wgu.getRandomWordCharArray();
        char[] charArray3 = wgu.getRandomWordCharArray();

        assertFalse( charArray1.equals(charArray2) && charArray1.equals(charArray3) && charArray2.equals(charArray3));
    }
}
