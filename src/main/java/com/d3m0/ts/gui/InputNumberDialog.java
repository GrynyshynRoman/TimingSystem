package com.d3m0.ts.gui;

import javax.swing.*;
import java.awt.event.*;

public class InputNumberDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JLabel inputFormName;
    private String riderNumber;

    private String getRiderNumber() {
        return riderNumber;
    }

    private void setRiderNumber(String riderNumber) {
        this.riderNumber = riderNumber;
    }

    public InputNumberDialog() {
    }

    public InputNumberDialog(String dialogLabel) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        inputFormName.setText(dialogLabel);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        setRiderNumber(textField1.getText());
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public String getNumber(String dialogLabel) {
        InputNumberDialog dialog = new InputNumberDialog(dialogLabel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        return dialog.getRiderNumber();
    }
}
