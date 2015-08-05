package com.corporation.bufra.blob_engine.OpenGL;

import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;

import com.corporation.bufra.blob_engine.OpenGL.Screen.Screen;
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
    public Screen screen;

    //Angles of Inclination, Set in MainAcitivty
    private float Ax = 0;
    private float Ay = 0;

    public void setAy(float ay) {
        Ay = ay;
    }
    public void setAx(float ax) {
        Ax = ax;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
       screen = new Screen();
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


        screen.renderScreen(Ax, Ay);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
