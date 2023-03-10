package net.n_19010417.primitivas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
//import java.nio.file.Path;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vista vista = new Vista(this);
        setContentView(vista);
    }

    class Vista extends View {

        float x;
        float y;

        String accion = "accion";
        Path path = new android.graphics.Path();

        public Vista (Context context) { super(context);}

        public void onDraw(Canvas canvas){
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE); //Forma al pincel
            paint.setStrokeWidth(5);            //Tamaño del pincel
            paint.setColor(Color.BLACK);        //Color
            paint.setColor(Color.BLUE);
            paint.setColor(Color.RED);

            if (accion.compareTo("down")==0){
                path.moveTo(x,y);
            }
            if (accion.compareTo("move")==0){
                path.lineTo(x,y);
            }
            canvas.drawPath(path, paint);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                accion = "down";
            if (motionEvent.getAction()==MotionEvent.ACTION_MOVE)
                accion = "move";
            invalidate();
            return true;
        }

    }

}