package net.sjava.appstore;

import android.content.Context;

/**
 * Interface to display publisher's apps
 *
 * @author mcsong@gmail.com
 * @date Dec 10, 2014 2:04:13 PM
 * @version 1.0.0
 */
public interface PublisherAppOpenable {
	/**
	 *	Open publisher's apps
	 *
	 * @param ctx
	 * @param key
	 */
	public void openPublisherApps(Context ctx, String key);
}
