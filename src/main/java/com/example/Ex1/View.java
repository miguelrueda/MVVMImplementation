package com.example.Ex1;

import com.example.rxjavamvvm.IView;
import com.example.widgets.StrictThreadingJFrame;
import com.example.widgets.StrictThreadingJLabel;
import io.reactivex.BackpressureStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;

import static com.example.rxjavamvvm.RxViewModelI2SwingViewBinder.bindViewModelString;

public class View extends StrictThreadingJFrame implements IView<ViewModel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(View.class);

    private final StrictThreadingJLabel label;

    @Override
    public void bind(ViewModel viewModel) {
        LOGGER.info("#bind()");
        bindViewModelString(viewModel.vm2v_info.toFlowable(BackpressureStrategy.BUFFER))
                .toSwingViewLabel(label);
    }

    public View() throws HeadlessException {
        super();
        setTitle(getClass().getSimpleName() + " " + ManagementFactory.getRuntimeMXBean().getName());

        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(StrictThreadingJFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));

        label = new StrictThreadingJLabel();
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(label, BorderLayout.CENTER);
    }
}
