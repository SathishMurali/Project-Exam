import java.util.ArrayList;

public class QuestionPojo {
    private int id;
    private String question;
    private String questionTwo;
    private String correctAnswer;
    private ArrayList<ChoicePojo> answers;

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    public QuestionPojo(int id, String question, String questionTwo, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.questionTwo = questionTwo;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<ChoicePojo> getAnswers() {
        return answers;
    }
}
