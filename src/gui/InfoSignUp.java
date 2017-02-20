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
import javax.swing.JCheckBox;

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
	

	boolean upClick = true;
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
			
			if(numberOfMacroKeys.equals("One")){
				upClick = true;
				downClick = false;
				leftClick = false;
				rightClick = false;
			}else if(numberOfMacroKeys.equals("Two")){
				upClick = true;
				downClick = true;
				leftClick = false;
				rightClick = false;
			}else if(numberOfMacroKeys.equals("Three")){
				upClick = true;
				downClick = true;
				leftClick = true;
				rightClick = false;
			}else if(numberOfMacroKeys.equals("Four")){
				upClick = true;
				downClick = true;
				leftClick = true;
				rightClick = true;
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
		
		JButton submitBtn = new JButton("Submit");

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> paths = new ArrayList<String>();
				if(upClick == true){
					paths.add(upArrowText.getText());
					if(downClick == true){
						paths.add(downArrowText.getText());
						if(leftClick == true){
							paths.add(leftArrowText.getText());
							if(rightClick == true){
								paths.add(rightArrowText.getText());
							}else{
								paths.add("del");
							}
						}else{
							paths.add("del");
							paths.add("del");
						}
					}else{
						paths.add("del");
						paths.add("del");
						paths.add("del");
					}
				}
				FixPaths pathsFixing = new FixPaths(paths);
				pathsFixing.changeToPaths();
			}
		});
		submitBtn.setBounds(10, 272, 414, 23);
		frame.getContentPane().add(submitBtn);
		
		JLabel lblDeleteImagesAfter = new JLabel("Delete Images After Moving");
		lblDeleteImagesAfter.setBounds(10, 247, 163, 14);
		frame.getContentPane().add(lblDeleteImagesAfter);
		
		JCheckBox chckbxYes = new JCheckBox("Yes");
		chckbxYes.setBounds(198, 242, 97, 23);
		frame.getContentPane().add(chckbxYes);
	}
}
