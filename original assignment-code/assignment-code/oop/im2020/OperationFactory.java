package oop.im2020;

import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;

public class OperationFactory {

	public enum OperationType {
		Grayscale, Tint, Chromakey, Negative, Blend, Threshold
	}
	
	public static OperationChooser createOperationChanger(OperationType type, BufferedImage inputImage, ImageProcessor frame, JFileChooser chooser) {
		switch (type) {
		case Grayscale:
			return new Grayscale(inputImage, frame, new GrayscaleUI());
		case Tint:
			return new Tint(inputImage, frame, new TintUI());
		case Chromakey:
			return new ChromaKey(inputImage, frame, new ChromaKeyUI(chooser));
		case Negative:
			return new Negative(inputImage, frame, new NegativeUI());
		case Blend:
			return new Blend(inputImage, frame, new BlendUI(chooser));
		case Threshold:
			return new Threshold(inputImage, frame, new ThresholdUI());
		}
		return null;
	}

}
