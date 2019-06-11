package prathmesh.talktome;



import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to change color of background(Relative layout) it is used
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layotu_parent);



        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);//Enter
        animationDrawable.setExitFadeDuration(1000);//Exit
        animationDrawable.start();//To start animation


    }


    public void  play_btn(View view) {
        final Button sound = (Button) view;

        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,getResources().getIdentifier((String) sound.getTag(),"raw",getPackageName()));
        mediaPlayer.start();

        if (mediaPlayer.isPlaying()) {
            sound.setBackgroundColor(Color.RED);
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sound.setBackgroundColor(Color.GREEN);
                sound.setTextColor(Color.WHITE);
            }
        });

    }
}

