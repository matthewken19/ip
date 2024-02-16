package duke.command;

import duke.DukeException;
import duke.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;
public class FindCommand implements Command {
    private String keyword;

    /**
     * Initializes a new FindCommand to find tasks based on the keyword.
     *
     * @param keyword the String keyword of the task description to find
     */
    public FindCommand(String  keyword) {
        this.keyword = keyword;
    }

    /**
     * Find tasks in the TaskList based on the keyword and returns the UI string message.
     *
     * @param tasks the TaskList for which the task is in
     * @param ui the UI that will be used to display the message
     * @return a String of the UI message and a list of tasks that are found matching with the
     * keyword in the TaskList
     */
    public String execute(TaskList tasks, Ui ui) {
        TaskList foundList = tasks.find(keyword);
        return ui.findMessage(foundList.toString());
    }

    public boolean isExit() {
        return false;
    }
}
