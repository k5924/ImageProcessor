package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ThresholdUI extends JPanel {

	private final JSlider alphaSlider = new JSlider(0, 100);

	public ThresholdUI() {
		super(new BorderLayout());

		add(new JLabel("Convert image to black and white with threshold value"), BorderLayout.CENTER);
		add(this.alphaSlider, BorderLayout.SOUTH);
	}

	public int getAlpha() {
		return this.alphaSlider.getValue();
	}
}
