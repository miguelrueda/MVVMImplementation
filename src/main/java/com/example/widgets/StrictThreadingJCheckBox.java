package com.example.widgets;

import com.example.utils.GuiPreconditions;

import javax.swing.*;

public class StrictThreadingJCheckBox extends JCheckBox {

    public StrictThreadingJCheckBox() {
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJCheckBox(Icon icon) {
        super(icon);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJCheckBox(Icon icon, boolean selected) {
        super(icon, selected);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJCheckBox(String text) {
        super(text);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJCheckBox(Action a) {
        super(a);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJCheckBox(String text, boolean selected) {
        super(text, selected);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJCheckBox(String text, Icon icon) {
        super(text, icon);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJCheckBox(String text, Icon icon, boolean selected) {
        super(text, icon, selected);
        GuiPreconditions.assertOnAwtEdt();
    }

    @Override
    public void setEnabled(boolean b) {
        GuiPreconditions.assertOnAwtEdt();
        super.setEnabled(b);
    }

    @Override
    public boolean isSelected() {
        GuiPreconditions.assertOnAwtEdt();
        return super.isSelected();
    }
}
