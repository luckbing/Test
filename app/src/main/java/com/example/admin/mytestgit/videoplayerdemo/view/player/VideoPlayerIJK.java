package com.example.admin.mytestgit.videoplayerdemo.view.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * 普通的视频播放器
 * Created by GuoShaoHong on 2017/7/25.
 */

public class VideoPlayerIJK extends FrameLayout {

    /**
     * 由ijkplayer提供，用于播放视频，需要给他传入一个surfaceView
     */
    private IMediaPlayer mMediaPlayer = null;

    /**
     * 视频文件地址
     */
    private String mPath = "";

    private TextureView textureView;

    private VideoPlayerListener listener;
    private Context mContext;

    public VideoPlayerIJK(@NonNull Context context) {
        super(context);
        initVideoView(context);
    }

    public VideoPlayerIJK(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initVideoView(context);
    }

    public VideoPlayerIJK(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initVideoView(context);
    }

    private void initVideoView(Context context) {
        mContext = context;

        //获取焦点，不知道有没有必要~。~
        setFocusable(true);
    }

    /**
     * 设置视频地址。
     * 根据是否第一次播放视频，做不同的操作。
     *
     * @param path the path of the video.
     */
    public void setVideoPath(String path) {
       /* if (TextUtils.equals("", mPath)) {
            //如果是第一次播放视频，那就创建一个新的surfaceView
            mPath = path;
            createSurfaceView();
        } else {
            //否则就直接load
            mPath = path;
            load();
        }*/
        // 上面的方法是可以让界面无缝播放，但是切换视频如果出现黑屏，无缝播放会保留上一次的最后一帧，
        //所以 这里每次都需要重新创键view，并且进行播放
        mPath = path;
        createSurfaceView();
    }

    /**
     * 新建一个surfaceview
     */
    private void createSurfaceView() {
        //生成一个新的surface view
        if (textureView != null && textureView.getParent() == this) {
            this.removeView(textureView);
        }
        textureView = new TextureView(mContext);
        textureView.setSurfaceTextureListener(new LmnSurfaceCallback());
        textureView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTextureViewClickListener != null) {
                    onTextureViewClickListener.onTextureViewclick();
                }
            }
        });
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT
                , LayoutParams.MATCH_PARENT, Gravity.CENTER);
        textureView.setLayoutParams(layoutParams);
        this.addView(textureView);
    }

    private Surface msurface;

    /**
     * surfaceView的监听器
     */
    private class LmnSurfaceCallback implements TextureView.SurfaceTextureListener {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            msurface = new Surface(surface);
            load();
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            surface = null;
            msurface = null;
            mMediaPlayer.stop();
            mMediaPlayer.release();
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    }

    /**
     * 加载视频
     */
    private void load() {
        //每次都要重新创建IMediaPlayer
        createPlayer();
        try {
            mMediaPlayer.setDataSource(mPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //给mediaPlayer设置视图
        //  mMediaPlayer.setDisplay(textureView.getHolder());
        mMediaPlayer.setSurface(msurface);
        mMediaPlayer.prepareAsync();
    }

    /**
     * 创建一个新的player
     */
    private void createPlayer() {
        if (mMediaPlayer != null) {
            try {
                mMediaPlayer.stop();
            } catch (Exception e) {
            }
            mMediaPlayer.setDisplay(null);
            mMediaPlayer.release();
        }
        IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
        ijkMediaPlayer.native_setLogLevel(IjkMediaPlayer.IJK_LOG_DEBUG);

//        //开启硬解码
        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
//        //开启硬解码
        //    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);

        //rtsp设置 https://ffmpeg.org/ffmpeg-protocols.html#rtsp
        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "rtsp_transport", "tcp");
        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "rtsp_flags", "prefer_tcp");

        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "start-on-prepared", 0);
        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "http-detect-range-support", 0);
        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_loop_filter", 48);
        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_loop_filter", 8);
        ijkMediaPlayer.setOption(1, "analyzemaxduration", 100L);
        ijkMediaPlayer.setOption(1, "probesize", 10240L);
        ijkMediaPlayer.setOption(1, "flush_packets", 1L);
        ijkMediaPlayer.setOption(4, "packet-buffering", 0L);
        ijkMediaPlayer.setOption(4, "framedrop", 1L);

        mMediaPlayer = ijkMediaPlayer;

        if (listener != null) {
            mMediaPlayer.setOnPreparedListener(listener);
            mMediaPlayer.setOnInfoListener(listener);
            mMediaPlayer.setOnSeekCompleteListener(listener);
            mMediaPlayer.setOnBufferingUpdateListener(listener);
            mMediaPlayer.setOnErrorListener(listener);
        }
    }

    public void setListener(VideoPlayerListener listener) {
        this.listener = listener;
        if (mMediaPlayer != null) {
            mMediaPlayer.setOnPreparedListener(listener);
        }
    }

    /**
     * -------======--------- 下面封装了一下控制视频的方法
     */

    public void start() {
        if (mMediaPlayer != null && !mMediaPlayer.isPlaying()) {
            mMediaPlayer.start();
        }
    }

    public void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void pause() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }

    public void stop() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
    }


    public void reset() {
        if (mMediaPlayer != null) {
            mMediaPlayer.reset();
        }
    }


    public long getDuration() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.getDuration();
        } else {
            return 0;
        }
    }


    public long getCurrentPosition() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.getCurrentPosition();
        } else {
            return 0;
        }
    }


    public void seekTo(long l) {
        if (mMediaPlayer != null) {
            mMediaPlayer.seekTo(l);
        }
    }

    public void setVolume(float leftvoice, float rightvoice) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setVolume(leftvoice, rightvoice);
        }
    }

    public Bitmap getBitmap() {
        Bitmap bitmap = textureView.getBitmap();
        return bitmap;
    }

    OnTextureViewClickListener onTextureViewClickListener;

    public interface OnTextureViewClickListener {
        void onTextureViewclick();

    }

    public void setOnTextureViewClickListener(OnTextureViewClickListener onTextureViewClickListener) {
        this.onTextureViewClickListener = onTextureViewClickListener;
    }

}
