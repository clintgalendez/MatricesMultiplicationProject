import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] arrA;
    static int[][] arrB;
    static int numOfArrays = 0;
    public static void main(String[] args) {
        //Get input
        while (true) {
            arrA = initializeArray();
            arrB = initializeArray();

            if (arrA[0].length != arrB.length) {
                clear();
                System.out.println("Error: The number of columns in the first matrix must be equal to the number of rows in the second matrix!");
                System.out.println("Please try again.");
                numOfArrays = 0;
            } else {
                break;
            }
        }
        //Show Output
        printProductMatrix(getProductMatrix(arrA, arrB));
    }
    public static int[][] initializeArray() {
        numOfArrays++;
        int rows;
        int cols;

        Scanner inputSC = new Scanner(System.in);
        System.out.print("Enter dimensions of Matrix #" + numOfArrays + ": ");
        if(inputSC.hasNextInt()) {
            rows = inputSC.nextInt();
            cols = inputSC.nextInt();
        } else {
            clear();
            System.out.println("Error: Please enter two integers!");
            System.out.println("Please try again.");
            numOfArrays--;
            return initializeArray();
        }

        //Initialize array
        int[][] curArr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter elements of row " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                curArr[i][j] = inputSC.nextInt();
            }
        }
        return curArr;
    }

    public static void clear(){
        //Clears Console in java
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error: Cannot Clear Console (Please Ignore)");
            System.out.println();
        }
    }

    public static int[][] getProductMatrix(int[][] a, int[][] b) {
        int[][] productMatrix = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    productMatrix[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return productMatrix;
    }

    public static void printProductMatrix(int[][] arrAnswer) {
        System.out.println("The product of the two matrices is: ");
        for (int[] ints : arrAnswer) {
            for (int j = 0; j < arrAnswer[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}

