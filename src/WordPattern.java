import java.util.Map;
import java.util.HashMap;
public class WordPattern {
    public static boolean wordPattern(String pattern, char delimiter, String s) {
        String[] words = s.split(String.valueOf(delimiter));

        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            if (charToWord.containsKey(currentChar)) {
                if (!charToWord.get(currentChar).equals(currentWord)) {
                    return false;
                }
            }
            else if (wordToChar.containsKey(currentWord)) {
                if (wordToChar.get(currentWord) != currentChar) {
                    return false;
                }
            }
            else {
                charToWord.put(currentChar, currentWord);
                wordToChar.put(currentWord, currentChar);
            }
        }

        return true;
    }
    public static void main(String[] args) {
        // Test cases
        System.out.println(wordPattern("abba", '?', "dog?cat?cat?dog"));
        System.out.println(wordPattern("abba", '|', "apple|banana|grape|apple"));
        System.out.println(wordPattern("aaaa", ',', "dog,cat,cat,dog"));
        System.out.println(wordPattern("aaaa", ' ', "ice cream taco day"));
        System.out.println(wordPattern("adxp", ' ', "ice cream taco day"));
    }
}