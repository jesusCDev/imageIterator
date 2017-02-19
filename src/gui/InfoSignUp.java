package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class InfoSignUp {

	private JFrame frame;
	private JTextField pictureDestinationText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String numberOfMacroKeys;
	private JTextField upArrowText;
	private JTextField downArrowText;
	private JTextField leftArrowText;
	private JTextField rightArrowText;
	

	boolean upClick = true;
	boolean downClick = false;
	boolean leftClick = false;
	boolean rightClick = false;

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
			int numberOfMacroKeysInt = 1;
			
			if(numberOfMacroKeys == "Two"){
				numberOfMacroKeysInt = 2;
			}else if(numberOfMacroKeys == "Three"){
				numberOfMacroKeysInt = 3;
				
			}else if(numberOfMacroKeys == "Four"){
				numberOfMacroKeysInt = 4;
			}
			
			JLabel lblUpArrowDestination = new JLabel("Up Arrow Destination");
			lblUpArrowDestination.setBounds(10, 134, 116, 14);
			frame.getContentPane().add(lblUpArrowDestination);
			
			upArrowText = new JTextField();
			upArrowText.setBounds(198, 131, 226, 20);
			frame.getContentPane().add(upArrowText);
			upArrowText.setColumns(10);
			
			if(downClick == true){
				frame.getContentPane().remove(downArrowText);
				downClick = false;
			}
			if(leftClick == true){
				frame.getContentPane().remove(leftArrowText);
				leftClick = false;
			}
			if(rightClick == true){
				frame.getContentPane().remove(rightArrowText);
				rightClick = false;
			}
			
			if(numberOfMacroKeysInt > 1){

				JLabel lblDownArrowDestination = new JLabel("Down Arrow Destination");
				lblDownArrowDestination.setBounds(10, 159, 116, 14);
				frame.getContentPane().add(lblDownArrowDestination);

				downArrowText = new JTextField();
				downArrowText.setBounds(198, 156, 226, 20);
				frame.getContentPane().add(downArrowText);
				downArrowText.setColumns(10);
				
				downClick = true;
				
				if(leftClick == true){
					frame.getContentPane().remove(leftArrowText);
					leftClick = false;
				}
				if(rightClick == true){
					frame.getContentPane().remove(rightArrowText);
					rightClick = false;
				}
				
				if (numberOfMacroKeysInt > 2){
					
					JLabel lblLeftArrowDestination = new JLabel("Left Arrow Destination");
					lblLeftArrowDestination.setBounds(10, 184, 116, 14);
					frame.getContentPane().add(lblLeftArrowDestination);
					
					leftArrowText = new JTextField();
					leftArrowText.setBounds(198, 181, 226, 20);
					frame.getContentPane().add(leftArrowText);
					leftArrowText.setColumns(10);
					
					leftClick = true;
					
					if(rightClick == true){
						frame.getContentPane().remove(rightArrowText);
						rightClick = false;
					}
					
					if (numberOfMacroKeysInt > 3){
						
						JLabel lblRightArrowDestination = new JLabel("Right Arrow Destination");
						lblRightArrowDestination.setBounds(10, 209, 116, 14);
						frame.getContentPane().add(lblRightArrowDestination);
						
						rightArrowText = new JTextField();
						rightArrowText.setBounds(198, 206, 226, 20);
						frame.getContentPane().add(rightArrowText);
						rightArrowText.setColumns(10);
						
						rightClick = true;
						
					}
				}
			}

			frame.revalidate();
			frame.repaint();
			
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
		
		pictureDestinationText = new JTextField();
		pictureDestinationText.setBounds(198, 75, 226, 20);
		frame.getContentPane().add(pictureDestinationText);
		pictureDestinationText.setColumns(10);
		
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
		
		JButton submitBtn = new JButton("Submit");

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				

				System.out.println(pictureDestinationText.getText().toString());
				System.out.println(upArrowText.getText().toString());
				
				System.out.println(pictureDestinationText.getText());
				System.out.println(upArrowText.getText());
				
				
				
				
				
				String[] paths = new String[5];
				
				if(!pictureDestinationText.getText().equals("") && !upArrowText.getText().equals("")){
					
					paths[0] = pictureDestinationText.getText();
					paths[1] = upArrowText.getText();
					
					if(downClick == true || rightClick == true || leftClick == true){
						
						if(downClick == true && !downArrowText.getText().equals("")){
							paths[2] = downArrowText.getText();
						}

						if(leftClick == true && !leftArrowText.getText().equals("")){
							paths[3] = rightArrowText.getText();
						}
						
						if(rightClick == true && !rightArrowText.getText().equals("")){
							paths[4] = leftArrowText.getText();
						}
					}else{

						
					}
				}
				
			}
		});
		submitBtn.setBounds(10, 227, 414, 23);
		frame.getContentPane().add(submitBtn);
		
		RadioListener listener = new RadioListener();
		rdbtnOne.addActionListener(listener);
		rdbtnTwo.addActionListener(listener);
		rdbtnThree.addActionListener(listener);
		rdbtnFour.addActionListener(listener);
	}
}
