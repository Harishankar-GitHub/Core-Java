import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        String regExp = "I want a \\w+.";
        System.out.println(challenge1.matches(regExp));
        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches(regExp));

        String regExp1 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp1));
        System.out.println(challenge2.matches(regExp1));

        String regExp3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regExp3);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        // Here, we didn't use matcher.reset().
        // That is because, we are not using same instance of matcher again,
        // we are using a new instance of matcher.
        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll(" ", "_"));        // This removes only spaces.
        System.out.println(challenge4.replaceAll("\\s", "_"));      // This removes spaces, tabs, new line etc. (All white spaces)

        String challenge5 = "aaaabccccccccdddefffg";
//        String challenge5 = "zaaaabccccccccdddefffg";
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        // The above regex matches only the challenge5 string.
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));

        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$"));     // This is also correct.
        System.out.println(challenge7.matches("^[A-Za-z]+\\.\\d+$"));       // This is also correct.

    }
}
