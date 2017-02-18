/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageIterator;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *This class will get the direction of the folder's where
 * the pictures are and where to put them, if they put del, the arrow key's will be used as delete keys
 * @author JesusCDev
 */
public class GetSourceInfo {
    
	/**
	 * Gets the users folder destinations depending on how many arrows they have selected to use.
	 * @param arrowGoingToBeUsed passing in the amount of arrow keys they will be using
	 * @return retuns the paths that have been piced
	 */
    public String[] getPathName(int arrowGoingToBeUsed){
        String[] pathNames = new String[5];
        Scanner keyboard = new Scanner(System.in);
        
        //Value for the main folder for where the images will be iterated through
        System.out.print("Please type the path where your images are being stored." + "\n");
        String path;
        path = keyboard.nextLine();
        //fixes path
        pathNames[0] = fixPath(path);
        
        //allows to put your folder destination to the arrow
        if(arrowGoingToBeUsed >= 1){
            System.out.print("Please type in file path name for arrow pointing up." + "\n");
            path = keyboard.nextLine();
            pathNames[1] = fixPath(path);
            doFilesExist(pathNames[1]);
            if(arrowGoingToBeUsed >= 2){
                System.out.print("Please type in file path name for arrow pointing down." + "\n");
                path = keyboard.nextLine();
                pathNames[2] = fixPath(path);
                doFilesExist(pathNames[2]);
                if(arrowGoingToBeUsed >= 3){
                    System.out.print("Please type in file path name for arrow porinting left." + "\n");
                    path = keyboard.nextLine();
                    pathNames[3] = fixPath(path);
                    doFilesExist(pathNames[3]);
                    if(arrowGoingToBeUsed >= 4){
                        System.out.print("Please type in file path name for arrow pointing right." + "\n");
                        path = keyboard.nextLine();
                        pathNames[4] = fixPath(path);
                        doFilesExist(pathNames[4]);
                    }
                }
            }
        }

        System.out.println(pathNames[0]);
        System.out.println(pathNames[1]);
        
        //goes through the keys that were'nt picked and puts dele in them to be used as a dele hotkey
        for(int i = (arrowGoingToBeUsed + 1); i < 5; i++){
        	pathNames[i] = "del";
        }
        keyboard.close();
        
        return pathNames;
    }
    
    /**
     * This class will fix the pat you put by putting in the slash marks
     * @param path
     * @return
     */
    private String fixPath(String path){


        ArrayList<Integer> backlashPoints = new ArrayList<>();
        
        //finds destination of the slash 
        for(int i = 0; i < path.length(); i++){
                if(path.charAt(i) == '\\'){
                    backlashPoints.add(i);
                }
            }
        
        //adds multiple slashes to each slash location found
        boolean skip = false; 
        StringBuilder fixedPathTwo = new StringBuilder();
        
        for(int i = 0; i < path.length(); i++){
            for(int j = 0; j < backlashPoints.size(); j++){
                if(i == backlashPoints.get(j)){
                    fixedPathTwo.append("\\\\");
                    skip = true;
                }
            }
            if(skip != true){
                fixedPathTwo.append(path.charAt(i));
            }
            skip = false;
        }
        
        //adds backslashes incase user wont put the slashes himself
        if(fixedPathTwo.substring((fixedPathTwo.length() - 1)) != "\\"){
        	fixedPathTwo.append("\\\\");
        }
        return fixedPathTwo.toString();
    }
    
    /**
     * This will check if the file exist. If it shows that it does nto exist, it will try 
     * to create the folder to the given destination.
     * @param path passes in the path that it will be trying to create
     */
    private void doFilesExist(String path){
    	File directory = new File(String.valueOf(path));
        if (!directory.exists()){
            directory.mkdirs();
        }
    }
    
    /**
     * This class will get the names of the images in the folder
     * @param path
     * @return
     */
    public ArrayList<String> getNameOfFiles(String path){
        
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> picturesSources = new ArrayList<>();
        
        //prints out if there are any directories
        System.out.println("\n" + "These are the exisisting directories in this folder.");
        for(int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
        	  //saves files if they have these extentions to an arraylist
        	  if(listOfFiles[i].getName().endsWith("jpg") == true || listOfFiles[i].getName().endsWith("gif") == true || listOfFiles[i].getName().endsWith("png") == true){
                  picturesSources.add(listOfFiles[i].getName());
        	  }
          } else if (listOfFiles[i].isDirectory()) {
            System.out.println("Directory " + listOfFiles[i].getName());
          }
        }
        System.out.println();
        
        return picturesSources;
    }

    /**
     * This class will prompt the user to see if they would like to have thier pictures deleted after they have been moved or not
     * @return
     */
    public String delPicturesInFolder(){
    	System.out.println("\n" + "Do you want to delete the images after they have been moved to your folder? (Y/N)" + "\n");
    	@SuppressWarnings("resource")
		String answer = new Scanner(System.in).nextLine();
    	return answer;
    }
}
