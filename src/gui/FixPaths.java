package gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import guiResources.GuiKeyListener;
import imageIterator.GetSourceInfo;

public class FixPaths {

	ArrayList<String> paths;
	int currentNumberInArray = 0;
	ArrayList<Path> pathsFixed = new ArrayList<Path>();
	
	FixPaths(ArrayList<String> paths){
		this.paths = paths;
	}

	public void changeToPaths() {
		String currentPath = paths.get(currentNumberInArray);
		while(!currentPath.equals("del")){
			Path pathMaker = Paths.get(currentPath);
			try {
				pathsFixed.add(pathMaker.toRealPath(LinkOption.NOFOLLOW_LINKS));
			} catch (IOException e) {
				e.printStackTrace();
			}
			currentNumberInArray++;
			currentPath = paths.get(currentNumberInArray);
		}
		System.out.println("NOT CREATED");
		
		for(int i = 0; i < pathsFixed.size(); i++){
			System.out.println("In For Loop");
			System.out.println(pathsFixed.toString());
			File directory = new File(pathsFixed.toString());
	        if (!directory.exists()){
	            directory.mkdirs();
	        }
		}
	}

	public void createGui(String delImagesAfterMove) {
        
        String[] pathsArray = new String[5];
        for(int i = 0; i < pathsFixed.size(); i++){
            pathsArray[i] = pathsFixed.get(i).toString() + "/";
        }
        for(int j = pathsFixed.size(); j < 5; j++){
        	pathsArray[j] = "del";
        }
        
        GetSourceInfo sourceInfo = new GetSourceInfo();
        //gets name of every file
        ArrayList<String> picturesSources = new ArrayList<>();
        picturesSources = sourceInfo.getNameOfFiles(pathsArray[0]);
    //GET FILES AND DESTINATIONS
        
    //PRESENTS THE GUI WITH BUTTONS AND THE IMAGES
        GuiKeyListener guiControls = new GuiKeyListener();
        guiControls.startGui(delImagesAfterMove, picturesSources, pathsArray, picturesSources.size());
		
	}
	
}
