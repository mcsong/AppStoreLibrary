package net.sjava.appstore;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.Iterator;
import java.util.List;
/**
 * 앱스토어 클래스 
 * 
 * @author mcsong@gmail.com
 * @date Dec 10, 2014 2:03:53 PM
 * @version 1.0.0
 */
public abstract class AppStore {
	protected static final String PACKAGE_NAME_PLAY_OLD = "com.google.market";
	protected static final String PACKAGE_NAME_PLAY_NEW = "com.android.vending";
	
	protected static final String PACKAGE_NAME_AMAZON = "com.amazon.venezia";
	protected static final String PACKAGE_NAME_TSTORE = "com.skt.skaf.A000Z00040";
	protected static final String PACKAGE_NAME_NSTORE = "com.nhn.android.appstore";
	
	protected Intent intent;
	
	private List<ApplicationInfo> getApplications(Context ctx) {
		return ctx.getPackageManager().getInstalledApplications(
				PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
	}
	
	protected boolean isAppInstalled(Context ctx, String packageName) {
		Iterator<ApplicationInfo> itr = getApplications(ctx).iterator();
		while (itr.hasNext()) {
			if (itr.next().packageName.indexOf(packageName) != -1)
				return true;
		}
		
		return false;
	}
	
	/**
	 * 마켓 앱의 설치여부를 리턴한다.
	 * 
	 * @param ctx
	 * @return
	 */
	public abstract boolean isInstalled(Context ctx);
	
	/**
	 * 마켓 앱으로 앱을 연다.
	 * 
	 * @param ctx
	 * @param uniqueId
	 */
	public abstract void openApp(Context ctx, String uniqueId);
	
	/**
	 * 마켓 앱으로 앱을 검색한다.
	 * 
	 * @param ctx
	 * @param keyword
	 */
	public abstract void searchApp(Context ctx, String keyword);

}
