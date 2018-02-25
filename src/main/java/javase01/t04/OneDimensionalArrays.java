package javase01.t04;

public class OneDimensionalArrays {
    public static void main(String[] args) {
        try {
            double[] array = new double[args.length - 1];
            for (int i = 0; i < args.length - 1; i++) {
                array[i] = Double.parseDouble(args[i]) + Double.parseDouble(args[i + 1]);
            }

            double max = array[0];
            System.out.print("Sequence: ");
            for (Double element : array) {
                if (element > max)
                    max = element;
                System.out.print(element + " ");
            }

            System.out.printf("\nMaximal element is %.2f", max);
        }
        catch(NumberFormatException | NegativeArraySizeException e){
            System.out.print("Input a number sequence!");
        }
    }
}