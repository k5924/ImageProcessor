package oop.im2020;

import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class OperationFactory {

	public enum OperationType {
		Grayscale, Tint, Chromakey
	}
	
	public static OperationChooser createOperationChanger(OperationType type, BufferedImage inputImage, ImageProcessor frame) {
		switch (type) {
		case Grayscale:
			return new Grayscale(inputImage, frame, new GrayscaleUI());
		case Tint:
			return new Tint(inputImage, frame, new TintUI());
		case Chromakey:
			return new ChromaKey(inputImage, frame, new ChromaKeyUI(new JFileChooser()));
		}
		return null;
	}

}
