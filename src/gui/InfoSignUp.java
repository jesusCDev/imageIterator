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
	
	JLabel lblUpArrowDestination;
	JLabel lblDownArrowDestination;
	JLabel lblLeftArrowDestination;
	JLabel lblRightArrowDestination;
	
	private JTextField upArrowText;
	private JTextField downArrowText;
	private JTextField leftArrowText;
	private JTextField rightArrowText;
	

	boolean upClick = false;
	boolean downClick = false;
	boolean leftClick = false;
	boolean rightClick = false;

	String originalLeft = null;
	String originalUp = null;
	String originalDown = null;

	boolean upClicked = false;
	boolean downClicked = false;
	boolean leftClicked = false;

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
	
	private void passText(String[] paths){
		System.out.println(paths[0]);
		System.out.println(paths[1]);
		System.out.println(paths[2]);
		System.out.println(paths[3]);
		System.out.println(paths[4]);
	}
	
	class RadioListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			JRadioButton btn = (JRadioButton)arg0.getSource();
			String numberOfMacroKeys = btn.getText();
			
			int numberOfMacroKeysInt = 1;
			
			if(numberOfMacroKeys.equals("Two")){
				
				numberOfMacroKeysInt = 2;
				
			}else if(numberOfMacroKeys.equals("Three")){
				
				numberOfMacroKeysInt = 3;
				
			}else if(numberOfMacroKeys.equals("Four")){
				numberOfMacroKeysInt = 4;
			}
			
			if(upClicked == true){
				originalUp = upArrowText.getText();
				System.out.println(originalUp);
			}
			
			
			upClicked = true;
			upClick = true;
			if(numberOfMacroKeysInt == 1){
				System.out.println("One");

				System.out.println(downClick);
				System.out.println(leftClick);
				System.out.println(rightClick);
				if(downClick == true){
					frame.getContentPane().remove(lblDownArrowDestination);
					frame.getContentPane().remove(downArrowText);
					downArrowText.setText("");
					downClick = false;
				}
				if(leftClick == true){
					frame.getContentPane().remove(lblLeftArrowDestination);
					frame.getContentPane().remove(leftArrowText);
					leftArrowText.setText("");
					leftClick = false;
				}
				if(rightClick == true){
					frame.getContentPane().remove(lblRightArrowDestination);
					frame.getContentPane().remove(rightArrowText);
					rightArrowText.setText("");
					rightClick = false;
				}
			}
			
			if(numberOfMacroKeysInt > 1){

				if(downClicked == true){
					originalDown = downArrowText.getText();
					System.out.println(originalDown);
				}
				
				downClick = true;
				downClicked = true;

				if(numberOfMacroKeysInt == 2){
					System.out.println(leftClick);
					System.out.println(rightClick);
					System.out.println("Two");
					if(leftClick == true){
						frame.getContentPane().remove(lblLeftArrowDestination);
						frame.getContentPane().remove(leftArrowText);
						leftArrowText.setText("");
						leftClick = false;
					}
					if(rightClick == true){
						frame.getContentPane().remove(lblRightArrowDestination);
						frame.getContentPane().remove(rightArrowText);
						rightArrowText.setText("");
						rightClick = false;
					}

				}
				
				if (numberOfMacroKeysInt > 2){

					if(leftClicked == true){
						originalLeft = leftArrowText.getText();
						System.out.println(originalLeft);
					}
					
					
					frame.getContentPane().remove(lblRightArrowDestination);
					frame.getContentPane().remove(rightArrowText);
					rightArrowText.setText("");
					
					leftClick = true;
					leftClicked = true;

					if(numberOfMacroKeysInt == 3){
						System.out.println(rightClick);
						System.out.println("Three");
						if(rightClick == true){
							rightClick = false;
						}
					}
					
					if (numberOfMacroKeysInt > 3){
						
						
						rightClick = true;
						
					}
				}
			}

			frame.revalidate();
			frame.repaint();

			if(upClicked == true){
				System.out.println("Pass one");
				upArrowText.setText(originalUp);
				
				if(downClicked == true){
					System.out.println("Pass Two");
					downArrowText.setText(originalDown);

					if(leftClicked == true){
						System.out.println("Pass Three");
						leftArrowText.setText(originalLeft);
					}
				}
			}
			
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
		frame.setBounds(100, 100, 450, 345);
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
				
				System.out.println("Pressed");
				
				String[] paths = new String[5];
				
				if((pictureDestinationText.getText().equals("")) == false && (upArrowText.getText().equals("") == false)){
					
					System.out.println("Box One");
					
					paths[0] = pictureDestinationText.getText();
					paths[1] = upArrowText.getText();
					
					if(downClick == true || rightClick == true || leftClick == true){
						
						System.out.println("True and False");
						
						if(downClick == true && !downArrowText.getText().equals("")){
							
							System.out.println("Box Two");
							paths[2] = downArrowText.getText();

							if(leftClick == true && !leftArrowText.getText().equals("")){
								
								System.out.println("Box Three");
								paths[3] = rightArrowText.getText();
								
								if(rightClick == true && !rightArrowText.getText().equals("")){
									
									System.out.println("Box Four");
									paths[4] = leftArrowText.getText();
									passText(paths);
									
								}else{
									
									passText(paths);
									
								}
							}else{
								
								passText(paths);
								
							}
						}
					}else{
						
						passText(paths);
						
					}
				}
				System.out.println("\n" + "After Pressed");
			}
		});
		submitBtn.setBounds(10, 272, 414, 23);
		frame.getContentPane().add(submitBtn);
		
		RadioListener listener = new RadioListener();
		rdbtnOne.addActionListener(listener);
		rdbtnTwo.addActionListener(listener);
		rdbtnThree.addActionListener(listener);
		rdbtnFour.addActionListener(listener);
		
		lblRightArrowDestination = new JLabel("Right Arrow Destination");
		lblRightArrowDestination.setBounds(10, 209, 136, 14);
		frame.getContentPane().add(lblRightArrowDestination);
		
		rightArrowText = new JTextField();
		rightArrowText.setBounds(198, 206, 226, 20);
		rightArrowText.setColumns(10);
		frame.getContentPane().add(rightArrowText);

		lblUpArrowDestination = new JLabel("Up Arrow Destination");
		lblUpArrowDestination.setBounds(10, 134, 136, 14);
		frame.getContentPane().add(lblUpArrowDestination);
		
		upArrowText = new JTextField();
		upArrowText.setBounds(198, 131, 226, 20);
		upArrowText.setColumns(10);
		frame.getContentPane().add(upArrowText);

		lblDownArrowDestination = new JLabel("Down Arrow Destination");
		lblDownArrowDestination.setBounds(10, 159, 136, 14);
		frame.getContentPane().add(lblDownArrowDestination);
		
		downArrowText = new JTextField();
		downArrowText.setBounds(198, 156, 226, 20);
		downArrowText.setColumns(10);
		frame.getContentPane().add(downArrowText);
		
		lblLeftArrowDestination = new JLabel("Left Arrow Destination");
		lblLeftArrowDestination.setBounds(10, 184, 136, 14);
		frame.getContentPane().add(lblLeftArrowDestination);
		
		leftArrowText = new JTextField();
		leftArrowText.setBounds(198, 181, 226, 20);
		leftArrowText.setColumns(10);
		frame.getContentPane().add(leftArrowText);
	}
}
