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
		}
	}
}

//	Third part: Evaluating the model







