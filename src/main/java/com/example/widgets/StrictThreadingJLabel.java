package com.example.widgets;

import com.example.utils.GuiPreconditions;

import javax.swing.*;

public class StrictThreadingJLabel extends JLabel {

    public StrictThreadingJLabel() {
        super();
    }

    public StrictThreadingJLabel(String text) {
        super(text);
        GuiPreconditions.assertOnAwtEdt();
    }

    @Override
    public void setText(String text) {
        GuiPreconditions.assertOnAwtEdt();
        super.setText(text);
    }
}
