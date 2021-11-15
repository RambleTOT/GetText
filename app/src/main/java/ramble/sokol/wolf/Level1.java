package ramble.sokol.wolf;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class Level1 extends AppCompatActivity {









    Array array = new Array();
    Random random = new Random();
    public int num;
public InterstitialAd interstitialAd;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        MobileAds.initialize(this, "ca-app-pub-9185251094182224~2021386547");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9185251094182224/6025685512");
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                try {
                    Intent intent = new Intent(Level1.this,GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });


        final TextView text_l = findViewById(R.id.text_l);

        final Button button_aaa = findViewById(R.id.button_aaa);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button btn_back = (Button) findViewById(R.id.button_k);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                } else{
                    try {
                        Intent intent = new Intent(Level1.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
            }
            }
        });
        num = random.nextInt(61);
        text_l.setText(array.lvl1[num]);
        button_aaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num = random.nextInt(61);
                    text_l.setText(array.lvl1[num]);
                } catch (Exception e) {

                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else{
            try {
                Intent intent = new Intent(Level1.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
    }
    }}