package ua.epamkpi.timonov.tasks.task07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTask {
    private String word;

    public StringTask(String word) {
        this.word = word;
    }

    public int findNumberAlphabetSymbols() {
        int result = 0;
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        for (int i = 0; i < word.length(); i++) {
            char[] symbol = {word.charAt(i)};
            Matcher matcher = pattern.matcher(new String(symbol));
            if (matcher.matches()) {
                result++;
            }
        }
        return result;
    }

    public boolean compare(String thatString) {
        int thisLength = word.length();
        int thatLength = thatString.length();
        if (thisLength != thatLength) {
            return false;
        }
        int maxLength = Math.max(thisLength, thatLength);
        for (int i = 0; i < maxLength; i++) {
            if (word.charAt(i) != thatString.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
