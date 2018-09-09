package lol.graunephar.android.dyredrejeapp;

import android.Manifest;
import android.app.ActionBar;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DyreDrejeActivity extends AppCompatActivity implements SensorEventListener{

    @BindView(R.id.imgRight)
    ImageView rightView;
    @BindView(R.id.imgLeft)
    ImageView leftView;


    private SensorManager mSensorManager;
    private Sensor mSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_dyre_dreje);
        ButterKnife.bind(this);

        rightView.setImageResource(R.drawable.goat);
        leftView.setImageResource(R.drawable.goat);


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);

        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_GAME);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    //Adapted from http://www.zoftino.com/android-sensors-examples
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() ==  Sensor.TYPE_GAME_ROTATION_VECTOR){
            float[] rotMatrix = new float[9];
            float[] rotVals = new float[3];

            SensorManager.getRotationMatrixFromVector(rotMatrix, event.values);
            SensorManager.remapCoordinateSystem(rotMatrix,
                    SensorManager.AXIS_X, SensorManager.AXIS_Y, rotMatrix);

            SensorManager.getOrientation(rotMatrix, rotVals);
            float azimuth = (float) Math.toDegrees(rotVals[0]);
            //float pitch = (float) Math.toDegrees(rotVals[1]);
            //float roll = (float) Math.toDegrees(rotVals[2]);


            Log.d("Azimuth", String.valueOf(azimuth));

            
            changeImages(azimuth);

        }

    }

    private void changeImages(float azimuth) {
        if(<)
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

        Log.d("SENSOR", "ACCURANCY CHSANGE");
    }
}
