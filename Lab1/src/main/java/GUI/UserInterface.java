package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**  
* UserInterface.java - UserInterface class handles the UI of the application. It announce the controller when something occured.
* @author  Vlad Bonta
*/
public class UserInterface {
	private AppInterfaceButtonEvents buttonEventHandler;

	private JFrame mainFrame;
	private JPanel controlPanel;
	private JLabel hintLabel;
	private JPanel polynomsPanel;
	private JPanel resultPanel;
	JLabel resultPolynomTextArea = new JLabel();
	int currentDegree;

	public UserInterface(AppInterfaceButtonEvents buttonEventHandler) {
		this.buttonEventHandler = buttonEventHandler;
		this.prepareGUI();
		this.placeButtons();

	}

	public UserInterface() {
		this.prepareGUI();
		this.placeButtons();
	}

	/*
	 * prepareGUI(): Prepare interface by adding the main frame and cotrolPanel
	 * to handle the views
	 */
	public void prepareGUI() {
		mainFrame = new JFrame("Polynoms");
		mainFrame.setSize(800, 800);
		mainFrame.setLayout(new GridLayout(5, 0));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(2, 3));

		polynomsPanel = new JPanel();
		polynomsPanel.setLayout(new GridLayout(2, 1));

		resultPanel = new JPanel();
		resultPanel.setLayout(new GridLayout(1, 1));
		resultPanel.add(resultPolynomTextArea);

		hintLabel = new JLabel();
		hintLabel.setLayout(new GridLayout(1, 1));
		hintLabel.setText("Example: 2x^6+3x^2+1x^1+1x^0");
		mainFrame.add(controlPanel);
		mainFrame.add(polynomsPanel);
		mainFrame.add(hintLabel);
		mainFrame.add(resultPanel);
		
		mainFrame.setVisible(true);
	}

	/*
	 * placeButtons(): Add buttons on the controlPanel
	 */
	private void placeButtons() {

		JButton addPolynomsButton = new JButton("Add polynoms");
		JButton subPolynomsButton = new JButton("Subtract polynoms");
		JButton mulPolynomsButton = new JButton("Multiply polynoms");
		JButton divPolynomsButton = new JButton("Divide polynoms");
		JButton derivatePolynomsButton = new JButton("Derivate polynom");
		JButton integratePolynomsButton = new JButton("Integrare polynom");

		final JTextField firstPolynomTextField = new JTextField(6);
		final JTextField secondPolynomTextField = new JTextField(6);
		firstPolynomTextField.setText("First polynomial");
		secondPolynomTextField.setText("Second polynomial");
		firstPolynomTextField.setBackground(Color.lightGray);
		secondPolynomTextField.setBackground(Color.lightGray);

		addPolynomsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonEventHandler.buttonTouched("Add polynoms", firstPolynomTextField.getText(), secondPolynomTextField.getText());

			}
		});

		subPolynomsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonEventHandler.buttonTouched("Subtract polynoms", firstPolynomTextField.getText(), secondPolynomTextField.getText());

			}
		});

		mulPolynomsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonEventHandler.buttonTouched("Multiply polynoms", firstPolynomTextField.getText(), secondPolynomTextField.getText());

			}
		});

		divPolynomsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonEventHandler.buttonTouched("Divide polynoms", firstPolynomTextField.getText(), secondPolynomTextField.getText());

			}
		});

		derivatePolynomsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonEventHandler.buttonTouched("Derivate polynom", firstPolynomTextField.getText(), secondPolynomTextField.getText());
			}
		});

		integratePolynomsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonEventHandler.buttonTouched("Integrate polynom", firstPolynomTextField.getText(), secondPolynomTextField.getText());
			}
		});

		controlPanel.add(addPolynomsButton);
		controlPanel.add(subPolynomsButton);
		controlPanel.add(mulPolynomsButton);
		controlPanel.add(divPolynomsButton);
		controlPanel.add(derivatePolynomsButton);
		controlPanel.add(integratePolynomsButton);
		polynomsPanel.add(firstPolynomTextField);
		polynomsPanel.add(secondPolynomTextField);

		mainFrame.setVisible(true);
	}

	

	public void showResultPolynom(String polynomString) {
		System.out.println("Show result Polynom");
		System.out.println(polynomString);
		resultPolynomTextArea.setText(polynomString);
		
		resultPanel.setVisible(true);
		mainFrame.repaint();
		mainFrame.setVisible(true);
	}
	
	public void showResultPolynom(String firstPolynomString, String secondPolynomString) {
		System.out.println(firstPolynomString);
		System.out.println(secondPolynomString);

		resultPolynomTextArea.setText("Quotient: " + firstPolynomString + "\nRemainder: " + secondPolynomString);
	
		resultPanel.setVisible(true);
		mainFrame.repaint();
		mainFrame.setVisible(true);
	}
}
