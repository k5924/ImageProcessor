package model;

import java.awt.image.BufferedImage;

import view.ImageProcessor;
import view.OperationDialog;
import view.TintUI;

public class Tint extends AbstractOperation {

	private TintUI ui;

	public Tint(BufferedImage inputImage, ImageProcessor frame, TintUI ui) {
		super(inputImage, frame);
		// TODO Auto-generated constructor stub
		this.ui = ui;
	}

	@Override
	public BufferedImage Operation() {
		final OperationDialog dialog = new OperationDialog(frame, this.ui);
		dialog.setVisible(true);
		if (!dialog.wasCancelled()) {
			final ColourComponent band = this.ui.getChosenColor();
			final double alpha = this.ui.getAlpha() / 100.0;
			for (int x = 0; x < inputImage.getWidth(); x++) {
				for (int y = 0; y < inputImage.getHeight(); y++) {
					final int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
					final int outputRGB = OperationUtilities.tint(inputRGB, alpha, band);
					OperationUtilities.setRGB(x, y, outputRGB, inputImage);
				}
			}
		}
		return inputImage;
	}

}
