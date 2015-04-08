package net.sjava.appstore.demo;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import net.sjava.appstore.AmazonAppStore;
import net.sjava.appstore.AppStore;
import net.sjava.appstore.PlayAppStore;
import net.sjava.appstore.PublisherAppOpenable;
import net.sjava.appstore.demo.R;


public class MainActivity extends ActionBarActivity {
	private Context ctx;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		ctx = this;

		initPlayAppStore();
		initAmazonAppStore();

	}

	private AppStore appStore;
	private PublisherAppOpenable publisherAppOpener;

	//https://play.google.com/store/apps/details?id=com.google.android.gm
	private void initPlayAppStore() {
		Button btn01 = (Button)findViewById(R.id.play_button_01);
		Button btn02 = (Button)findViewById(R.id.play_button_02);
		Button btn03 = (Button)findViewById(R.id.play_button_03);
		Button btn04 = (Button)findViewById(R.id.play_button_04);

		btn01.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				appStore = PlayAppStore.newInstance();
				Toast.makeText(ctx, "설치 여부 : " + appStore.isInstalled(ctx), Toast.LENGTH_SHORT).show();
			}
		});

		btn02.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				appStore = PlayAppStore.newInstance();
				appStore.openApp(ctx, "com.google.android.gm");
			}
		});

		btn03.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				publisherAppOpener = PlayAppStore.newInstance();
				publisherAppOpener.openPublisherApps(ctx, "com.google.android.gm");
			}
		});

		btn04.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				appStore = PlayAppStore.newInstance();
				appStore.searchApp(ctx, "gmail");
			}
		});

	}

	private void initAmazonAppStore() {
		Button btn01 = (Button)findViewById(R.id.amazon_button_01);
		Button btn02 = (Button)findViewById(R.id.amazon_button_02);
		Button btn03 = (Button)findViewById(R.id.amazon_button_03);
		Button btn04 = (Button)findViewById(R.id.amazon_button_04);

		btn01.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				appStore = AmazonAppStore.newInstance();
				Toast.makeText(ctx, "설치 여부 : " + appStore.isInstalled(ctx), Toast.LENGTH_SHORT).show();
			}
		});

		btn02.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				appStore = AmazonAppStore.newInstance();
				appStore.openApp(ctx, "com.amazon.mp3");
			}
		});

		btn03.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				publisherAppOpener = AmazonAppStore.newInstance();
				publisherAppOpener.openPublisherApps(ctx, "com.amazon.mp3");
			}
		});

		btn04.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				appStore = AmazonAppStore.newInstance();
				appStore.searchApp(ctx, "mp3");
			}
		});


	}










}
