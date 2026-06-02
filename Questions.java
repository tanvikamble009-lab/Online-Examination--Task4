public class Questions {

    private String questionText;
    private String[] options;
    private int correctOption;

    public Questions(String questionText,
                     String[] options,
                     int correctOption) {

        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void display() {

        System.out.println(questionText);

        for (int i = 0; i < options.length; i++) {

            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int answer) {

        return answer == correctOption;
    }
}
