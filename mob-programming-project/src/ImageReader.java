import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * This will read the images
 */
public class ImageReader {

	public static final int IMAGE_HEIGHT = 28;
	public static final int IMAGE_WIDTH = 28;


	public static List<Image> read(File file) throws IOException {
		List<Image> images = new ArrayList<>();
		List<String> lines = Files.readAllLines(file.toPath());

		//remove the header
		lines.remove(0);

		for (String line : lines) {
			String[] parts = line.split(",");
			int label = Integer.parseInt(parts[0]);
			double[][] matrix = convertToMatrix(parts);
			Image image = new Image(matrix, label);
			images.add(image);
		}

		return images;
	}

	private static double[][] convertToMatrix(String[] parts) {
		double[][] matrix = new double[IMAGE_HEIGHT][IMAGE_WIDTH];
		for (int i = 0; i < IMAGE_HEIGHT; i++) {
			for (int j = 0; j < IMAGE_WIDTH; j++) {
				matrix[i][j] = Double.parseDouble(parts[i * IMAGE_HEIGHT + j]);
			}
			System.out.println();
		}
		return matrix;
	}

}
