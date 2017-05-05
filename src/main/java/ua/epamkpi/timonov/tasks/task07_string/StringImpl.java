package ua.epamkpi.timonov.tasks.task07_string;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents implementation for some methods for String
 */
public class StringImpl {

    public static final char A_UPPER = 'A';
    public static final char A_LOWER = 'a';
    public static final char Z_UPPER = 'Z';
    public static final char Z_LOWER = 'z';
    public static final String DELIMITERS = " ,;.:-+='\"~!?@#$%^&*()";

    private String string;

    public StringImpl() {
        this.string = "";
    }

    public StringImpl(String string) {
        this.string = string;
    }

    /**
     * finds number of letters in the string
     * @return      number of letters
     */
    public int findNumberOfLetters() {
        int result = 0;
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        for (int i = 0; i < string.length(); i++) {
            char[] symbol = {string.charAt(i)};
            Matcher matcher = pattern.matcher(new String(symbol));
            if (matcher.matches()) {
                result++;
            }
        }
        return result;
    }

    /**
     * compares stored string with received one ignoring case
     * @param stringToCompare       string to compare
     * @return                      true if strings are equal ignoring case
     */
    public boolean compareIgnoreCase(String stringToCompare) {
        int thisLength = string.length();
        if (thisLength != stringToCompare.length()) {
            return false;
        }

        String thisWord = toLowerCase();
        String thatWord = stringToCompare.toLowerCase();
        for (int i = 0; i < thisLength; i++) {
            if (thisWord.charAt(i) != thatWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * returns stored string in upper case
     * @return      string in upper case
     */
    public String toUpperCase() {
        int residual = A_UPPER - A_LOWER;          // negative residual, for decreasing character code for upper case
        return changeCase(A_LOWER, Z_LOWER, residual);
    }

    /**
     * returns stored string in lower case
     * @return      string in lower case
     */
    public String toLowerCase() {
        int residual = A_LOWER - A_UPPER;          // positive residual, for increasing character code for lower case
        return changeCase(A_UPPER, Z_UPPER, residual);
    }

    private String changeCase(char firstLetter, char lastLetter, int residual) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character >= firstLetter && character <= lastLetter) {
                result.append((char) (character + residual));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    /**
     * finds indexes of occurrences of received word in stored string
     * @param wordToFind        received word to search in the string
     * @return                  list of indexes
     */
    public List<Integer> findOccurIndexes(String wordToFind) {
        String stringLowerCase = toLowerCase();
        String wordToFindLowerCase = wordToFind.toLowerCase();
        List<Integer> results = new ArrayList<>();
        int startIndex = 0;
        while (startIndex < stringLowerCase.length()) {
            int occurPosition = stringLowerCase.indexOf(wordToFindLowerCase, startIndex);
            if (occurPosition >= 0 ) {
                for (int i = 0; i < wordToFindLowerCase.length(); i++) {
                    results.add(occurPosition + i);
                }
                startIndex = occurPosition + wordToFind.length();
            } else {
                startIndex = stringLowerCase.length();
            }
        }
        return results;
    }

    /**
     * returns string with replacing one received word to another
     * @param wordToFind        substring to search in stored string
     * @param wordToReplace     substring to replace in stored string
     * @return                  stored string with replaced word
     */
    public String replace(String wordToFind, String wordToReplace) {
        String result = toLowerCase();
        String wordToFindLowerCase = wordToFind.toLowerCase();
        int startIndex = 0;
        while (startIndex < result.length()) {
            int occurPosition = result.indexOf(wordToFindLowerCase, startIndex);
            if (occurPosition >= 0 ) {
                String prefix = result.substring(0, occurPosition);
                String suffix = result.substring(occurPosition + wordToFindLowerCase.length());
                result = prefix + wordToReplace + suffix;
                startIndex = occurPosition + wordToReplace.length();
            } else {
                startIndex = result.length();
            }
        }
        return result;
    }

    /**
     * finds repeated word and returns map with founded words and number of their occurrences
     * @return      map with repeated words and number of their occurrences
     */
    public Map<String, Integer> findEqualWords() {
        Map<String, Integer> map = new HashMap<>();
        String stringToLowerCase = toLowerCase();
        StringTokenizer stringTokenizer = new StringTokenizer(stringToLowerCase, DELIMITERS);
        while (stringTokenizer.hasMoreElements()) {
            String word = stringTokenizer.nextToken();
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, ++count);
            } else {
                map.put(word, 1);
            }
        }
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    /* ================ Getters & setters ================== */

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
