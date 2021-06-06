
import java.util.List;
public class Centroid {
    public static void TrainCentroids(List<Image> images) {
        for (Image image : images) {
            double[][] Jay = image.getData();
            System.out.println(Jay);
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < 28; j++) {
                    System.out.println(Jay[i][j]);
                }
                System.out.println();//read out all matrix
            }

            float Sum = 0, Average;
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < 28; j++) {
                    Sum = (float) (Sum + Jay[i][j]);
                }
            }
            Average = Sum / (28 * 28);
            System.out.printf("average of Matrix = %.2f", Average);
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < 28; j++) {
                    System.out.println(Jay[i][j]);
                    double diff = Average - Jay[i][j];
                    System.out.println(diff);
                }
                System.out.println();
            }
        }
    }

    public static double computeSD(List<Image> images) {
        double[][] Jay = new double[0][];
        for (Image image : images) {
            Jay = image.getData();
            System.out.println(Jay);
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < 28; j++) {
                    System.out.println(Jay[i][j]);
                }
                System.out.println();//read out all matrix
            }

            float computedSum = 0, Average;
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < 28; j++) {
                    computedSum = (float) (computedSum + Jay[i][j]); // Sum
                }
            }
            Average = computedSum / (28 * 28);
            System.out.printf("Computed average of Matrix = %.2f", Average); //  Average
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < 28; j++) {
                    System.out.println(Jay[i][j]);
                    double diff = Average - Jay[i][j];
                    System.out.println(diff);  // distance between Centroids
                }
                System.out.println();// read out all matrix
            }
        }
        double sum = 0.0, standardDeviation = 0.0;
        int length = Jay.length;
        for (int i = 1; i < 28 - 1; i++) {
            for (int j = 1; j < 28 - 1; j++) {
                sum += Jay[i][j];
            }
        }
        double mean = sum / length;
        for (int i = 1; i < 28 - 1; i++) {
            for (int j = 1; j < 28 - 1; j++) {
                standardDeviation += Math.pow(Jay[i][j] - mean, 2);
            }
        }
        System.out.println(Math.sqrt(standardDeviation / length));
        return Math.sqrt(standardDeviation / length);
    }
}

//#########################################################