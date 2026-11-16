package view;

import interface_adapter.AttentionTest.AttentionTestController;
import interface_adapter.AttentionTest.AttentionTestViewModel;
import interface_adapter.AttentionTest.AttentionTestViewModelListener;
import interface_adapter.MemoryTest.MemoryTestController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttentionTestView extends JPanel implements ActionListener, AttentionTestViewModelListener {

    private final AttentionTestViewModel attentionTestViewModel;
    private AttentionTestController attentionTestController = null;

    public AttentionTestView(AttentionTestViewModel attentionTestViewModel) {
        this.attentionTestViewModel = attentionTestViewModel;
    }

    @Override
    public void stateChanged() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setAttentionTestController(AttentionTestController attentionTestController) {
        this.attentionTestController = attentionTestController;
    }
}
