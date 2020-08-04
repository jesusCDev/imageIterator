# Image Iterator
## Purpose
This app is for people who have a folders of clutterd images who want to get organize and free up some space.
## Page Selector
- Top
  - A Label with the main folder position is presented here.
- Middle
  - The main image being affected is shown in the middle.
  - "Undo" button alows user to undo the last move and go back to the last image.
  - "Do Not Move" button allows user to leave the current image alone and move on to the next one.
- Bottom
  - A Label showing how many images have been moved, and how many images are left to move.
  - Labels that show the arrow keys folder destination.
## How To Use
1. Type in the first text box the position of the unorganized images.
2. Click on the amount of folders you would like to use by clicking one of the radio buttons.
3. Click on this checkbox to decided whether the moving images will be deleted or not.
4. Type in the names of the folders you would like to put these images in.
      - You can just add a backslash and write the name of a folder and it will create the folder in the same directory it is in
      - Cannot move on till all text boxes are filled
5. Click submit button
6. Now you should be in a new page, click the button "Click To Start" to begin.
7. The current image showing is the one going to be affected.
8. Use arrow keys to direct the images to the folder they are pointing at.
      - Any images who are not directed to a folder, or ignored will be deleted.
## How to Run
Running through terminal
```
javac Main.java
java Main.class
```
You can always compile it as a runable jar file
## Future Updates
- Better design aesthetics
- Better way for user to find path with images
- Maybe multiple keys
## Requirements
- Java 8 Enviorment
