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

**(Optional)** Then pass the callback interface to deal with the error using `onErrorLoadingImage()` method:

```java
    SImageLoader.with(context).onErrorLoadingImage(new OnErrorLoadListener() {
        @Override
        public void onError(LoadImageException error) {
            
        }
    })
```

**(Optional)** After that, if you need to add a default placeholder using methods:

```java
    .placeholder(R.drawable.placeholder)
```

then pass the url of the image using `load()` method:

```java
    .load("url")
```

And finally, set the imageview you want the image to be loaded on.

```java
    .into(imageview)
```

## Example Code

• connections doesn't need params/headers:

```java
    SImageLoader.with(this)
        .load("https://avatars.githubusercontent.com/u/70884742?v=4")
        .placeholder(R.drawable.downloading)
        .onErrorLoadingImage((error) -> Log.e("Error", error.getMessage()))
        .into(imageView);
```

<br/>

## Donations

> If you would like to support this project's further development, the creator of this projects or the continuous maintenance of the project **feel free to donate**.
Your donation is highly appreciated. Thank you!

<br/>

You can **choose what you want to donate**, all donations are awesome!</br>

<br/>

[![PayPal](https://img.shields.io/badge/PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white)](https://www.paypal.me/husseinshakir)
[![Buy me a coffee](https://img.shields.io/badge/Buy_Me_A_Coffee-FFDD00?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black)](https://www.buymeacoffee.com/HusseinShakir)
[![Ko-fi](https://img.shields.io/badge/Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white)](https://ko-fi.com/husseinsmith)

<br/>

<p align="center">
  <img src="https://raw.githubusercontent.com/smith8h/smith8h/main/20221103_150053.png" style="width: 38%;" alt=""/>
  <br/>
  <b>
    With :heart:
  </b>
</p>
<br/>