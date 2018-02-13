package com.example.widgets;

import com.example.utils.GuiPreconditions;

import javax.swing.*;
import javax.swing.text.Document;

public class StrictThreadingJTextField extends JTextField {

    public StrictThreadingJTextField() {
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJTextField(String text) {
        super(text);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJTextField(int columns) {
        super(columns);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJTextField(String text, int columns) {
        super(text, columns);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
        GuiPreconditions.assertOnAwtEdt();
    }

    @Override
    public String getText() {
        GuiPreconditions.assertOnAwtEdt();
        return super.getText();
    }

    @Override
    public void setText(String t) {
        GuiPreconditions.assertOnAwtEdt();
        super.setText(t);
    }

    @Override
    public void setEnabled(boolean enabled) {
        GuiPreconditions.assertOnAwtEdt();
        super.setEnabled(enabled);
    }

    @Override
    public void setEditable(boolean b) {
        GuiPreconditions.assertOnAwtEdt();
        super.setEditable(b);
    }
}
