package net.sjava.appstore;

import android.content.Context;

/**
 * Interface to display publisher's apps
 *
 * @author mcsong@gmail.com
 * @version 1.0.0
 * @date Dec 10, 2014 2:04:13 PM
 */
public interface PublisherAppOpenable {
  /**
   * Open publisher's apps
   *
   * @param ctx
   * @param key
   */
  public void openPublisherApps(Context ctx, String key);
}
