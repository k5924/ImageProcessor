package model;

import java.awt.image.BufferedImage;

import view.ImageProcessor;

public abstract class AbstractOperation {

	protected final BufferedImage inputImage;
	protected ImageProcessor frame;

	public AbstractOperation(BufferedImage inputImage, ImageProcessor frame) {
		// TODO Auto-generated constructor stub
		this.inputImage = inputImage;
		this.frame = frame;
	}

	public abstract BufferedImage Operation();
}
