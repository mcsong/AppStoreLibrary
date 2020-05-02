package net.sjava.appstore.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.sjava.appstore.AmazonStoreApp;
import net.sjava.appstore.AppStore;
import net.sjava.appstore.OneStoreApp;
import net.sjava.appstore.PlayAppStore;
import net.sjava.appstore.PublisherAppOpenable;

public class MainActivity extends AppCompatActivity {
  private Context ctx;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentView(R.layout.activity_main);
    ctx = this;

    initPlayAppStore();
    initAmazonAppStore();
    initOneStore();
  }

  private AppStore appStore;
  private PublisherAppOpenable publisherAppOpener;

  //https://play.google.com/store/apps/details?id=com.google.android.gm
  private void initPlayAppStore() {
    Button btn01 = findViewById(R.id.play_button_01);
    Button btn02 = findViewById(R.id.play_button_02);
    Button btn03 = findViewById(R.id.play_button_03);
    Button btn04 = findViewById(R.id.play_button_04);

    Button btn05 = findViewById(R.id.play_button_05);
    Button btn06 = findViewById(R.id.play_button_06);

    btn01.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appStore = PlayAppStore.newInstance();
        Toast.makeText(ctx, "Play store app is installed: " + appStore.isInstalled(ctx), Toast.LENGTH_SHORT).show();
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
        publisherAppOpener.openPublisherApps(ctx, "Google Inc.");
      }
    });

    btn04.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appStore = PlayAppStore.newInstance();
        appStore.searchApp(ctx, "gmail");
      }
    });

    btn05.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appStore = PlayAppStore.newInstance();
        ((PlayAppStore) appStore).openDeveloperPage(ctx, "developerId");

      }
    });

    btn06.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appStore = PlayAppStore.newInstance();
        //Staff Picks (Featured)
				/*
				Collection	collection_name
				Staff Picks (Featured)	featured
				Top Paid	topselling_paid
				Top Free	topselling_free
				Top New Free	topselling_new_free
				Top New Paid	topselling_new_paid
				Top Grossing	topgrossing
				Trending	movers_shakers
				*/
        //((PlayAppStore)appStore).openCollectionApps(ctx, "featured");
        ((PlayAppStore) appStore).openCollectionApps(ctx, "topgrossing");

      }
    });

  }

  private void initAmazonAppStore() {
    Button btn01 = findViewById(R.id.amazon_button_01);
    Button btn02 = findViewById(R.id.amazon_button_02);
    Button btn03 = findViewById(R.id.amazon_button_03);
    Button btn04 = findViewById(R.id.amazon_button_04);

    btn01.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appStore = AmazonStoreApp.newInstance();
        Toast.makeText(ctx, "Amazon store app is installed: " + appStore.isInstalled(ctx), Toast.LENGTH_SHORT).show();
      }
    });

    btn02.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appStore = AmazonStoreApp.newInstance();
        appStore.openApp(ctx, "com.amazon.mp3");
      }
    });

    btn03.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        publisherAppOpener = AmazonStoreApp.newInstance();
        publisherAppOpener.openPublisherApps(ctx, "com.amazon.mp3");
      }
    });

    btn04.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appStore = AmazonStoreApp.newInstance();
        appStore.searchApp(ctx, "mp3");
      }
    });
  }

  private void initOneStore() {
    Button btn01 = findViewById(R.id.tstore_button_01);
    Button btn02 = findViewById(R.id.tstore_button_02);
    Button btn03 = findViewById(R.id.tstore_button_03);
    Button btn04 = findViewById(R.id.tstore_button_04);

    btn01.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appStore = OneStoreApp.newInstance();
        Toast.makeText(ctx, "OneStore app is installed: " + appStore.isInstalled(ctx), Toast.LENGTH_SHORT).show();
      }
    });


    btn02.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        appStore = OneStoreApp.newInstance();
        appStore.openApp(ctx, "0000035733");
      }
    });

    btn03.setVisibility(View.INVISIBLE);
		/*
		btn03.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				publisherAppOpener = PlayAppStore.newInstance();
				publisherAppOpener.openPublisherApps(ctx, "Google Inc.");
			}
		}); */

    btn04.setVisibility(View.INVISIBLE);
		/*
		btn04.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				appStore = OneStoreApp.newInstance();
				appStore.searchApp(ctx, "T map");
			}
		}); */
  }

}
