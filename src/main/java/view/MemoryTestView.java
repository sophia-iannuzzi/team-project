package view;

import interface_adapter.MemoryTest.MemoryTestController;
import interface_adapter.MemoryTest.MemoryTestViewModel;
import interface_adapter.MemoryTest.MemoryTestViewModelListener;
import interface_adapter.TestSelection.TestSelectionController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryTestView extends JPanel implements ActionListener, MemoryTestViewModelListener {

    private final MemoryTestViewModel memoryTestViewModel;
    private MemoryTestController memoryTestController = null;

    public MemoryTestView(MemoryTestViewModel memoryTestViewModel) {
        this.memoryTestViewModel = memoryTestViewModel;
    }

    @Override
    public void stateChanged() {

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    public void setMemoryTestController(MemoryTestController memoryTestController) {
        this.memoryTestController = memoryTestController;
    }
}
