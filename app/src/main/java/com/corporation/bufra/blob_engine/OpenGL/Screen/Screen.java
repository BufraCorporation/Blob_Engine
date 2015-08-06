package com.corporation.bufra.blob_engine.OpenGL.Screen;


import com.corporation.bufra.blob_engine.OpenGL.Map.Map;
import com.corporation.bufra.blob_engine.OpenGL.shapes.Rectangle;
import com.corporation.bufra.blob_engine.OpenGL.shapes.figures.MainFigure;

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

    public float mapCoordinates[] = {
            0.0f, 0.0f
    };

    public Screen(){

        mainChar = new MainFigure(0.1f, 0.05f, -0.1f, -0.05f);
        map = new Map();

    }

    private float randomFull(){
        return ((float)(Math.random()*2 - 1));
    }

    private float randomFullDistance(){
        return ((float)(Math.random()/10 ));
    }

    public void renderScreen(float xAng, float yAng){

        mainChar.draw(true);

        rectangles = map.getRectangles();
        screenBorderCollision = mainChar.setValues(rectangles, 0.001f * xAng, 0.001f * yAng);

        mainChar.draw(true);

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

