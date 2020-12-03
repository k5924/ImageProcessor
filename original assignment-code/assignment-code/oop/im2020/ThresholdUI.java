package oop.im2020;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ThresholdUI extends JPanel {

    private final JSlider alphaSlider = new JSlider(0, 100);

    public ThresholdUI() {
        super(new BorderLayout());
        
        JLabel label = new JLabel("Convert image to black and white with threshold value");

        add(label, BorderLayout.CENTER);
        add(this.alphaSlider, BorderLayout.SOUTH);
    }

    public int getAlpha() {
        return this.alphaSlider.getValue();
    }
}
