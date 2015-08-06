package com.corporation.bufra.blob_engine.OpenGL.shapes;

import android.opengl.GLES20;

import com.corporation.bufra.blob_engine.Global.BlobConstants;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by Marc on 31.07.2015.
 */
public class Triangle extends Shape {

    private FloatBuffer vertexBuffer;

    public float[] getVerticles() {
        return verticles;
    }

    private float verticles[] = {
             -0.3f,  0.0f, 0.0f,
              0.3f,  0.0f, 0.0f,
              0.0f,  0.3f, 0.0f
    };

    static private float color[] = new float[] { 0.0f, 1.0f, 1.0f, 0.5f};

    private final String vertexShaderCode =
            "attribute vec4 vPosition;" +
            "void main() {" +
            "gl_Position = vPosition;" +
            "}";
    private final String fragmentShaderCode =
            "precision mediump float;" +
            "uniform vec4 vColor;" +
            "void main() {" +
            " gl_FragColor = vColor;" +
            "}";
    private int shaderProgram;

    public static int loadShader(int type, String shaderCode) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

    public Triangle() {
        renderRectangle();
    }

    public Triangle( float x1, float x2, float y1, float y2, float z1, float z2){
        this();
        verticles[BlobConstants.T_COORDINATE1_X] =  x1;
        verticles[BlobConstants.T_COORDINATE1_Y] =  x2;

        verticles[BlobConstants.T_COORDINATE2_X] =  y1;
        verticles[BlobConstants.T_COORDINATE2_Y] =  y2;

        verticles[BlobConstants.T_COORDINATE3_X] =  z1;
        verticles[BlobConstants.T_COORDINATE3_Y] =  z2;

       renderRectangle();
    }

    public void draw(){
        GLES20.glUseProgram(shaderProgram);

        int positionAttrib = GLES20.glGetAttribLocation(shaderProgram, "vPosition");
        GLES20.glEnableVertexAttribArray(positionAttrib);

        GLES20.glVertexAttribPointer(positionAttrib, 3, GLES20.GL_FLOAT, false, 0, vertexBuffer);

        int colorUniform = GLES20.glGetUniformLocation(shaderProgram, "vColor");

        GLES20.glUniform4fv(colorUniform, 1, color, 0);
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, verticles.length / 3);
        GLES20.glDisableVertexAttribArray(positionAttrib);
    }


    public void setValues( float x2, float y2){
        //Update x Values
            verticles[BlobConstants.T_COORDINATE1_X] -= x2;
            verticles[BlobConstants.T_COORDINATE2_X] -= x2;
            verticles[BlobConstants.T_COORDINATE3_X] -= x2;

        //Update y Values
            verticles[BlobConstants.T_COORDINATE1_Y] -= y2;
            verticles[BlobConstants.T_COORDINATE2_Y] -= y2;
            verticles[BlobConstants.T_COORDINATE3_Y] -= y2;

        resizeRectangle();
    }

    public void setValues(){
        resizeRectangle();
    }
    public void renderRectangle(){
        resizeRectangle();

        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

        shaderProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(shaderProgram, vertexShader);
        GLES20.glAttachShader(shaderProgram, fragmentShader);
        GLES20.glLinkProgram(shaderProgram);
    }

    public void resizeRectangle(){
        ByteBuffer bb = ByteBuffer.allocateDirect(verticles.length * 4);
        bb.order(ByteOrder.nativeOrder());

        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(verticles);
        vertexBuffer.position(0);
    }
}
