package ramble.sokol.wolf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class GameLevels extends AppCompatActivity {
    public InterstitialAd interstitialAd;
    public int transition = 0;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_levels);



        MobileAds.initialize(this, "ca-app-pub-9185251094182224~2021386547");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9185251094182224/6025685512");
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                try {
                    switch (transition){
                        case 0: break;
                        case 1: Intent intent = new Intent(GameLevels.this,Level1.class);
                            startActivity(intent);finish();
                        case 2: Intent intent2 = new Intent(GameLevels.this,Level2.class);
                            startActivity(intent2);finish();
                        case 3: Intent intent3 = new Intent(GameLevels.this,Level3.class);
                            startActivity(intent3);finish();
                        case 4: Intent intent4 = new Intent(GameLevels.this,Level4.class);
                            startActivity(intent4);finish();
                        case 5: Intent intent5 = new Intent(GameLevels.this,Level5.class);
                            startActivity(intent5);finish();
                        case 6: Intent intent6 = new Intent(GameLevels.this,Level6.class);
                            startActivity(intent6);finish();
                        case 7: Intent intent7 = new Intent(GameLevels.this,MainActivity.class);
                            startActivity(intent7);finish();
                    }

                }catch (Exception e){

                }
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button) findViewById(R.id.button_plus);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    transition = 7;
                    interstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(GameLevels.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            }
        });

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    transition = 1;
                    interstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            }
        });

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    transition = 2;
                    interstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(GameLevels.this, Level2.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            }
        });

        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    transition = 3;
                    interstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(GameLevels.this, Level3.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            }
        });
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    transition = 4;
                    interstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(GameLevels.this, Level4.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            }
        });

        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    transition = 6;
                    interstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(GameLevels.this, Level6.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            }
        });
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    transition = 5;
                    interstitialAd.show();
                } else {
                    try {
                        Intent intent = new Intent(GameLevels.this, Level5.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {

                    }
                }
            }
        });
    }
        @Override
        public void onBackPressed() {
            if (interstitialAd.isLoaded()) {
                transition = 7;
                interstitialAd.show();
            } else {
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        }

}