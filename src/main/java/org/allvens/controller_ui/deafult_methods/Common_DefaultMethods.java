package org.allvens.controller_ui.deafult_methods;

import org.allvens.assets.Constants_Prefs;

/**
 * Resets Project Data To Default
 */
public class Common_DefaultMethods implements Constants_Prefs {

    /**
     * Resets values at the end of every session
     */
    public void resetValues(){
        prefs.put(PREF_SV_ScreenHeight, "600");
        prefs.put(PREF_SV_ScreenWidth, "400");
    }

    /**
     * Resets values if app is hard reset
     */
    public void hardRest(){
    }

    /**
     * Resets pref value
     * @param prefID - pref id
     * @param value - pref value
     */
    private void resetPrefValues(String prefID, String value){
        prefs.put(prefID, value);
    }

    /**
     * Resets pref value
     * @param prefID - pref id
     * @param value - pref boolean value
     */
    private void resetBooleanPrefValue(String prefID, boolean value){
        prefs.putBoolean(prefID, value);
    }
}
