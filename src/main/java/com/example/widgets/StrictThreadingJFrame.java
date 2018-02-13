package com.example.widgets;

import com.example.utils.GuiPreconditions;

import javax.swing.*;
import java.awt.*;

public class StrictThreadingJFrame extends JFrame {

    public StrictThreadingJFrame() throws HeadlessException {
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJFrame(GraphicsConfiguration gc) {
        super(gc);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJFrame(String title) throws HeadlessException {
        super(title);
        GuiPreconditions.assertOnAwtEdt();
    }

    public StrictThreadingJFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
        GuiPreconditions.assertOnAwtEdt();
    }

    @Override
    public void setVisible(boolean b) {
        GuiPreconditions.assertOnAwtEdt();
        super.setVisible(b);
    }
}
