package org.allvens.assets;

public interface Constants {

    /********** Folder Names **********/
    String FOLDER_ImageIterator = "Image Iterator";
	String TEMP_FOLDER  = "tempImageKeeper";

    /********** Window Titles **********/
    String WINDOW_TITLE_Installer = "Installer";
    String WINDOW_TITLE_Main = "Home";
    String WINDOW_TITLE_ImageView = "Image View";

    /********** File LInks **********/
	String FILE_FXML_Installer = "Installer.fxml";
	String FILE_FXML_Home = "home.fxml";
	String FILE_FXML_ImageViewer = "image_viewer.fxml";
	String FILE_CSS_DefaultStyles = "styles.css";

    /********** Default Sizes **********/
    double DEFAULT_WINDOW_INSTALLER_WIDTH = 800;
    double DEFAULT_WINDOW_INSTALLER_HEIGHT= 600;
    double DEFAULT_TOAST_WIDTH = 500.0;
    double DEFAULT_TOAST_HEIGHT = 300.0;

    /********** Image Loader Strings **********/
	String fileExtension = "file:";
	String imageIconLink = "Image_Organizer_icon_transparent.png";

    /********** Key Words **********/
	String TOAST_MESSAGE_OKAY = "Okay";
    String SYMBOL_Underscore = "_";
	char SYMBOL_BackSlash =  '/';
	char SYMBOL_FrontSlash = '\\';
	String KEY_WORD_DelKeyword = "del";
	String KEY_WORD_MoveOn = "movedOn";
	String KEY_WORD_No = "No";
	String KEY_WORD_Yes = "Yes";
	String KEY_WORD_Space = " ";
	String KEY_WORD_Empty = "";

    /********** Image Extensions **********/
	String EXTENSION_gif = "gif";
	String EXTENSION_jpg = "jpg";
	String EXTENSION_jpeg = "jpeg";
	String EXTENSION_png = "png";
	String EXTENSION_PNG = "PNG";

    /********** User Report Text **********/
    String TEXT_TITLE_SelectedFolderDidntWork = "Error";
    String TEXT_MESSAGE_SelectedFolderDidntWork = "Selected Folder Did Not Work, Please Select A Different Location.";

    String TEXT_TITLE_Error = "Error";
    String TEXT_MESSAGE_FileChooserCanceled = "No File Picked";
    String TEXT_MESSAGE_FileChooserError = "An Error Has Occurred";
    String TEXT_TITLE_NoMoreImages = "Stop";
    String TEXT_MESSAGE_NoMoreImages = "No more images to undo.";
    String TEXT_TITLE_NoImageInFolder = "Problem";
    String TEXT_MESSAGE_NoImageInFolder = "There are no images in the current selected folder.";
    String TEXT_TITLE_HelpfulTips = "Helpful Tips";
    String TEXT_MESSAGE_HelpfulHomeTips = "- If a folder doesn't exit, it will be automatically created." + "\n" +
            "- If you type a '/' and a name it will assume you want to create(or it resides) in the main folder.";
    String TEXT_MESSAGE_HelpfulImageViewTips = "- You can resize the images scrolling either up or down." + "\n" +
            "- If Images get stuck when fully expanding the window and shrinking it, resize the window manually till image responds.(quick fix for now)"  + "\n" +
            "- You can also use the W-A-S-D keys as the up, down, left, and right keys." + "\n" +
            "- Q key will allow user to undo last action." + "\n" +
            "- E key will allow user to skip image without any actions applied to it." + "\n" +
            "- Scrolling on image will allow user to zoom in and zoom out.";
    String TEXT_TITLE_Done = "Done";
    String TEXT_MESSAGE_Done = "Done Moving Images, any images in folder left are not in supported formats.";
}
