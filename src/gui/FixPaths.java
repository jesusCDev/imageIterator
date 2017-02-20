package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
	
}
