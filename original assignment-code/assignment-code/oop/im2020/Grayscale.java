package oop.im2020;

import java.awt.image.BufferedImage;

public class Grayscale implements OperationChooser{
	
//	private GrayscaleUI ui;
//
//	public Grayscale(BufferedImage inputImage, ImageProcessor frame, GrayscaleUI ui) {
//		super(inputImage, frame);
//		this.ui = ui;
//		
//	}

//	public BufferedImage confirm(BufferedImage inputImage) {
//		final OperationDialog dialog = new OperationDialog( frame, this.ui);
//		dialog.setVisible( true);
//		if (!dialog.wasCancelled()) {
//			execute(inputImage);
//		}
//		return inputImage;
//	}
//
//	protected void execute(BufferedImage inputImage) {
//		for (int x = 0; x < inputImage.getWidth(); x++) {
//			for (int y = 0; y < inputImage.getHeight(); y++) {
//				final int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
//				final int outputRGB = OperationUtilities.grayscale(inputRGB);
//				OperationUtilities.setRGB(x, y, outputRGB, inputImage);
//			}
//		}
//	}

	@Override
	public BufferedImage GrayScaleOperation(BufferedImage inputImage, ImageProcessor frame, GrayscaleUI ui) {
		final OperationDialog dialog = new OperationDialog( frame, ui);
		dialog.setVisible( true);
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

	@Override
	public BufferedImage ChromaKeyOperation(BufferedImage inputImage, ImageProcessor frame, ChromaKeyUI ui) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BufferedImage TintOperation(BufferedImage inputImage, ImageProcessor frame, TintUI ui) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
