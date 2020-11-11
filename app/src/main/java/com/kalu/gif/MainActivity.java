package com.kalu.gif;

import android.Manifest;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import lib.kalu.gif.GifManager;

public class MainActivity extends Activity {

    private ImageView mIvShow;
    private GifManager mGifPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 666);
        }
        mIvShow = findViewById(R.id.iv_show);
        mGifPlayer = new GifManager();
        mGifPlayer.setOnGifListener(new GifManager.OnGifListener() {
            @Override
            public void start() {
                Log.e("test", "gif start");
            }

            @Override
            public void draw(final Bitmap bitmap) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mIvShow.setImageBitmap(bitmap);
                    }
                });
            }

            @Override
            public void end() {
                Log.e("test", "gif end");
            }
        });
        findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGifPlayer.assetPlay(false, MainActivity.this, "demo1.gif");
//                // 外部目录play
//                File file = new File(Environment.getExternalStorageDirectory(), "1/test.gif");
//                if (file.exists()) {
//                    mGifPlayer.storagePlay(false,file.getPath());
//                } else {
//                    Toast.makeText(MainActivity.this, "file not exists!!!", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGifPlayer.pause();
            }
        });
        findViewById(R.id.btn_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGifPlayer.resume();
            }
        });
        findViewById(R.id.btn_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGifPlayer.stop();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGifPlayer.resume();
    }

    @Override
    protected void onPause() {
        mGifPlayer.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mGifPlayer.destroy();
        super.onDestroy();
    }
}
