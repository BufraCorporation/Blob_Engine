package com.corporation.bufra.blob_engine.OpenGL.shapes.figures;


import com.corporation.bufra.blob_engine.OpenGL.shapes.Rectangle;

public class MainFigure extends Rectangle {

    boolean tempRet[] = {false, false, false, false};
    float tempUpperleft[] = {0f, 0f, 0f};
    float tempDownerright[] = {0f, 0f, 0f};

    boolean CollisionArray[] = {false, false, false, false};




    public MainFigure() {
        super();
    }

    public void draw(boolean showHelp){
        super.draw(showHelp);
    }

    public MainFigure(float x1, float x2, float x3, float x4) {
        super(x1, x2, x3, x4);
    }

    public void setValues( Rectangle[] rec, float x2, float y2) {
        CollisionArray = CollisionDetector(rec, x2, y2);
        //Movement Right
        if(x2>0 && super.verticles[3] > -1f) {super.setValues(x2, 0);}
        //Movement Left
        if(x2<0 && super.verticles[0] <  1f ) {super.setValues(x2, 0);}

        //Movement Up
        if(y2<0 &&  super.verticles[1] <  1f) {super.setValues(0, y2);}
        //Movement Down
        if(y2>0 && super.verticles[4]  > -1f ) {super.setValues(0, y2);}
    }

    public boolean[] CollisionDetector(Rectangle[] rec, float x2, float y2) {
        //Return array [Coll. left, Coll. up, Coll. right, Coll. down]
//Maintest

        //Check Border collection
        //LEFT


        //For each Rectangle
       /* for (Rectangle r : rec) {


            return tempRet;
        }*/
        return tempRet;
    }


}
