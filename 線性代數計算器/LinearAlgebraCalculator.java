import java.util.Scanner;

public class LinearAlgebraCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入指令 開始");
        String input = scanner.nextLine();
        while (!input.equals("開始")) {
            System.out.println("無效的指令，請重新輸入:");
            input = scanner.nextLine();
        }
        System.out.println("線性代數計算程式已啟動，請輸入您要進行的操作:");

        while (true) {
            System.out.println("1. 矩陣加法");
            System.out.println("2. 矩陣減法");
            System.out.println("3. 矩陣乘法");
            System.out.println("4. 向量加法");
            System.out.println("5. 向量減法");
            System.out.println("6. 向量乘法");
            System.out.println("7. 求反矩陣");
            System.out.println("8. 退出");

            int choice = scanner.nextInt();

            if (choice == 8) {
                System.out.println("程式已退出。");
                break;
            }

            System.out.println("請輸入矩陣或向量的大小，格式為 m n:");
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            double[][] matrix = new double[m][n];

            System.out.println("請輸入矩陣或向量的元素，以空格分隔:");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextDouble();
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("請輸入第二個矩陣或向量的大小，格式為 m n:");
                    int p1 = scanner.nextInt();
                    int q1 = scanner.nextInt();
                    double[][] matrix1 = new double[p1][q1];

                    System.out.println("請輸入第二個矩陣或向量的元素，以空格分隔:");
                    for (int i = 0; i < p1; i++) {
                        for (int j = 0; j < q1; j++) {
                            matrix1[i][j] = scanner.nextDouble();
                        }
                    }

                    double[][] result1 = addMatrix(matrix, matrix1);

                    System.out.println("兩個矩陣或向量的和為:");
                    printMatrix(result1);
                    break;

                case 2:
                    System.out.println("請輸入第二個矩陣或向量的大小，格式為 m n:");
                    int p2 = scanner.nextInt();
                    int q2 = scanner.nextInt();
                    double[][] matrix2 = new double[p2][q2];

                    System.out.println("請輸入第二個矩陣或向量的元素，以空格分隔:");
                    for (int i = 0; i < p2; i++) {
                        for (int j = 0; j < q2; j++) {
                            matrix2[i][j] = scanner.nextDouble();
                        }
                    }

                    double[][] result2 = subtractMatrix(matrix, matrix2);

                    System.out.println("兩個矩陣或向量的差為:");
                    printMatrix(result2);
                    break;

                case 3:
                    System.out.println("請輸入第二個矩陣的大小，格式為 n p:");
                    int p3 = scanner.nextInt();
                    int q3 = scanner.nextInt();
                    double[][] matrix3 = new double[p3][q3];

                    System.out.println("請輸入第二個矩陣的元素，以空格分隔:");
                    for (int i = 0; i < p3; i++) {
                        for (int j = 0; j < q3; j++) {
                            matrix3[i][j] = scanner.nextDouble();
                        }
                    }

                    double[][] result3 = multiplyMatrix(matrix, matrix3);

                    System.out.println("兩個矩陣的乘積為:");
                    printMatrix(result3);
                    break;

                case 4:
                    System.out.println("請輸入第二個向量的大小，格式為 n:");
                    int p4 = scanner.nextInt();
                    double[] vector1 = new double[p4];

                    System.out.println("請輸入第二個向量的元素，以空格分隔:");
                    for (int i = 0; i < p4; i++) {
                        vector1[i] = scanner.nextDouble();
                    }

                    double[] result4 = addVector(matrix[0], vector1);

                    System.out.println("兩個向量的和為:");
                    printVector(result4);
                    break;

                case 5:
                    System.out.println("請輸入第二個向量的大小，格式為 n:");
                    int p5 = scanner.nextInt();
                    double[] vector2 = new double[p5];

                    System.out.println("請輸入第二個向量的元素，以空格分隔:");
                    for (int i = 0; i < p5; i++) {
                        vector2[i] = scanner.nextDouble();
                    }

                    double[] result5 = subtractVector(matrix[0], vector2);

                    System.out.println("兩個向量的差為:");
                    printVector(result5);
                    break;

                case 6:
                    System.out.println("請輸入一個實數:");
                    double scalar = scanner.nextDouble();
                    double[][] result6 = scalarMultiply(matrix, scalar);
                    System.out.println("矩陣或向量與實數的積為:");
                    printMatrix(result6);
                    break;

                case 7:
                    System.out.println("請輸入矩陣或向量的大小，格式為 m n:");
                    int p7 = scanner.nextInt();
                    int q7 = scanner.nextInt();
                    double[][] matrix7 = new double[p7][q7];

                    System.out.println("請輸入矩陣或向量的元素，以空格分隔:");
                    for (int i = 0; i < p7; i++) {
                        for (int j = 0; j < q7; j++) {
                            matrix7[i][j] = scanner.nextDouble();
                        }
                    }

                    double[] result7 = multiplyMatrixByVector(matrix7, matrix[0]);

                    System.out.println("矩陣或向量與向量的乘積為:");
                    printVector(result7);
                    break;

                default:
                    System.out.println("輸入的指令不正確，請重新輸入。");
                    break;
            }

            System.out.println("\n請輸入要執行的指令:");
            System.out.println("1. 兩個矩陣或向量的和");
            System.out.println("2. 兩個矩陣或向量的差");
            System.out.println("3. 兩個矩陣的乘積");
            System.out.println("4. 兩個向量的和");
            System.out.println("5. 兩個向量的差");
            System.out.println("6. 矩陣或向量與實數的積");
            System.out.println("7. 矩陣或向量與向量的乘積");
            System.out.println("0. 結束程式。");
            int command = scanner.nextInt();
        }

        System.out.println("程式已結束。");
    }

    public static double[][] addMatrix(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("兩個矩陣大小不一致，無法計算和。");
            return null;
        }

        int p = matrix1.length;
        int q = matrix1[0].length;
        double[][] result = new double[p][q];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static double[][] subtractMatrix(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("兩個矩陣大小不一致，無法計算差。");
            return null;
        }

        int p = matrix1.length;
        int q = matrix1[0].length;
        double[][] result = new double[p][q];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            System.out.println("兩個矩陣大小不適合，無法計算乘積。");
            return null;
        }

        int p = matrix1.length;
        int q = matrix2[0].length;
        double[][] result = new double[p][q];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static double[] addVector(double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) {
            System.out.println("兩個向量大小不一致，無法計算和。");
            return null;
        }

        int n = vector1.length;
        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            result[i] = vector1[i] + vector2[i];
        }

        return result;
    }

    public static double[] subtractVector(double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) {
            System.out.println("兩個向量大小不一致，無法計算差。");
            return null;
        }

        int n = vector1.length;
        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            result[i] = vector1[i] - vector2[i];
        }

        return result;
    }

    public static double[][] scalarMultiply(double[][] matrix, double scalar) {
        int p = matrix.length;
        int q = matrix[0].length;
        double[][] result = new double[p][q];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }

        return result;
    }

    public static double[] multiplyMatrixByVector(double[][] matrix, double[] vector) {
        if (matrix[0].length != vector.length) {
            System.out.println("矩陣大小和向量大小不適合，無法計算乘積。");
            return null;
        }

        int p = matrix.length;
        double[] result = new double[p];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }

        return result;
    }

    public static void printMatrix(double[][] matrix) {
        int p = matrix.length;
        int q = matrix[0].length;

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printVector(double[] vector) {
        int n = vector.length;

        for (int i = 0; i < n; i++) {
            System.out.println(vector[i]);
        }
    }
}
