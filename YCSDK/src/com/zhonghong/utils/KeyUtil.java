/**
 * 
 */
package com.zhonghong.utils;

import android.app.Instrumentation;
import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;

/**
 * 按键
 * @author YC
 * @time 2017-4-8 上午9:59:39
 * TODO:
 */
public class KeyUtil {
	/**
	 * 发送系统按键
	 * @param keycode = KeyEvent.keycode
	 */
	public static void sendSyskey(final int keycode){
		new Thread(new Runnable() {
			@Override
			public void run() {
				new Instrumentation().sendKeyDownUpSync(keycode);
			}
		}).start();
	}
	
	/**
	 * 媒体按键，可以防止被其它应用阻塞
	 * @param context
	 * @param keycode
	 */
	public static void sendMediaButton(final Context context, final int keycode){
		AudioManager manager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);// = (AudioManager)get
		manager.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keycode));
		manager.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, keycode));
	}
}
