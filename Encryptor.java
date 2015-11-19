import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encryptor {
	public static void Encrypt(String filename, int offset, String encryptedFilename) {
		BufferedReader br = null;

		try {
			int charAsInteger = -1;
			br = new BufferedReader(new FileReader(filename));
			
			StringBuilder builder = new StringBuilder();
			while ((charAsInteger = br.read()) != -1) {
				builder.append((char)((charAsInteger + offset + 128) % 128));
			}
			
			writeToFile(encryptedFilename, builder.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
		
	private static void writeToFile(String filename, String content) {
		BufferedWriter writer = null;
        try {
            File logFile = new File(filename);
            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}
