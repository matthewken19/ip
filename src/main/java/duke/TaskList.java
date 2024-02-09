package duke;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private ArrayList<Task> tasks;

    TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    void add(Task task) {
        tasks.add(task);
    }

    int size() {
        return tasks.size();
    }

    void remove(int index) {
        tasks.remove(index);
    }
    Task get(int index) {
        return tasks.get(index);
    }

    TaskList find(String str) {
        ArrayList<Task> foundList = new ArrayList<>();
        for (Task task: tasks) {
            if (task.contains(str)) {
                foundList.add(task);
            }
        }
        return new TaskList(foundList);
    }

    String toStore() {
        String out = "";
        for (Task task: tasks) {
            out += task.toStore() + "\n";
        }
        return out;
    }

    public String toString() {
        int index = 1;
        String out = "";
        for (Task task: tasks) {
            out += index + "." + task.toString() + "\n";
            index++;
        }
        return out;
    }
}
