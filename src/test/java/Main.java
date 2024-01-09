import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class Main {

    // find duplicate characters in the string "gabcdec", and print them with their count.
    public static void main(String[] args) {
        String str = "gabcdec";

        int [] duplicatedChars = new int[128];
        for (int i = 0; i < str.length(); i++) {
                duplicatedChars[str.charAt(i)]++;
            }

        for (int i = 0; i < duplicatedChars.length; i++) {
            if (duplicatedChars[i] > 1) {
                System.out.println((char) i + ": " + parseInt(String.valueOf(duplicatedChars[i])));
            }
        }

        }

    public static void main2(String[] args) {
        String str = "gabcdec";
        Map<Character, Integer> charQuantity = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            charQuantity.put(str.charAt(i), charQuantity.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charQuantity.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    }

