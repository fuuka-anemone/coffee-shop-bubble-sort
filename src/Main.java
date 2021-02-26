import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {

    public static double[] array;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static DecimalFormat df2 = new DecimalFormat("#.0#");

    public static void main(String[] args) throws IOException {
        df2.setRoundingMode(RoundingMode.DOWN);
        int count = Integer.parseInt(br.readLine());
        while (count != 0) {
            String line = br.readLine();
            String[] data = line.split(" ");
            array = new double[data.length];
            for (int i = 0; i < data.length; i++) {
                array[i] = Double.parseDouble(data[i]);
            }
            printSortedArray(bubbleSort(array));
            count--;
        }
        br.close();
        bw.close();
    }

    public static double bubbleSort(double[] arrayTest) {
        double swapCount = 0;
        double roundCount = 0;
        for (int j = 1; j < arrayTest.length; j++) {
            roundCount = j;
            for (int i = 0; i < arrayTest.length - j; i++) {
                if (arrayTest[i] > arrayTest[i + 1]) {
                    swapCount++;
                    double temp = arrayTest[i];
                    arrayTest[i] = arrayTest[i + 1];
                    arrayTest[i + 1] = temp;
                }
            }
        }
        return (swapCount / roundCount);
    }

    public static void printSortedArray(double prom) throws IOException {
        bw.write(df2.format(prom).replace(",",".") + "-"+ Arrays.toString(array).
                replace("[", "").
                replace("]", "").
                replace(",","") + "\n");
    }
}