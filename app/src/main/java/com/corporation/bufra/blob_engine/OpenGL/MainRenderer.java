package com.corporation.bufra.blob_engine.OpenGL;

import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;

import com.corporation.bufra.blob_engine.OpenGL.shapes.Rectangle;
import com.corporation.bufra.blob_engine.OpenGL.shapes.Triangle;
import com.corporation.bufra.blob_engine.OpenGL.shapes.figures.MainFigure;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Marc on 31.07.2015.
 */
public class MainRenderer implements Renderer, SensorEventListener {

    static float red = 0.8f, green = 0.0f,  blue = 0.0f, alpha = 1.0f;

    Triangle triangle;
    //Rectangle rectangleNull;
   //Rectangle rectangles[] = {rectangleNull};
    Rectangle rectangleNull, rectangleOne, rectangleTwo, rectangleThree, rectangleFour, rectangleFive, rectangleSix, rectangleSeven, rectangleEight, rectangleNine, rectangleTen, rectangleEleven, rectangleTwelve, rectangleThirteen, rectangleFourteen;
    Rectangle rectangles[] = {rectangleNull, rectangleOne, rectangleTwo, rectangleThree, rectangleFour, rectangleFive, rectangleSix, rectangleSeven, rectangleEight, rectangleNine, rectangleTen, rectangleEleven, rectangleTwelve, rectangleThirteen, rectangleFourteen};
    MainFigure mainChar;

    private float Ax = 0;

    public void setAy(float ay) {
        Ay = ay;
    }

    private float Ay = 0;

    public void setAx(float ax) {
        Ax = ax;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

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

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    public void setColor(float red, float green, float blue, float alpha){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClearColor(red, green, blue, alpha);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);


        mainChar.draw(true);
        for (Rectangle r : rectangles) {
            r.draw(true);

        }

        mainChar.setValues(rectangles, 0.001f * Ax, 0.001f * Ay);

        mainChar.draw(true);
        for (Rectangle r : rectangles) {
            r.setValues();
    }
        //rectangleNull.draw(true);
        //rectangleOne.draw(true);
        //rectangleTwo.draw(true);

        // rectangleNull.setValues();
        //rectangleOne.setValues();
        // rectangleTwo.setValues();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
