package javase01.t02;

public class Sequence {

    public static void main(String[] args) {
        try {
            float eps = Float.parseFloat(args[0].replace(",","."));

            double a;
            int i = 0;
            StringBuilder seq = new StringBuilder();

            do {
                i++;
                a = 1/Math.pow(i+1,2);
                seq.append(a).append(" ");
            }while (a > eps);

            System.out.printf("Minimal number of the sequence = %d\n", i);
            System.out.printf("The sequence: %s", seq.toString().trim());
        }
        catch(NumberFormatException e){
            System.out.println("Input one number of format \"1.23456\"");
        }

    }
}
