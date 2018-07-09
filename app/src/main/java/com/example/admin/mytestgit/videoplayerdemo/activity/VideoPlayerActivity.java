package com.example.admin.mytestgit.videoplayerdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.admin.mytestgit.R;
import com.example.admin.mytestgit.videoplayerdemo.view.player.VideoPlayerIJK;
import com.example.admin.mytestgit.videoplayerdemo.view.player.VideoPlayerListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class VideoPlayerActivity extends AppCompatActivity {
    private static final String URI = "rtsp://admin:lg123456@192.168.2.18:554";
    @BindView(R.id.player)
    VideoPlayerIJK mPlayerIJK;

    public static Intent getInstance(Context context) {
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initPlayer();
    }

    private void initPlayer() {
        //加载so文件
//        try {
//            IjkMediaPlayer.loadLibrariesOnce(null);
//            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
//            IjkMediaPlayer.native_profileBegin("libijkffmpeg.so");
//            IjkMediaPlayer.native_profileBegin("libijksdl.so");
//        } catch (Exception e) {
//        }
        mPlayerIJK.setListener(new VideoPlayerListener() {
            @Override
            public void onBufferingUpdate(IMediaPlayer mp, int percent) {

            }

            @Override
            public void onCompletion(IMediaPlayer mp) {
//                ResetAnim();
                mp.seekTo(0);
                mp.start();
//                setVisiblityTimer();
            }

            @Override
            public boolean onError(IMediaPlayer mp, int what, int extra) {
//                ResetAnim();
                Toast.makeText(VideoPlayerActivity.this, "失败了", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onInfo(IMediaPlayer mp, int what, int extra) {

                return false;
            }


            @Override
            public void onPrepared(IMediaPlayer mp) {
                mp.start();
//                ResetAnim();
//                setVisiblityTimer();
            }

            @Override
            public void onSeekComplete(IMediaPlayer mp) {
            }

            @Override
            public void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sar_num, int sar_den) {
                //获取到视频的宽和高
            }
        });

        mPlayerIJK.setOnTextureViewClickListener(new VideoPlayerIJK.OnTextureViewClickListener() {
            @Override
            public void onTextureViewclick() {
                Toast.makeText(VideoPlayerActivity.this, "点击了", Toast.LENGTH_SHORT).show();
//                if (iv_takephoto.getVisibility() == View.VISIBLE) {
//                    if (countDownTimer != null) {
//                        countDownTimer.cancel();
//                        countDownTimer = null;
//                    }
//                    setViewVisiblity(View.GONE);
//                } else {
//                    setViewVisiblity(View.VISIBLE);
//                    setVisiblityTimer();
//                }
            }
        });
//        String url = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
//        String url = "rtsp://admin:lg123456@192.168.2.18:554";
//        mPlayerIJK.setVideoPath(url);
    }

    @OnClick(R.id.btn_switch_net)
    public void switchNetPath(){
        String url = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
        mPlayerIJK.setVideoPath(url);
    }

    @OnClick(R.id.btn_switch_local)
    public void switchLocalPath(){
        String url = "rtsp://admin:lg123456@192.168.2.18:554";
        mPlayerIJK.setVideoPath(url);
    }
}
