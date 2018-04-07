package javase07.t01;

public class Main {
    public static void main(String[] args) {
        DepositProcess deposit = new DepositProcess();
        WithdrawProcess withdraw = new WithdrawProcess();

        withdraw.start();
        deposit.start();

        try {
            withdraw.join();
            deposit.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
