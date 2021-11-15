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

public class Level3 extends AppCompatActivity {
    Array array = new Array();
    Random random = new Random();
    public int num;
    public InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        MobileAds.initialize(this, "ca-app-pub-9185251094182224~2021386547");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9185251094182224/6025685512");
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                try {
                    Intent intent = new Intent(Level3.this,GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        final TextView text_as = findViewById(R.id.text_as);

        final Button button_si = findViewById(R.id.button_si);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button btn_back = (Button) findViewById(R.id.button_gor);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(Level3.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            }
        });
        num = random.nextInt(43);
        text_as.setText(array.lvl3[num]);
        button_si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num = random.nextInt(43);
                    text_as.setText(array.lvl3[num]);
                } catch (Exception e) {

                }
            }
        });

    }
    @Override
    public void onBackPressed(){
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            try {
                Intent intent = new Intent(Level3.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }
        }
    }}