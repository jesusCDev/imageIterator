package guiResources;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Thsi class will mainly hangle with listening to the keystrokes of the keyboard and act depending on the keys that are being pressed
 * @author JesusCDev
 *
 */
public class GuiKeyListener implements KeyListener {

	//TODO fix so that the first picture is the main title but does not count when being placed and moves to next picture
	GuiSources createGui;
	boolean spaceBarClicked = false;
	/**
	 * This class is basically incharge of creating the Gui and passing on info
	 * @param picturesSources this is passing in the the picture ids found in the folder
	 * @param paths this is passing along the paths that belong to locations the user chose if not just setting them to dele
	 * @param imagesInFolder this will keep track of how many images there are left so you dont go overboard
	 */
	public void startGui(String delPicturesAfterMove, ArrayList<String> picturesSources, String[] paths, int imagesInFolder){
		createGui = new GuiSources();
		createGui.setImageSources(delPicturesAfterMove, picturesSources, paths, imagesInFolder);
		createGui.addKeyListener(this);
		createGui.createFrame();
		
	}
	
	/**
	 * This class will give the key press a function to do when clicked on
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_SPACE){
			createGui.startApplication();
			spaceBarClicked = true;
		}else if(keyCode == KeyEvent.VK_ESCAPE){
			createGui.setVisible(false);
		}else if(keyCode == KeyEvent.VK_UP && spaceBarClicked == true){
			createGui.upCick();
		}else if(keyCode == KeyEvent.VK_DOWN && spaceBarClicked == true){
			createGui.downClick();
		}else if(keyCode == KeyEvent.VK_LEFT && spaceBarClicked == true){
			createGui.leftClick();
		}else if(keyCode == KeyEvent.VK_RIGHT && spaceBarClicked == true){
			createGui.rightClick();
		}
	}

	/**
	 * this class is useless since i wont be doing anything after they are clicked
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		e.consume();
	}
	
	/**
	 * this class is useless since i wont be doing anything after they are clicked 
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
	}

}
