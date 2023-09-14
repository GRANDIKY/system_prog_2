import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int min37 = 10001;
        int max73 = 0;

        int quantity = 0;
        int minSum = 0;

        int[] numbers = new int[1000];

        try (BufferedReader reader = new BufferedReader(new FileReader("17-342.txt"))) {
            int number;
            for (int i = 0; i < 1000; i++) {
                number = Integer.parseInt(reader.readLine());
                numbers[i] = number;

                if ((number % 37 == 0) && (number < min37)) {
                    min37 = number;
                }
                if ((number % 73 == 0) && (number > max73)) {
                    max73 = number;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < 1000; i++) {
            if (min37 < numbers[i] || numbers[i] < max73) {
                if (i - 1 >= 0 && !(min37 < numbers[i - 1] || numbers[i - 1] < max73)) {
                    quantity++;
                    int sum = numbers[i] + numbers[i - 1];
                    if (sum < minSum) {
                        minSum = sum;
                    }
                }
                if (i + 1 < 1000 && !(min37 < numbers[i + 1] || numbers[i + 1] < max73)) {
                    quantity++;
                    int sum = numbers[i] + numbers[i + 1];
                    if (sum < minSum) {
                        minSum = sum;
                    }
                }
            }
        }
        System.out.println(minSum);
        System.out.println(quantity);
    }
}