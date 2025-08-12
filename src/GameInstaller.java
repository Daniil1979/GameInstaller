import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameInstaller {

    private static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {

        ArrayList<String> directoryPaths = new ArrayList<>();
        ArrayList<String> filePaths = new ArrayList<>();

        directoryPaths.add("Games");
        directoryPaths.add("Games/src");
        directoryPaths.add("Games/res");
        directoryPaths.add("Games/savegames");
        directoryPaths.add("Games/temp");
        directoryPaths.add("Games/src/main");
        directoryPaths.add("Games/src/test");
        directoryPaths.add("Games/res/drawables");
        directoryPaths.add("Games/res/vectors");
        directoryPaths.add("Games/res/icons");

        filePaths.add("Games/src/main/Main.java");
        filePaths.add("Games/src/main/Utils.java");
        filePaths.add("Games/temp/temp.txt");

        createDirectories(directoryPaths);

        createFiles(filePaths);

        writeLogToFile("Games/temp/temp.txt");
    }

    private static void createDirectories(ArrayList<String> paths) {
        log.append("=== СОЗДАНИЕ ДИРЕКТОРИЙ ===\n");

        for (String path : paths) {
            File dir = new File(path);
            if (dir.exists()) {
                log.append("Директория '").append(path).append("' уже существует.\n");
            } else {
                boolean created = dir.mkdir();
                if (created) {
                    log.append("Директория '").append(path).append("' создана успешно.\n");
                } else {
                    log.append("Ошибка: Не удалось создать директорию '").append(path).append("'.\n");
                }
            }
        }
    }

    private static void createFiles(ArrayList<String> paths) {
        log.append("\n=== СОЗДАНИЕ ФАЙЛОВ ===\n");

        for (String path : paths) {
            File file = new File(path);
            if (file.exists()) {
                log.append("Файл '").append(path).append("' уже существует.\n");
            } else {
                try {
                    boolean created = file.createNewFile();
                    if (created) {
                        log.append("Файл '").append(path).append("' создан успешно.\n");
                    } else {
                        log.append("Ошибка: Не удалось создать файл '").append(path).append("'.\n");
                    }
                } catch (IOException e) {
                    log.append("Ошибка при создании файла '").append(path)
                            .append("': ").append(e.getMessage()).append("\n");
                }
            }
        }
    }

    private static void writeLogToFile(String logFilePath) {
        log.append("\n=== ЗАВЕРШЕНИЕ ===\n");
        log.append("Лог установки завершён.\n");

        try (FileWriter writer = new FileWriter(logFilePath)) {
            writer.write(log.toString());
            System.out.println("Установка завершена. Лог сохранён в: " + logFilePath);
        } catch (IOException e) {
            System.err.println("Не удалось записать лог в файл: " + e.getMessage());
            System.out.println("\n--- ЛОГ (не удалось записать в файл) ---\n" + log);
        }
    }
}
