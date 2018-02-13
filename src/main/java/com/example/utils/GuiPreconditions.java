package com.example.utils;

import javax.swing.*;

public class GuiPreconditions {

    public static void assertOnAwtEdt() {
        if(!SwingUtilities.isEventDispatchThread()) {
            throw new IllegalStateException("This is not runningon AWT EDT, it's running on: " + Thread.currentThread().getName());
        }
    }

}
