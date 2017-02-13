package main;

import java.util.ArrayList;

import guiResources.GuiKeyListener;
import imageIterator.AssignKeys;
import imageIterator.GetSourceInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This program will allow people to iterate through multiple images in order for them to
 *organize thier folders in a better and faster way.
 * @author JesusCDev
 */
public class Main {
    
    public static void main(String[] args){
        
    //GET FILES AND DESTINATIONS
        GetSourceInfo sourceInfo = new GetSourceInfo();
        //chose how many folder location's you would like
        AssignKeys keys = new AssignKeys();
        int arrowGoingToBeUsed = keys.assignArrowKeys();
        //Find out if you can delete pictures after moving them
        String delImagesAfterMove = sourceInfo.delPicturesInFolder();
        //assign keys to folder locations
        String[] paths = sourceInfo.getPathName(arrowGoingToBeUsed);
        //gets name of every file
        ArrayList<String> picturesSources = new ArrayList<>();
        picturesSources = sourceInfo.getNameOfFiles(paths[0]);
    //GET FILES AND DESTINATIONS
        
    //PRESENTS THE GUI WITH BUTTONS AND THE IMAGES
        GuiKeyListener guiControls = new GuiKeyListener();
        guiControls.startGui(delImagesAfterMove, picturesSources, paths, picturesSources.size());
    //PRESENTS TEH GUI WITH BUTTONS AND THE IMAGES
        
        System.out.println("Done");

    }
}