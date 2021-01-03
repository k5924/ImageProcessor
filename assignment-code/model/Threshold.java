package model;

import java.awt.image.BufferedImage;

import view.ImageProcessor;
import view.OperationDialog;
import view.ThresholdUI;

public class Threshold extends AbstractOperation {

	private ThresholdUI ui;

	public Threshold(BufferedImage inputImage, ImageProcessor frame, ThresholdUI ui) {
		super(inputImage, frame);
		// TODO Auto-generated constructor stub
		this.ui = ui;
	}

	@Override
	public BufferedImage Operation() {
		final OperationDialog dialog = new OperationDialog(frame, this.ui);
		dialog.setVisible(true);
		if (!dialog.wasCancelled()) {
			final int alpha = this.ui.getAlpha();
			for (int x = 0; x < inputImage.getWidth(); x++) {
				for (int y = 0; y < inputImage.getHeight(); y++) {
					final int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
					final int outputRGB = OperationUtilities.threshold(inputRGB, alpha);
					OperationUtilities.setRGB(x, y, outputRGB, inputImage);
				}
			}
		}
		return inputImage;
	}

}
