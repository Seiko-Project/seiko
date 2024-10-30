package dev.songpola.seiko.task.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TaskInputPanel extends JPanel {
    private final TaskListPanel taskListPanel;
    private JTextField taskField;

    public TaskInputPanel(TaskListPanel taskListPanel) {
        this.taskListPanel = taskListPanel;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        addTaskField();
        addButtonAddTask();
        addButtonRemoveTask();
        addButtonMarkTask();
    }

    private void addTaskField() {
        taskField = new JTextField();
        add(taskField);
    }

    private void addButtonAddTask() {
        add(makeButton("Add Task", e -> {
            var task = taskField.getText();
            // TODO: disable button if task is empty
            if (!task.isEmpty()) {
                taskListPanel.addTask(task);
                taskField.setText("");
            }
        }));
    }

    private void addButtonRemoveTask() {
        add(makeButton("Remove Task", e -> {
            int selectedIndex = taskListPanel.getSelectedIndex();
            if (selectedIndex != -1) taskListPanel.removeTask(selectedIndex);
        }));
    }

    private void addButtonMarkTask() {
        add(makeButton("Mark as Completed", e -> {
            int selectedIndex = taskListPanel.getSelectedIndex();
            if (selectedIndex != -1) taskListPanel.markTaskAsCompleted(selectedIndex);
        }));
    }

    private JButton makeButton(String text, ActionListener callback) {
        var button = new JButton(text);
        button.addActionListener(callback);
        return button;
    }
}
