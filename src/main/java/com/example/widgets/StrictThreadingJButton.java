package com.example.widgets;

import com.example.utils.GuiPreconditions;

import javax.swing.*;

public class StrictThreadingJButton extends JButton {

    public StrictThreadingJButton() {
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJButton(Icon icon) {
        super(icon);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJButton(String text) {
        super(text);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJButton(Action a) {
        super(a);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJButton(String text, Icon icon) {
        super(text, icon);
        GuiPreconditions.assertOnAwtEdt();
    }

    @Override
    public void setEnabled(boolean b) {
        GuiPreconditions.assertOnAwtEdt();
        super.setEnabled(b);
    }

    @Override
    public boolean isEnabled() {
        GuiPreconditions.assertOnAwtEdt();
        return super.isEnabled();
    }
}
