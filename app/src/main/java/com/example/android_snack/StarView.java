package com.example.android_snack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The type Star view：游戏开始界面
 */
public class StarView extends AppCompatActivity implements View.OnClickListener {

    private Button Starbutton,Sbutton,Backbutton;
    /**
     * The Shared：实例化存储对象
     */
    SharedPre shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_view);
        Init();
    }

    /**
     * Init：初始化该活动界面信息
     */
    void Init(){
        Starbutton=findViewById(R.id.star_game);
        Sbutton=findViewById(R.id.MostBUtton);
        Backbutton=findViewById(R.id.BackButton);

        shared=new SharedPre(this);

        Starbutton.setOnClickListener(this);
        Sbutton.setOnClickListener(this);
        Backbutton.setOnClickListener(this);
    }
    /**
     * onClick:该界面按钮监听事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.star_game:
                Intent intent=new Intent(StarView.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.BackButton:
                finish();
                break;
            case R.id.MostBUtton:
                Sbutton.setText(Macro.H_MOST_SCORE+shared.read());
                break;
        }
    }
}