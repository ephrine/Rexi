package ephrine.devesh.rexi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by Devesh & Madhuri on 6/2/2015.
 */
public class Label extends ActionBarActivity {

    public String pharma_stor_val;
    public String addres_pharma_store_val;
    public String phno_pharma_store_val;
    public String doc_name_val;
    public String drug_val;
    public String rx_no__val;
    public String pat_name_val;
    public String dose_val;
    public String freq_value;
    public String refill_val;
    public String presc_date_val;
    public String use_bef_date_val;
    public String mfg_name_val;
    public String qty_val;

    public String saveas_val;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.label);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void open_p(View v){
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        String f = "/sdcard/" + saveas_val + ".html";
        File file = new File(f);
        intent.setDataAndType(Uri.fromFile(file), "text/html");
        startActivity(intent);

    }
    public void next1(View v){
        EditText pharma_store = (EditText) findViewById(R.id.editText11);
        EditText addres_pharma_store = (EditText) findViewById(R.id.editText);
        EditText phno_pharma_store = (EditText) findViewById(R.id.editText2);
        EditText doc_name = (EditText) findViewById(R.id.editText3);
        EditText rx_no = (EditText) findViewById(R.id.editText4);
        EditText pat_name = (EditText) findViewById(R.id.editText5);
        EditText drug = (EditText) findViewById(R.id.editText6);
        EditText dose = (EditText) findViewById(R.id.editText7);
        EditText freq = (EditText) findViewById(R.id.editText8);
        EditText refill = (EditText) findViewById(R.id.editText9);
        EditText presc_date = (EditText) findViewById(R.id.editText10);
        EditText use_bef_date = (EditText) findViewById(R.id.editText21);
        EditText mfg_name = (EditText) findViewById(R.id.editText22);
        EditText qty = (EditText) findViewById(R.id.editText23);
        EditText saveas = (EditText) findViewById(R.id.editText12);


        doc_name_val = doc_name.getText().toString();
        pat_name_val = pat_name.getText().toString();
        pharma_stor_val = pharma_store.getText().toString();
        addres_pharma_store_val = addres_pharma_store.getText().toString();
        drug_val = drug.getText().toString();
        phno_pharma_store_val = phno_pharma_store.getText().toString();
        rx_no__val = rx_no.getText().toString();
        dose_val = dose.getText().toString();
        freq_value = freq.getText().toString();
        refill_val = refill.getText().toString();
        presc_date_val = presc_date.getText().toString();
        use_bef_date_val = use_bef_date.getText().toString();
        mfg_name_val = mfg_name.getText().toString();
        qty_val = qty.getText().toString();
        saveas_val = saveas.getText().toString();

        String filename = saveas_val + ".html";
        String data = "<html><head><title> Label</title>\n" +
                "\n" +
                "</head><body>\n" +
                "\n" +
                "<h2>&nbsp; &nbsp; &nbsp; "+pharma_stor_val+"</h1>\n" +
                addres_pharma_store_val+"<br>\n" +
                phno_pharma_store_val+"&nbsp; &nbsp; &nbsp; Date: "+presc_date_val+"\n" +
                "<hr>\n" +
                "<i>Dr. "+doc_name_val+"</i> \n" +
                "<h3>Rx no: "+rx_no__val+"</h3>\n" +
                "<h2><b>"+pat_name_val+"</b></h2>\n" +
                "Dose:  "+dose_val+" &nbsp; &nbsp; &nbsp; , frequency: "+freq_value+"<br>\n" +
                "<b>"+drug_val+" </b>  &nbsp; &nbsp; &nbsp Mfg: "+mfg_name_val+"<br>\n" +
                "Qty: "+qty_val+"<br>\n" +
                "Refill Instructions: "+refill_val+"  &nbsp; &nbsp; &nbsp BEFORE: "+use_bef_date_val+"\n" +
                "<hr>\n" +
                "\n" +
                "</body></html>";

        try {
            File myFile = new File("/sdcard/" + filename);
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(data);
            myOutWriter.close();
            fOut.close();


            Toast.makeText(getApplicationContext(), "Label is created successfully and saved as " + filename + "", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.label_finish);

            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void m_nxt(View v){
        setContentView(R.layout.next);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        }
    public void home(View v){
        finish();
    }




}
