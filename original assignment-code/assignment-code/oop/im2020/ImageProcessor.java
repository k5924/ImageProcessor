package oop.im2020;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import oop.im2020.OperationFactory.OperationType;

/**
 *
 * @author childm
 */
public class ImageProcessor extends JFrame {
	private static final long serialVersionUID = 1L;

	private final JFileChooser chooser = new JFileChooser();
	private final ImagePanel imagePanel = new ImagePanel();

	private BufferedImage image;

	private File loadedImage;

	private final JMenu opMenu = new JMenu("Operations");

	private final GrayscaleUI grayscaleUI = new GrayscaleUI();
	private final TintUI tintUI = new TintUI();
	private final ChromaKeyUI chromaKeyUI = new ChromaKeyUI(chooser);

	public ImageProcessor() {
		this.chooser.setMultiSelectionEnabled(false);
		this.chooser.setCurrentDirectory(new File(".")); // set current directory

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		final JMenuBar menuBar = new JMenuBar();
		final JMenu fileMenu = new JMenu("File");

		final JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(ev -> doOpenImage());
		fileMenu.add(openItem);

		final JMenuItem revertItem = new JMenuItem("Revert");
		revertItem.addActionListener(ev -> revert());
		fileMenu.add(revertItem);

		menuBar.add(fileMenu);
		menuBar.add(this.opMenu);
		setJMenuBar(menuBar);

		add(this.imagePanel, BorderLayout.CENTER);
		pack();

		addMenuOperation("Grayscale");
		addMenuOperation("Tint");
		addMenuOperation("Chromakey");

		this.setVisible(true);
	}

	private void addMenuOperation(final String identifier) {
		final JMenuItem item = new JMenuItem(identifier);
		item.addActionListener(ev -> doOperation(identifier));
		this.opMenu.add(item);
	}

	private File chooseImageFile() {
		if (this.chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			return this.chooser.getSelectedFile();
		} else {
			return null;
		}
	}

	private void doOpenImage() {
		final File file = chooseImageFile();
		if (file != null) {
			loadImage(file);
		}
	}

	private void loadImage(final File file) {
		try {
			this.image = ImageIO.read(file);
			this.loadedImage = file;
			setImage(this.image);
		} catch (final IOException ex) {
			ex.printStackTrace();
		}
	}

	private void setImage(final BufferedImage image) {
		this.image = image;
		this.imagePanel.setImage(image);
		pack();
	}

	private void revert() {
		if (this.loadedImage != null) {
			loadImage(this.loadedImage);
		}
	}

	private void doOperation(final String identifier) {
//		if (identifier.equals("Grayscale")) {
//			Grayscale type = new Grayscale(this.image, this, this.grayscaleUI);
//			setImage(type.confirm(this.image));
//			//setImage((BufferedImage) new Grayscale(this.image, this, grayscaleUI));
//		} else if (identifier.equals("Tint")) {
//			Tint type = new Tint(this.image, this, this.tintUI);
//			setImage(type.confirm(this.image));
//			//setImage(new Tint(this.image, this, grayscaleUI));
//		} else if (identifier.equals("Chromakey")) {
//			ChromaKey type = new ChromaKey(this.image, this, this.chromaKeyUI);
//			setImage(type.confirm(this.image));
//			//setImage(new ChromaKey(this.image, this, grayscaleUI));
//		}
		if (identifier.equals("Grayscale")) {
			OperationChooser operation = OperationFactory.createOperationChanger(OperationType.Grayscale);
			operation.GrayScaleOperation(this.image, this, this.grayscaleUI);
		} else if (identifier.equals("Tint")) {
			OperationChooser operation = OperationFactory.createOperationChanger(OperationType.Tint);
			operation.TintOperation(this.image, this, this.tintUI);
		} else if (identifier.equals("Chromakey")) {
			OperationChooser operation = OperationFactory.createOperationChanger(OperationType.Chromakey);
			operation.ChromaKeyOperation(this.image, this, this.chromaKeyUI);
		}
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(() -> new ImageProcessor());
	}

}
