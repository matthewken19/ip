package duke;

public class DeleteCommand implements Command {
    int index;

    DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Delete the task in TaskList and display the UI message.
     *
     * @param tasks the TaskList for which the task is in
     * @param ui the UI that will be used to display the message
     * @throws DukeException if index is greater than the amount of Task in the TaskList
     */
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        if (index + 1 > tasks.size()) {
            throw new DukeException("You only have " + tasks.size() + " tasks in the list.");
        }
        Task task = tasks.get(index);
        tasks.remove(index);
        ui.deleteMessage(task.toString(), tasks.size());
    }

    public boolean isExit() {
        return false;
    }
}
