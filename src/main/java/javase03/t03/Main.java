package javase03.t03;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    FileController controller = FileController
            .getInstance("C:\\epam\\projects\\epampractice\\src\\main\\java\\javase03\\t03\\attachment.html");
        System.out.println("Links are consistent: " + controller.isConsistent());
        System.out.println("Links : \n" + controller.getCoincidences());
    }
}
