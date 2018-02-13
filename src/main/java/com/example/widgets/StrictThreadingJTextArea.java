package com.example.widgets;

import com.example.utils.GuiPreconditions;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class StrictThreadingJTextArea extends JTextArea {

    public StrictThreadingJTextArea() {
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJTextArea(String text) {
        super(text);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJTextArea(int rows, int columns) {
        super(rows, columns);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJTextArea(String text, int rows, int columns) {
        super(text, rows, columns);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJTextArea(Document doc) {
        super(doc);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJTextArea(Document doc, String text, int rows, int columns) {
        super(doc, text, rows, columns);
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
    public boolean isEnabled() {
        GuiPreconditions.assertOnAwtEdt();
        return super.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        GuiPreconditions.assertOnAwtEdt();
        super.setEnabled(enabled);
    }
}
