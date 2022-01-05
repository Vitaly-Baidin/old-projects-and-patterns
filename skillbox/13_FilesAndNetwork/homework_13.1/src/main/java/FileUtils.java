import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long dirSize = 0;

        try {
            dirSize = Files.walk(Path.of(path))
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length)
                    .sum();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dirSize;
    }
}
