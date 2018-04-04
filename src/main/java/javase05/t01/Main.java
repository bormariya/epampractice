package javase05.t01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilesProcessing filesProcessing = FilesProcessing.create();
        System.out.println(filesProcessing.getContent("C:\\"));
        System.out.println("Choose a file or a directory. Input a number of the list. \nFor exit input 'q'");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {//первый ввод команды
            if (scan.hasNextInt()) {
                int number = scan.nextInt();
                if (number >= 1 && number <= filesProcessing.maxListValue()) {//если число в диапазоне
                    if (filesProcessing.getFiles().get(number).isDirectory())//если папка
                        System.out.println(filesProcessing.getContent(number));
                    else//если файл
                        if (filesProcessing.getFiles().get(number).getName()//если .txt
                                .substring(filesProcessing.getFiles().get(number).getName().lastIndexOf("."),
                                        filesProcessing.getFiles().get(number).getName().length()).equals(".txt")) {
                            System.out.println("\"open\" - Open the directory\n"
                                    + "\"del\" - Delete the directory\n"
                                    + "\"write\" - Write data to end of the file\n"
                                    + "\"rewrite\" - Write new data to the file");
                            if (scan.hasNext()) {
                                String command = scan.next();
                                if (command.equals("open"))
                                    System.out.println(filesProcessing.getContent(number));
                                else if (command.equals("del"))
                                    filesProcessing.deleteFile(number);
                                else if (command.equals("write"))
                                    //TODO ввод нового текста в файл
                                    filesProcessing.writeData("C:\\D\\try.txt", "NEW DATA", false);
                                else if (command.equals("rewrite"))
                                    //TODO ввод нового текста в файл
                                    filesProcessing.writeData("C:\\D\\try.txt", "NEW DATA", true);
                                else
                                    System.out.println("Input one of the suggested commands!");
                            }

                        } else//если НЕ .txt
                            System.out.println("Format file should be like '*.txt'.");
                } else//если число НЕ в диапазоне
                    System.out.println("Input a number of the list!!! \n For exit input 'q'");
            }
        }
    }

}