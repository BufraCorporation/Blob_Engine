package com.corporation.bufra.blob_engine.OpenGL.Screen;


import com.corporation.bufra.blob_engine.Global.BlobConstants;
import com.corporation.bufra.blob_engine.OpenGL.Map.Map;
import com.corporation.bufra.blob_engine.OpenGL.shapes.Rectangle;
import com.corporation.bufra.blob_engine.OpenGL.shapes.figures.MainFigure;

import java.sql.Blob;

/**
 * Created by Marc on 05.08.2015.
 */
public class Screen {

    Rectangle rectangles[];
    MainFigure mainChar;
    Map map;
    boolean screenBorderCollision[] = {false, false, false, false, false, false, false, false};

    //  Xxxoooooooooooooooooooooooooooooo
    //  xxxoooooooooooooooooooooooooooooo
    //  xxxoooooooooooooooooooooooooooooo
    //  ooooooooooooooooooooooooooooooooo
    //  ooooooooooooooooooooooooooooooooo
    //  ooooooooooooooooooooooooooooooooo
    //  ooooooooooooooooooooooooooooooooo
    //  ooooooooooooooooooooooooooooooooo
    //  ooooooooooooooooooooooooooooooooo
    //  ooooooooooooooooooooooooooooooooo
    //  ooooooooooooooooooooooooooooooooo
    /* Coordinates of X */

     public Screen(){
         //Generate the MainFigure
        mainChar = new MainFigure(0.1f, 0.05f, -0.1f, -0.05f);
         //Generate the Map
        map = new Map();

    }

    public void renderScreen(float xAng, float yAng){
        //Draw the Character
        mainChar.draw(true);

        //get Rectangles on Screen
        rectangles = map.getRectangles();

        //calculate Rectangles on Screen
        screenBorderCollision = mainChar.setValues(rectangles, xAng * BlobConstants.Magic_Movement_X, yAng * BlobConstants.Magic_Movement_Y);




        map.draw(screenBorderCollision, xAng, yAng);


        screenBorderCollision[0] = false;
        screenBorderCollision[1] = false;
        screenBorderCollision[2] = false;
        screenBorderCollision[3] = false;
        screenBorderCollision[4] = false;
        screenBorderCollision[5] = false;
        screenBorderCollision[6] = false;
        screenBorderCollision[7] = false;


    }


}

