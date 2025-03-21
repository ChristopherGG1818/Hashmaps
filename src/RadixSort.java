import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        String[] input = { //jjk
                "google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo",
                "pupperino", "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao","peter","jayden","navi",
                "Chris"
        };

        String[] sortedArray = radixSortStrings(input);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static String[] radixSortStrings(String[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int maxLength = 0;
        for (String s : arr) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        String[] paddedArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            paddedArr[i] = padString(arr[i], maxLength);
        }

        for (int i = maxLength - 1; i >= 0; i--) {
            paddedArr = countingSort(paddedArr, i);
        }

        String[] result = new String[paddedArr.length];
        for (int i = 0; i < paddedArr.length; i++) {
            result[i] = paddedArr[i].replace("\0", "");
        }

        return result;
    }

    private static String padString(String s, int maxLength) {
        return String.format("%-" + maxLength + "s", s).replace(' ', '\0');
    }

    private static String[] countingSort(String[] arr, int charIndex) {
        Map<Character, Integer> count = new HashMap<>();
        for (String s : arr) {
            char c = s.charAt(charIndex);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Character> sortedChars = new ArrayList<>(count.keySet());
        sortedChars.sort((a, b) -> {
            if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
                return Character.isUpperCase(a) ? -1 : 1;
            }
            return Character.toLowerCase(a) - Character.toLowerCase(b);
        });

        Map<Character, Integer> cumulativeCount = new HashMap<>();
        int total = 0;
        for (char c : sortedChars) {
            cumulativeCount.put(c, total);
            total += count.get(c);
        }

        String[] sortedArr = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i].charAt(charIndex);
            int index = cumulativeCount.get(c);
            sortedArr[index] = arr[i];
            cumulativeCount.put(c, index + 1);
        }

        return sortedArr;
    }
}