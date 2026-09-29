package com.ifsc.app_aula1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SimplesPaint extends View {
    Path path;
    Paint paint;

    ArrayList<Paint> paintList;
    ArrayList<Path> pathList;

    public SimplesPaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(0xFF000000);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paintList = new ArrayList<>();
        pathList = new ArrayList<>();
    }


    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i <paintList.size(); i++){
            canvas.drawPath(pathList.get(i),paintList.get(i));
        }
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                return true;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;

            case MotionEvent.ACTION_UP:
                break;

            default:
                return false;
        }
        invalidate();
        return true;
    }
    public void setColor(int color){
        //Criar nova camada paint e path

        pathList.add(path);
        paintList.add(paint);
        path = new Path();
        paint = new Paint(paint);


        paint.setColor(color);
        invalidate();
    }
}

