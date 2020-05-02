## AppStore Library
[![Release](https://img.shields.io/badge/jcenter-1.0.9-blue.svg)](https://bintray.com/mcsong/maven/appstore)  [![Android Arsenal](https://img.shields.io/badge/Android-Arsenal-green.svg?style=flat)](https://android-arsenal.com/details/1/1772)

<a href='https://ko-fi.com/mcsong' target='_blank'>
	<img height='34' style='border:0px;height:34px;' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' />
</a>

## Overview
This library makes easy to use the AppStore app's features.

### Features
- Detect a store app is installed or not.
- Open app via store app.
- Search apps with publisher via store app.
- Search apps within store app.

### Supported AppStore apps
- Play Store
- Amazon AppStore
- OneStore

## Gradle & Maven
Gradle
```groovy
    dependencies {
    	implementation 'net.sjava:appstore:1.1.0'
    }
```

Maven
```xml
    <dependency>
     <groupId>net.sjava</groupId>
     <artifactId>appstore</artifactId>
     <version>1.1.0</version>
    </dependency>
```
## Usage

```java
	private void initPlayAppStore() {
		Button btn01 = findViewById(R.id.play_button_01);
		Button btn02 = findViewById(R.id.play_button_02);
		Button btn03 = findViewById(R.id.play_button_03);
		Button btn04 = findViewById(R.id.play_button_04);

		btn01.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				appStore = PlayAppStore.newInstance();
				Toast.makeText(ctx, "isInstalled : " + appStore.isInstalled(ctx), Toast.LENGTH_SHORT).show();
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
	}
```

## License

Copyright 2020 MooChan(Justin) Song

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


### Follow me

[![Twitter Follow](https://img.shields.io/twitter/follow/mcsong.svg?style=social)](https://twitter.com/mcsong)
