package com.example.test;

import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	
	


	public void generate(View view) {  
		Bitmap qrBitmap = generateBitmap("¹þ¶û±õÑ§Ôº 111",400, 400);  
	    Toast.makeText(getApplicationContext(), "111", Toast.LENGTH_SHORT).show();
	    ImageView iv = (ImageView) findViewById(R.id.iv);
		iv.setImageBitmap(qrBitmap);  
	  
	}  
	
	
	private Bitmap generateBitmap(String content,int width, int height) {  
	    QRCodeWriter qrCodeWriter = new QRCodeWriter();  
	    Map<EncodeHintType, String> hints = new HashMap<>();  
	    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
	    try {  
	        BitMatrix encode = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);  
	        int[] pixels = new int[width * height];  
	        for (int i = 0; i < height; i++) {  
	            for (int j = 0; j < width; j++) {  
	                if (encode.get(j, i)) {  
	                    pixels[i * width + j] = 0x00000000;  
	                } else {  
	                    pixels[i * width + j] = 0xffffffff;  
	                }  
	            }  
	        }  
	        return Bitmap.createBitmap(pixels, 0, width, width, height, Bitmap.Config.RGB_565);  
	    } catch (WriterException e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	}  
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
