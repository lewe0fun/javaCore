import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        backup("./testFolder", "./Backup");
    }

    public static void backup(String source, String target) {
        Path pathSource = Paths.get(source);
        List<Path> paths;
        try {
            Stream<Path> walkStream = Files.walk(pathSource, 1);
            paths = walkStream.filter(Files::isRegularFile).collect(Collectors.toList());
            walkStream.close();
            for (Path p : paths) {
                System.out.print(p + " -> "+Paths.get(target + "/" + p.getFileName())+"\n");
                Files.copy(p, Paths.get(target+"/" + p.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
