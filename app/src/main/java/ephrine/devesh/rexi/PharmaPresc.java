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
 * Created by Devesh & Madhuri on 5/31/2015.
 */
public class PharmaPresc extends ActionBarActivity {
    /*public EditText doc_name=(EditText)findViewById(R.id.editText11);
    public EditText pat_name=(EditText)findViewById(R.id.editText);
    public EditText dob=(EditText)findViewById(R.id.editText2);
    public EditText addr=(EditText)findViewById(R.id.editText3);
    public EditText drug=(EditText)findViewById(R.id.editText4);
    public EditText strength=(EditText)findViewById(R.id.editText5);
    public EditText amount=(EditText)findViewById(R.id.editText6);
    public EditText route=(EditText)findViewById(R.id.editText7);
    public EditText freq=(EditText)findViewById(R.id.editText8);
    public EditText refill=(EditText)findViewById(R.id.editText9);
    public EditText presc_date=(EditText)findViewById(R.id.editText10);*/
    public String doc_name_val;
    public String pat_name_val;
    public String dob_val;
    public String addr_val;
    public String drug_val;
    public String strength_val;
    public String amount_val;
    public String route_val;
    public String freq_value;
    public String refill_val;
    public String presc_date_val;
    public String saveas_val;
    public String drug_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pharmapresc);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
    public void m_nxt(View v){
        setContentView(R.layout.next);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void next1(View v) {

        EditText doc_name = (EditText) findViewById(R.id.editText11);
        EditText pat_name = (EditText) findViewById(R.id.editText);
        EditText dob = (EditText) findViewById(R.id.editText2);
        EditText addr = (EditText) findViewById(R.id.editText3);
        EditText drug = (EditText) findViewById(R.id.editText4);
        EditText strength = (EditText) findViewById(R.id.editText5);
        EditText amount = (EditText) findViewById(R.id.editText6);
        EditText route = (EditText) findViewById(R.id.editText7);
        EditText freq = (EditText) findViewById(R.id.editText8);
        EditText refill = (EditText) findViewById(R.id.editText9);
        EditText presc_date = (EditText) findViewById(R.id.editText10);
        EditText saveas = (EditText) findViewById(R.id.editText12);


        doc_name_val = doc_name.getText().toString();
        pat_name_val = pat_name.getText().toString();
        dob_val = dob.getText().toString();
        addr_val = addr.getText().toString();
        drug_val = drug.getText().toString();
        strength_val = strength.getText().toString();
        amount_val = amount.getText().toString();
        route_val = route.getText().toString();
        freq_value = freq.getText().toString();
        refill_val = refill.getText().toString();
        presc_date_val = presc_date.getText().toString();
        saveas_val = saveas.getText().toString();

        setContentView(R.layout.presc_layout);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }
    public void home(View v){
        finish();
    }
    public void open_p(View v){
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        String f = "/sdcard/" + saveas_val + ".html";
        File file = new File(f);
        intent.setDataAndType(Uri.fromFile(file), "text/plain");
        startActivity(intent);

    }

    public void type1(View v) {


        String filename = saveas_val + ".html";
        String data = "<html><head><title> Prescription of Dr. " + doc_name_val + "</title></head><body>" +
                "<h1>Dr. " + doc_name_val + "</h1><br>\n" +
                "Patient Name: " + pat_name_val + "<br>\n" +
                "Address: " + addr_val + " <br>\n" +
                "Date of birth: " + addr_val + "<br>\n" +
                "<hr>\n" +
                "<h1>Rx</h1>\n" +
                "" + drug_val + " &nbsp; &nbsp; &nbsp; " + strength_val + "<br>\n" +
                "" + amount_val + "  &nbsp; &nbsp; &nbsp; " + freq_value + "<br>\n" +
                "Route: " + route_val + "<br>\n" +
                "Refill Instructions: " + refill_val + "<br>\n" +
                "<hr>\n" +
                "<h3> Dr. " + doc_name_val + "</h3>\n" + "<br><br>" +
                "Signature:\n" +
                "<h4>Date:" + presc_date_val + "</h4>\n" +

                "\n" +
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


            Toast.makeText(getApplicationContext(), "Prescription is created successfully and saved as "+filename + "", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.presc_finish);

            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void type2(View v) {
        String filename = saveas_val + ".html";
        String data = "<html><head><title> Prescription of Dr. " + doc_name_val + "</title></head><body background=\"https://sites.google.com/site/deveshhub/bg2.jpg\">" +
                "<h1><img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\">Dr." + doc_name_val +" <img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\"></h1><br>" +
                "Patient Name: " + pat_name_val + "<br>\n" +
                "Address: " + addr_val + " <br>\n" +
                "Date of birth: " + addr_val + "<br>\n" +
                "<hr>\n" +
                "<h1>Rx</h1>\n" +
                "" + drug_val + " &nbsp; &nbsp; &nbsp; " + strength_val + "<br>\n" +
                "" + amount_val + "  &nbsp; &nbsp; &nbsp; " + freq_value + "<br>\n" +
                "Route: " + route_val + "<br>\n" +
                "Refill Instructions: " + refill_val + "<br>\n" +
                "<hr>\n" +
                "<h3> Dr. " + doc_name_val + "</h3>\n" + "<br><br>" +
                "Signature:\n" +
                "<h4>Date:" + presc_date_val + "</h4>\n" +

                "\n" +
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
            Toast.makeText(getApplicationContext(), "Prescription is created successfully and saved as "+filename + "", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.presc_finish);

            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

/*
            Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            String f = "/sdcard/" + saveas_val + ".html";
            File file = new File(f);
            intent.setDataAndType(Uri.fromFile(file), "url/text/*");
            startActivity(intent);
*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void type3(View v) {
        String filename = saveas_val + ".html";

        String data = "<html><head><title> Prescription of Dr. " + doc_name_val + "</title></head><body background=\"https://sites.google.com/site/deveshhub/bg.jpg\">" +
                "<h1><img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\">Dr." + doc_name_val +"<img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\"></h1><br>" +
                "Patient Name: " + pat_name_val + "<br>\n" +
                "Address: " + addr_val + " <br>\n" +
                "Date of birth: " + addr_val + "<br>\n" +
                "<hr>\n" +
                "<h1>Rx</h1>\n" +
                "" + drug_val + " &nbsp; &nbsp; &nbsp; " + strength_val + "<br>\n" +
                "" + amount_val + "  &nbsp; &nbsp; &nbsp; " + freq_value + "<br>\n" +
                "Route: " + route_val + "<br>\n" +
                "Refill Instructions: " + refill_val + "<br>\n" +
                "<hr>\n" +
                "<h3> Dr. " + doc_name_val + "</h3>\n" + "<br><br>" +
                "Signature:\n" +
                "<h4>Date:" + presc_date_val + "</h4>\n" +
                "\n" +
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
            setContentView(R.layout.presc_finish);

            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

        /*    Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            String f = "/sdcard/" + saveas_val + ".html";
            File file = new File(f);
            intent.setDataAndType(Uri.fromFile(file), "url/text/*");
            startActivity(intent);
*/
            Toast.makeText(getApplicationContext(), "Prescription is created successfully and saved as "+filename + "", Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	
	 public void type4(View v) {
        String filename = saveas_val + ".html";

        String data = "<html><head><title> Prescription of Dr. " + doc_name_val + "</title></head><body background=\"https://sites.google.com/site/deveshhub/bg3.jpg\">" +
                "<h1><img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\">Dr." + doc_name_val +"<img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\"></h1><br>" +
                "Patient Name: " + pat_name_val + "<br>\n" +
                "Address: " + addr_val + " <br>\n" +
                "Date of birth: " + addr_val + "<br>\n" +
                "<hr>\n" +
                "<h1>Rx</h1>\n" +
                "" + drug_val + " &nbsp; &nbsp; &nbsp; " + strength_val + "<br>\n" +
                "" + amount_val + "  &nbsp; &nbsp; &nbsp; " + freq_value + "<br>\n" +
                "Route: " + route_val + "<br>\n" +
                "Refill Instructions: " + refill_val + "<br>\n" +
                "<hr>\n" +
                "<h3> Dr. " + doc_name_val + "</h3>\n" + "<br><br>" +
                "Signature:\n" +
                "<h4>Date:" + presc_date_val + "</h4>\n" +
                "\n" +
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
            setContentView(R.layout.presc_finish);

            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

        /*  
*/
            Toast.makeText(getApplicationContext(), "Prescription is created successfully and saved as "+filename + "", Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	 public void type5(View v) {
        String filename = saveas_val + ".html";

        String data = "<html><head><title> Prescription of Dr. " + doc_name_val + "</title></head><body background=\"https://sites.google.com/site/deveshhub/bg5.jpg\">" +
                "<h1><img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\">Dr." + doc_name_val +"<img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\"></h1><br>" +
                "&nbsp; &nbsp;Patient Name: " + pat_name_val + "<br>\n" +
                "&nbsp; &nbsp;Address: " + addr_val + " <br>\n" +
                "&nbsp; &nbsp;Date of birth: " + addr_val + "<br>\n" +
                "<hr>\n" +
                "<h1>Rx</h1>\n" +
                "&nbsp; &nbsp;" + drug_val + " &nbsp; &nbsp; &nbsp; " + strength_val + "<br>\n" +
                "&nbsp; &nbsp;" + amount_val + "  &nbsp; &nbsp; &nbsp; " + freq_value + "<br>\n" +
                "&nbsp; &nbsp;Route: " + route_val + "<br>\n" +
                "&nbsp; &nbsp;Refill Instructions: " + refill_val + "<br>\n" +
                "<hr>\n" +
                "<h3>&nbsp; &nbsp; Dr. " + doc_name_val + "</h3>\n" + "<br><br>" +
                "&nbsp; &nbsp;Signature:\n" +
                "<h4>&nbsp; &nbsp;Date:" + presc_date_val + "</h4>\n" +
                "\n" +
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
            setContentView(R.layout.presc_finish);

            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

        /*  
*/
            Toast.makeText(getApplicationContext(), "Prescription is created successfully and saved as "+filename + "", Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


	 public void type6(View v) {
        String filename = saveas_val + ".html";

        String data = "<html><head><title> Prescription of Dr. " + doc_name_val + "</title></head><body background=\"https://sites.google.com/site/deveshhub/bg4.jpg\">" +
                "<h1><img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\">Dr." + doc_name_val +"<img src=\"https://sites.google.com/site/deveshhub/doc.png\" height=\"50\" weight=\"50\"></h1><br>" +
                "&nbsp; &nbsp;Patient Name: " + pat_name_val + "<br>\n" +
                "&nbsp; &nbsp;Address: " + addr_val + " <br>\n" +
                "&nbsp; &nbsp;Date of birth: " + addr_val + "<br>\n" +
                "<hr>\n" +
                "<h1>Rx</h1>\n" +
                "&nbsp; &nbsp;" + drug_val + " &nbsp; &nbsp; &nbsp; " + strength_val + "<br>\n" +
                "&nbsp; &nbsp;" + amount_val + "  &nbsp; &nbsp; &nbsp; " + freq_value + "<br>\n" +
                "&nbsp; &nbsp;Route: " + route_val + "<br>\n" +
                "&nbsp; &nbsp;Refill Instructions: " + refill_val + "<br>\n" +
                "<hr>\n" +
                "<h3>&nbsp; &nbsp; Dr. " + doc_name_val + "</h3>\n" + "<br><br>" +
                "&nbsp; &nbsp;Signature:\n" +
                "<h4>&nbsp; &nbsp;Date:" + presc_date_val + "</h4>\n" +
                "\n" +
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
            setContentView(R.layout.presc_finish);

            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);


            Toast.makeText(getApplicationContext(), "Prescription is created successfully and saved as "+filename + "", Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

public void add_drug(View v){

}





}
