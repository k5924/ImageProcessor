package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.ChromaKeyUI;
import view.ImageProcessor;
import view.OperationDialog;

public class ChromaKey extends AbstractOperation {

	private ChromaKeyUI ui;

	public ChromaKey(BufferedImage inputImage, ImageProcessor frame, ChromaKeyUI ui) {
		super(inputImage, frame);
		// TODO Auto-generated constructor stub
		this.ui = ui;
	}

	@Override
	public BufferedImage Operation() {
		final OperationDialog dialog = new OperationDialog(frame, this.ui);
		dialog.setVisible(true);
		if (!dialog.wasCancelled()) {
			try {
				double sensitivity = this.ui.getSensitivity();
				BufferedImage otherImage = ImageIO.read(this.ui.getOtherImagePath());

				int targetRGB = this.ui.getTargetColor().getRGB();

				BufferedImage output = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(),
						inputImage.getType());
				for (int x = 0; x < output.getWidth(); x++) {
					for (int y = 0; y < output.getHeight(); y++) {
						int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
						int otherRGB = OperationUtilities.getRGB(x, y, otherImage);
						int outputRGB = OperationUtilities.chromaKey(inputRGB, otherRGB, targetRGB, sensitivity);
						OperationUtilities.setRGB(x, y, outputRGB, output);
					}
				}
				return output;
			} catch (IOException ex) {
				ex.printStackTrace();
				return inputImage;
			}
		} else {
			return inputImage;
		}
	}

}
