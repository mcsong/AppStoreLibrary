package net.sjava.appstore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * 네이버 스토어 클래스
 * 
 * @author mcsong@gmail.com
 * @date Dec 10, 2014 2:04:08 PM
 * @version 1.0.0
 */
public class NaverAppStore extends AppStore {
	static String APP_URL ="http://nstore.naver.com/appstore/web/detail.nhn?productNo=";
	
	public static NaverAppStore newInstance() {
		return new NaverAppStore();
	}
	
	@Override
	public boolean isInstalled(Context ctx) {
		return isAppInstalled(ctx, PACKAGE_NAME_NSTORE);
	}

	@Override
	public void openApp(Context ctx, String uniqueId) {
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL + uniqueId));
		ctx.startActivity(intent);
	}

	@Override
	public void searchApp(Context ctx, String keyword) {
		String url = "http://nstore.naver.com/search/search.nhn?t=all&fs=appstore&q="+keyword;
		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		ctx.startActivity(intent);
	}

}
