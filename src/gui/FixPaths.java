package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import guiResources.GuiKeyListener;
import imageIterator.GetSourceInfo;

public class FixPaths {

	ArrayList<String> paths;
	int currentNumberInArray = 0;
	ArrayList<Path> pathsFixed;
	
	FixPaths(ArrayList<String> paths){
		this.paths = paths;
	}

	public void changeToPaths() {
		String currentPath = paths.get(currentNumberInArray);
		while(currentPath != null){
			Path pathMaker = Paths.get(currentPath);
			pathsFixed.add(pathMaker);
			currentNumberInArray++;
			currentPath = paths.get(currentNumberInArray);
		}
		for(int i = 0; i < pathsFixed.size(); i++){
			if(!Files.exists(pathsFixed.get(i))){
				try {
					Files.createDirectories(pathsFixed.get(i));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void createGui(String delImagesAfterMove) {
        GetSourceInfo sourceInfo = new GetSourceInfo();
        //gets name of every file
        ArrayList<String> picturesSources = new ArrayList<>();
        picturesSources = sourceInfo.getNameOfFiles(pathsFixed.get(0).toString());
    //GET FILES AND DESTINATIONS
        
        String[] pathsArray = new String[5];
        for(int i = 0; i < pathsFixed.size(); i++){
            pathsArray[i] = pathsFixed.get(i).toString();
        }
        for(int j = pathsFixed.size(); j < 5; j++){
        	pathsArray[j] = "del";
        }
        
    //PRESENTS THE GUI WITH BUTTONS AND THE IMAGES
        GuiKeyListener guiControls = new GuiKeyListener();
        guiControls.startGui(delImagesAfterMove, picturesSources, pathsArray, picturesSources.size());
		
	}
	
}
