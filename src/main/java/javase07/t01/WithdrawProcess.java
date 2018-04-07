package javase07.t01;

import javase04.t03.MyFileReader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WithdrawProcess extends Thread{
    @Override
    public void run() {
        try {
            MyFileReader reader = MyFileReader.create("src\\main\\java\\javase07\\t01\\info.txt");
            String text = reader.getContent();

            Pattern p = Pattern.compile("(\\d*[_]\\d*)\\s*FROM\\s*(\\d*)\\s*TO\\s*(\\d*)");
            Matcher m = p.matcher(text);

            while (m.find()) {
                Double money = Double.parseDouble(m.group(1).replaceAll("_", ""));
                Account accFrom = new Account(Long.parseLong(m.group(2)));

                accFrom.withdraw(money);
                System.out.printf("Withdraw %.2fcu from № %d\n", money, accFrom.getNumber());
                System.out.printf("Balance of № %d = %.2fcu\n", accFrom.getNumber(), accFrom.getMoney());

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
