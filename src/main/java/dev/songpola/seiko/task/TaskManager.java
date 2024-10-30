package dev.songpola.seiko.task;

import dev.songpola.seiko.task.view.TaskInputPanel;
import dev.songpola.seiko.task.view.TaskListPanel;

import javax.swing.*;
import java.awt.*;

public class TaskManager extends JPanel {
    private TaskListPanel taskListPanel;

    public TaskManager() {
        super(new BorderLayout());
        addTaskList();
        addTaskInput();
        // TODO: load tasks from file
        // TODO: save tasks to file
    }

    private void addTaskList() {
        taskListPanel = new TaskListPanel();
        add(taskListPanel, BorderLayout.CENTER);
    }

    private void addTaskInput() {
        var taskInputPanel = new TaskInputPanel(taskListPanel);
        add(taskInputPanel, BorderLayout.SOUTH);
    }
}
