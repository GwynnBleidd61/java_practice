import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File directory = new File("folder");
        File file = new File("folder/1.txt");
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {
            Scanner scanner = new Scanner(System.in);
            String s = "";
            while (true) {
                System.out.println("Enter your name: ");
                s = scanner.nextLine();
                if (Objects.equals(s.toLowerCase(), "exit")) {
                    break;
                }
                outputStream.write((s + " ").getBytes());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))){
            byte[] array = new byte[1024];
            int count = inputStream.read(array);
            StringBuilder result = new StringBuilder();
            while (count > 0) {
                result.append(new String(array, 0, count));
                count = inputStream.read(array);
            }
            System.out.println(result.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
