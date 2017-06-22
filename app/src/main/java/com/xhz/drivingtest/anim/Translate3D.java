package com.xhz.drivingtest.anim;


import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 14:28
 */

public class Translate3D extends Animation {
    private Camera mCamera;
    private int halfParentWidth;
    private int halfParentHeight;
    private float from;
    private float to, distance;
    private boolean farAway = true;

    public Translate3D(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Translate3D(float from, float to, boolean farAway,long duration,AnimationListenerAdapter animationlistenerAdapter) {
        this.from = from;
        this.to = to;
        this.farAway = farAway;
        distance = to - from;
        setDuration(duration);
        setAnimationListener(animationlistenerAdapter);
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        mCamera = new Camera();
        halfParentWidth = parentWidth / 2;
        halfParentHeight = parentHeight / 2;
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
//        t.getMatrix().setTranslate(0,interpolatedTime*300);//从0～300位置

        Matrix matrix = t.getMatrix();

        mCamera.save();

        mCamera.translate(0, 0, (farAway ? interpolatedTime : 1 - interpolatedTime) * halfParentWidth);
        mCamera.rotateY(interpolatedTime * distance+from);
        mCamera.getMatrix(matrix);
        mCamera.restore();

        matrix.preTranslate(-halfParentWidth, -halfParentHeight);
        matrix.postTranslate(halfParentWidth, halfParentHeight);
        super.applyTransformation(interpolatedTime, t);

    }



}
