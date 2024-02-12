package duke.ui;

import java.util.Scanner;

public class Ui {
    static String LINE = "_____________________________________________";

    public void open() {
        String greeting = "Hello! I'm Donald.\nWhat can I do for you?\n";
        String out = LINE + "\n" + greeting + LINE;
        System.out.println(out);
    }

    public void close() {
        String closing = "Bye. Hope to see you again soon!\n";
        String out = closing + LINE;
        System.out.println(out);
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String addMessage(String str, int taskSize) {
        return "Got it. I've added this task:\n" + str + "\nNow you have "
                + taskSize + " tasks in this list.";
    }

    public String deleteMessage(String str, int taskSize) {
        return "Noted. I've removed this task:\n" + str + "\nNow you have "
                + taskSize + " tasks in the list.";
    }

    public String markMessage(String str) {
        return "Nice! I've marked this task as done:\n" + str;
    }

    public String unmarkMessage(String str) {
        return "OK, I've marked this task as not done yet:\n" + str;
    }

    public String listMessage(String str) {
        return "Here are the tasks in your list:\n" + str;
    }

    public String findMessage(String str) {
        return "Here are the matching tasks in your list:\n" + str;
    }
}
