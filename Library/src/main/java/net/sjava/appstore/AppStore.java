package net.sjava.appstore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.List;
/**
 * AppStore abstract class
 *
 * @author mcsong@gmail.com
 * @date Dec 10, 2014 2:03:53 PM
 * @version 1.0.0
 */
public abstract class AppStore {
	protected static final String PACKAGE_NAME_PLAY = "com.android.vending";
	protected static final String PACKAGE_NAME_AMAZON = "com.amazon.venezia";
	protected static final String PACKAGE_NAME_TSTORE = "com.skt.skaf.A000Z00040";

	protected Intent intent;

	@SuppressLint("WrongConstant")
	private List<ApplicationInfo> getApplications(Context ctx) {
		return ctx.getPackageManager().getInstalledApplications(
				PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
	}

	protected boolean isAppInstalled(Context ctx, String packageName) {
		List<ApplicationInfo> apps = getApplications(ctx);
		if(apps.size() == 0) {
			return false;
		}

		for(ApplicationInfo appinfo : apps) {
			if(appinfo.packageName.contains(packageName)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Check store app is installed.
	 *
	 * @param ctx
	 * @return
	 */
	public abstract boolean isInstalled(Context ctx);

	/**
	 * Open app with store app.
	 *
	 * @param ctx
	 * @param uniqueId
	 */
	public abstract void openApp(Context ctx, String uniqueId);

	/**
	 * Search app with store app.
	 *
	 * @param ctx
	 * @param keyword
	 */
	public abstract void searchApp(Context ctx, String keyword);

}
