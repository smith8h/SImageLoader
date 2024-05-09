package smith.lib.net;

import android.app.Activity;
import android.graphics.*;
import android.os.*;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import java.net.*;
import java.util.concurrent.Executors;

public class SImageLoader {

    private Activity activity;
    private String url;
    private Bitmap bitmap = null;
    private OnErrorLoadListener listener;
    private int placeholder = R.drawable.downloading;

    @NonNull
    public static SImageLoader with(Activity activity) {
        SImageLoader loader = new SImageLoader();
        loader.activity = activity;
        return loader;
    }

    public SImageLoader load(String url) {
        this.url = url;
        return this;
    }

    public SImageLoader placeholder(int placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    public SImageLoader onErrorLoadingImage(OnErrorLoadListener listener) {
        this.listener = listener;
        return this;
    }

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
