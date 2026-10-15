package com.didomodz.apkbuilder;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.widget.Toast;
import android.net.Uri;
import android.graphics.Color;
import android.os.Build;

public class MainActivity extends Activity {
    private static final String START_URL = "https://example.com";
    private WebView webView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        webView = new WebView(this);
        setContentView(webView);
        int color = Color.parseColor(BuildConfig.THEME_COLOR);
        webView.setBackgroundColor(color);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(color);
            getWindow().setNavigationBarColor(color);
        }

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setSupportMultipleWindows(false);
        settings.setTextZoom(BuildConfig.TEXT_ZOOM);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, android.webkit.WebResourceRequest request) {
                Uri uri = request.getUrl();
                if ("https".equalsIgnoreCase(uri.getScheme())) {
                    return false;
                }
                Toast.makeText(MainActivity.this, "Por segurança, somente endereços HTTPS são permitidos.", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(START_URL);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
