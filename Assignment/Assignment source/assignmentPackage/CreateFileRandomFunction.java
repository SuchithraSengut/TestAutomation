package assignmentPackage;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class CreateFileRandomFunction {

	int lines = 1;
	static int page = 0;

	@SuppressWarnings("removal")
	public static void main(String[] args) {

		// int int_random = rand.nextInt(upperbound);
		float leftLimit = 1000F;
		float rightLimit = 10000F;
		float generatedFloat;
		// = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
		int numberOfWords = 50;
		String[] randomStrings = new String[numberOfWords];
		Random random = new Random();
		for (int i = 0; i < numberOfWords; i++) {
			char[] word = new char[random.nextInt(8) + 3];
			for (int j = 0; j < word.length; j++) {
				word[j] = (char) ('a' + random.nextInt(26));
			}
			// System.out.println("Random word is " + word);
			randomStrings[i] = new String(word);
		}

		try {
//			File output = new File("Test File Finance.txt");
//			 System.out.println("Writing to: "+output.getAbsolutePath());
//			    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
//			

			FileOutputStream outputStream = new FileOutputStream(
					"C:\\Users\\hariharan\\eclipse-workspace\\Assignment\\Assignment source\\Test File Finance.txt");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

			for (int lines = 1; lines <= 725;) {
				do {

					for (int i = 0; i < 80; i++) {
						bufferedWriter.write("=");
					}
					bufferedWriter.write("\r\n");
					lines = lines + 1;

					for (int i = 0; i < 65; i++)
						bufferedWriter.write("*");
					bufferedWriter.write("Sample Company");
					bufferedWriter.write("\r\n");
					lines = lines + 1;

					for (int k = 0; k < 25; k++) {

						if (k == 3) {
							bufferedWriter.write("testing");
						}
						for (int j = 0; j < 10; j++) {

							bufferedWriter.write(randomStrings[j]);
							bufferedWriter.write("  ");
						}
						bufferedWriter.write("\r\n");
						lines = lines + 1;

						for (int j = 0; j < 10; j++) {

							generatedFloat = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
							bufferedWriter.write("$");
							bufferedWriter
									.write(new Float(leftLimit + new Random().nextFloat() * (rightLimit - leftLimit))
											.toString());
							bufferedWriter.write("  ");
						}
						bufferedWriter.write("\r\n");
						lines = lines + 1;
					}
				} while (lines % 55 == 0);
				{

					page = page + 1;
					for (int i = 0; i < 64; i++) {
						bufferedWriter.write("-");
					}
					bufferedWriter.write("\r\n");
					lines = lines + 1;

					bufferedWriter.write(StringUtils.center("Page Number" + page, 30));
					bufferedWriter.write("\r\n");
					bufferedWriter.write(StringUtils.left("Sample Company", 30));
					bufferedWriter.write("\r\n");
					lines = lines + 2;

				}
			}

			bufferedWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		String s = "finance";
		String s2 = "Finance";
		Path path = Paths.get("C:\\Users\\hariharan\\eclipse-workspace\\Assignment\\Assignment source",
				"Test File Finance.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
			writer.write(s);
			writer.write("\n");
			writer.write(s2);
			writer.write("\n");
			writer.write(s2);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
