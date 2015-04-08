package net.sjava.appstore;

import android.content.Context;

/**
 * 스토어에 배포한 개발사의 앱 목록을 보여주는 인터페이스
 *
 * @author mcsong@gmail.com
 * @date Dec 10, 2014 2:04:13 PM
 * @version 1.0.0
 */
public interface PublisherAppOpenable {
	/**
	 * 앱스토어에 배포한 개발사의 앱을 연다.
	 *
	 * @param ctx
	 * @param key
	 */
	public void openPublisherApps(Context ctx, String key);
}
