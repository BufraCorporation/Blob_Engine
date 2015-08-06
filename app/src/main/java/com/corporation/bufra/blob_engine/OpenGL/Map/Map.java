package com.corporation.bufra.blob_engine.OpenGL.Map;

import com.corporation.bufra.blob_engine.OpenGL.shapes.Rectangle;

/**
 * Created by Marc on 05.08.2015.
 */

public class Map {
    Rectangle rectangleNull, rectangleOne, rectangleTwo, rectangleThree, rectangleFour, rectangleFive, rectangleSix, rectangleSeven, rectangleEight, rectangleNine, rectangleTen, rectangleEleven, rectangleTwelve, rectangleThirteen, rectangleFourteen;


    Rectangle rectangles[] = {rectangleNull, rectangleOne, rectangleTwo, rectangleThree, rectangleFour, rectangleFive, rectangleSix, rectangleSeven, rectangleEight, rectangleNine, rectangleTen, rectangleEleven, rectangleTwelve, rectangleThirteen, rectangleFourteen};


    public float mapDimension[] = {
            0.0f,   0.0f,
          500.0f, 500.0f

    };

    public Map() {
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
        return ((float)(Math.random()/2 ));
    }

    public void draw(boolean screenBorderCollision[], float xVel, float yVel) {

        for (Rectangle r : rectangles) {
            r.draw(true);
            }

        for (Rectangle r : rectangles) {
            r.setValues();
            if(screenBorderCollision[0]  &&!screenBorderCollision[4]){
                r.setValues(  -0.001f*xVel, 0f);
            }
            if(screenBorderCollision[2]  &&!screenBorderCollision[6]){
                r.setValues( -0.001f*xVel, 0f);
            }
            if(screenBorderCollision[1]  &&!screenBorderCollision[5]){
                r.setValues( 0f,  -0.001f*yVel);
            }
            if(screenBorderCollision[3]  &&!screenBorderCollision[7]){
                r.setValues( 0f,  -0.001f*yVel);
            }
        }

    }


    public Rectangle[] getRectangles() {
        return rectangles;
    }
}
