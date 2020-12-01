package oop.im2020;

import java.awt.image.BufferedImage;

public interface OperationChooser {
	BufferedImage GrayScaleOperation(BufferedImage inputImage, ImageProcessor frame, GrayscaleUI ui);

	BufferedImage ChromaKeyOperation(BufferedImage inputImage, ImageProcessor frame, ChromaKeyUI ui);
	
	BufferedImage TintOperation(BufferedImage inputImage, ImageProcessor frame, TintUI ui);
}
