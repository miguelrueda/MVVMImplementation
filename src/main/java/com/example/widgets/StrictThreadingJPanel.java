package com.example.widgets;

import com.example.utils.GuiPreconditions;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StrictThreadingJPanel extends JPanel {

    public StrictThreadingJPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJPanel(LayoutManager layout) {
        super(layout);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJPanel() {
        GuiPreconditions.assertOnAwtEdt();
    }

    @Override
    public Component add(Component comp) {
        GuiPreconditions.assertOnAwtEdt();
        return super.add(comp);
    }

    @Override
    public Component add(Component comp, int index) {
        GuiPreconditions.assertOnAwtEdt();
        return super.add(comp, index);
    }

    @Override
    public Component add(String name, Component comp) {
        GuiPreconditions.assertOnAwtEdt();
        return super.add(name, comp);
    }

    @Override
    public void remove(Component comp) {
        GuiPreconditions.assertOnAwtEdt();
        super.remove(comp);
    }

    @Override
    public void removeAll() {
        GuiPreconditions.assertOnAwtEdt();
        super.removeAll();
    }

    @Override
    public void remove(int index) {
        GuiPreconditions.assertOnAwtEdt();
        super.remove(index);
    }

    @Override
    public void setLayout(LayoutManager mgr) {
        GuiPreconditions.assertOnAwtEdt();
        super.setLayout(mgr);
    }

    @Override
    public void setBorder(Border border) {
        GuiPreconditions.assertOnAwtEdt();
        super.setBorder(border);
    }
}
