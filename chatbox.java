import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class SimpleChatbot {

    private static final Map<String, String> responses = new HashMap<>();

    static {
        responses.put("hello", "Hi there! How can I help you?");
        responses.put("how are you", "I'm just a bot, but I'm doing great! How can I assist you?");
        responses.put("bye", "Goodbye! Have a nice day!");
        responses.put("what is your name", "I'm a simple chatbot. I don't have a name.");
        responses.put("default", "Sorry, I didn't understand that.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple Chatbot is ready! Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("exit")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            }

            String response = getResponse(userInput);
            System.out.println("Chatbot: " + response);
        }

        scanner.close();
    }

    private static String getResponse(String userInput) {
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            if (userInput.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return responses.get("default");
    }
}

