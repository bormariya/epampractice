package javase07.t01;

import javase04.t03.MyFileReader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DepositProcess extends Thread {
    public void run() {
        try {
            MyFileReader reader = MyFileReader.create("src\\main\\java\\javase07\\t01\\info.txt");
            String text = reader.getContent();

            Pattern p = Pattern.compile("(\\d*[_]\\d*)\\s*FROM\\s*(\\d*)\\s*TO\\s*(\\d*)");
            Matcher m = p.matcher(text);

            while (m.find()) {
                Double money = Double.parseDouble(m.group(1).replaceAll("_", ""));
                Account accTo = new Account(Long.parseLong(m.group(3)));

                accTo.put(money);
                System.out.printf("Put %.2fcu into № %d\n", money, accTo.getNumber());
                System.out.printf("Balance of № %d = %.2fcu\n", accTo.getNumber(), accTo.getMoney());

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
