package vn.elca.training;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application {

	private Panel controlPanel;
	private Label headerLabel;
	private Label lblResult;
	private Label lblVowelString1;
	private Label lblVowelString2;

	private Frame mainFrame;

	public static void main(String[] args) {
		Application app = new Application();
		app.checkVowelsPattern();
	}

	public Application() {
		prepareGUI();
	}

	private void checkVowelsPattern() {
		headerLabel.setText("Input string into text box and click check button.");

		Label lblString1 = new Label("String 1: ", Label.RIGHT);
		Label lblString2 = new Label("String 2: ", Label.CENTER);
		final TextField txtString1 = new TextField(6);
		final TextField txtString2 = new TextField(6);

		Button btnCheck = new Button("Check");

		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// if String1, String2 are not empty
					if (!txtString1.getText().isEmpty() || !txtString1.getText().equals("")
							|| !txtString2.getText().isEmpty() || !txtString2.getText().equals("")) {
						Boolean result = VowelsPattern.sameVowelPatternOfLongWord(txtString1.getText(),
								txtString2.getText());
						if (!VowelsPattern.stringVowel1.isEmpty() || !VowelsPattern.stringVowel1.equals("")) {
							lblVowelString1.setText("Vowel string 1: " + VowelsPattern.stringVowel1);
						} else {
							lblVowelString1.setText("String 1: (" + txtString1.getText() + ") do not have any vowel!");
						}

						if (!VowelsPattern.stringVowel2.isEmpty() || !VowelsPattern.stringVowel2.equals("")) {
							lblVowelString2.setText("Vowel string 2: " + VowelsPattern.stringVowel2);
						} else {
							lblVowelString2.setText("String 2: (" + txtString2.getText() + ") do not have any vowel!");
						}

						if (result) {
							lblResult.setText("Vowel string are matched, result: " + result.toString());
						} else {
							lblResult.setText("Vowel string are not matched, result: " + result.toString());
						}

					} else {
						lblResult.setText("Please input string!");
					}

				} catch (InvalidInputException exception) {
					// TODO Auto-generated catch block
					exception = new InvalidInputException("Input string are invalid!");
					lblResult.setText(exception.toString());
					exception.printStackTrace();
				}
			}
		});

		controlPanel.add(lblString1);
		controlPanel.add(txtString1);
		controlPanel.add(lblString2);
		controlPanel.add(txtString2);
		controlPanel.add(btnCheck);
		mainFrame.setVisible(true);
	}

	private void prepareGUI() {
		mainFrame = new Frame("[ILT] Check Vowel Pattern");
		mainFrame.setSize(400, 250);
		mainFrame.setLayout(new GridLayout(5, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		lblResult = new Label();
		lblResult.setAlignment(Label.CENTER);
		lblResult.setSize(350, 100);

		lblVowelString1 = new Label();
		lblVowelString1.setAlignment(Label.LEFT);
		lblVowelString1.setSize(350, 100);

		lblVowelString2 = new Label();
		lblVowelString2.setAlignment(Label.LEFT);
		lblVowelString2.setSize(350, 100);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(lblVowelString1);
		mainFrame.add(lblVowelString2);
		mainFrame.add(lblResult);
		mainFrame.setVisible(true);
	}
}
