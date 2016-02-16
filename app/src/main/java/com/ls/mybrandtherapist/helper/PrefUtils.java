package com.ls.mybrandtherapist.helper;

import android.content.Context;

/**
 * Created by xitij on 17-03-2015.
 */
public class PrefUtils {

    // 0 - For Login Screen
    // 1 - For OTp Screen
    // 2 - For Profile Screen
    // 3 - For ClassSelection Screen
    // 4 - For main Screen

    public static void saveCurrentScreen(Context ctx,int val){
        Prefs.with(ctx).save("Screenno",val);
    }
    public static int getCurrentScreen(Context ctx){
        int val = Prefs.with(ctx).getInt("Screenno", 0);
        return val;
    }

    public static void saveAppInstallDate(Context ctx,String dt){
        Prefs.with(ctx).save("AppInstallDate",dt);
    }
    public static String getAppInstallDate(Context ctx){
        String val = Prefs.with(ctx).getString("AppInstallDate", "");
        return val;
    }

    public static void saveInstituteCode(Context ctx,String code){
        Prefs.with(ctx).save("InstituteCode",code);
    }
    public static String getInstituteCode(Context ctx){
        String val = Prefs.with(ctx).getString("InstituteCode","");
        return val;
    }

    public static void saveMobile(Context ctx,String code){
        Prefs.with(ctx).save("Mobile",code);
    }
    public static String getMobile(Context ctx){
        String val = Prefs.with(ctx).getString("Mobile","");
        return val;
    }

    public static void saveInstituteUserID(Context ctx,String code){
        Prefs.with(ctx).save("InstituteUserID",code);
    }
    public static String getInstituteUserID(Context ctx){
        String val = Prefs.with(ctx).getString("InstituteUserID","");
        return val;
    }


}
