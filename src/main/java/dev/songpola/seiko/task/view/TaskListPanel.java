package dev.songpola.seiko.task.view;

import dev.songpola.seiko.task.model.TaskModel;

import javax.swing.*;
import java.awt.*;

public class TaskListPanel extends JPanel {
    private final TaskModel model = new TaskModel();
    private final JList<String> taskList;

    public TaskListPanel() {
        super(new BorderLayout());
        taskList = new JList<>(model);
        taskList.setFocusable(false);
        var scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addTask(String task) {
        model.addTask(task);
    }

    public void removeTask(int index) {
        model.removeTask(index);
    }

    public void markTaskAsCompleted(int index) {
        model.markTaskAsCompleted(index);
    }

    public int getSelectedIndex() {
        return taskList.getSelectedIndex();
    }
}
