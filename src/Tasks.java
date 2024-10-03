package lab03;

/**
 * Lab 03: Tasks
 *
 * @author Andriy Fedoruk
 */
public class Tasks {

    /**
     * Entry point. Tests all task methods with different arguments.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // Testing Task 1
        System.out.println("Task 1: Sum of the series");
        printResultsTask1(1, 1, 5);
        printResultsTask1(1, 4, 30);
        printResultsTask1(2, 2, 31); // invalid k
        printResultsTask1(3, 3, 0); // invalid k
        printResultsTask1(1, -1, 10); // invalid b

        System.out.println("\nTask 2: Function calculation");
        // Testing Task 2
        printResultsTask2(1, 1);
        printResultsTask2(2, 1);
        printResultsTask2(1, 3);
        printResultsTask2(1, 5);
        printResultsTask2(-1, 1); // invalid t
        printResultsTask2(0, 3);

        System.out.println("\nTask 3: Sum of the series");
        // Testing Task 3
        printResultsTask3(0.01);
        printResultsTask3(0.001);
        printResultsTask3(0); // invalid epsilon
        printResultsTask3(-0.01); // invalid epsilon
    }

    // Task 1 methods
    public static double calculateSum(double a, double b, int k) {
        if (k > 30 || k <= 0 || b < 0) {
            throw new IllegalArgumentException("Invalid parameters: k = " + k + ", b = " + b);
        }

        double sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(a * i * Math.sqrt(b / i));
        }
        return sum;
    }

    static void printResultsTask1(double a, double b, int k) {
        System.out.print("a: " + a + " b: " + b + " k: " + k + " result: ");
        try {
            System.out.println(calculateSum(a, b, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }

    // Task 2 methods
    public static double x(double t, int i) {
        if (t <= 0) {
            throw new IllegalArgumentException("Invalid t: t must be greater than 0");
        }

        if (i == 1 || i == 2) {
            return Math.log(t);
        } else if (i > 2) {
            double sum = 0;
            for (int k = 1; k <= i; k++) {
                sum += Math.sin(t) / k;
            }
            return sum;
        }
        return 0;
    }

    static void printResultsTask2(double t, int i) {
        System.out.print("t: " + t + " i: " + i + " result: ");
        try {
            System.out.println(x(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }

    // Task 3 methods
    public static double calculateSeriesSum(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Invalid epsilon: must be greater than 0");
        }

        double sum = 0;
        double term;
        int i = 1;

        do {
            term = Math.pow(-1, i + 1) / (i * (i + 1) * (i + 2));
            sum += term;
            i++;
        } while (Math.abs(term) >= epsilon);

        return sum;
    }

    static void printResultsTask3(double epsilon) {
        System.out.print("epsilon: " + epsilon + " result: ");
        try {
            System.out.println(calculateSeriesSum(epsilon));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}

