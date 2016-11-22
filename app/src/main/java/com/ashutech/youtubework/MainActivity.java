package com.ashutech.youtubework;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.youtube.player.YouTubeBaseActivity;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    Button b1;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);
        webView = (WebView) this.findViewById(R.id.webView);

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo == null || networkInfo.isConnected() == false) {
            webView.loadData("<h1> NO_INTERNET - CHECK AGAIN </h1>",
                    "text/html",
                    null);
            return;
        }


        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                Intent intent = new Intent(MainActivity.this, YouTubeBaseActivity.class);
                intent.putExtra("ur", url);
                startActivity(intent);

            }
        });
        /*webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent intent = new Intent(MainActivity.this, YouTubeBaseActivity.class);
                intent.putExtra("ur", url);
                startActivity(intent);
                return true;
            }
        });*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et1.getText().toString();
                //String url = "http://www.youtube.com/results?q="+ str;
                webView.loadUrl("http://www.youtube.com/results?q="+str);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());


            }
        });



    }

}



