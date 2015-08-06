package com.corporation.bufra.blob_engine.OpenGL.Map;

import com.corporation.bufra.blob_engine.Global.BlobConstants;
import com.corporation.bufra.blob_engine.OpenGL.shapes.Rectangle;
import com.corporation.bufra.blob_engine.OpenGL.Map.Elements.Shares;
/**
 * Created by Marc on 05.08.2015.
 */

public class Map {
    Rectangle rectangleNull, rectangleOne, rectangleTwo, rectangleThree, rectangleFour, rectangleFive, rectangleSix, rectangleSeven, rectangleEight, rectangleNine, rectangleTen, rectangleEleven, rectangleTwelve, rectangleThirteen, rectangleFourteen;


    Rectangle rectangles[] = new Rectangle[15];

    Shares shares[][] = new Shares[((int)(BlobConstants.MAP_HEIGHT/BlobConstants.SHARE_HEIGHT))][((int)(BlobConstants.MAP_LENGTH/BlobConstants.SHARE_LENGTH))];

    public float mapDimension[] = {
            0.0f,   0.0f,
          500.0f, 500.0f

    };

    public Map() {
        float x1,x2;

        for (int i=0; i<15; i++) {
            x1 = randomFull();
            x2 = randomFull();
            rectangles[i] = new Rectangle(x1, x2, x1+randomFullDistance(), x2+randomFullDistance());
        }
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
