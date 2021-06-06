import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MnistReaderTest {


	public static final int IMAGE_HEIGHT = 28;
	public static final int IMAGE_WIDTH = 28;

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(new File("E:\\EPITA\\Java\\Assignment\\mob-programming-project\\mnist_test_sample.csv").toPath());

		//remove the header
		lines.remove(0);

		String line = lines.get(0);
		//System.out.println(line);

		String[] parts = line.split(",");
		String label = parts[0];

		System.out.println(parts.length);

		int data_line_length = parts.length - 1;
		System.out.println(Math.sqrt(data_line_length));



		//for int i = 0 to i = 27
			// for int j = 0 to j = 27
				// matrix[i][j] = parts[i * 28 + j]

		double[][] matrix = convertToMatrix(parts);
		System.out.println(displayMatrix(matrix));

		System.out.println(label);

	}

	private static double[][] convertToMatrix(String[] parts) {
		double[][] matrix = new double[IMAGE_HEIGHT][IMAGE_WIDTH];
		for (int i = 0; i < IMAGE_HEIGHT; i ++){
			for (int j = 0; j < IMAGE_WIDTH; j++){
				matrix[i][j]  = Double.parseDouble(parts[i * IMAGE_HEIGHT + j]);
			}
			System.out.println();
		}
		return matrix;
	}

	private static String displayMatrix(double[][] matrix){
		String result = "";
		for (int i = 0; i < matrix.length; i ++) {
			for (int j = 0; j < matrix[i].length; j++) {
				String display = "..";
				if (matrix[i][j] > 100){
					display = "xx";
				}
				result += display;
			}
			result += "\n";
		}
		return result;
	}

}
