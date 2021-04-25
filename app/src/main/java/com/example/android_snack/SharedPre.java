package com.example.android_snack;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * The type Shared pre：分数存储处理
 */
public class SharedPre {
    private int mostscore;
    private Context context;

    public SharedPre() {

    }

    public SharedPre(Context context) {
        this.context = context;
    }

    /**
     * Save：分数存储
     *
     * @param mscore the mscore
     */
//存储最高游戏分数记录
    public void save(int mscore) {
        SharedPreferences sp = context.getSharedPreferences(Macro.Pname, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("score",mscore);
        editor.apply();
    }

    /**
     * Read int：读取分数
     *
     * @return the int
     */
//读出并显示最高游戏分数记录
    public int read(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(Macro.Pname,Context.MODE_PRIVATE);
        mostscore=sharedPreferences.getInt("score",0);
        return mostscore;
    }
}
