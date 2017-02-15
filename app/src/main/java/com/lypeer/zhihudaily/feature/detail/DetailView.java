package com.lypeer.zhihudaily.feature.detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.framework.BaseView;
import com.lypeer.zhihudaily.model.detail.bean.NewsDetailResponse;
import com.lypeer.zhihudaily.utils.BaseUtil;

import butterknife.BindView;

/**
 * Created by Peng on 2017/2/15.
 */

public class DetailView extends BaseView<DetailContract.Presenter> implements DetailContract.View {
    private static final String TAG = "DetailView";
    @BindView(R.id.tv_title)
    TextView mTvTitle;

    public DetailView(@NonNull Context context) {
        super(context);
    }

    public DetailView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DetailView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void initView(Context context, AttributeSet attrs, int defStyleAttr) {

    }

    public void getDetail(String id) {
        getPresenter().loadNews(id);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.detail_view;
    }

    @Override
    public void showNews(NewsDetailResponse news) {
        mTvTitle.setText(news.getTitle());
        BaseUtil.showToast(news.getTitle());
        Log.i(TAG, "showNews: " + news.getTitle());
    }

    @Override
    public void showError(String errorMessage) {

    }
}
