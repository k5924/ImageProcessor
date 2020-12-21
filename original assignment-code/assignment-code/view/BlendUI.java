package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlendUI extends JPanel {

	private final JTextField otherImagePath = new JTextField(60);
	private final JButton fileChooserButton = new JButton("Open");
	private final JColorChooser colorChooser = new JColorChooser();

	private final JFileChooser chooser;
	private File file;

	public BlendUI(final JFileChooser chooser) {
		super(new BorderLayout());

		this.chooser = chooser;

		this.colorChooser.setPreviewPanel(new JPanel());

		final JPanel pathPanel = new JPanel();
		pathPanel.add(this.otherImagePath);
		pathPanel.add(this.fileChooserButton);
		pathPanel.setBorder(BorderFactory.createTitledBorder("Image to blend"));
		colorChooser.setBorder(BorderFactory.createTitledBorder("Colour to blend through"));

		add(pathPanel, BorderLayout.NORTH);
		add(this.colorChooser, BorderLayout.CENTER);

		this.otherImagePath.setEditable(false);

		this.fileChooserButton.addActionListener(ev -> showChooser());
	}

	private void showChooser() {
		if (this.chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			this.file = this.chooser.getSelectedFile();
			this.otherImagePath.setText(this.file.getPath());
		}
	}

	public File getOtherImagePath() {
		return this.file;
	}

	public Color getTargetColor() {
		return this.colorChooser.getColor();
	}
}
