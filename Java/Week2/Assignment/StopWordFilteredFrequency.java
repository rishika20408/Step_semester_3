import java.util.*;

public class StopWordFilteredFrequency {

    public static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        feedback = feedback.toLowerCase();

        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {

            if (isStopWord(word, stopWords)) {
                continue;
            }

            if (frequencyMap.containsKey(word)) {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            } else {
                frequencyMap.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequencyMap.entrySet());

        entries.sort((entry1, entry2) ->
                entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static boolean isStopWord(String word, String[] stopWords) {

        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}