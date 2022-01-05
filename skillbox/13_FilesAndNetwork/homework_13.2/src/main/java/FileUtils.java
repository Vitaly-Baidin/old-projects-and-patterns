import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        Files.walk(Paths.get(sourceDirectory)).forEach(src -> {
            Path destination = Paths.get(destinationDirectory, src.toString().substring(sourceDirectory.length()));
            try {
                Files.copy(src, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
