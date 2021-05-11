import service.WordGeneratorUtil;


import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EocsHangmanApplication {


    public static void main(String... args) {

        WordGeneratorUtil wgu = new WordGeneratorUtil();

        // setup the char arrays
        char[] wordChars = wgu.getRandomWordCharArray();
        char[] result = wordChars.clone();

        for (int i = 1; i < wordChars.length - 1; i++) {
            wordChars[i] = '_';
        }


        // some setup
        String message = "Insert the Position and the Character you intend to place: ";
        TreeSet<Integer> legalIndexes = new TreeSet();
        for ( int i = 1; i < wordChars.length -1 ; i++) {
            legalIndexes.add(i);
        }
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(\\d)\\s([a-z])", Pattern.CASE_INSENSITIVE);
        int misstrials = 0;
        final int validMisstrials = 10;
        int tries = 0;
        ZonedDateTime timestamp = ZonedDateTime.now();



        // one loop is a round in this game
        while (misstrials < validMisstrials) {
            // print out the UI
            System.out.println("################################################################");
            System.out.println("\t\tEurofunk eOCS Hangman Game");
            System.out.println("################################################################");
            System.out.println("Find the missing character in the word below. Insert your character in the following format: \"<index> <character>\" ");
            System.out.println("Mind: Don't forget the whitespace! The Game is case-sensitive");
            for (int i = 0; i < result.length; i++ ) {
                System.out.print(i + "\t");
            }
            System.out.println();
            for (int i = 0; i < result.length; i++ ) {
                System.out.print(wordChars[i] + "\t");
            }
            System.out.println("\n" + message);
            System.out.println("\nMisstrials: " + misstrials + "/" + validMisstrials );
            System.out.println("Time neeeded: " + (timestamp.until(ZonedDateTime.now(), ChronoUnit.SECONDS) ) + " seconds");
            tries += 1;
            System.out.println();

//          waiting for user input
            String input = scanner.nextLine();

            //  Move old stuff up -> cleaning out the console does not work for W10!
            for (int i = 0; i < 10; i ++ ) System.out.println();

            // regex the input, announce the user if wrong format
            // all character followed will be ignored
            Matcher matcher = pattern.matcher(input);
            if (! matcher.find()) {
                message = "You entered the wrong format! Insert the index of the character and a whitespace followed by one character!";
                continue;
            };

            // seperate regex groups
            int insertedIndex = Integer.parseInt(matcher.group(1));
            char insertedChar =  matcher.group(2).charAt(0);

            if( !legalIndexes.contains(insertedIndex) ) {
                message = "You entered the wrong index! Insert a number between " + legalIndexes.first() + " and " + legalIndexes.last() ;
                continue;
            }

            if ( result[insertedIndex] == insertedChar) {
                wordChars[insertedIndex] = insertedChar;
                message = "You're right! Try the next one!";
                legalIndexes.remove(insertedIndex);
            } else {
                misstrials += 1;
                message = "What a pity, that was wrong. Try again!";
            }

            boolean contains_ = false;
            for ( char c : wordChars ) {
                if (c == '_' ) {
                    contains_ = true;
                    break;
                }
            }


            if (!contains_) {
                System.out.println("***************************************************");
                System.out.println("\t\t You won! ");
                System.out.println("***************************************************");
                return;
            }

        }
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t You lost! ");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");


    }


}

