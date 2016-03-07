package com.ls.mybrandtherapist.helper;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;


import com.ls.mybrandtherapist.R;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Functions {

    public static double mWidthPixels;
    public static double mHeightPixels;

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    public static float convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }

    public static void fireIntent(Activity activity, Class cls) {
        Intent i = new Intent(activity, cls);
        activity.startActivity(i);
    }

    public static String stingToUTF(String val){
        return Charset.forName("UTF-8").encode(val).toString();
    }


    public static double getDeviceHeight(Context _ctx){
        double deviceSize = 0f;
        Activity act = (Activity)_ctx;
        Display display = act.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        if(height<800){
            deviceSize = 4f;
        }else  if(height>800 && height <1000){
            deviceSize = 4.5f;
        } else if(height>1000 && height <1500){
            deviceSize = 5f;
        }else{
            deviceSize = 5.5f;
        }
        return deviceSize;
    }

    public static double getDeviceInch(Context _ctx){
        setRealDeviceSizeInPixels(_ctx);

        DisplayMetrics dm = new DisplayMetrics();
        Activity act = (Activity)_ctx;
        act.getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(mWidthPixels / dm.xdpi, 2);
        double y = Math.pow(mHeightPixels / dm.ydpi, 2);
        double screenInches = Math.sqrt(x + y);
        Log.e("@@@@@ Screen inches : ","" + screenInches);
        return screenInches;
    }

    public static void setRealDeviceSizeInPixels(Context _ctx) {
        Activity act = (Activity) _ctx;
        WindowManager windowManager = act.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);


        // since SDK_INT = 1;
        mWidthPixels = displayMetrics.widthPixels;
        mHeightPixels = displayMetrics.heightPixels;

        // includes window decorations (statusbar bar/menu bar)
        if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
            try {
                mWidthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
                mHeightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
            } catch (Exception ignored) {
            }
        }

        // includes window decorations (statusbar bar/menu bar)
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                Point realSize = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
                mWidthPixels = realSize.x;
                mHeightPixels = realSize.y;
            } catch (Exception ignored) {
            }
        }

    }


    public static boolean isInternetConnected(Context _context){
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
    }
    public static String getAppVersion(Context _ctx) {
        String appVersion="";
        try {
            PackageInfo pInfo = _ctx.getPackageManager().getPackageInfo(_ctx.getPackageName(), 0);
            appVersion = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appVersion;
    }


    public static void showAlert(Context _context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                _context);

        // set title
        alertDialogBuilder.setTitle("" + _context.getResources().getString(R.string.app_name));

        // set dialog message
        alertDialogBuilder
                .setMessage("Please check your Internet connection and try again")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });


        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }


    public static String UnicodeTOString(String inputUnicode){
        Scanner scanner =  new Scanner(inputUnicode);
        String unicodeCharStr = scanner.findWithinHorizon("\\\\{1}u[0-9a-fA-F]{4}", 0);
        char unicodeChar = (char)(int)Integer.valueOf(unicodeCharStr.substring(2, 6), 16);
        inputUnicode = inputUnicode.replace(unicodeCharStr, unicodeChar+"");
        return inputUnicode;
    }


    public static void setDefaultLocale(Context context, String locale) {
        Locale locJa = new Locale(locale.trim());
        Locale.setDefault(locJa);

        Configuration config = new Configuration();
        config.locale = locJa;

        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());

        locJa = null;
        config = null;
    }

    public static boolean emailValidation(String email) {
        boolean validEmailAddress = true;
        if (email.length() == 0) {
            validEmailAddress = false;
        } else {
            if (!email.contains(".") || !email.contains("@")) {
                validEmailAddress = false;
            } else {
                int index1 = email.indexOf("@");
                String subStringType = email.substring(index1);
                int index2 = index1 + subStringType.indexOf(".");
                if (index1 == 0 || index2 == 0) {
                    validEmailAddress = false;
                } else {
                    String typeOf = email.substring(index1, index2);
                    if (typeOf.length() < 1) {
                        validEmailAddress = false;
                    }
                    String typeOf2 = email.substring(index2);
                    if (typeOf2.length() < 2) {
                        validEmailAddress = false;
                    }
                }

            }
        }

        return validEmailAddress;
    }

    public static String parseDate(String inputDate, String inputPattern, String outputPattern) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(inputDate);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getCurrentDateTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    public static void ShareTipDataByWhatsAPP(Context _ctx,String topicName,String subject,String topparagraph
            ,StringBuilder sb,String bottompara,String published_by){

        final String msg = "Hi,\n" +
                "I would like to share one good "+topicName+" Tip with you\n" +
                subject +
                AppConstants.SPACE+topparagraph+"\n"+AppConstants.SPACE+sb.toString().trim()+"\n"+bottompara +
                AppConstants.SPACE+"Posted by,\n" +
                AppConstants.SPACE+ published_by+" on EduBuzz APP\n" +
                AppConstants.SPACE+"Uplift your Life with EduBuzz !!";

        boolean isWhatsappInstalled = whatsappInstalledOrNot(_ctx,"com.whatsapp");
        if (isWhatsappInstalled) {
            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = msg;
            PackageManager pm = _ctx.getPackageManager();
            try {
                PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }


            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            _ctx.startActivity(Intent.createChooser(waIntent, "Share with"));
        } else {

            Toast.makeText(_ctx, "WhatsApp not Installed",
                    Toast.LENGTH_SHORT).show();
                     /*   Uri uri = Uri.parse("market://details?id=com.whatsapp");
                        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(goToMarket);*/

        }
    }

    public static void ShareTipDataByFacebook(Context _ctx,String topicName,String subject,String topparagraph
            ,StringBuilder sb,String bottompara,String published_by){

        final String msg = "Hi,\n" +
                "I would like to share one good "+topicName+" Tip with you\n" +
                subject +
                AppConstants.SPACE+topparagraph+"\n"+AppConstants.SPACE+sb.toString().trim()+"\n"+bottompara +
                AppConstants.SPACE+"Posted by,\n" +
                AppConstants.SPACE+ published_by+" on EduBuzz APP\n" +
                AppConstants.SPACE+"Uplift your Life with EduBuzz !!";
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"EduBuzz");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "" + msg);
//                        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);

        PackageManager pm = _ctx.getPackageManager();
        List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
        for (final ResolveInfo app : activityList) {
            if ((app.activityInfo.name).contains("facebook")) {
                final ActivityInfo activity = app.activityInfo;
                final ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                shareIntent.setComponent(name);
                _ctx.startActivity(shareIntent);
                break;
            }
        }

    }

    public static void ShareTipDataByTwitter(Context _ctx,String topicName,String subject,String topparagraph
            ,StringBuilder sb,String bottompara,String published_by){

        final String msg = "Hi,\n" +
                "I would like to share one good "+topicName+" Tip with you\n" +
                subject +
                AppConstants.SPACE+topparagraph+"\n"+AppConstants.SPACE+sb.toString().trim()+"\n"+bottompara +
                AppConstants.SPACE+"Posted by,\n" +
                AppConstants.SPACE+ published_by+" on EduBuzz APP\n" +
                AppConstants.SPACE+"Uplift your Life with EduBuzz !!";

        Intent tweetIntent = new Intent(Intent.ACTION_SEND);
        tweetIntent.putExtra(Intent.EXTRA_TEXT, "" + msg);
        tweetIntent.setType("text/plain");

        PackageManager packManager = _ctx.getPackageManager();
        List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

        boolean resolved = false;
        for(ResolveInfo resolveInfo: resolvedInfoList){
            if(resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")){
                tweetIntent.setClassName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name);
                resolved = true;
                break;
            }
        }
        if(resolved){
            _ctx.startActivity(tweetIntent);
        }else{
            Intent i = new Intent();
            i.putExtra(Intent.EXTRA_TEXT, ""+msg);
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://twitter.com/intent/tweet?text=message&via=profileName"));
            _ctx.startActivity(i);
            Toast.makeText(_ctx, "Twitter app isn't found", Toast.LENGTH_LONG).show();
        }

    }

    public static void ShareLessonData(){

    }

    public static boolean whatsappInstalledOrNot(Context ctx,String uri) {
        PackageManager pm = ctx.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }


//end of main class
}