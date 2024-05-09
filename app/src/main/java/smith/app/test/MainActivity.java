package smith.app.test;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import smith.app.test.databinding.ActivityMainBinding;
import smith.lib.net.SImageLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SImageLoader.with(this)
                .load("https://avatars.githubusercontent.com/u/70884742?v=4")
                .placeholder(smith.lib.net.R.drawable.downloading)
                .onErrorLoadingImage((error) -> Log.e("Error", error.getMessage()))
                .into(binding.imageView);
    }
}