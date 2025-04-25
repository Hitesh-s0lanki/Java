public class Question {
    private String prompt;
    private String[] options;
    private int correctOption;

    public Question(String prompt, String[] options, int correctOption) {
        this.prompt = prompt;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getPrompt() {
        return prompt;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}