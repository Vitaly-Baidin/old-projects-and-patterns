import java.io.File;

public class Main {

    private static final int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "../srcImg";
        String dstFolder = "../dstImg";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        int cores = Runtime.getRuntime().availableProcessors();
        int threadsInCore = files.length / cores;
        int srcPos = 0;
        int countAddFiles = files.length % cores;

        long start = System.currentTimeMillis();

        if (cores >= files.length) {
            cores = files.length;
            threadsInCore = 1;
        }

        for (int i = 0; i < cores; i++) {
            File[] filesForThread;

            if (countAddFiles > 0) {
                filesForThread = new File[threadsInCore + 1];
                System.arraycopy(files, srcPos, filesForThread, 0, filesForThread.length);
                srcPos = srcPos + threadsInCore + 1;
                countAddFiles--;
            } else {
                filesForThread = new File[threadsInCore];
                System.arraycopy(files, srcPos, filesForThread, 0, filesForThread.length);
                srcPos = srcPos + threadsInCore;
            }

            ImageResizer resizer = new ImageResizer(filesForThread, newWidth, dstFolder, start);
            new Thread(resizer).start();

        }
    }
}
