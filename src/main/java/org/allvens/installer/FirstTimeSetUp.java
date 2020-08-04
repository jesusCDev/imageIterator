package org.allvens.installer;

import org.allvens.assets.Constants;
import org.allvens.assets.Constants_Prefs;
import org.allvens.controller_ui.deafult_methods.FileFixer;

import java.io.File;

public class FirstTimeSetUp implements Constants_Prefs {

    /**
     * Creates main Folder Where Project And Any Files Related To It Will Remain
     * @param mainFileLocation
     * @return
     */
    public boolean createFolderForProject(String mainFileLocation){
        File f = new File(mainFileLocation);
        return f.mkdir();
    }

    public void setMainPathValue(String mainFileLocation){
        prefs.put(PREF_String_MainPath, mainFileLocation);
    }

    public void setFirstTimePref(boolean value){
        prefs.putBoolean(PREF_Boolean_FirstTimeUsingApp, value);
    }

    /********** main Path Fixer **********/

    /**
     * Creates main Path
     * @param filePath
     * @return
     */
    public String fixFilePath(String filePath){
        FileFixer ff = new FileFixer();
        return ff.fixDuplicatesPath((ff.fixBackFrontSlash(filePath) + Constants.FOLDER_ImageIterator + File.separator));
    }
}
