import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = List.of(
                new Question(
                        "What is the capital of France?",
                        new String[] { "Berlin", "Madrid", "Paris", "Rome" },
                        3),
                new Question(
                        "Which language runs in a web browser?",
                        new String[] { "Java", "C", "Python", "JavaScript" },
                        4));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        System.out.println("Welcome to the Quiz!");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.getPrompt());
            String[] opts = q.getOptions();
            for (int j = 0; j < opts.length; j++) {
                System.out.println((j + 1) + ". " + opts[j]);
            }
            System.out.print("Your answer: ");
            int ans = scanner.nextInt();

            if (ans == q.getCorrectOption()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + opts[q.getCorrectOption() - 1]);
            }
        }

        System.out.println("\nQuiz finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}