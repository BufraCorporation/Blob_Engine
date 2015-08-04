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
        //Movement left
        if(x2>0 && !CollisionArray[2]) {super.setValues(x2, 0);}
        //Movement right
        if(x2<0 && !CollisionArray[0] ) {super.setValues(x2, 0);}

        //Movement Up
        if(y2<0 &&  !CollisionArray[1]) {super.setValues(0, y2);}
        //Movement Down
        if(y2>0 && !CollisionArray[3] ) {super.setValues(0, y2);}
    }

    public boolean[] CollisionDetector(Rectangle[] rec, float x2, float y2) {
        //Return array [Coll. right, Coll. up, Coll. left, Coll. down]
//Maintest

        tempRet[0] = false;
        tempRet[1] = false;
        tempRet[2] = false;
        tempRet[3] = false;

        //Check Border collection
        //LEFT
        if (super.verticles[0] - x2 < 1f) {
            //tempRet[2] = false;
        } else {
            tempRet[0] = true;
        }
        //RIGHT
        if (super.verticles[3] - x2 > -1f) {
            //tempRet[0] = false;
        } else {
            tempRet[2] = true;
        }
        //UP
        if (super.verticles[1] - y2 < 1f) {
            //tempRet[1] = false;
        } else {
            tempRet[1] = true;
        }
        //DOWN
        if (super.verticles[4] - y2 > -1f) {
            //tempRet[3] = false;
        } else {
            tempRet[3] = true;
        }



        //For each Rectangle
        if (rec != null) {
            for (Rectangle r : rec) {
                if( verticles[0] -x2 > r.verticles[3] && verticles[3] - x2 < r.verticles[0] && verticles[4] < r.verticles[1] && verticles[1] > r.verticles[4])
                    tempRet[0] = true;
                //else tempRet[0] = false;


                if( verticles[3] - x2 < r.verticles[0] && verticles[0] - x2 > r.verticles[3] && verticles[4] < r.verticles[1] && verticles[1] > r.verticles[4])
                    tempRet[2] = true;
                //else tempRet[2] = false;

                if( verticles[4] - y2 < r.verticles[1] && verticles[1] - y2 > r.verticles[4] && verticles[3] < r.verticles[0] && verticles[0] > r.verticles[3])
                    tempRet[1] = true;
                //else tempRet[1] = false;

                if( verticles[1] - y2 > r.verticles[4] && verticles[4] - y2 < r.verticles[1] && verticles[3] < r.verticles[0] && verticles[0] > r.verticles[3])
                    tempRet[3] = true;
                //else tempRet[3] = false;
            }

        }
        return tempRet;
    }


}
