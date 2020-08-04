package org.allvens.assets;

import java.util.prefs.Preferences;

public interface Constants_Prefs {
    Preferences prefs = Preferences.userRoot();

    /********** Boolean Values **********/
    String PREF_Boolean_FirstTimeUsingApp = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_FirstTimeUsingApp"; // tracts installation of project
    String PREF_Boolean_DeleteValue = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_DeleteMainPicturesValue"; // tracts value if images should be deleted or not

    /********** Main Container **********/
    String PREF_String_ProjectFolder = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_ProjectFolder"; // Folder where project is held
    String PREF_String_MainPath = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_MainPath"; // folder where images are stored

    /********** Arrow Paths **********/
    String PREF_String_UpArrowPath = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_upArrowPath"; // up arrow path
    String PREF_String_DownArrowPath = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_downArrowPath"; // down arrow path
    String PREF_String_LeftArrowPath = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_leftArrowPath"; // left arrow path
    String PREF_String_RightArrowPath = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_rightArrowPath"; // right arrow path

    /********** Screens **********/
    String PREF_SV_ScreenMax = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_MaxScreen"; // screen max change
    String PREF_SV_ScreenWidth = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_ScreenWidth"; // screen width
    String PREF_SV_ScreenHeight = "pref_sv_Image-Iterator_Key-FdGS7*(*s%fFA[2_ScreenHeight"; // screen height
}
