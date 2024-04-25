import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Picnic {
    public static void main(String[] args) {
        // 1. Подсчитываем количество слов в файле
        int wordCount = countWords();
        System.out.println("Количество слов в файле: " + wordCount);

        // 2. Находим самое длинное слово в файле
        String longestWord = findLongestWord();
        System.out.println("Самое длинное слово в файле: " + longestWord);

        // 3. Подсчитываем количество вхождений каждого слова
        Map<String, Integer> wordFrequency = countWordFrequency();
        System.out.println("Частота встречаемости слов:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Метод для подсчета количества слов в файле
    public static int countWords() {
        int count = 0;
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }

    // Метод для нахождения самого длинного слова в файле
    public static String findLongestWord() {
        String longestWord = "";
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return longestWord;
    }

    // Метод для подсчета частоты встречаемости каждого слова в файле
    public static Map<String, Integer> countWordFrequency() {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }
}
