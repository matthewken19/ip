import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;


class Storage {
    private File file;

    Storage(String filePath) {
        this.file = new File(filePath);
    }

    Storage(File file) {
        this.file = file;
    }

    ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        // If file doesn't exist, create the parent directories and the file
        if (!file.exists()) {
            try {
                // Create parent directories
                file.getParentFile().mkdirs();
                // Create file
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.\n" +
                        "Program will run without saved file.");
                return tasks;
            }
        }
        try {
            Scanner sc = new Scanner(file);
            String lineRead;
            while (sc.hasNext()) {
                lineRead = sc.nextLine();
                tasks.add(Parser.parseToTask(lineRead, "\\|"));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred while opening the file\n" +
                    "Program will run without saved file.");
            return tasks;
        } catch (DukeException ex) {
            System.out.println("An error occurred while reading the file.\n" +
                    "File may contain corrupted data!\n" +
                    "Program will run without saved file.");
            return tasks;
        }
        return tasks;
    }

    void save(TaskList tasks) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(tasks.toStore());
            fw.close();
        } catch (IOException ex) {
            System.out.println("Failed tot save progress!");
        }
    }
}
