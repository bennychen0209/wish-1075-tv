package com.huawei.example.bumperapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//public class MainActivity extends Activity {
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    public void UpdateClick(View view) {
//        try {
//            // Здесь необходимо использовать имя пакета вашего приложения. Так как имя пакета и сертификат
//            // у бампера такой же, как у основного приложения, он просто будет заменён основным приложением при обновлении.
//            // versionCode в build.gradle должен быть заведомо ниже, чем у основного приложения
//
//            String appId = "com.wish1075";
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("appmarket://details?id=" + appId));
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.setPackage("com.huawei.appmarket.tv");
//            startActivity(intent);
//        } catch (ActivityNotFoundException ex) {
//            Toast.makeText(this, "DEBUG: AppGallery not found", Toast.LENGTH_SHORT).show();
//        }
//    }
//}

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startPlayMarket("com.wish1075");
        finish();
    }

    private void startPlayMarket(String component) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);

            String deepLinkUrl = "appmarket://details?id=" + component; // For Huawei AppGallery
            intent.setPackage("com.huawei.appmarket.tv");
            intent.setData(Uri.parse(deepLinkUrl));
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, "DEBUG: App Market not found", Toast.LENGTH_SHORT).show();
        }
    }
}