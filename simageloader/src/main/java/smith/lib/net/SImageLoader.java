package smith.lib.net;

import android.app.Activity;
import android.graphics.*;
import android.os.*;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import java.net.*;
import java.util.concurrent.Executors;

import smith.lib.net.callbacks.OnErrorLoadListener;
import smith.lib.net.exceptions.LoadImageException;

/**
 * {@code  Glide-like} class to load images from the net.
 * with fast and new single isolated thread to maintain <b>app's performance</b>.
 * @since 1.0.0
 * @author <a href="https://t.me/smithdev">Hussein Shakir</a>
 */
public class SImageLoader {

    private Activity activity;
    private String url;
    private Bitmap bitmap = null;
    private OnErrorLoadListener listener;
    private int placeholder = R.drawable.downloading;

    /**
     * init the loader class with the current context you used with.
     * @param activity the current context you want to load images in.
     * @return a new instance of {@link SImageLoader}.
     * @since 1.0.0
     * @author <a href="https://t.me/smithdev">Hussein Shakir</a>
     */
    @NonNull
    public static SImageLoader with(Activity activity) {
        SImageLoader loader = new SImageLoader();
        loader.activity = activity;
        return loader;
    }

    /**
     * set the url of the image you want to load.
     * @param url the url of the image you want to load.
     * @return the same instance of the {@link SImageLoader}.
     * @since 1.0.0
     * @author <a href="https://t.me/smithdev">Hussein Shakir</a>
     */
    public SImageLoader load(String url) {
        this.url = url;
        return this;
    }

    /**
     * set the default image to be shown in your image view while loading the image from url or in nay other case.
     * @param placeholder the default image while loading the url.
     * @return the same instance of {@link  SImageLoader}.
     * @since 1.0.0
     * @author <a href="https://t.me/smithdev">Hussein Shakir</a>
     */
    public SImageLoader placeholder(int placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    /**
     * set a callback to catch error while loading the image from url.
     * @param listener the callback using {@link OnErrorLoadListener}.
     * @return the same instance of {@link SImageLoader}.
     * @since 1.0.0
     * @author <a href="https://t.me/smithdev">Hussein Shakir</a>
     */
    public SImageLoader onErrorLoadingImage(OnErrorLoadListener listener) {
        this.listener = listener;
        return this;
    }

    /**
     * load the image and show it in the {@link ImageView} used.
     * @param imageView the image view you want to show the image in.
     * @since 1.0.0
     * @author <a href="https://t.me/smithdev">Hussein Shakir</a>
     */
    public void into(ImageView imageView) {
        loadImage(imageView);
    }

    private void loadImage(ImageView imageView) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setDoInput(true);
                connection.connect();
                bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            } catch (Exception e) {
                if (listener != null) listener.onError(new LoadImageException(e.getMessage()));
            }
            new Handler(Looper.getMainLooper()).post(() -> {
                if (bitmap != null) activity.runOnUiThread(() -> imageView.setImageBitmap(bitmap));
                else imageView.setImageResource(placeholder);
                imageView.setClipToOutline(true);
            });
        });
    }
}
