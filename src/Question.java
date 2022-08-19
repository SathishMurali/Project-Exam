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
    long ques = Files.lines(Paths.get("D:\\JAVA FSD\\Project-Exam\\src\\qa\\questions.txt")).count();
    long cout = Files.lines(Paths.get("D:\\JAVA FSD\\Project-Exam\\src\\qa\\answers.txt")).count();
    int total = 0;
    ArrayList<String> arr = new ArrayList<>();
}

class Question extends QueAns {
    Question() throws IOException {
        System.out.println();
    }

    public static void main() throws IOException {
        Question q = new Question();

        q.an.write("Exam Starting Time: " + LocalTime.now());
        q.an.write("\nYour Answers:\t\tCorrect Answers:\n");

        ArrayList<QuestionPojo> questionPojos = new ArrayList<>();

        for (int n = 0, y = 0; n <= q.ques && y <= q.cout - 1; n += 2, y++) {
            System.out.println(Files.readAllLines(Paths.get("D:\\JAVA FSD\\Project-Exam\\src\\qa\\answers.txt")).get(y));
            System.out.println(Files.readAllLines(Paths.get("D:\\JAVA FSD\\Project-Exam\\src\\qa\\questions.txt")).get(n));
            n = n + 1;
            System.out.println(Files.readAllLines(Paths.get("D:\\JAVA FSD\\Project-Exam\\src\\qa\\questions.txt")).get(n));
            String ans = q.sc.nextLine();
            for (String st: q.arr){
                q.an.write("\t" + ans + "\t\t\t\t\t\t" + st + "\n");
                if (ans.equals(st)) {
                    q.total = q.total + 1;
                }
            }
            q.arr.clear();
        }
        q.an.write("Total Score: " + q.total + "/" + q.cout);
        System.out.println("========================================\nThank you for taking the Exam!\nYour answers are stored!\nYour Total Score is:" + q.total + "/" + q.cout + "\n========================================");
        q.an.close();
    }
}