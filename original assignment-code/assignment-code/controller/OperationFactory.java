package controller;

import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;

import model.AbstractOperation;
import model.Blend;
import model.ChromaKey;
import model.Grayscale;
import model.Negative;
import model.OperationType;
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

	private final static JFileChooser chooser = new JFileChooser();

	private final static GrayscaleUI grayscaleUI = new GrayscaleUI();
	private final static TintUI tintUI = new TintUI();
	private final static ChromaKeyUI chromaKeyUI = new ChromaKeyUI(chooser);
	private final static NegativeUI negativeUI = new NegativeUI();
	private final static BlendUI blendUI = new BlendUI(chooser);
	private final static ThresholdUI thresholdUI = new ThresholdUI();

	public static AbstractOperation createOperationChanger(OperationType type, BufferedImage inputImage,
			ImageProcessor frame) {
		switch (type) {
		case Grayscale:
			return new Grayscale(inputImage, frame, grayscaleUI);
		case Tint:
			return new Tint(inputImage, frame, tintUI);
		case Chromakey:
			return new ChromaKey(inputImage, frame, chromaKeyUI);
		case Negative:
			return new Negative(inputImage, frame, negativeUI);
		case Blend:
			return new Blend(inputImage, frame, blendUI);
		case Threshold:
			return new Threshold(inputImage, frame, thresholdUI);
		}
		return null;
	}

}
