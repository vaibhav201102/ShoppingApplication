package internship.app.commercial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView Img;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        sp = getSharedPreferences(ConstantSP.PREF,MODE_PRIVATE);

        Img =findViewById(R.id.splash_img);
        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setDuration(500);
        animation.setRepeatCount(1);
        Img.startAnimation(animation);

         new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sp.getString(ConstantSP.Email,"").isEmpty()){
                    new CommonMethod(Splash.this,MainActivity.class);
                }
               else {
                    new CommonMethod(Splash.this,Homeactivity.class);
                }
                finish();
            }
        },500);
    }
}