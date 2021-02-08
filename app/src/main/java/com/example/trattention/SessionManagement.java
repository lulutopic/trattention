package com.example.trattention;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";

    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void saveSession(User user){//查一下靜態與否的差異
        //判斷若使用者已登入，則儲存 session
        int id = user.getId();
        editor.putInt(SESSION_KEY, id).commit();
    }
    public int getSession(){
        //用於回傳 session 儲存的 user 是誰
        //利用抓到的 SESSION_KEY 設定 value 為 -1（未登入裝態）
        return sharedPreferences.getInt(SESSION_KEY, -1);
    }
    public void removeSession(){ //設定為 -1（未登入裝態）
        editor.putInt(SESSION_KEY,-1).commit();
    }
}

