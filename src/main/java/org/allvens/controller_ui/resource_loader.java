package org.allvens.controller_ui;

import org.allvens.assets.Constants;

import java.io.File;
import java.io.InputStream;

/**
 * Loads resources that are included in the jar file
 */
final public class resource_loader implements Constants {

	public static InputStream load(String path){
		InputStream input = resource_loader.class.getResourceAsStream(path);
		if(input == null){
			resource_loader.class.getResourceAsStream(File.separator + path);
		}
		return input;
	}
}

