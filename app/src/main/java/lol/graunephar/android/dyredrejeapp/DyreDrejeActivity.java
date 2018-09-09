package lol.graunephar.android.dyredrejeapp;

import android.app.ActionBar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DyreDrejeActivity extends AppCompatActivity {

    @BindView(R.id.imgRight)
    ImageView rightView;
    @BindView(R.id.imgLeft)
    ImageView leftView;

    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_dyre_dreje);
        ButterKnife.bind(this);

        rightView.setImageResource(R.drawable.goat);
        leftView.setImageResource(R.drawable.goat);



    }

    public void fullScreen() {

    }
}
