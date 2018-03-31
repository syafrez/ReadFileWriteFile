import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWriteStringFromFile {

	public static void main(String[] args) {
		try {
			File read = new File("source.txt");
			FileReader fileReader = new FileReader(read);
			StringBuffer stringBuffer = new StringBuffer();
			int numCharsRead;
			char[] charArray = new char[1024];
			while ((numCharsRead = fileReader.read(charArray)) > 0) {
				stringBuffer.append(charArray, 0, numCharsRead);
			}
			fileReader.close();
			System.out.println(stringBuffer.toString());
			
			File write = new File("output.bin");
			FileWriter fileWriter = new FileWriter(write);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(stringBuffer.toString());
			fileWriter.flush();
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}