import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstaller {
    public static void main(String[] args) {

        File gamesDir = new File("Games");
        File srcDir = new File("Games", "src");
        File resDir = new File("Games", "res");
        File savegamesDir = new File("Games", "savegames");
        File tempDir = new File("Games", "temp");

        File mainDir = new File(srcDir, "main");
        File testDir = new File(srcDir, "test");

        File mainJava = new File(mainDir, "Main.java");
        File utilsJava = new File(mainDir, "Utils.java");

        File drawablesDir = new File(resDir, "drawables");
        File vectorsDir = new File(resDir, "vectors");
        File iconsDir = new File(resDir, "icons");

        File tempFile = new File(tempDir, "temp.txt");

        StringBuilder log = new StringBuilder();

        log.append("=== УСТАНОВКА ИГРЫ ===\n");

        if (gamesDir.mkdir()) {
            log.append("Директория Games создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию Games.\n");
        }

        if (srcDir.mkdir()) {
            log.append("Директория src создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию src.\n");
        }

        if (resDir.mkdir()) {
            log.append("Директория res создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию res.\n");
        }

        if (savegamesDir.mkdir()) {
            log.append("Директория savegames создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию savegames.\n");
        }

        if (tempDir.mkdir()) {
            log.append("Директория temp создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию temp.\n");
        }


        if (mainDir.mkdir()) {
            log.append("Директория src/main создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию src/main.\n");
        }

        if (testDir.mkdir()) {
            log.append("Директория src/test создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию src/test.\n");
        }


        if (drawablesDir.mkdir()) {
            log.append("Директория res/drawables создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию res/drawables.\n");
        }

        if (vectorsDir.mkdir()) {
            log.append("Директория res/vectors создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию res/vectors.\n");
        }

        if (iconsDir.mkdir()) {
            log.append("Директория res/icons создана успешно.\n");
        } else {
            log.append("Ошибка: Не удалось создать директорию res/icons.\n");
        }


        try {
            if (mainJava.createNewFile()) {
                log.append("Файл Main.java создан успешно.\n");
            } else {
                log.append("Файл Main.java уже существует.\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании Main.java: ").append(e.getMessage()).append("\n");
        }

        try {
            if (utilsJava.createNewFile()) {
                log.append("Файл Utils.java создан успешно.\n");
            } else {
                log.append("Файл Utils.java уже существует.\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании Utils.java: ").append(e.getMessage()).append("\n");
        }

        try {
            if (tempFile.createNewFile()) {
                log.append("Файл temp.txt создан успешно.\n");
            } else {
                log.append("Файл temp.txt уже существует.\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании temp.txt: ").append(e.getMessage()).append("\n");
        }


        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(log.toString());
            System.out.println("Установка завершена. Лог записан в Games/temp/temp.txt");
        } catch (IOException e) {
            System.err.println("Не удалось записать лог в temp.txt: " + e.getMessage());
        }

        
        System.out.println("\n--- ЛОГ УСТАНОВКИ ---\n" + log);
    }
}