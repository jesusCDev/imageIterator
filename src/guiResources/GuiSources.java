/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiResources;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 *
 * @author JesusCDev
 */


@SuppressWarnings("serial")
public class GuiSources extends JFrame
{
    private ImageIcon beginingImage = new ImageIcon ("imageIterator.png");
    JPanel ImageGallery = new JPanel();
    private ImageIcon[] myImages = new ImageIcon[4];
    private int curImageIndex=0;
    private int imagesInFolder;
    
    private ArrayList<String> picturesSources;
    private String delPicturesAfterMove;
    private String rootPath;
    private String upPath;
    private String downPath;
    private String leftPath;
    private String rightPath;
    
    /**
     * This class will just start off the frame with the basics and tells it where to put it and what to add
     */
    public GuiSources ()
        {   
            ImageGallery.add(new JLabel (beginingImage));
            myImages[0]=beginingImage;

            add(ImageGallery, BorderLayout.NORTH);

            JPanel Menu = new JPanel();
            Menu.setLayout(new GridLayout(1,4));

            add(Menu, BorderLayout.SOUTH);

        }
    
    /**
     * This class creates the frame and gives it its details
     */
    public void createFrame()
    {
        this.setSize(1334,750);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    /**
     * This class moves to the next image after the current one has been delt wtih
     * will close the window if we run out of images
     */
    private void moveToNextFile()
    {
    	ImageGallery.remove(0);
        curImageIndex = curImageIndex + 1;
        
        if(curImageIndex != imagesInFolder)
        {
            ImageIcon nextImage = new ImageIcon(rootPath + picturesSources.get(curImageIndex));
            ImageGallery.add(new JLabel (nextImage));
            ImageGallery.validate();
            ImageGallery.repaint(); 
        }
        else
        {
        	this.setVisible(false);
        	System.out.println("\n" + "Done. Have a good day. :D");
        }
    }
    
    /**
     * This sets the sources of the image, the paths, and whether or not thee iamge should be deleted so this class has access to them
     * @param delPicturesAfterMove whether or not the image should be deleted
     * @param picturesSources name of all the images in the foldedr
     * @param paths the paths where the imares are and where to put them
     * @param imagesInFolder hwo many images are in the folder
     */
    public void setImageSources(String delPicturesAfterMove, ArrayList<String> picturesSources, String[] paths, int imagesInFolder)
    {	
    	this.delPicturesAfterMove = delPicturesAfterMove;
    	this.picturesSources = picturesSources;
    	this.imagesInFolder = imagesInFolder;
    	
    	rootPath = paths[0];
    	upPath = paths[1];
    	downPath = paths[2];
    	leftPath = paths[3];
    	rightPath = paths[4];
    }
    
    /**
     * This class will move the image to a different folder
     * @param newPath the folder that the image will be moved to
     * @param imagePath the folder the image is currently in
     */
    private void moveImage(String newPath, String imagePath)
    {
    	try
    	{
			InputStream input = new FileInputStream(imagePath);
			FileOutputStream output = new FileOutputStream(newPath);
		
		//MOVING IMAGE
			byte[] buf = new byte[1024];
			int bytesRead;
			
			while((bytesRead = input.read(buf)) > 0)
			{
				output.write(buf, 0, bytesRead);
			}
		//MOBING IMAGE
			
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//deletes the imgae if that is what the user wanted
    	if(delPicturesAfterMove.equalsIgnoreCase("Y"))
    	{
    		delImage(imagePath);
    	}
    }
    
    /**
     * will delete the image
     * @param imageToDeletePath the path to delete the image
     */
    public void delImage(String imageToDeletePath)
    {
    	File imageToDelete = new File(imageToDeletePath);
    	imageToDelete.delete();
    }
    
    /**
     * will activate when the up arrow is clicked
     * will either move the image, or delete it
     */
    public void upCick()
    {
    	if(upPath.equals("del"))
    	{
    		delImage((rootPath + picturesSources.get(curImageIndex)));
    	}
    	else
    	{
    		moveImage((upPath + picturesSources.get(curImageIndex)), (rootPath + picturesSources.get(curImageIndex)));
    	}
    	moveToNextFile();
    }
    
    /**
     * will activate when the down arrow is clicked
     * will either move the image, or delete it
     */
    public void downClick()
    {
    	if(downPath.equals("del")){
    		delImage((rootPath + picturesSources.get(curImageIndex)));
    	}
    	else
    	{
    		moveImage((downPath + picturesSources.get(curImageIndex)), (rootPath + picturesSources.get(curImageIndex)));
    	}
    	moveToNextFile();
    }
    
    /**
     * will activate when the left arrow is clicked
     * will either move the image, or delete it
     */
    public void leftClick(){
    	if(leftPath.equals("del")){
    		delImage((rootPath + picturesSources.get(curImageIndex)));
    	}else{
    		moveImage((leftPath + picturesSources.get(curImageIndex)), (rootPath + picturesSources.get(curImageIndex)));
    	}
    	moveToNextFile();
    }
    
    /**
     * will activate when the right arrow is clicked
     * will either move the image, or delete it
     */
    public void rightClick(){
    	if(rightPath.equals("del")){
    		delImage((rootPath + picturesSources.get(curImageIndex)));
    	}else{
    		moveImage((rightPath + picturesSources.get(curImageIndex)), (rootPath + picturesSources.get(curImageIndex)));
    	}
    	moveToNextFile();
    }
    
    /**
     * This will allow you to start the app and let you see the first image rather then get rid of it
     */
    public void startApplication(){
    	
    	ImageGallery.remove(0);
    	ImageIcon nextImage = new ImageIcon(rootPath + picturesSources.get(curImageIndex));
    	ImageGallery.add(new JLabel (nextImage));
    	ImageGallery.validate();
    	ImageGallery.repaint(); 
        
    }
}