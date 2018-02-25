package javase01.t05;

public class TwoDimensionalArrays {
    public static void main(String[] args) {
        String[][] array = new String[6][7];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j && i ==3)
                    array[i][j] = "O";
                else if (i == 3)
                    array[i][j] = "M";
                else if (j == 3)
                    array[i][j] = String.valueOf('\u039B');
                else
                    array[i][j] = "0";

                switch (j) {
                    case 0:
                        array[0][j] = "1";
                        array[array.length - 1][j] = "1";
                        break;
                    case 1:
                        array[1][j] = "1";
                        array[array.length - 2][j] = "1";
                        break;
                    case 2:
                        array[2][j] = "1";
                        break;
                    case 4:
                        array[2][j] = "1";
                        break;
                    case 5:
                        array[1][j] = "1";
                        array[array.length - 2][j] = "1";
                        break;
                    case 6:
                        array[0][j] = "1";
                        array[array.length - 1][j] = "1";
                        break;
                }

            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }
}
