package com.example.as;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * 一个应用程序可以有1个或多个活动，而没有任何限制。
 * 每个为应用程序所定义的活动都需要在 AndroidManifest.xml 中声明，应用的主活动的意图过滤器标签中需要包含 MAIN 动作和 LAUNCHER 类别
 * 如果 MAIN 动作还是 LAUNCHER 类别没有在活动中声明，那么应用程序的图标将不会出现在主屏幕的应用列表中。
 * implements View.OnClickListener：用于绑定单击事件
 * implements SurfaceHolder.Callback：用于监测 surface 的状态，重写其三个方法
 * android.view.SurfaceHolder 是接口，Callback 是 SurfaceHolder 的子接口
 */
public class home extends AppCompatActivity {
    /**
     * android.widget.VideoView：视频播放器控件
     */
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bindViews();
    }

    private void bindViews() {
        /**
         * 香港卫视：http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8
         * CCTV1高清直播：http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8
         * CCTV3高清直播：http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8
         * CCTV5高清直播：http://ivi.bupt.edu.cn/hls/cctv5hd.m3u8
         * CCTV5+高清直播：http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8
         * CCTV6高清直播：http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8
         * 苹果提供的测试源（点播）：http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear2/prog_index.m3u8
         * 微博视频：https://f.us.sinaimg.cn/000BFP1Zgx07nNMQWH4A01040200bazV0k010.mp4?label=mp4_hd&template=640x360.28&Expires=1537611622&ssig=hAwEQKCJkz&KID=unistore,video
         * 直播视频精进度条能看到当前播放时间，看不到总共多少时间
         */
        String url = "http://vjs.zencdn.net/v/oceans.mp4";
        videoView = findViewById(R.id.videoView);
        /**
         * 设置播放的资源路径，使用 setVideoURI(Uri uri)  或者 setVideoPath(String path)(底层也是调用的  serVideoURL(Uri uri))
         */
        videoView.setVideoPath(url);

        /**为控件设置焦点*/
        videoView.requestFocus();

        /**
         * 为 VideoView 视图设置媒体控制器，设置了之后就会自动由进度条、前进、后退等操作
         */
        videoView.setMediaController(new MediaController(this));

        /**视频准备完成时回调
         * */
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("tag", "--------------视频准备完毕,可以进行播放.......");
            }
        });
        /**
         * 视频播放完成时回调
         */
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.i("tag", "------------------视频播放完毕..........");
            }
        });

        /**
         * 视频播放发送错误时回调
         */
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.i("tag", "---------------------视频播放失败...........");
                return false;
            }
        });

        /**开始播放视频
         * */
        videoView.start();
    }
}
