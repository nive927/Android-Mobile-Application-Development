package com.example.dynamicwebpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        WebAppClient webViewClient = new WebAppClient(MainActivity.this);

        webView.setWebViewClient(webViewClient);

//        https - very important
//        webView.loadUrl("https://www.ssn.edu.in");


//        Load own html - mimeType and encoding is important
        webView.loadData("<html>" +
                "<body style=\"background-color:yellow; text-align:center;\">" +
                "<br><br>" +
                "<h1 style=\"text-decoration: underline\">Nivedhitha's<br>Website</h1>" +
                "<br><br>" +
                "<h2>" +
                "<p>Hello, Welcome !!!!</p>" +
                "<b>Thanks for visiting my website !!!!</b><br><br>" +
                "<i>Have a nice day!!!!</i><br><br>" +
                "</h2>" +
                "<br><br><br>" +
                "<h3>" +
                "<em>Visit my website again</em><br><br>" +
                "</h3>" +
                "</body>" +
                "</html>", "text/html", "UTF-8");
    }
}