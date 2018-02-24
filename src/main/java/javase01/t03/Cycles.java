package javase01.t03;

public class Cycles {

    public static void main(String[] args) {
        try {
            float a = Float.parseFloat(args[0]);
            float b = Float.parseFloat(args[1]);
            float h = Float.parseFloat(args[2]);

            double func;

            System.out.println("|\tx\t|\tF(x)\t|");
            for (float x = a; x < b; x += h) {
                func = Math.tan(2 * x) - 3;
                System.out.printf("| %f\t| %f\t|\n", x, func);
            }
        }
        catch(NumberFormatException e){
            System.out.println("Input three numbers");
        }
    }
}
