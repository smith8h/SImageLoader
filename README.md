# SImageLoader

![Builds and tests](https://github.com/smith8h/SImageLoader/actions/workflows/build.yml/badge.svg)
[![JitPack release](https://jitpack.io/v/smith8h/SImageLoader.svg)](https://jitpack.io/#smith8h/SImageLoader)
![Latest release](https://img.shields.io/github/v/release/smith8h/SImageLoader?include_prereleases&amp;label=latest%20release)
![stable version](https://img.shields.io/badge/stable_version-v1.0.0-blue)
![stability-stable](https://img.shields.io/badge/stability-stable-6a87e3.svg)
![minimumSDK](https://img.shields.io/badge/minSDK-24-f39f37)
![Repository size](https://img.shields.io/github/repo-size/smith8h/SImageLoader)

<br/>

**(SImageLoader)** A *Glide-like* image loader library.

<br/>

## Content

- [**Setup**](#setup)
- [**Changelog**](https://github.com/smith8h/SImageLoader/blob/main/CHANGELOG.md)
- [**Documentation**](#documentation)
- [**Example Code**](#example-code)
- [**Donations :heart:**](#donations)

<br/>

## Setup

> **Step 1.**
> Add the JitPack repository to your build file.</br>
> Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
        ...
    }
}
```

> **Step 2.** Add the dependency:

```gradle
dependencies {
    ...
    implementation 'com.github.smith8h:SImageLoader:1.0.0'
    ...
}
```

<br/>

## Documentation

To create a connection first pass a context using `with()` method:

```java
    SImageLoader.with(context)
```

Then pass the callback interface to deal with the response using `callback()` method:

```java
    SImageLoader.with(context).callback(new SConnectCallBack() {
        @Override
        public void onFailure(SResponse response, String tag) {}
            
        @Override
        public void onSuccess(SResponse response, String tag, Map<String, Object> responseHeaders) {
            // use response, tag, responseHeaders
            if (response.isJSON() && response.isMap()) {
                Toast.makeText(context, response.getMap().getString("key"), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    })
```