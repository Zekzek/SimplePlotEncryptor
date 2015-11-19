
public class Starter {
	public static void main(String[] args) {
		Encryptor.Encrypt("Plot.txt", 1, "Encrypted_Plot.txt");
		Encryptor.Encrypt("Encrypted_Plot.txt", -1, "Plot.txt");
	}
}
