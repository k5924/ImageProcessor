package oop.im2020;

public class OperationFactory {

	public enum OperationType {
		Grayscale, Tint, Chromakey
	}
	
	public static OperationChooser createOperationChanger(OperationType type) {
		switch (type) {
		case Grayscale:
			return new Grayscale();
		case Tint:
			return new Tint();
		case Chromakey:
			return new ChromaKey();
		}
		return null;
	}

}
