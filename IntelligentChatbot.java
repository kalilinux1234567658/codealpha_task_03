import java.util.*;

public class IntelligentChatbot {

    private static Map<String, String> knowledgeBase = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    // Initialize with some basic patterns and responses
    static {
        knowledgeBase.put("hello", "Hello! How can I assist you today?");
        knowledgeBase.put("hi", "Hi there! What can I do for you?");
        knowledgeBase.put("how are you", "I'm just a bunch of code, but thanks for asking!");
        knowledgeBase.put("what is your name", "I am an intelligent Java chatbot.");
        knowledgeBase.put("help", "Sure! You can ask me about the weather, time, or just chat!");
        knowledgeBase.put("weather", "I don't have real weather data, but it's always sunny in the digital world!");
        knowledgeBase.put("time", "I don't have a clock, but it's always now!");
        knowledgeBase.put("bye", "Goodbye! Have a great day!");
    }

    public static void main(String[] args) {
        System.out.println("Intelligent Java Chatbot - type 'exit' to quit.");
        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().toLowerCase().trim();
            if (input.equals("exit")) {
                System.out.println("Chatbot: Goodbye! Talk to you later.");
                break;
            }
            String response = generateResponse(input);
            System.out.println("Chatbot: " + response);
            // Optional learning if chatbot doesn't understand
            if (response.equals("I am not sure how to respond to that. Can you teach me? (yes/no)")) {
                handleLearning(input);
            }
        }
    }

    private static String generateResponse(String input) {
        // Basic preprocessing: remove punctuation for matching
        String cleanInput = input.replaceAll("[^a-zA-Z0-9\\s]", "");
        for (String key : knowledgeBase.keySet()) {
            if (cleanInput.contains(key)) {
                return knowledgeBase.get(key);
            }
        }
        return "I am not sure how to respond to that. Can you teach me? (yes/no)";
    }

    private static void handleLearning(String input) {
        System.out.print("You: ");
        String answer = scanner.nextLine().toLowerCase().trim();
        if (answer.equals("yes")) {
            System.out.print("Please provide the response I should give: ");
            String newResponse = scanner.nextLine();
            knowledgeBase.put(input, newResponse);
            System.out.println("Chatbot: Thank you! I have learned something new.");
        } else {
            System.out.println("Chatbot: No worries! Let's continue.");
        }
    }
}
