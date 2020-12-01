package oop.im2020;

import java.awt.image.BufferedImage;

public abstract class AbstractOperation implements OperationChooser{

	protected final BufferedImage inputImage;
	protected ImageProcessor frame;
	
	public AbstractOperation(BufferedImage inputImage, ImageProcessor frame) {
		// TODO Auto-generated constructor stub
		this.inputImage = inputImage;
		this.frame = frame;
	}
}
