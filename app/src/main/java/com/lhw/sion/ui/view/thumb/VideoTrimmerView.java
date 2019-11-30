package com.lhw.sion.ui.view.thumb;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dueeeke.videoplayer.listener.OnVideoViewStateChangeListener;
import com.dueeeke.videoplayer.player.VideoView;
import com.dueeeke.videoplayer.player.VideoViewManager;
import com.hjq.demo.R;
import com.lhw.sion.bean.LocalVideoBean;
import com.lhw.sion.ui.view.ZVideoView;
import com.lhw.sion.ui.view.thumb.interfaces.IVideoTrimmerView;
import com.lhw.sion.ui.view.thumb.interfaces.VideoTrimListener;
import com.lhw.sion.ui.view.thumb.trim.VideoTrimmerUtil;
import com.lhw.sion.ui.view.thumb.widget.RangeSeekBarView;
import iknow.android.utils.callback.SingleCallback;
import iknow.android.utils.thread.BackgroundExecutor;
import iknow.android.utils.thread.UiThreadExecutor;

import static com.lhw.sion.ui.view.thumb.trim.VideoTrimmerUtil.VIDEO_FRAMES_WIDTH;

/*import com.iknow.android.R;
import com.iknow.android.features.trim.VideoTrimmerAdapter;
import com.iknow.android.features.trim.VideoTrimmerUtil;
import com.iknow.android.interfaces.IVideoTrimmerView;
import com.iknow.android.interfaces.VideoTrimListener;
import com.iknow.android.utils.StorageUtil;*/

//import static com.iknow.android.features.trim.VideoTrimmerUtil.VIDEO_FRAMES_WIDTH;

/**
 * Author：J.Chou
 * Date：  2016.08.01 2:23 PM
 * Email： who_know_me@163.com
 * Describe:
 */
public class VideoTrimmerView extends FrameLayout implements IVideoTrimmerView {

  private static final String TAG = VideoTrimmerView.class.getSimpleName();

  private int mMaxWidth = VIDEO_FRAMES_WIDTH;
  private Context mContext;
  private RelativeLayout mLinearVideo;
  private VideoView mVideoView;
  private ImageView mPlayView;
  private RecyclerView mVideoThumbRecyclerView;
  private RangeSeekBarView mRangeSeekBarView;
  private LinearLayout mSeekBarLayout;
  private ImageView mRedProgressIcon;
  private TextView mVideoShootTipTv;
  private float mAverageMsPx;//每毫秒所占的px
  private float averagePxMs;//每px所占用的ms毫秒

  private VideoTrimListener mOnTrimVideoListener;
  private int mDuration = 0;

  private boolean isFromRestore = false;
  //new
  private long mLeftProgressPos, mRightProgressPos;
  private long mRedProgressBarPos = 0;
  private long scrollPos = 0;
  private int mScaledTouchSlop;
  private int lastScrollX;
  private boolean isSeeking;
  private boolean isOverScaledTouchSlop;
  private int mThumbsTotalCount;
  private ValueAnimator mRedProgressAnimator;
  private Handler mAnimationHandler = new Handler();
  private ThumbAdapter mVideoThumbAdapter;
  public VideoTrimmerView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public VideoTrimmerView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  private void init(Context context) {
    this.mContext = context;
    LayoutInflater.from(context).inflate(R.layout.view_video_clip_processing, this, true);

    mLinearVideo = findViewById(R.id.layout_surface_view);
    mVideoView = findViewById(R.id.video_loader);
    mPlayView = findViewById(R.id.icon_video_play);
    mSeekBarLayout = findViewById(R.id.seekBarLayout);
    mRedProgressIcon = findViewById(R.id.positionIcon);
    mVideoShootTipTv = findViewById(R.id.video_shoot_tip);
    mVideoThumbRecyclerView = findViewById(R.id.video_frames_recyclerView);
    mVideoThumbRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
    mVideoThumbAdapter = new ThumbAdapter(null);
    mVideoThumbRecyclerView.setAdapter(mVideoThumbAdapter);
    mVideoThumbRecyclerView.addOnScrollListener(mOnScrollListener);
    setUpListeners();
  }

  private void initRangeSeekBarView() {
    if(mRangeSeekBarView != null) return;
    int rangeWidth;
    mLeftProgressPos = 0;
    if (mDuration <= VideoTrimmerUtil.MAX_SHOOT_DURATION) {
      mThumbsTotalCount = VideoTrimmerUtil.MAX_COUNT_RANGE;
      rangeWidth = mMaxWidth;
      mRightProgressPos = mDuration;
    } else {
      mThumbsTotalCount = VideoTrimmerUtil.MAX_COUNT_RANGE;
      rangeWidth = mMaxWidth;
      mRightProgressPos = mDuration;
    }
    mVideoThumbRecyclerView.addItemDecoration(new SpacesItemDecoration2(VideoTrimmerUtil.RECYCLER_VIEW_PADDING, mThumbsTotalCount));
    mRangeSeekBarView = new RangeSeekBarView(mContext, mLeftProgressPos, mRightProgressPos);
    mRangeSeekBarView.setSelectedMinValue(mLeftProgressPos);
    mRangeSeekBarView.setSelectedMaxValue(mRightProgressPos);
    mRangeSeekBarView.setStartEndTime(mLeftProgressPos, mRightProgressPos);
    mRangeSeekBarView.setMinShootTime(VideoTrimmerUtil.MIN_SHOOT_DURATION);
    mRangeSeekBarView.setNotifyWhileDragging(true);
    mRangeSeekBarView.setOnRangeSeekBarChangeListener(mOnRangeSeekBarChangeListener);
    mSeekBarLayout.addView(mRangeSeekBarView);

    mAverageMsPx = mDuration * 1.0f / rangeWidth * 1.0f;
    averagePxMs = (mMaxWidth * 1.0f / (mRightProgressPos - mLeftProgressPos));
  }
  LocalVideoBean videoBean;
  public void initVideoByURI(LocalVideoBean videoURI) {
    this.videoBean=videoURI;
    mVideoView.setUrl(videoBean.getThumbPath());
    mVideoView.requestFocus();
    mVideoView.setLooping(true);
    mVideoView.release();
    mVideoView.start();
    mVideoShootTipTv.setText(String.format(mContext.getResources().getString(R.string.video_shoot_tip), VideoTrimmerUtil.VIDEO_MAX_TIME));
    videoPrepared(mVideoView);


  }

  private void startShootVideoThumbs(final Context context, final String videoUri, int totalThumbsCount, long startPosition, long endPosition) {
    VideoTrimmerUtil.shootVideoThumbInBackground(videoUri, totalThumbsCount, startPosition, endPosition,
            new SingleCallback<Bitmap, Integer>() {
              @Override
              public void onSingleCallback(final Bitmap bitmap, final Integer interval) {
                if (bitmap != null) {
                  UiThreadExecutor.runTask("", new Runnable() {
                    @Override
                    public void run() {
                      mVideoThumbAdapter.addData(bitmap);

                    }
                  }, 0L);
                }
              }
            });
    mVideoThumbAdapter.notifyDataSetChanged();

  }

  private void onCancelClicked() {
    mOnTrimVideoListener.onCancel();
  }

  private void videoPrepared(VideoView mp) {
    /*ViewGroup.LayoutParams lp = mp.getLayoutParams();
    int videoWidth = mp.getWidth();
    int videoHeight = mp.getHeight();

    float videoProportion = (float) videoWidth / (float) videoHeight;
    int screenWidth = mLinearVideo.getWidth();
    int screenHeight = mLinearVideo.getHeight();

    if (videoHeight > videoWidth) {
      lp.width = screenWidth;
      lp.height = screenHeight;
    } else {
      lp.width = screenWidth;
      float r = videoHeight / (float) videoWidth;
      lp.height = (int) (lp.width * r);
    }
    mVideoView.setLayoutParams(lp);*/
    mDuration = (int) videoBean.getDuration();
    if (!getRestoreState()) {
      seekTo((int) mRedProgressBarPos);
    } else {
      setRestoreState(false);
      seekTo((int) mRedProgressBarPos);
    }
    initRangeSeekBarView();
    startShootVideoThumbs(mContext, videoBean.getThumbPath(), mThumbsTotalCount, 0, videoBean.getDuration());
  }

  private void videoCompleted() {
    seekTo(mLeftProgressPos);
    setPlayPauseViewIcon(false);
  }

  private void onVideoReset() {
    mVideoView.pause();
    setPlayPauseViewIcon(false);
  }

  private void playVideoOrPause() {
    mRedProgressBarPos = mVideoView.getCurrentPosition();
    if (mVideoView.isPlaying()) {
      mVideoView.pause();
      pauseRedProgressAnimation();
    } else {
      mVideoView.start();
      playingRedProgressAnimation();
    }
    setPlayPauseViewIcon(mVideoView.isPlaying());
  }

  public void onVideoPause() {
    if (mVideoView.isPlaying()) {
      seekTo(mLeftProgressPos);//复位
      mVideoView.pause();
      setPlayPauseViewIcon(false);
      mRedProgressIcon.setVisibility(GONE);
    }
  }

  public void setOnTrimVideoListener(VideoTrimListener onTrimVideoListener) {
    mOnTrimVideoListener = onTrimVideoListener;
  }
public void RemoveVideo(){
  mVideoView.pause();
  VideoViewManager.instance().removeVideoView(mVideoView);
}
  private void setUpListeners() {
    findViewById(R.id.cancelBtn).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        onCancelClicked();
      }
    });

    findViewById(R.id.finishBtn).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        mOnTrimVideoListener.onLoad();
        onSaveClicked();
      }
    });

 /*
    mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
      @Override
      public void onPrepared(MediaPlayer mp) {
        mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT);
        videoPrepared(mp);
      }
    });
    mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
      @Override
      public void onCompletion(MediaPlayer mp) {
        videoCompleted();
      }
    });*/
    mPlayView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        playVideoOrPause();
      }
    });
  }

  private void onSaveClicked() {
    if (mRightProgressPos - mLeftProgressPos < VideoTrimmerUtil.MIN_SHOOT_DURATION) {
      Toast.makeText(mContext, "视频长不足3秒,无法上传", Toast.LENGTH_SHORT).show();
    } else {
      mVideoView.pause();
      Log.i("onSaveClicked", mLeftProgressPos+"~~~~"+mRightProgressPos);
      VideoTrimmerUtil videoTrimmerUtil=new VideoTrimmerUtil();
      videoTrimmerUtil.trim(mContext,
              videoBean.getThumbPath(),
              mLeftProgressPos,
              mRightProgressPos,
              mOnTrimVideoListener);
    }
  }

  private void seekTo(long msec) {
    mVideoView.seekTo((int) msec);
    Log.d(TAG, "seekTo = " + msec);
  }

  private boolean getRestoreState() {
    return isFromRestore;
  }

  public void setRestoreState(boolean fromRestore) {
    isFromRestore = fromRestore;
  }

  private void setPlayPauseViewIcon(boolean isPlaying) {
    mPlayView.setImageResource(isPlaying ? R.drawable.ic_video_pause_black : R.drawable.ic_video_play_black);
  }

  private final RangeSeekBarView.OnRangeSeekBarChangeListener mOnRangeSeekBarChangeListener = new RangeSeekBarView.OnRangeSeekBarChangeListener() {
    @Override
    public void onRangeSeekBarValuesChanged(RangeSeekBarView bar, long minValue, long maxValue, int action, boolean isMin,
                                            RangeSeekBarView.Thumb pressedThumb) {
      Log.d(TAG, "-----minValue----->>>>>>" + minValue);
      Log.d(TAG, "-----maxValue----->>>>>>" + maxValue);
      mLeftProgressPos = minValue + scrollPos;
      mRedProgressBarPos = mLeftProgressPos;
      mRightProgressPos = maxValue + scrollPos;
      Log.d(TAG, "-----mLeftProgressPos----->>>>>>" + mLeftProgressPos);
      Log.d(TAG, "-----mRightProgressPos----->>>>>>" + mRightProgressPos);
      switch (action) {
        case MotionEvent.ACTION_DOWN:
          isSeeking = false;
          break;
        case MotionEvent.ACTION_MOVE:
          isSeeking = true;
          seekTo((int) (pressedThumb == RangeSeekBarView.Thumb.MIN ? mLeftProgressPos : mRightProgressPos));
          break;
        case MotionEvent.ACTION_UP:
          isSeeking = false;
          seekTo((int) mLeftProgressPos);
          break;
        default:
          break;
      }

      mRangeSeekBarView.setStartEndTime(mLeftProgressPos, mRightProgressPos);
    }
  };

  private final RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
      super.onScrollStateChanged(recyclerView, newState);
      Log.d(TAG, "newState = " + newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
      super.onScrolled(recyclerView, dx, dy);
      isSeeking = false;
      int scrollX = calcScrollXDistance();
      //达不到滑动的距离
      if (Math.abs(lastScrollX - scrollX) < mScaledTouchSlop) {
        isOverScaledTouchSlop = false;
        return;
      }
      isOverScaledTouchSlop = true;
      //初始状态,why ? 因为默认的时候有35dp的空白！
      if (scrollX == -VideoTrimmerUtil.RECYCLER_VIEW_PADDING) {
        scrollPos = 0;
      } else {
        isSeeking = true;
        scrollPos = (long) (mAverageMsPx * (VideoTrimmerUtil.RECYCLER_VIEW_PADDING + scrollX));
        mLeftProgressPos = mRangeSeekBarView.getSelectedMinValue() + scrollPos;
        mRightProgressPos = mRangeSeekBarView.getSelectedMaxValue() + scrollPos;
        Log.d(TAG, "onScrolled >>>> mLeftProgressPos = " + mLeftProgressPos);
        mRedProgressBarPos = mLeftProgressPos;
        if (mVideoView.isPlaying()) {
          mVideoView.pause();
          setPlayPauseViewIcon(false);
        }
        mRedProgressIcon.setVisibility(GONE);
        seekTo(mLeftProgressPos);
        mRangeSeekBarView.setStartEndTime(mLeftProgressPos, mRightProgressPos);
        mRangeSeekBarView.invalidate();
      }
      lastScrollX = scrollX;
    }
  };

  /**
   * 水平滑动了多少px
   */
  private int calcScrollXDistance() {
    LinearLayoutManager layoutManager = (LinearLayoutManager) mVideoThumbRecyclerView.getLayoutManager();
    int position = layoutManager.findFirstVisibleItemPosition();
    View firstVisibleChildView = layoutManager.findViewByPosition(position);
    int itemWidth = firstVisibleChildView.getWidth();
    return (position) * itemWidth - firstVisibleChildView.getLeft();
  }

  private void playingRedProgressAnimation() {
    pauseRedProgressAnimation();
    playingAnimation();
    mAnimationHandler.post(mAnimationRunnable);
  }

  private void playingAnimation() {
    if (mRedProgressIcon.getVisibility() == View.GONE) {
      mRedProgressIcon.setVisibility(View.VISIBLE);
    }
    final LayoutParams params = (LayoutParams) mRedProgressIcon.getLayoutParams();
    int start = (int) (VideoTrimmerUtil.RECYCLER_VIEW_PADDING + (mRedProgressBarPos - scrollPos) * averagePxMs);
    int end = (int) (VideoTrimmerUtil.RECYCLER_VIEW_PADDING + (mRightProgressPos - scrollPos) * averagePxMs);
    mRedProgressAnimator = ValueAnimator.ofInt(start, end).setDuration((mRightProgressPos - scrollPos) - (mRedProgressBarPos - scrollPos));
    mRedProgressAnimator.setInterpolator(new LinearInterpolator());
    mRedProgressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        params.leftMargin = (int) animation.getAnimatedValue();
        mRedProgressIcon.setLayoutParams(params);
        Log.d(TAG, "----onAnimationUpdate--->>>>>>>" + mRedProgressBarPos);
      }
    });
    mRedProgressAnimator.start();
  }

  private void pauseRedProgressAnimation() {
    mRedProgressIcon.clearAnimation();
    if (mRedProgressAnimator != null && mRedProgressAnimator.isRunning()) {
      mAnimationHandler.removeCallbacks(mAnimationRunnable);
      mRedProgressAnimator.cancel();
    }
  }

  private Runnable mAnimationRunnable = new Runnable() {

    @Override
    public void run() {
      updateVideoProgress();
    }
  };

  private void updateVideoProgress() {
    long currentPosition = mVideoView.getCurrentPosition();
    Log.d(TAG, "updateVideoProgress currentPosition = " + currentPosition);
    if (currentPosition >= (mRightProgressPos)) {
      mRedProgressBarPos = mLeftProgressPos;
      pauseRedProgressAnimation();
      onVideoPause();
    } else {
      mAnimationHandler.post(mAnimationRunnable);
    }
  }

  /**
   * Cancel trim thread execut action when finish
   */
  @Override
  public void onDestroy() {
    BackgroundExecutor.cancelAll("", true);
    UiThreadExecutor.cancelAll("");
  }
}
