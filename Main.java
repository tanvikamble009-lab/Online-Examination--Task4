import java.util.*;

public class Main {

    static boolean timeUp = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Candidate user = new Candidate("Tanmay", "1234");

        System.out.print("Enter username: ");
        String u = sc.nextLine();

        System.out.print("Enter password: ");
        String p = sc.nextLine();

        if (user.login(u, p)) {

            System.out.println("Login successful.");

            System.out.print("Do you want to update profile? (yes/no): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("yes")) {

                System.out.print("Enter new username: ");
                String newU = sc.nextLine();

                System.out.print("Enter new password: ");
                String newP = sc.nextLine();

                user.updateProfile(newU, newP);
            }

            System.out.println("\nSelect an option:");
            System.out.println("1. Start Exam");
            System.out.println("2. Logout");

            int option = sc.nextInt();

            if (option == 1) {
                startExam(sc);
            } else {
                System.out.println("Logged out.");
            }

        } else {
            System.out.println("Invalid credentials.");
        }

        sc.close();
    }

    public static void startExam(Scanner sc) {

        Questions[] questions = {

            new Questions(
                    "Java is:",
                    new String[]{"Procedural", "Object-Oriented", "Functional", "None"},
                    2
            ),

            new Questions(
                    "Which loop is exit-controlled?",
                    new String[]{"for", "while", "do-while", "foreach"},
                    3
            ),

            new Questions(
                    "Which one is not a Java keyword?",
                    new String[]{"static", "Integer", "new", "void"},
                    2
            )
        };

        int score = 0;
        int[] answers = new int[questions.length];

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("\nTime's up! Auto-submitting your exam...");
            }
        }, 10000);

        for (int i = 0; i < questions.length; i++) {

            if (timeUp) {
                break;
            }

            System.out.println("\nQ" + (i + 1) + ":");

            questions[i].display();

            System.out.print("Your answer (1-4): ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Please enter a number (1-4): ");
            }

            answers[i] = sc.nextInt();
        }

        timer.cancel();

        for (int i = 0; i < questions.length; i++) {

            if (answers[i] == 0) {
                continue;
            }

            if (questions[i].isCorrect(answers[i])) {
                score++;
            }
        }

        System.out.println("\nExam completed!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }
}
