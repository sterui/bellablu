package com.bellabluclient;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FotoRosso extends ActionBarActivity {
	private String colore;
	
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foto_rosso);
		StrictMode.enableDefaults();
		setTitle("Scelta Cameriere");
		 Bundle extras = getIntent().getExtras();
	        if(extras !=null) {
	        colore = extras.getString("colore");
	        }
	          
       
		RelativeLayout li=(RelativeLayout)findViewById(R.id.relative1);
		if(colore.equals("Rosso"))
		li.setBackgroundColor(Color.RED);
		else li.setBackgroundColor(Color.GREEN);
		setControllo();
		
final Thread thread3 = new Thread(){
            
        	@Override
           public void run() {
                try {
                	 Thread.sleep(60000);
                	 Intent data = new Intent();
                     String text2 = "Nullo";
                     //---set the data to pass back---
                    data.setData(Uri.parse(text2));
                       setResult(RESULT_OK, data);
                	
                     finish();// As I am using LENGTH_LONG in Toast
                     
                   
               } catch (Exception e) {
                   e.printStackTrace();
               }
            }  
          };
          
          thread3.start();
		
		 

	      
		
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foto_rosso, menu);
		return true;
	}

	
	public void onClickIm(View view) {
		LayoutInflater inflater = getLayoutInflater();
        // Inflate the Layout
        View layout = inflater.inflate(R.layout.toast,
                                       (ViewGroup) findViewById(R.id.custom_toast_layout));

        TextView text = (TextView) layout.findViewById(R.id.textToShow);
        // Set the Text to show in TextView
        text.setText("Grazie per aver votato!!! Thanks for your rating!!!!");
        text.setTextColor(Color.BLACK);
        text.setTextSize(40);         
		  final Toast toast = new Toast(getApplicationContext());
	        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
	        toast.setDuration(Toast.LENGTH_LONG);
	        toast.setView(layout);
	        
		 Intent data = new Intent();
	     String text2 = "Raneri Massimo";
	     //---set the data to pass back---
	    data.setData(Uri.parse(text2));
	       setResult(RESULT_OK, data);
	       FotoRosso.this.runOnUiThread(new Runnable() {
      		    public void run() {
     		        //Toast.makeText(English.this, "Thanks for your rating!", Toast.LENGTH_LONG).show();
      		    	toast.show();
     		    }});
	     //---close the activity---
	     finish();
		
	}
public void onClickIm2(View view) {
	LayoutInflater inflater = getLayoutInflater();
    // Inflate the Layout
    View layout = inflater.inflate(R.layout.toast,
                                   (ViewGroup) findViewById(R.id.custom_toast_layout));

    TextView text = (TextView) layout.findViewById(R.id.textToShow);
    // Set the Text to show in TextView
    text.setText("Grazie per aver votato!!! Thanks for your rating!!!!");
    text.setTextColor(Color.BLACK);
    text.setTextSize(40);         
	  final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        
	 Intent data = new Intent();
     String text2 = "Ragonese Venero";
     //---set the data to pass back---
    data.setData(Uri.parse(text2));
       setResult(RESULT_OK, data);
       FotoRosso.this.runOnUiThread(new Runnable() {
  		    public void run() {
 		        //Toast.makeText(English.this, "Thanks for your rating!", Toast.LENGTH_LONG).show();
  		    	toast.show();
 		    }});
     //---close the activity---
     finish();
	}
public void onClickIm3(View view) {
	LayoutInflater inflater = getLayoutInflater();
    // Inflate the Layout
    View layout = inflater.inflate(R.layout.toast,
                                   (ViewGroup) findViewById(R.id.custom_toast_layout));

    TextView text = (TextView) layout.findViewById(R.id.textToShow);
    // Set the Text to show in TextView
    text.setText("Grazie per aver votato!!! Thanks for your rating!!!!");
    text.setTextColor(Color.BLACK);
    text.setTextSize(40);         
	  final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        
	 Intent data = new Intent();
     String text2 = "Marouf Salah Eddine";
     //---set the data to pass back---
    data.setData(Uri.parse(text2));
       setResult(RESULT_OK, data);
       FotoRosso.this.runOnUiThread(new Runnable() {
  		    public void run() {
 		        //Toast.makeText(English.this, "Thanks for your rating!", Toast.LENGTH_LONG).show();
  		    	toast.show();
 		    }});
     //---close the activity---
     finish();
	
}
public void onClickIm4(View view) {
	LayoutInflater inflater = getLayoutInflater();
    // Inflate the Layout
    View layout = inflater.inflate(R.layout.toast,
                                   (ViewGroup) findViewById(R.id.custom_toast_layout));

    TextView text = (TextView) layout.findViewById(R.id.textToShow);
    // Set the Text to show in TextView
    text.setText("Grazie per aver votato!!! Thanks for your rating!!!!");
    text.setTextColor(Color.BLACK);
    text.setTextSize(40);         
	  final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        
	 Intent data = new Intent();
     String text2 = "Bougrine Adel";
     //---set the data to pass back---
    data.setData(Uri.parse(text2));
       setResult(RESULT_OK, data);
       FotoRosso.this.runOnUiThread(new Runnable() {
  		    public void run() {
 		        //Toast.makeText(English.this, "Thanks for your rating!", Toast.LENGTH_LONG).show();
  		    	toast.show();
 		    }});
     //---close the activity---
     finish();
	
}
public void setControllo()
{
	 try{
		
		 HttpParams httpParameters = new BasicHttpParams();
		 int timeoutConnection = 4000;
		 HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
		 int timeoutSocket = 6000;
		 HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
         HttpClient httpclient = new DefaultHttpClient(httpParameters);
         HttpPost httppost = new HttpPost("http://bellablu.dx.am/controllo.php");
        
         httpclient.execute(httppost);
         
       
      }
      catch(Exception e){
   	   Log.e("log_tag2", "Error converting result "+e.toString());
          System.out.println("Error in http connection "+e.toString());
          Intent data = new Intent();
          String text2 = "Nullo";
          //---set the data to pass back---
         data.setData(Uri.parse(text2));
            setResult(RESULT_OK, data);
     	
          finish();
    }
}
@Override
public void onBackPressed() {
}

	}



