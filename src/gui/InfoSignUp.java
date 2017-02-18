package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class InfoSignUp {

	private JFrame frame;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String numberOfMacroKeys;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoSignUp window = new InfoSignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class RadioListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JRadioButton btn = (JRadioButton)arg0.getSource();
			String numberOfMacroKeys = btn.getText();
			
		}
		
	}

	/**
	 * Create the application.
	 */
	public InfoSignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHowManyArrow = new JLabel("How many arrow keys will you use?");
		lblHowManyArrow.setBounds(10, 11, 178, 20);
		frame.getContentPane().add(lblHowManyArrow);
		
		JLabel lblWhereAreYour = new JLabel("Where are your photos stored?");
		lblWhereAreYour.setBounds(10, 78, 178, 14);
		frame.getContentPane().add(lblWhereAreYour);
		
		textField = new JTextField();
		textField.setBounds(198, 75, 226, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnOne = new JRadioButton("One");
		buttonGroup.add(rdbtnOne);
		rdbtnOne.setBounds(198, 10, 109, 23);
		frame.getContentPane().add(rdbtnOne);
		
		JRadioButton rdbtnTwo = new JRadioButton("Two");
		buttonGroup.add(rdbtnTwo);
		rdbtnTwo.setBounds(198, 36, 109, 23);
		frame.getContentPane().add(rdbtnTwo);
		
		JRadioButton rdbtnFour = new JRadioButton("Four");
		buttonGroup.add(rdbtnFour);
		rdbtnFour.setBounds(309, 36, 109, 23);
		frame.getContentPane().add(rdbtnFour);
		
		JRadioButton rdbtnThree = new JRadioButton("Three");
		buttonGroup.add(rdbtnThree);
		rdbtnThree.setBounds(309, 10, 109, 23);
		frame.getContentPane().add(rdbtnThree);
		
		RadioListener listener = new RadioListener();
		rdbtnOne.addActionListener(listener);
		rdbtnTwo.addActionListener(listener);
		rdbtnThree.addActionListener(listener);
		rdbtnFour.addActionListener(listener);
	}
}
