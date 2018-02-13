package com.example.Ex1;

import com.example.utils.UncaughtExceptionHandlerInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.lang.management.ManagementFactory;

public class Ex1Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Ex1Main.class);

    public static void main(String[] args) {
        LOGGER.info(ManagementFactory.getRuntimeMXBean().getName());
//        UncaughtExceptionHandlerInitializer.initUncaughtExceptionHandler();

        Model model = new Model();
        ViewModel viewModel = new ViewModel();
        viewModel.connectTo(model);

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
                LOGGER.error(e.getMessage());
            }
            View view = new View();
            view.bind(viewModel);
            view.setVisible(true);
            view.setLocation(300, 300);
        });
    }

}
