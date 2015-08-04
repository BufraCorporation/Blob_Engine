package com.corporation.bufra.blob_engine.OpenGL.shapes;

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
           mainTriangle = new Triangle(verticles[3], verticles[4], verticles[3], verticles[1], verticles[0], verticles [4]);
           helpTriangle = new Triangle(verticles[0], verticles[1], verticles[3], verticles[1], verticles[0], verticles [4]);
        createTriangles();
    }

    public Rectangle(float x1, float x2, float y1, float y2) {

        if( x1 > y1){
            verticles[0] = x1;
            verticles[3] = y1;
        }
        else{
            verticles[0] = y1;
            verticles[3] = x1;
        }

        if( x2 > y2){
            verticles[1] = x2;
            verticles[4] = y2;
        }
        else{
            verticles[1] = y2;
            verticles[4] = x2;
        }
        createTriangles();
    }

    private void createTriangles(){
        mainTriangle = new Triangle(verticles[3], verticles[4], verticles[3], verticles[1], verticles[0], verticles [4]);
        helpTriangle = new Triangle(verticles[0], verticles[1], verticles[3], verticles[1], verticles[0], verticles [4]);
    }

    public void draw(boolean showHelp) {
        mainTriangle.draw();
       if(showHelp)
       {helpTriangle.draw();}
    }

    public void setValues( float x2, float y2){
        mainTriangle.setValues(x2, y2);
       helpTriangle.setValues(x2, y2);
        verticles[0] -= x2;
        verticles[3] -= x2;

        verticles[1] -= y2;
        verticles[4] -= y2;
    }
    public void setValues() {
        mainTriangle.setValues();
        helpTriangle.setValues();
    }
}
