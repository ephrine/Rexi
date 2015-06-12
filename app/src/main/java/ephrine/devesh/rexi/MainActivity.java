package ephrine.devesh.rexi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends ActionBarActivity {

    InterstitialAd mInterstitialAd;
    public static final String MyPrescList = "MyPrescList" ;
    public static final String presc1_pref = "presc1";
    public static final String presc2_pref = "presc2";
    public static final String presc3_pref = "presc2";
    public static final String presc4_pref = "presc2";
    public static final String presc5_pref = "presc2";

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
   LinearLayout ll1 = (LinearLayout)findViewById(R.id.ll1);
        LinearLayout ll2 = (LinearLayout)findViewById(R.id.ll2);
        LinearLayout ll3 = (LinearLayout)findViewById(R.id.ll3);
        LinearLayout ll4 = (LinearLayout)findViewById(R.id.ll4);
        LinearLayout ll5 = (LinearLayout)findViewById(R.id.ll5);
ll1.setVisibility(View.GONE);
     ll2.setVisibility(View.GONE);
    ll3.setVisibility(View.GONE);
  ll4.setVisibility(View.GONE);
  ll5.setVisibility(View.GONE);



        sharedpreferences = getSharedPreferences(MyPrescList, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
       // editor.putString(null,"");
        editor.commit();
        String presc1 = sharedpreferences.getString(presc1_pref,"");
        String presc2 = sharedpreferences.getString(presc2_pref,"");
        String presc3 = sharedpreferences.getString(presc3_pref,"");
        String presc4 = sharedpreferences.getString(presc4_pref,"");
        String presc5 = sharedpreferences.getString(presc5_pref,"");

        if(presc1=="yes"){
   ll1.setVisibility(View.VISIBLE);
}
        if(presc2=="yes"){
            ll2.setVisibility(View.VISIBLE);
        }
        if(presc3=="yes"){
            ll3.setVisibility(View.VISIBLE);
        }
        if(presc4=="yes"){
            ll4.setVisibility(View.VISIBLE);
        }
        if(presc5=="yes"){
            ll5.setVisibility(View.VISIBLE);
        }


      //  WebView myWebView = (WebView) findViewById(R.id.webView);
             //  myWebView.loadUrl("https://sites.google.com/site/rexiandroidapp");
      //  WebSettings webSettings = myWebView.getSettings();
     //   webSettings.setJavaScriptEnabled(true);
      //  myWebView.setWebViewClient(new WebViewClient());
      //  myWebView.setWebViewClient(new MyWebViewClient());

        mInterstitialAd = new InterstitialAd(this);

         mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");   // Test Ad ID

       // mInterstitialAd.setAdUnitId("ca-app-pub-6702661245453687/7466670653"); // My own F***king Ad ID

        requestNewInterstitial();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();


            }
        });

    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
               // .addTestDevice("YOUR_DEVICE_HASH")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public void pharma_p(View v) {
        Intent intent = new Intent(this, PharmaPresc.class);
        startActivity(intent);

    }

    public void label(View v) {
        Intent intent = new Intent(this, Label.class);
        startActivity(intent);

            }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            finish();

        } else {
            finish();
        }

    }

    public void about(View v){
        Intent intent = new Intent(this, about.class);
        startActivity(intent);
    }


    private class MyWebViewClient extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (Uri.parse(url).getHost().equals("https://sites.google.com")) {
                // This is my web site, so do not override; let my WebView load the page

                return false;
            }
            if (Uri.parse(url).getHost().equals("sites.google.com")) {
                // This is my web site, so do not override; let my WebView load the page

                return false;
            }
            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

        }


    }
}
