package duke;

import java.util.ArrayList;
import duke.task.Task;
import java.util.List;

public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    public void add(Task task) throws DukeException {
        for (Task item: tasks) {
            if (item.equals(task)) {
                throw new DukeException("\uD83D\uDC3E Oops! It seems like this item already exists in our list. " +
                        "Let's try adding something new. \uD83D\uDE3A");
            }
        }
        tasks.add(task);
    }

    public int size() {
        return tasks.size();
    }

    public void remove(int index) {
        tasks.remove(index);
    }
    public Task get(int index) {
        return tasks.get(index);
    }

    public TaskList find(String str) {
        ArrayList<Task> foundList = new ArrayList<>();
        for (Task task: tasks) {
            if (task.contains(str)) {
                foundList.add(task);
            }
        }
        return new TaskList(foundList);
    }

    public String toStore() {
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
