package ramble.sokol.wolf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class Level5 extends AppCompatActivity {

    public InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);
        MobileAds.initialize(this, "ca-app-pub-9185251094182224~2021386547");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9185251094182224/6025685512");
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                try {
                    Intent intent = new Intent(Level5.this,GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        final TextView text_f = findViewById(R.id.text_f);

        final Button button_ss = findViewById(R.id.button_ss);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(Level5.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            }
        });
        button_ss.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){

                }else if (event.getAction()==MotionEvent.ACTION_UP){

                    text_f.setText(R.string.level5);
                    button_ss.setEnabled(false);
                }
                return false;
            }
        });

    }
    @Override
    public void onBackPressed(){
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            try {
                Intent intent = new Intent(Level5.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        }
    }}