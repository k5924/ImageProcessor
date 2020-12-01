package oop.im2020;

import java.awt.image.BufferedImage;

public class Grayscale extends AbstractOperation {

	private GrayscaleUI ui;

	public Grayscale(BufferedImage inputImage, ImageProcessor frame, GrayscaleUI ui) {
		super(inputImage, frame);
		// TODO Auto-generated constructor stub
		this.ui = ui;
	}

	@Override
	public BufferedImage Operation() {
		final OperationDialog dialog = new OperationDialog(frame, this.ui);
		dialog.setVisible(true);
		if (!dialog.wasCancelled()) {
			for (int x = 0; x < inputImage.getWidth(); x++) {
				for (int y = 0; y < inputImage.getHeight(); y++) {
					final int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
					final int outputRGB = OperationUtilities.grayscale(inputRGB);
					OperationUtilities.setRGB(x, y, outputRGB, inputImage);
				}
			}
		}
		return inputImage;
	}

}
