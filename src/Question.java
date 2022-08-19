import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


class QueAns {

    QueAns() throws IOException {
        System.out.println();
    }

    FileWriter an = new FileWriter(Interface.path, true);
    Scanner sc = new Scanner(System.in);
    long ques = Files.lines(Paths.get("D:\\Project-Exam\\src\\qa\\questions.txt")).count();
    long cout = Files.lines(Paths.get("D:\\Project-Exam\\src\\qa\\answers.txt")).count();
    int total = 0;
    ArrayList<QuestionPojo> questionPojos = new ArrayList<>();
    ArrayList<ChoicePojo> choicePojos = new ArrayList<>();


    void loop() throws IOException {
        for (int n = 0, y = 0; n <= ques && y <= cout - 1; n += 2, y++) {
            String answerLines = Files.readAllLines(Paths.get("D:\\Project-Exam\\src\\qa\\answers.txt")).get(y);
            String questionLineOne = Files.readAllLines(Paths.get("D:\\Project-Exam\\src\\qa\\questions.txt")).get(n);
            n = n + 1;
            String questionLineTwo = Files.readAllLines(Paths.get("D:\\Project-Exam\\src\\qa\\questions.txt")).get(n);
            questionPojos.add(new QuestionPojo(y + 1, questionLineOne, questionLineTwo, answerLines));
        }
    }
}

class Question extends QueAns {
    Question() throws IOException {
        System.out.println();
    }

    public static void main() throws IOException {
        Question q = new Question();
        q.loop();
        FileWriter a = q.an;

        q.an.write("Exam Starting Time: " + LocalTime.now());
        q.an.write("\nYour Answers:\t\tCorrect Answers:\n");

//        List<String> fl = Files.readAllLines(Paths.get("D:\\Project-Exam\\src\\qa\\questions.txt"));
        q.questionPojos.forEach((display) -> {
            System.out.println(display.getId() + "." + display.getQuestion() + "\n" + display.getQuestionTwo() + display.getCorrectAnswer());
            String ans = q.sc.nextLine();
            try {
                a.write("\t" + ans + "\t\t\t\t\t\t" + display.getCorrectAnswer() + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            q.choicePojos.add(new ChoicePojo(0, ans));
            if (ans.equals(display.getCorrectAnswer())){
                q.total = q.total + 1;
            }
        });
        q.an.write("Total Score: " + q.total + "/" + q.cout);
        System.out.println("========================================\nThank you for taking the Exam!\nYour answers are stored!\nYour Total Score is:" + q.total + "/" + q.cout + "\n========================================");
        q.an.close();
    }
}