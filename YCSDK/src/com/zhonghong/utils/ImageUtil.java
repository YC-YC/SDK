/**
 * 
 */
package com.zhonghong.utils;

import java.io.File;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;

/**
 * @author YC
 * @time 2017-7-1 下午2:27:22
 * TODO:
 */
public class ImageUtil {

	private static final String TAG = "ImageUtil";

	private ImageUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }
	
	public static Options getImageOption(String path) {
		Options options = new BitmapFactory.Options();  
		options.inJustDecodeBounds = true;  
		
		File file = new File(path);
		if (file.exists()){
			Log.i(TAG, "decodeFile ------");
			BitmapFactory.decodeFile(path, options);
			Log.i(TAG, "decodeFile ++++++");
		}
		int imageHeight = options.outHeight;  
		int imageWidth = options.outWidth;  
		Log.i(TAG, "get image width = " + imageWidth + ", height = " + imageHeight);
		return options;
	}
	
	public static boolean isLegalImage(String path){
//		Log.i(TAG, "image path = " + path);
		File file = new File(path);
		if (file.exists() && file.length() < 10*1024*1024){
			Options options = new BitmapFactory.Options();  
			options.inJustDecodeBounds = true;  
//			Log.i(TAG, "decodeFile ------");
			BitmapFactory.decodeFile(path, options);
//			Log.i(TAG, "decodeFile ++++++");
			int imageWidth = options.outWidth;  
			int imageHeight = options.outHeight;  
			if (imageWidth <= 0 || imageWidth > 5120
					|| imageHeight <= 0 || imageHeight > 5120){
				Log.e(TAG, "get image width = " + imageWidth + ", height = " + imageHeight);
				return false;
			}
			return true;
		}
		return false;
	}
	
}
