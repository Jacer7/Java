import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * THis is test case that does......
 */
public class MnistImageReaderTest {

	public static void main(String[] args) throws IOException {
		File file = new File("E:\\EPITA\\Java\\Assignment\\mob-programming-project\\mnist_test.csv");
		List<Image> images = ImageReader.read(file);
		images.sort(Comparator.comparingInt(Image::getLabel));
		List<Image> pictures;
		Centroid.TrainCentroids(images);
		Centroid.computeSD(images);

		Map<Integer, Integer> distributionMap = new LinkedHashMap<>();

		for (Image image : images) {
			int currentLabel = image.getLabel();
			Integer count = distributionMap.computeIfAbsent(currentLabel, label -> 0);
			distributionMap.put(currentLabel, count + 1);
		}
		System.out.println(distributionMap);


// D. Analysing the distribution of the dataset :

		for (Image image : images) {
			double[][] Jay = image.getData();
			System.out.println(Jay);

			for (int i = 0; i < 28; i++) {
				for (int j = 0; j < 28; j++) {
					System.out.println(Jay[i][j]);
				}
				System.out.println();//read out all matrix
			}


// E. Calculating the average  represent:

			float sum = 0, average;
			for (int i = 0; i < 28; i++) {
				for (int j = 0; j < 28; j++) {
					sum = (float) (sum + Jay[i][j]);
				}
			}
			average = sum / (28 * 28);
			System.out.printf("AVERAGE of the elements of the matrix = %.2f", average);

			for (int i = 0; i < 28; i++) {
				for (int j = 0; j < 28; j++) {
					System.out.println(Jay[i][j]);
					double diff = average - Jay[i][j];
					System.out.println(diff);  // F. Performing your first classification:

				}
				System.out.println();//read out all matrix

			}

			//	Third part: Evaluating the model

			double sum1 = 0.0, standardDeviation = 0.0;
			int length = Jay.length;
			for (int i = 1; i < 28 - 1; i++) {
				for (int j = 1; j < 28 - 1; j++) {
					sum1 += Jay[i][j];
				}
			}
			double mean = sum1 / length;
			for (int i = 1; i < 28 - 1; i++) {
				for (int j = 1; j < 28 - 1; j++) {
					standardDeviation += Math.pow(Jay[i][j] - mean, 2);
				}
			}
			System.out.println(Math.sqrt(standardDeviation / length));
		}
	}
}









