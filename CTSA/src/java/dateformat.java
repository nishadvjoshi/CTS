import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
import java.nio.file.attribute.*;
 
/**
 * This Java program demonstrates how to compress a directory in ZIP format.
 *
 * @author www.codejava.net
 */
public class dateformat extends SimpleFileVisitor<Path> {
 
    private static ZipOutputStream zos;
 
    private Path sourceDir;
 
    public dateformat(Path sourceDir) {
        this.sourceDir = sourceDir;
    }
 
    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attributes) {
 
        try {
            Path targetFile = sourceDir.relativize(file);
 
            zos.putNextEntry(new ZipEntry(targetFile.toString()));
 
            byte[] bytes = Files.readAllBytes(file);
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
 
        } catch (IOException ex) {
            System.err.println(ex);
        }
 
        return FileVisitResult.CONTINUE;
    }
 
    public static void main(String[] args) {
        String dirPath = "C:\\Users\\Administrator\\Desktop\\CTSA";
        Path sourceDir = Paths.get(dirPath);
        System.out.println(sourceDir);
                
 
        try {
            String zipFileName = dirPath.concat(".zip");
            zos = new ZipOutputStream(new FileOutputStream(zipFileName));
 
            Files.walkFileTree(sourceDir, new dateformat(sourceDir));
 
            zos.close();
        } catch (IOException ex) {
            System.err.println("I/O Error: " + ex);
        }
    }
}