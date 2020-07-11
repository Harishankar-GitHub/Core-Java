import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//         Some useful reference links :
//         Matcher : https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html
//         Pattern : https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html

        // Introduction ************************************************************************************************

        String string = "I am a String. Yes I am.";
        System.out.println(string);

        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphaNumeric = "hhfhu8t756473yeg5657";
        System.out.println(alphaNumeric.replaceAll(".", "Y"));
        // . denotes any character.

        System.out.println(alphaNumeric.replaceAll("^hhfhu", "YYY"));
        // ^ is to search for the pattern at the beginning of the string.

        String secondString = "hhfhu8t7hhfhu5647";
        System.out.println(secondString.replaceAll("^hhfhu", "YYY"));
        // Here, we used ^ , so the second occurrence of "hhfhu" did not get replaced.

        System.out.println(alphaNumeric.matches("^hhfhu"));                 // false
        System.out.println(alphaNumeric.matches("hhfhu8t756473yeg5657"));   // true
        System.out.println(alphaNumeric.matches("^hhfhu8t756473yeg5657"));   // true
        // string.matches() returns true if entire string is matched.
        // Even if we use regex like ^ etc, it should match the entire string to return true.

        System.out.println(secondString.replaceAll("u5647$", "END"));
        // $ is to check if the string ends with the regex given.

        String anotherString = "hfidwe3tw6id21a";

        System.out.println((anotherString.replaceAll("[aei]", "X")));
        System.out.println((anotherString.replaceAll("[aei]", " REPLACE ")));
        // The above line replaces "X" in place of "a" or "e" or "i".

        System.out.println(anotherString.replaceAll("[aei][d3]", " A "));
        // The above line replaces if it finds a match which has "a" or "e" or "i" and "d" or "3" after that.

        System.out.println("Harry".replaceAll("[Hh]arry", "HARRY"));
        // The above line checks for a H or h followed by arry. If found, then replaces with HARRY.

        String newAnotherString = "hfidwAe3tw6iVd21a";

        System.out.println(newAnotherString.replaceAll("[^iw]", "X"));
        // The above line replaces X for characters other than "i" or "w".
        // If ^ is put outside [], it is to check the beginning of the string.
        // If ^ is put inside [], like this [^iw], it means -> it will match except "i" and "w".

        System.out.println(newAnotherString.replaceAll("[abcdef345678]", "X"));
        // Above line replaces X for the given characters.
        // The same can be simplified as below.
        System.out.println(newAnotherString.replaceAll("[a-f3-8]", "X"));
        System.out.println(newAnotherString.replaceAll("[a-fA-F3-8]", "X"));
        // a-f denotes range. i.e., a,b,c,d,e,f
        // 3-8 denotes range. i.e., 3,4,5,6,7,8

        System.out.println(newAnotherString.replaceAll("(?i)[a-f3-8]", "X"));
        // (?i) is to remove the case sensitivity.
        // i.e., It matches a-f and A-Z.
        // (?i)     - only for ASCII Strings.
        // (?iu)    - for both ASCII & Unicode Strings.

        // Introduction ************************************************************************************************

        // Character Classes and Boundary Matchers *********************************************************************

        System.out.println(newAnotherString.replaceAll("[0-9]", " Digit "));
        // Above line replaces if it encounters a digit between 0-9.
        // This can be simplified as below.
        System.out.println(newAnotherString.replaceAll("\\d", " Digit "));
        System.out.println(newAnotherString.replaceAll("\\D", " Digit "));
        // "\\d" - Matches digits.
        // "\\D" - Matches Non-Digits.
        

        String hasWhiteSpace = "I have blanks and\ta tab and also a new line\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        // "\\s" is to check if the string has spaces (spaces, tabs, new line etc).

        System.out.println(hasWhiteSpace.replaceAll("\t", "X"));
        // "\t" is to check if the string has a tab space.

        System.out.println(hasWhiteSpace.replaceAll("\\S", "X"));
        // "\\S" to check for non white space.

        System.out.println(alphaNumeric.replaceAll("\\w", "X"));
        // "\\w" to check for all alphabets, 0-9 and underscore.
        // "\\W" will have the opposite effect.

        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));
        // "\\b" is used to surround each word with the replacement string.
        // "\\b" is also called as Boundary Matchers.

        // Character Classes and Boundary Matchers *********************************************************************

        // Quantifiers *************************************************************************************************

        String thirdAlphaNumeric = "hhfhuuu8t75hij6473yeg5657";
        System.out.println(thirdAlphaNumeric.replaceAll("^hhfhu{3}", "YYY"));
        // {} is a quantifier. It comes after the character to which it applies.
        // In this case, "u" must occur 3 times.

        System.out.println(thirdAlphaNumeric.replaceAll("^hhfhu+", "YYY"));
        // + is a quantifier.
        // In this case, "u" must occur at least 1 or more times.

        System.out.println(thirdAlphaNumeric.replaceAll("^hhfhu*", "YYY"));
        // * is a quantifier.
        // In this case, "u" can occur 0 or more times.

        System.out.println(thirdAlphaNumeric.replaceAll("^hhfhu{2,5}", "YYY"));
        // {2,5} is used to give range for the number of occurence.
        // In this case, "u" can occur from 2 to 5 times.

        System.out.println(thirdAlphaNumeric.replaceAll("h+i*j", "HHH"));
        // The above regex is to find if the string has at least 1 "h" followed by 0 or more "i" and followed by "j".


        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";                  // It is a regex.
        Pattern pattern = Pattern.compile(h2Pattern);   // Creating a Pattern Instance.
        Matcher matcher = pattern.matcher(htmlText);    // Creating a Matcher Instance using Pattern Instance.
        System.out.println(matcher.matches());          // Calling matches() method which is inside Matcher Class to check
                                                        // if the Pattern matches the regular expression.

        // matcher.matches() method returns true of the entire string is matched with pattern.
        // ".*<h2>.*" - This regex means, the string can have 0 or more characters before and after <h2>.

        // If we want to match <h2> and also <H2>, we can modify the regex to handle it.
        // If not, there's another way to do it as below.
        // Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);

        // Quantifiers *************************************************************************************************

        // Matcher find and Group Methods ******************************************************************************

        matcher.reset();        // When we are using matcher again, it needs to be reset.
        int count = 0;

        while(matcher.find())
        {
            count++;
            System.out.println("Occurrence : " + count + " : " + matcher.start() + " to " + matcher.end());
            // matcher.start() and matcher.end() returns the index of the pattern which is matched in the string.
            // matcher.end() returns the index of the next character of the pattern in the string.
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        // The reason of putting a ? in the above regex is to find the text between 1st <h2> and 2nd <h2> and so on.
        // If ? is not used, it will print the text between 1st <h2> and the last <h2>.
        // To check, we can remove ? from the regex and observe the output.
        // This concept is known as Greedy Quantifier and Lazy Quantifier.

        Pattern grouPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = grouPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();

        while(groupMatcher.find())
        {
            System.out.println("Occurrence : " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        // Group 1 - (<h2>)
        // Group 2 - (.+?)
        // Group 3 - (</h2>)
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find())
        {
            System.out.println("Occurrence : " + h2TextMatcher.group(2));
            // We are printing the text between <h2> and </h2> tags.
            // That's why we pass 2 in h2TextMatcher.group() method.
        }

        // Matcher find and Group Methods ******************************************************************************

        // And, Or & Not ***********************************************************************************************

        // "abc" "a" and "b" and "c"
        // [Hh]arry
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // [^abc]
        String tvTest = "tstvtkt";
        // String tNotVRegExp = "t[^v]";
        // In the above regex, any 1 character other than v MUST be present after t.

        String tNotVRegExp = "t(?!v)";      // This is known as Negative Look Ahead expression.
        // In the above regex, any 1 character after t other than v will match and no character after t will also match.
        // ! is NOT Operator.
        // ? is part of look ahead syntax.

        // String positiveLookAhead = "t(?=v)";     // This is known as Positive Look Ahead expression.
        // In the above regex, v MUST be present after t that will match and no character after t will also match.
        // = is EQUAL Operator.
        // ? is part of look ahead syntax.

        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }


        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        // Above line is a regex for a US Phone Number - (123) 456-7890

        String phone1 = "1234567890";       // Shouldn't match
        String phone2 = "(123) 456-7890";   // match
        String phone3 = "123 456-7890";     // Shouldn't match
        String phone4 = "(123)456-7890";    // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));


        // ^4[0-9]{12}([0-9]{3})?$
        // Explanation for the above regex :
        // Starts with 4.
        // Then 12 numbers between 0 and 9.
        // Optional 3 characters between 0 and 9.

        String visa1 = "4444444444444";     // should match
        String visa2 = "5444444444444";     // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";              // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));

        // And, Or & Not ***********************************************************************************************
    }
}