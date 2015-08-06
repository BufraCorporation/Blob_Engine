package com.corporation.bufra.blob_engine.OpenGL.shapes;

import com.corporation.bufra.blob_engine.Global.BlobConstants;

/**
 * Created by Marc on 02.08.2015.
 */
public class Rectangle extends Shape {
    public Triangle mainTriangle, helpTriangle;

    public float verticles[] = {
             0.0f,  0.0f, 0.0f,  //upper right corner
             0.0f,  0.0f, 0.0f  //downer left corner
    };


    public Rectangle(){
    }

    public Rectangle(float x1, float x2, float y1, float y2) {

        if( x1 > y1){
            verticles[BlobConstants.R_COORDINATE1_X] = x1;
            verticles[BlobConstants.R_COORDINATE2_X] = y1;
        }
        else{
            verticles[BlobConstants.R_COORDINATE1_X] = y1;
            verticles[BlobConstants.R_COORDINATE2_X] = x1;
        }

        if( x2 > y2){
            verticles[BlobConstants.R_COORDINATE1_Y] = x2;
            verticles[BlobConstants.R_COORDINATE2_Y] = y2;
        }
        else{
            verticles[BlobConstants.R_COORDINATE1_Y] = y2;
            verticles[BlobConstants.R_COORDINATE2_Y] = x2;
        }
        createTriangles();
    }

    private void createTriangles(){
        helpTriangle = new Triangle(verticles[BlobConstants.R_COORDINATE1_X], verticles[BlobConstants.R_COORDINATE1_Y], verticles[BlobConstants.R_COORDINATE2_X], verticles[BlobConstants.R_COORDINATE1_Y], verticles[BlobConstants.R_COORDINATE1_X], verticles [BlobConstants.R_COORDINATE2_Y]);
        mainTriangle = new Triangle(verticles[BlobConstants.R_COORDINATE2_X], verticles[BlobConstants.R_COORDINATE2_Y], verticles[BlobConstants.R_COORDINATE2_X], verticles[BlobConstants.R_COORDINATE1_Y], verticles[BlobConstants.R_COORDINATE1_X], verticles [BlobConstants.R_COORDINATE2_Y]);


    }

    public void draw(boolean showHelp) {
        mainTriangle.draw();
       if(showHelp)
       {helpTriangle.draw();}
    }

    public void setValues( float x2, float y2){
        mainTriangle.setValues(x2, y2);
       helpTriangle.setValues(x2, y2);
        verticles[BlobConstants.R_COORDINATE1_X] -= x2;
        verticles[BlobConstants.R_COORDINATE2_X] -= x2;

        verticles[BlobConstants.R_COORDINATE1_Y] -= y2;
        verticles[BlobConstants.R_COORDINATE2_Y] -= y2;
    }
    public void setValues() {
        mainTriangle.setValues();
        helpTriangle.setValues();
    }
}
