package com.skillhunternaim.anotherloser.convertanyunit;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Want to Exit???")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog= builder.create();
        alertDialog.show();
        //super.onBackPressed();
    }

    public void sndPlay(){
        //vibrator=(Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.clicksnd);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mp.setVolume((float)0.3,(float) 0.3);
        //vibrator.vibrate(50);
        mp.start();
    }
    public void goLength(View view){
        sndPlay();
        Intent intent=new Intent(this,Length.class);
        startActivity(intent);
    }
    public void goArea(View view){
        sndPlay();
        Intent intent=new Intent(this,Area.class);
        startActivity(intent);
    }
    public void goTime(View view){
        sndPlay();
        Intent intent=new Intent(this,Time.class);
        startActivity(intent);
    }
    public void goWeight(View view){
        sndPlay();
        Intent intent=new Intent(this,Weight.class);
        startActivity(intent);
    }
    public void goTemperature(View view){
        sndPlay();
        Intent intent=new Intent(this,Temperature.class);
        startActivity(intent);
    }
    public void goVolume(View view){
        sndPlay();
        Intent intent=new Intent(this,Volume.class);
        startActivity(intent);
    }
    public void goDevelopers(View view){
        sndPlay();
        Intent intent=new Intent(this,Developers.class);
        startActivity(intent);
    }

}
