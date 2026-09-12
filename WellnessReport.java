import java.util.Random;

public class WellnessReport {

    public static void main(String[] args) {
        int n = 10;
        Random rand = new Random();

        double[] heights = new double[n];
        double[] weights = new double[n];

        for (int i = 0; i < n; i++) {
            heights[i] = 1.5 + rand.nextDouble() * 0.5;
            weights[i] = 50 + rand.nextDouble() * 50;
        }

        printWellnessReport(heights, weights);
    }

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%d | %.2f | %.2f | %.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }
}