package com.hp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static long startTime;
	private static long end;
	private static int count=0;
	
	EditText editText;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText=(EditText) findViewById(R.id.editText1);
        
        editText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
				 //writeFile(" "+String.valueOf(s.charAt(count-1))+"  ");
				
end=new Date().getTime();
	    		
				String data="  "+String.valueOf(end)+ "  ";
				
				 data=data+String.valueOf(end-startTime);
				    	    
				    	    writeFile(data);
				    	    
				    	   writeFile("  "+String.valueOf(s.charAt(s.length()-1))+"  ");
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
				startTime=new Date().getTime();
	    	     
		    	String data="  "+String.valueOf(startTime)+ "  ";
		    	    
		    	    writeFile(data);
		    	    
		    	   
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			/*	end=new Date().getTime();
	    		
				String data="  "+String.valueOf(end)+ "  ";
				
				 data=data+String.valueOf(end-startTime);
				    	    
				    	    writeFile(data);
				    	    
				    	   writeFile("  "+String.valueOf(s.charAt(s.length()-1))+"  ");
				*/
			//writeFile(" "+String.valueOf(s));
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*public boolean dispatchKeyEvent(KeyEvent event) {
    	int keyaction = event.getAction();
    	if(keyaction==KeyEvent.ACTION_DOWN)
    	{	start=new Date().getTime();
    	     
    	String data="  "+String.valueOf(start)+ "  ";
    	    
    	    writeFile(data);
    	}
    	
    	if(keyaction==KeyEvent.ACTION_UP)
    		
    		{
    		
    		end=new Date().getTime();
    		
String data="  "+String.valueOf(end)+ "  ";
 data=data+String.valueOf(end-start);
    	    
    	    writeFile(data);
    		}
    	
       return super.dispatchKeyEvent(event);
       
       
    }*/
    
    
    
    public void writeFile(String data)
    {
    	
    	String filename="KeyStrokeData1.txt";
        
        //String data="\n  KDT    KUT    LETTER    DIFF  \n";
        
       // String data="\n  "+String.valueOf(start)+"   "+String.valueOf(end)+"   "+event.getNumber()+"  "+String.valueOf(end-start);
        
        try {  
            File myFile = new File("/sdcard/"+filename);  
             myFile.createNewFile();  
             FileOutputStream fOut = new FileOutputStream(myFile,true);  
             OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);  
             
			myOutWriter.append(data);  
             myOutWriter.close();  
             fOut.close();  
          
//  Toast.makeText(getApplicationContext(),data + "saved",Toast.LENGTH_LONG).show();  
           
          
        } catch (FileNotFoundException e) {e.printStackTrace();}  
        catch (IOException e) {e.printStackTrace();}  
    	
    	
    }
    
 
}
