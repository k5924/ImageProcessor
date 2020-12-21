package controller;

import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;

import model.AbstractOperation;
import model.Blend;
import model.ChromaKey;
import model.Grayscale;
import model.Negative;
import model.Threshold;
import model.Tint;
import view.BlendUI;
import view.ChromaKeyUI;
import view.GrayscaleUI;
import view.ImageProcessor;
import view.NegativeUI;
import view.ThresholdUI;
import view.TintUI;

public class OperationFactory {

	public enum OperationType {
		Grayscale, Tint, Chromakey, Negative, Blend, Threshold
	}

	public static AbstractOperation createOperationChanger(OperationType type, BufferedImage inputImage,
			ImageProcessor frame, GrayscaleUI grayscaleUI, ChromaKeyUI chromaKeyUI, TintUI tintUI,
			JFileChooser chooser) {
		switch (type) {
		case Grayscale:
			return new Grayscale(inputImage, frame, grayscaleUI);
		case Tint:
			return new Tint(inputImage, frame, tintUI);
		case Chromakey:
			return new ChromaKey(inputImage, frame, chromaKeyUI);
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
