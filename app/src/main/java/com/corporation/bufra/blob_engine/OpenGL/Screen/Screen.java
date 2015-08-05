package com.corporation.bufra.blob_engine.OpenGL.Screen;


import com.corporation.bufra.blob_engine.OpenGL.shapes.Rectangle;
import com.corporation.bufra.blob_engine.OpenGL.shapes.figures.MainFigure;

/**
 * Created by Marc on 05.08.2015.
 */
public class Screen {

    Rectangle rectangleNull, rectangleOne, rectangleTwo, rectangleThree, rectangleFour, rectangleFive, rectangleSix, rectangleSeven, rectangleEight, rectangleNine, rectangleTen, rectangleEleven, rectangleTwelve, rectangleThirteen, rectangleFourteen;
    Rectangle rectangles[] = {rectangleNull, rectangleOne, rectangleTwo, rectangleThree, rectangleFour, rectangleFive, rectangleSix, rectangleSeven, rectangleEight, rectangleNine, rectangleTen, rectangleEleven, rectangleTwelve, rectangleThirteen, rectangleFourteen};
    MainFigure mainChar;
    boolean screenBorderCollision[] = {false, false, false, false};

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

        float x1,x2;

        x1 = randomFull();
        x2 = randomFull();
        rectangleNull = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleOne = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleTwo = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleThree = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleFour = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleFive = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleSix = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleSeven = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleEight = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleNine = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleTen = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleEleven = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleTwelve = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleThirteen = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        x1 = randomFull();
        x2 = randomFull();
        rectangleFourteen = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());

        rectangles[0] = rectangleNull;
        rectangles[1] = rectangleOne;
        rectangles[2] = rectangleTwo;
        rectangles[3] = rectangleThree;
        rectangles[4] = rectangleFour;
        rectangles[5] = rectangleFive;
        rectangles[6] = rectangleSix;
        rectangles[7] = rectangleSeven;
        rectangles[8] = rectangleEight;
        rectangles[9] = rectangleNine;
        rectangles[10] = rectangleTen;
        rectangles[11] = rectangleEleven;
        rectangles[12] = rectangleTwelve;
        rectangles[13] = rectangleThirteen;
        rectangles[14] = rectangleFourteen;

    }

    private float randomFull(){
        return ((float)(Math.random()*2 - 1));
    }

    private float randomFullDistance(){
        return ((float)(Math.random()/10 ));
    }

    public void renderScreen(float xAng, float yAng){

        mainChar.draw(true);

        for (Rectangle r : rectangles) {
            r.draw(true);

        }

       screenBorderCollision = mainChar.setValues(rectangles, 0.001f * xAng, 0.001f * yAng);

        mainChar.draw(true);
        for (Rectangle r : rectangles) {
            r.setValues();
            if(screenBorderCollision[0]){
                r.setValues(  0.004f, 0f);
            }
            if(screenBorderCollision[2]){
                r.setValues( -0.004f, 0f);
            }
            if(screenBorderCollision[1]){
                r.setValues( 0f,  0.004f);
            }
            if(screenBorderCollision[3]){
                r.setValues( 0f, -0.004f);
            }

        }

        screenBorderCollision[0] = false;
        screenBorderCollision[1] = false;
        screenBorderCollision[2] = false;
        screenBorderCollision[3] = false;
    }


}

