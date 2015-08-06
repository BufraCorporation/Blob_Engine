package com.corporation.bufra.blob_engine.OpenGL.Map.Elements;

import com.corporation.bufra.blob_engine.Global.BlobConstants;
import com.corporation.bufra.blob_engine.OpenGL.shapes.Rectangle;


/**
 * Created by Marc on 06.08.2015.
 */
public class Shares extends Rectangle {

    public Shares(float x1, float x2){
        super(x1, x2, x1 + BlobConstants.SHARE_HEIGHT, x2 + BlobConstants.SHARE_LENGTH);
    }

}