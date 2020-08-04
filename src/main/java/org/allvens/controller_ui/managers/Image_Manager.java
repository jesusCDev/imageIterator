package org.allvens.controller_ui.managers;

import org.allvens.assets.Constants;
import org.allvens.assets.Constants_Prefs;
import org.allvens.controller_ui.deafult_methods.ui_feedback.Toast;

import java.io.*;
import java.util.ArrayList;

public class Image_Manager implements Constants, Constants_Prefs {

    private String projectTempPath;

    private String mainPath;
    private String upArrowPath;
    private String downArrowPath;
    private String leftArrowPath;
    private String rightArrowPath;

    private boolean delMainPictures;

    private ArrayList<String> imagesInFolder;
    private String[] fileActionSavor;

    private int curImageIndex = 0;
    private int fullCountOfImagesInFolder;
    private String currentImageName;

    public int getFullCountOfImagesInFolder(){
        return fullCountOfImagesInFolder;
    }

    public Image_Manager(){
        projectTempPath = ((prefs.get(PREF_String_ProjectFolder, "") + TEMP_FOLDER + File.separator));
        File f = new File(projectTempPath);
        if(!f.exists()){
            f.mkdirs();
        }
    }

    /********** Image Source Methods **********/
    public void setImageSources() {
        mainPath = prefs.get(PREF_String_MainPath, null);
        
        upArrowPath = prefs.get(PREF_String_UpArrowPath, null);
        downArrowPath = prefs.get(PREF_String_DownArrowPath, null);
        leftArrowPath = prefs.get(PREF_String_LeftArrowPath, null);
        rightArrowPath = prefs.get(PREF_String_RightArrowPath, null);

        delMainPictures = prefs.getBoolean(PREF_Boolean_DeleteValue, true);
    }


    public void setImages(ArrayList<String> imagesInFolder){
        this.imagesInFolder = imagesInFolder;
        fullCountOfImagesInFolder = imagesInFolder.size();

        currentImageName = imagesInFolder.get(curImageIndex);
        fileActionSavor = new String[imagesInFolder.size()];
    }

    /**
     * This class gets the images from the folder
     * @param path
     */
    public ArrayList<String> getImagesFromFolder(String path){
        File[] listOfFiles = new File(path).listFiles();
        ArrayList<String> picturesSources = new ArrayList<>();
        try {
            for (File f : listOfFiles) {
                if (f.isFile()) {
                    //saves files if they have these extentions to an arraylist
                    if (f.getName().endsWith(EXTENSION_jpeg) || f.getName().endsWith(EXTENSION_jpg) ||
                            f.getName().endsWith(EXTENSION_gif) || f.getName().endsWith(EXTENSION_png) || f.getName().endsWith(EXTENSION_PNG)) {
                        picturesSources.add(f.getName());
                        fullCountOfImagesInFolder++;
                    }
                } else if (f.isDirectory()) {
                    // Maybe Do Something Later On With The Directories
                }
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return picturesSources;
    }

    /********** Image Actions **********/
    /**
     * Moves to next image
     *  - tells user when they are done
     */
    private void moveToNextImage() {
        curImageIndex++;

        if(fullCountOfImagesInFolder == curImageIndex){
            new Toast().showMessage(TEXT_MESSAGE_Done, TEXT_TITLE_Done);
        }

        currentImageName = imagesInFolder.get(curImageIndex);
    }

    /**
     * Empties Folder with any extra files
     */
    public void emptyTempFolder(){
        File index = new File(projectTempPath);
        try{
            for(String s: index.list()){
                File currentFile = new File(index.getPath() ,s);
                currentFile.delete();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    /**
     * Skips to the next image in array
     */
    public void leaveImageAlone(){
        fileActionSavor[curImageIndex] = KEY_WORD_MoveOn;
        moveToNextImage();
    }

    /**
     * Moves Image To New Path
     * @param newPath - Path to move to
     * @param imagePath - Path of moving Item
     * @param called -
     * @param imageName - Name Of Image
     */
    private void moveImage(String newPath, String imagePath, String called, String imageName) {
        try {
            InputStream input = new FileInputStream(imagePath);
            FileOutputStream output = new FileOutputStream(newPath);

            byte[] buf = new byte[1024];
            int bytesRead;

            while((bytesRead = input.read(buf)) > 0)
            {
                output.write(buf, 0, bytesRead);
            }

            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(delMainPictures && !called.equals(KEY_WORD_Yes)) {
            delImage(imagePath, imageName);
        }
    }
    
    /**
     * will delete the image
     * @param imageToDeletePath the path to delete the image
     */
    public void delImage(String imageToDeletePath, String imageName) {
        moveImage((projectTempPath + File.separator + imageName), imageToDeletePath, KEY_WORD_Yes, imageName);
        File imageToDelete = new File(imageToDeletePath);
        imageToDelete.delete();
    }

    /**
     * Undoes last action performed by user
     */
    public void undoLastAction(){
        curImageIndex--;
        if(curImageIndex < 0){
            curImageIndex++;
            new Toast().showMessage(TEXT_MESSAGE_NoMoreImages, TEXT_TITLE_NoMoreImages);
        }else if((!fileActionSavor[curImageIndex].equals(KEY_WORD_DelKeyword)) && !fileActionSavor[curImageIndex].equals(KEY_WORD_MoveOn)){
            moveImage((mainPath + imagesInFolder.get(curImageIndex)), (fileActionSavor[curImageIndex]), KEY_WORD_No, imagesInFolder.get(curImageIndex));
            curImageIndex--;
            moveToNextImage();
        }else if(fileActionSavor[curImageIndex].equals(KEY_WORD_DelKeyword)){
            moveImage((mainPath + imagesInFolder.get(curImageIndex)), (projectTempPath + File.separator + imagesInFolder.get(curImageIndex)), KEY_WORD_No, imagesInFolder.get(curImageIndex));
            curImageIndex--;
            moveToNextImage();
        }else{
            curImageIndex--;
            moveToNextImage();
        }
    }

    /**
     * Move Image depending on the values
     * @param path
     */
    public void moveImage(String path){
        if(path.equals(KEY_WORD_DelKeyword)){
            delImage((mainPath + imagesInFolder.get(curImageIndex)), imagesInFolder.get(curImageIndex));
            fileActionSavor[curImageIndex] = KEY_WORD_DelKeyword;
        }else{
            moveImage((path + imagesInFolder.get(curImageIndex)), (mainPath + imagesInFolder.get(curImageIndex)), KEY_WORD_No, imagesInFolder.get(curImageIndex));
            fileActionSavor[curImageIndex] = (path + imagesInFolder.get(curImageIndex));
        }
        moveToNextImage();
    }

    /********** Getter Methods **********/
    public String getMainPath(){
        return mainPath;
    }

    public String getUpArrowPath(){
        return upArrowPath;
    }

    public String getDownArrowPath(){
        return downArrowPath;
    }

    public String getLeftArrowPath(){
        return leftArrowPath;
    }

    public String getRightArrowPath(){
        return rightArrowPath;
    }

    public String getCurrentImageIndex(){
        return Integer.toString(curImageIndex);
    }

    public String getCurrentImageName(){
        return currentImageName;
    }

    public String getCurrentImagePath(){
        return mainPath + currentImageName;
    }
}
