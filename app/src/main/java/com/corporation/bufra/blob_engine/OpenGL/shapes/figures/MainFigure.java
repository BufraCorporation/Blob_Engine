package com.corporation.bufra.blob_engine.OpenGL.shapes.figures;


import com.corporation.bufra.blob_engine.Global.BlobConstants;
import com.corporation.bufra.blob_engine.OpenGL.shapes.Rectangle;

public class MainFigure extends Rectangle {

    //[4-7] are only for overwriting return of setValues
    boolean recCol[] = {false, false, false, false, false, false, false, false};
    boolean borderCol[] = {false, false, false, false, false, false, false, false};

    boolean tempRet[] = {false, false, false, false};
    float tempUpperleft[] = {0f, 0f, 0f};
    float tempDownerright[] = {0f, 0f, 0f};

    boolean CollisionArray[] = {false, false, false, false};
    // [1 to 3] return border collisions [4 to 7] return every Rectangle collision
    boolean BorderArray[]    = {false, false, false, false, false, false, false, false};




    public MainFigure() {
        super();
    }

    public void draw(boolean showHelp){
        super.draw(showHelp);
    }

    public MainFigure(float x1, float x2, float x3, float x4) {
        super(x1, x2, x3, x4);
    }

    public boolean[] setValues( Rectangle[] rec, float x2, float y2) {
        CollisionArray = CollisionDetector(rec, x2, y2);
        BorderArray    = BorderCollision(x2, y2);

        BorderArray[4] = false;
        BorderArray[5] = false;
        BorderArray[6] = false;
        BorderArray[7] = false;

        //Movement left
        if(x2>0 && !CollisionArray[2] && !BorderArray[2]) {super.setValues(x2, 0);}
        //Movement right
        if(x2<0 && !CollisionArray[0] && !BorderArray[0]) {super.setValues(x2, 0);}

        //Movement Up
        if(y2<0 && !CollisionArray[1] && !BorderArray[1]) {super.setValues(0, y2);}
        //Movement Down
        if(y2>0 && !CollisionArray[3] && !BorderArray[3]) {super.setValues(0, y2);}

        BorderArray[4] = CollisionArray[0];
        BorderArray[5] = CollisionArray[1];
        BorderArray[6] = CollisionArray[2];
        BorderArray[7] = CollisionArray[3];
        return BorderArray;
    }

    public boolean[] BorderCollision(float x2, float y2){
        borderCol[0] = false;
        borderCol[1] = false;
        borderCol[2] = false;
        borderCol[3] = false;

        //Check Border collection
        //LEFT
        if (super.verticles[0] - x2 < BlobConstants.TOLERANCE_HORICONTAL) {
            //tempRet[2] = false;
        } else {
            borderCol[0] = true;
        }
        //RIGHT
        if (super.verticles[3] - x2 > -BlobConstants.TOLERANCE_HORICONTAL) {
            //tempRet[0] = false;
        } else {
            borderCol[2] = true;
        }
        //UP
        if (super.verticles[1] - y2 < BlobConstants.TOLERANCE_VERTICAL) {
            //tempRet[1] = false;
        } else {
            borderCol[1] = true;
        }
        //DOWN
        if (super.verticles[4] - y2 > -BlobConstants.TOLERANCE_VERTICAL) {
            //tempRet[3] = false;
        } else {
            borderCol[3] = true;
        }


        return borderCol;
    }


    public boolean[] CollisionDetector(Rectangle[] rec, float x2, float y2) {
        //Return array [Coll. right, Coll. up, Coll. left, Coll. down]
        //Set Collision to false
        recCol[0] = false;
        recCol[1] = false;
        recCol[2] = false;
        recCol[3] = false;

        //For each Rectangle: Check collision
        if (rec != null) {
            for (Rectangle r : rec) {
                if( verticles[0] - x2 > r.verticles[3] && verticles[3] - x2 < r.verticles[0] && verticles[4] < r.verticles[1] && verticles[1] > r.verticles[4])
                    recCol[0] = true;
                //else tempRet[0] = false;


                if( verticles[3] - x2 < r.verticles[0] && verticles[0] - x2 > r.verticles[3] && verticles[4] < r.verticles[1] && verticles[1] > r.verticles[4])
                    recCol[2] = true;
                //else tempRet[2] = false;

                if( verticles[4] - y2 < r.verticles[1] && verticles[1] - y2 > r.verticles[4] && verticles[3] < r.verticles[0] && verticles[0] > r.verticles[3])
                    recCol[1] = true;
                //else tempRet[1] = false;

                if( verticles[1] - y2  > r.verticles[4] && verticles[4] - y2 < r.verticles[1] && verticles[3] < r.verticles[0] && verticles[0] > r.verticles[3])
                    recCol[3] = true;
                //else tempRet[3] = false;
            }

        }
        return recCol;
    }


}
