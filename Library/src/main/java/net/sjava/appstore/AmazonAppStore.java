package net.sjava.appstore;

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
public class AmazonAppStore extends AppStore implements PublisherAppOpenable {
	static String APPSTORE_URI = "amzn://apps/android?";
	static String APP_URL = "http://www.amazon.com/gp/mas/dl/android?";

	public static AmazonAppStore newInstance() {
		return new AmazonAppStore();
	}

	@Override
	public boolean isInstalled(Context ctx) {
		return isAppInstalled(ctx, PACKAGE_NAME_AMAZON);
	}

	@Override
	public void openApp(Context ctx, String uniqueId) {
		if(isInstalled(ctx)) {
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APPSTORE_URI +"p=" + uniqueId));
			ctx.startActivity(intent);
			return;
		}

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL + "p=" + uniqueId));
		ctx.startActivity(intent);
	}

	@Override
	public void searchApp(Context ctx, String keyword) {
		if(isInstalled(ctx)) {
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APPSTORE_URI +"s=" + keyword));
			ctx.startActivity(intent);
			return;
		}

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL + "s="+ keyword));
		ctx.startActivity(intent);
	}

	@Override
	public void openPublisherApps(Context ctx, String key) {
		if(isInstalled(ctx)) {
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APPSTORE_URI + "p=" + key +"&showAll=1"));
			ctx.startActivity(intent);
			return;
		}

		intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL + "p=" + key +"&showAll=1"));
		ctx.startActivity(intent);
	}
}
