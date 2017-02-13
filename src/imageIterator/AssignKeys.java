/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageIterator;

import java.util.Scanner;

/**
 *Thsi class is used in order to prompt the user to show how many buttons they will be using
 *as hot keys. If the user express more then four keys or if the user express a number or letter
 *then i will allow the user to use at least one arrow as a hot key and every other arrow will be a delete button.
 *
 * @author JesusCDev
 */
public class AssignKeys {

	/**
	 * This class will prompt the user to see how many hotkeys they will be using
	 * @return
	 */
    public int assignArrowKeys() {
        System.out.print("How many keys will you be using?(1-4) EVeryother arrow not selected will function as a delete key." + "\n");
        @SuppressWarnings("resource")
		int numberOfKeys = new Scanner(System.in).nextInt();
        
        if(numberOfKeys == 0){
        	numberOfKeys = 1;
        	System.out.println("The Up arrow will be your only destination and all other arrows will be delete." + "\n");
        }else if(numberOfKeys > 4){
        	numberOfKeys = 4;
        	System.out.println("You are only limited to the 4 arrow keys." + "\n");
        }
        
        return numberOfKeys;
    }
}
