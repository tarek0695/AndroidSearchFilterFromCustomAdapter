package com.pixelhubllc.searchfiltercustomadapter;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences mSharedPref;

    public SharedPref(Context context){
        mSharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }


    //this method will save spinner state
    public void setListViewPos(int num){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putInt("Num", num);
        editor.apply();
    }

    //this method will load maximum suggestion nums
    public int loadListViewPos(){
        return mSharedPref.getInt("Num", 0);
    }

    //this method will save night mode state , true or false
    public void setSelColorState(Boolean state){
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean("SelColor", state);
        editor.apply();
    }

    //this method will load the night mode state
    public boolean loadSelColorState(){
        return mSharedPref.getBoolean("SelColor", false);
    }

}
