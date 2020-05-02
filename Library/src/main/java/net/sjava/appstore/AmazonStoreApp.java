package net.sjava.appstore;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Amazon Store class
 *
 * @author mcsong@gmail.com
 * @date Dec 10, 2014 2:04:02 PM
 * @version 1.0.0
 */
public class AmazonStoreApp extends AppStore implements PublisherAppOpenable {
	private static final String APPSTORE_URI = "amzn://apps/android?";
	private static final String APP_URL = "https://www.amazon.com/gp/mas/dl/android?";

	public static AmazonStoreApp newInstance() {
		return new AmazonStoreApp();
	}

	@Override
	public boolean isInstalled(Context ctx) {
		return isAppInstalled(ctx, PACKAGE_NAME_AMAZON);
	}

	@Override
	public void openApp(Context ctx, String uniqueId) {
		if(isInstalled(ctx)) {
			try {
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APPSTORE_URI + "p=" + uniqueId));
				ctx.startActivity(intent);
				return;
			} catch (ActivityNotFoundException e) { // ignore
			}
		}

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL + "p=" + uniqueId));
		ctx.startActivity(intent);
	}

	@Override
	public void searchApp(Context ctx, String keyword) {
		if(isInstalled(ctx)) {
			try {
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APPSTORE_URI +"s=" + keyword));
				ctx.startActivity(intent);
				return;
			} catch (ActivityNotFoundException e) { // ignore
			}
		}

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL + "s="+ keyword));
		ctx.startActivity(intent);
	}

	@Override
	public void openPublisherApps(Context ctx, String key) {
		if(isInstalled(ctx)) {
			try {
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APPSTORE_URI + "p=" + key +"&showAll=1"));
				ctx.startActivity(intent);
				return;
			} catch (ActivityNotFoundException e) { // ignore
			}
		}

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL + "p=" + key +"&showAll=1"));
		ctx.startActivity(intent);
	}
}
