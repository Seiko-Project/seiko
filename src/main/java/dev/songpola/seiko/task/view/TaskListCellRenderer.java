package dev.songpola.seiko.task.view;

import dev.songpola.seiko.task.model.TaskModel;

import javax.swing.*;
import java.awt.*;

public class TaskListCellRenderer extends JLabel implements ListCellRenderer<TaskModel> {
    @Override
    public Component getListCellRendererComponent(
        JList<? extends TaskModel> list,
        TaskModel value,
        int index,
        boolean isSelected,
        boolean cellHasFocus
    ) {
        var title = value.getTitle();
        var completed = value.isCompleted() ? " (completed)" : ""; // TODO: strikethrough text instead
        setText(title + completed);
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setOpaque(true);
        return this;
    }
}
