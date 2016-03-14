package com.bellabluclient;



import java.io.BufferedReader;
import java.io.IOException;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class English extends ActionBarActivity {

	TextView t1, t2, t3;
	RatingBar ib1,ib2,ib3;
    int cont,a,b,c=0;
    /*private final int delayTime = 180000;
    private Handler myHandler = new Handler();*/
    String nation="English";
    private InputStream is;
	private String result;
	Calendar ca = Calendar.getInstance(); 
	private int num=0;
	private int num2=2;
	static final int REQ_CODE = 1;
	private String nomeRes="nullo";
	
	
   
   
    int food, pulizia, servizio;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        setTitle("BellaBlu Rating");
        final Intent intent = new Intent(this, FotoRosso.class);
        final Intent intent2 = new Intent(this, English.class);
        final Thread thread3 = new Thread(){
            
        	@Override
           public void run() {
                try {
                	 Thread.sleep(50000);
                	 setControllo();
                     finish();// As I am using LENGTH_LONG in Toast
                     startActivity(intent2);
                   
               } catch (Exception e) {
                   e.printStackTrace();
               }
            }  
          };
          
          //thread3.start();
          
        
       /* Bundle extras = getIntent().getExtras();
        if(extras !=null) {
        nation = extras.getString("nazione");
        }*/
          
        
        /*Bundle extras = getIntent().getExtras();
        if(extras !=null) {
        nation = extras.getString("nation");
        }*/
        StrictMode.enableDefaults();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        ib1= (RatingBar) findViewById(R.id.ratingBar1);
        ib2= (RatingBar) findViewById(R.id.ratingBar2);
        ib3= (RatingBar) findViewById(R.id.ratingBar3);
       
        ib1.setStepSize(1.0f);
        ib2.setStepSize(1.0f);
        ib3.setStepSize(1.0f);
      
        t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        
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
      
       
        /*final Thread thread = new Thread(){
            
        	@Override
           public void run() {
                try {
                   Thread.sleep(3500);
                   setControllo();
                   finish();// As I am using LENGTH_LONG in Toast
                   startActivity(intent2);
                   
               } catch (Exception e) {
                   e.printStackTrace();
               }
            }  
          };*/
          final Thread thread2 = new Thread(){
              
          	@Override
             public void run() {
                  try {
                	  sendRating2(food, pulizia, servizio, nation, nomeRes);
                	 thread3.interrupt();
                	  English.this.runOnUiThread(new Runnable() {
               		    public void run() {
              		        //Toast.makeText(English.this, "Thanks for your rating!", Toast.LENGTH_LONG).show();
               		    	toast.show();
              		    }});
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
              }  
            };
        
            /*final Thread thread4 = new Thread(){
                
              	@Override
                 public void run() {
                      try {
                    	  sendRating2(food, pulizia, servizio, nation, nomeRes);
                    	  thread3.interrupt();
                    	  English.this.runOnUiThread(new Runnable() {
                   		    public void run() {
                  		        //Toast.makeText(English.this, "Thanks for your rating!", Toast.LENGTH_LONG).show();
                   		    	toast.show();
                  		    }});
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
                  }  
                };*/
                
        ib1.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
    		public void onRatingChanged(RatingBar ratingBar, float rating,
    				boolean fromUser){
            	check();
            	if (num2== 2){
            	if (num == 1){
    			cont++;
    			food=(int) ib1.getRating();
    			food-=3;
    			//ib1.setBackgroundColor(Color.BLUE);
    			if(a<1){
    				a++;
    				if(servizio < 0  && cont>=3 && a==1 && b==1 && c==1){
    					 thread3.interrupt();
        				intent.putExtra("colore", "Rosso");
        				startActivityForResult(intent, REQ_CODE);
        			} //do sth
        			else if(servizio > 0 && cont>=3 && a==1 && b==1 && c==1){
        				 thread3.interrupt();
        				intent.putExtra("colore", "verde");
        				startActivityForResult(intent, REQ_CODE);
        				
        			}
        			else if(cont>=3 && a==1 && b==1 && c==1){
        				ib3.setRating(0.0f);
        				ib2.setRating(0.0f);
        				ib1.setRating(0.0f);
        				thread2.start();
        				finish();
        				startActivity(intent2);
        			}
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				num=0;
    				
    			//thread.start();
    			}
    			}
    		}else { 
		        Toast.makeText(English.this, "Locked!!", Toast.LENGTH_SHORT).show();
		        ib1.setRating(0.0f);
		   }
            	}
            	else{
            		cont++;
        			food=(int) ib1.getRating();
        			food-=3;
        			//ib1.setBackgroundColor(Color.BLUE);
        			if(a<1){
        				a++;
        				if(servizio < 0  && cont>=3 && a==1 && b==1 && c==1){
        					 thread3.interrupt();
            				intent.putExtra("colore", "Rosso");
            				startActivityForResult(intent, REQ_CODE);
            			} //do sth
            			else if(servizio > 0 && cont>=3 && a==1 && b==1 && c==1){
            				 thread3.interrupt();
            				intent.putExtra("colore", "verde");
            				startActivityForResult(intent, REQ_CODE);
            				
            			}
            			else if(cont>=3 && a==1 && b==1 && c==1){
            				ib3.setRating(0.0f);
            				ib2.setRating(0.0f);
            				ib1.setRating(0.0f);
            				thread2.start();
            				finish();
            				startActivity(intent2);
            			}
        			if(cont>=3 && a==1 && b==1 && c==1){
        				//sendRating(food, pulizia, servizio, nation);
        				num=0;
        				
        			//thread.start();
        			}
        			}
            		
            		
            	}
            }});
        ib2.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
    		public void onRatingChanged(RatingBar ratingBar, float rating,
    				boolean fromUser){
            	check();
            	if (num2== 2){
            	if (num == 1){
    			cont++;
    			pulizia=(int) ib2.getRating();
    			pulizia-=3;
    			//ib2.setBackgroundColor(Color.BLUE);
    			if(b<1){
    				b++;
    				if(servizio < 0 && cont>=3 && a==1 && b==1 && c==1){
    					 thread3.interrupt();
        				intent.putExtra("colore", "Rosso");
        				startActivityForResult(intent, REQ_CODE);
        			} //do sth
        			else if(servizio > 0 && cont>=3 && a==1 && b==1 && c==1){
        				 thread3.interrupt();
        				intent.putExtra("colore", "verde");
        				startActivityForResult(intent, REQ_CODE);
        				
        			}
        			else if(cont>=3 && a==1 && b==1 && c==1){
        				ib3.setRating(0.0f);
        				ib2.setRating(0.0f);
        				ib1.setRating(0.0f);
        				thread2.start();
        				finish();
        				startActivity(intent2);
        			}
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				num=0;
    				
    				
    			//thread.start();
    			}
    			}
            	}else{ 
    		        Toast.makeText(English.this, "Locked!!", Toast.LENGTH_SHORT).show();
    		        ib2.setRating(0.0f);
     		   }
            	}
            	else{
            		cont++;
        			pulizia=(int) ib2.getRating();
        			pulizia-=3;
        			//ib2.setBackgroundColor(Color.BLUE);
        			if(b<1){
        				b++;
        				if(servizio < 0 && cont>=3 && a==1 && b==1 && c==1){
        					 thread3.interrupt();
            				intent.putExtra("colore", "Rosso");
            				startActivityForResult(intent, REQ_CODE);
            			} //do sth
            			else if(servizio > 0 && cont>=3 && a==1 && b==1 && c==1){
            				 thread3.interrupt();
            				intent.putExtra("colore", "verde");
            				startActivityForResult(intent, REQ_CODE);
            				
            			}
            			else if(cont>=3 && a==1 && b==1 && c==1){
            				thread2.start();
            				ib3.setRating(0.0f);
            				ib2.setRating(0.0f);
            				ib1.setRating(0.0f);
            				
            				finish();
            				startActivity(intent2);
            			}
        			if(cont>=3 && a==1 && b==1 && c==1){
        				//sendRating(food, pulizia, servizio, nation);
        				num=0;
        				
        				
        			//thread.start();
        			}
        			}
            		
            	}
    		}
    	});
        ib3.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
    		public void onRatingChanged(RatingBar ratingBar, float rating,
    				boolean fromUser){
            	check();
            	if (num2 == 2){
            	if (num == 1){
    			cont++;
    			servizio=(int) ib3.getRating(); 			
    			servizio-=3;
    			if(c<1){
    				c++;
    			if(servizio < 0 && cont>=3 && a==1 && b==1 && c==1){
    				 thread3.interrupt();
    				intent.putExtra("colore", "Rosso");
    				startActivityForResult(intent, REQ_CODE);
    			} //do sth
    			else if(servizio > 0 && cont>=3 && a==1 && b==1 && c==1){
    				 thread3.interrupt();
    				intent.putExtra("colore", "verde");
    				startActivityForResult(intent, REQ_CODE);
    				
    			}
    			else if(cont>=3 && a==1 && b==1 && c==1){
    				thread2.start();
    				ib3.setRating(0.0f);
    				ib2.setRating(0.0f);
    				ib1.setRating(0.0f);
    				
    				finish();
    				startActivity(intent2);
    			}//do sth else
    			//ib3.setBackgroundColor(Color.BLUE);
    			
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				num=0;
    				/*if(servizio==0)
    				thread2.start();
    				else thread4.start();*/
    				
    			//thread.start();
    			}
    			}
            	}else{ 
    		        Toast.makeText(English.this, "Locked!!", Toast.LENGTH_SHORT).show();
    		        ib3.setRating(0.0f);
     		   }
    		}else {
    			cont++;
    			servizio=(int) ib3.getRating(); 			
    			servizio-=3;
    			if(c<1){
    				c++;
    			if(servizio < 0 && cont>=3 && a==1 && b==1 && c==1){
    				 thread3.interrupt();
    				intent.putExtra("colore", "Rosso");
    				startActivityForResult(intent, REQ_CODE);
    			} //do sth
    			else if(servizio > 0 && cont>=3 && a==1 && b==1 && c==1){
    				 thread3.interrupt();
    				intent.putExtra("colore", "verde");
    				startActivityForResult(intent, REQ_CODE);
    				
    			}
    			else if(cont>=3 && a==1 && b==1 && c==1){
    				thread2.start();
    				ib3.setRating(0.0f);
    				ib2.setRating(0.0f);
    				ib1.setRating(0.0f);
    				
    				finish();
    				startActivity(intent2);
    			}//do sth else
    			//ib3.setBackgroundColor(Color.BLUE);
    			
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				num=0;
    				/*if(servizio==0)
    				thread2.start();
    				else thread4.start();*/
    				
    			//thread.start();
    			}
    			}
    		}
            	}
    	});
        
       /* ib4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			cont++;
    			pulizia=-1;
    			ib4.setBackgroundColor(Color.BLUE);
    			if(b<1){
    				b++;
    			
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				thread2.start();
    				
    			thread.start();
    			}
    		}
    		}
    	});
        ib5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			cont++;
    			pulizia=0;
    			ib5.setBackgroundColor(Color.BLUE);
    			if(b<1){
    				b++;
    			
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				thread2.start();
    				
    			thread.start();
    			}
    		}
    		}
    	});
        ib6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			cont++;
    			pulizia=1;
    			ib6.setBackgroundColor(Color.BLUE);
    			if(b<1){
    				b++;
    			
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				thread2.start();
    				
    			thread.start();
    			}
    		}
    		}
    	});
        
        
        ib7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			cont++;
    			servizio=-1;
    			ib7.setBackgroundColor(Color.BLUE);
    			if(c<1){
    				c++;
    			
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				thread2.start();
    				
    			thread.start();
    			}
     
    		}}
    	});
        ib8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			cont++;
    			servizio=0;
    			ib8.setBackgroundColor(Color.BLUE);
    			if(c<1){
    				c++;
    			
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				thread2.start();
    				
    			thread.start();
    			}
     
    		}}
    	});
        ib9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			cont++;
    			servizio=1;
    			ib9.setBackgroundColor(Color.BLUE);
    			if(c<1){
    				c++;
    			
    			if(cont>=3 && a==1 && b==1 && c==1){
    				//sendRating(food, pulizia, servizio, nation);
    				thread2.start();
    				
    			thread.start();
    			}
     
    		}}
    	});*/
     //   myHandler.postDelayed(closeControls, delayTime);
       
    }
    
   /* public void onUserInteraction(){
        myHandler.removeCallbacks(closeControls);
        myHandler.postDelayed(closeControls, delayTime);
    }*/

    /*private Runnable closeControls = new Runnable() {
        public void run() {
            finish();
           
        }
    };*/
    
  
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home: 
            // API 5+ solution
            onBackPressed();
            return true;

        default:
            return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
    }
    public void sendRating(int a, int b, int c, String n)
    {
    	try{
    	 HttpParams httpParameters = new BasicHttpParams();
		 int timeoutConnection = 4000;
		 HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
		 int timeoutSocket = 6000;
		 HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
         HttpClient httpclient = new DefaultHttpClient(httpParameters);
    	
        HttpPost httppost = new HttpPost("http://bellablu.dx.am/sendRating.php");
        
        JSONObject json = new JSONObject();

       
            // JSON data:
        	 int giorno = ca.get(Calendar.DAY_OF_MONTH);
             int mese = ca.get(Calendar.MONTH) + 1;
             int anno = ca.get(Calendar.YEAR);
             int ora = ca.get(Calendar.HOUR_OF_DAY);
                 
                 json.put("giorno", giorno);
                 json.put("mese", mese);
                 json.put("anno", anno);
                 json.put("ora", ora);
                 
            json.put("nation", n);
            json.put("food", a);
            json.put("pulizia", b);
            json.put("servizio", c);
           
            JSONArray postjson=new JSONArray();
            postjson.put(json);

            // Post the data:
            httppost.setHeader("json",json.toString());
            httppost.getParams().setParameter("jsonpost",postjson);
            // Execute HTTP Post Request
            //System.out.print(json);
            HttpResponse response = httpclient.execute(httppost);
            int status = response.getStatusLine().getStatusCode();
            Log.i("Status", "Status code is...." + status);
        
       
         
		} catch (Exception e){
			Toast.makeText(English.this, "Network is not working...", Toast.LENGTH_SHORT).show();
			final Intent intent3 = new Intent(this, English.class);
          	 finish();
          	 startActivity(intent3);
			
		}
    }
    
    public void sendRating2(int a, int b, int c, String n, String nameRes)
    {
    	try{
    	 HttpParams httpParameters = new BasicHttpParams();
		 int timeoutConnection = 4000;
		 HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
		 int timeoutSocket = 6000;
		 HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
         HttpClient httpclient = new DefaultHttpClient(httpParameters);
        HttpPost httppost = new HttpPost("http://bellablu.dx.am/sendRating2.php");
        
        JSONObject json = new JSONObject();

        
            // JSON data:
        	 int giorno = ca.get(Calendar.DAY_OF_MONTH);
             int mese = ca.get(Calendar.MONTH) + 1;
             int anno = ca.get(Calendar.YEAR);
             int ora = ca.get(Calendar.HOUR_OF_DAY);
                 
                 json.put("giorno", giorno);
                 json.put("mese", mese);
                 json.put("anno", anno);
                 json.put("ora", ora);
                 
            json.put("nation", n);
            json.put("food", a);
            json.put("pulizia", b);
            json.put("servizio", c);
            json.put("nomeCam", nameRes);
            
            JSONArray postjson=new JSONArray();
            postjson.put(json);

            // Post the data:
            httppost.setHeader("json",json.toString());
            httppost.getParams().setParameter("jsonpost",postjson);
            // Execute HTTP Post Request
            //System.out.print(json);
            HttpResponse response = httpclient.execute(httppost);
            int status = response.getStatusLine().getStatusCode();
            Log.i("Status", "Status code is...." + status);
        }
       
      
    	catch (Exception e){
			Toast.makeText(English.this, "Network is not working...", Toast.LENGTH_SHORT).show();
			final Intent intent3 = new Intent(this, English.class);
          	 finish();
          	 startActivity(intent3);
			
		}
    }
    
        
        public String getNazione()
        {
        	 try{
        		 HttpParams httpParameters = new BasicHttpParams();
        		 int timeoutConnection = 4000;
        		 HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        		 int timeoutSocket = 6000;
        		 HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
                 HttpClient httpclient = new DefaultHttpClient(httpParameters);
                 HttpPost httppost = new HttpPost("http://bellablu.dx.am/getNation.php");
                
                 HttpResponse response = httpclient.execute(httppost);
                 HttpEntity entity = response.getEntity();
                  is = entity.getContent();
           
              
              
                  BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                  StringBuilder sb = new StringBuilder();
                  String line = null;
                  while ((line = reader.readLine()) != null) {
                          sb.append(line + "\n");
                  }
                  is.close();

                  result=sb.toString();
            
    			
    		
            

            //parse json data
            
                  JSONArray jArray = new JSONArray(result);
                  JSONObject json_data = jArray.getJSONObject(0);
                  String ris= json_data.getString("nazione");
                return ris;
        	 }
        catch (Exception e){
    			Toast.makeText(English.this, "Network is not working...", Toast.LENGTH_SHORT).show();
    			final Intent intent3 = new Intent(this, English.class);
              	 finish();
              	 startActivity(intent3);
    			
    		}
	
            return "";
}
        public void check()
        {
        	 try{
        		 HttpParams httpParameters = new BasicHttpParams();
        		 int timeoutConnection = 4000;
        		 HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        		 int timeoutSocket = 6000;
        		 HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
                 HttpClient httpclient = new DefaultHttpClient(httpParameters);
                 HttpPost httppost = new HttpPost("http://bellablu.dx.am/bellablu.php");
                
                 HttpResponse response = httpclient.execute(httppost);
                 HttpEntity entity = response.getEntity();
                  is = entity.getContent();
             
        	 
     			
     		
              
              
                  BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                  StringBuilder sb = new StringBuilder();
                  String line = null;
                  while ((line = reader.readLine()) != null) {
                          sb.append(line + "\n");
                  }
                  is.close();

                  result=sb.toString();
           

            //parse json data
         
                  JSONArray jArray = new JSONArray(result);
                  JSONObject json_data = jArray.getJSONObject(0);
                  String sum= json_data.getString("controllo");
                  num= Integer.parseInt(sum);

                  JSONObject json_data2 = jArray.getJSONObject(1);
                  String sum2= json_data2.getString("data");
                  num2= Integer.parseInt(sum2);
                  
                         
                          
                  
            }
            catch (Exception e){
    			Toast.makeText(English.this, "Network is not working...", Toast.LENGTH_SHORT).show();
           	 final Intent intent3 = new Intent(this, English.class);
           	 finish();
           	 startActivity(intent3);
    			
    		
    		}
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
        	 catch (Exception e){
     			Toast.makeText(English.this, "Network is not working...", Toast.LENGTH_SHORT).show();
     			final Intent intent3 = new Intent(this, English.class);
              	 finish();
              	 startActivity(intent3);
     		}
        }
        public void onActivityResult(int requestCode, int resultCode, Intent data)
        {
          if (requestCode == REQ_CODE) {
             if (resultCode == RESULT_OK) {
            	 nomeRes = data.getData().toString();
            	 if(nomeRes.equals("Nullo")) sendRating2(food, pulizia, servizio, nation,nomeRes);
            	 else sendRating2(food, pulizia, servizio, nation, nomeRes);
            	 /*ib3.setRating(0.0f);
            	 ib2.setRating(0.0f);
            	 ib1.setRating(0.0f);*/
            	 final Intent intent3 = new Intent(this, English.class);
            	 finish();
            	 startActivity(intent3);
                 
               }
          }
        }
}
