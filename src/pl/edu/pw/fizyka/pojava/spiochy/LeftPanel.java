package pl.edu.pw.fizyka.pojava.spiochy;

import javax.swing.*;

public class LeftPanel extends JPanel {
    public LeftPanel(Parameters parameters) {
        this.add(new ParametersPanel(parameters));
    }
}
