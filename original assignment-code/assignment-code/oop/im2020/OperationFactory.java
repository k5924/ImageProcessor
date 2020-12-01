package oop.im2020;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class OperationFactory {

	public enum OperationType {
		Grayscale, Tint, Chromakey
	}
	
	public static OperationChooser createOperationChanger(OperationType type, BufferedImage inputImage, ImageProcessor frame, JPanel ui) {
		switch (type) {
		case Grayscale:
			return new Grayscale(inputImage, frame, (GrayscaleUI) ui);
		case Tint:
			return new Tint(inputImage, frame, (TintUI) ui);
		case Chromakey:
			return new ChromaKey(inputImage, frame, (ChromaKeyUI) ui);
		}
		return null;
	}

}
