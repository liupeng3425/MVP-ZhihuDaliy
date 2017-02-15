package com.lypeer.zhihudaily.feature.detail;

import android.support.annotation.NonNull;

import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.framework.BasePresenter;
import com.lypeer.zhihudaily.model.detail.DetailRepository;
import com.lypeer.zhihudaily.model.detail.bean.NewsDetailResponse;
import com.lypeer.zhihudaily.model.news.NewsRepository;

/**
 * Created by Peng on 2017/2/15.
 */
public class DetailPresenter extends BasePresenter<DetailContract.View, DetailRepository> implements DetailContract.Presenter {
    public DetailPresenter(@NonNull DetailRepository repository, @NonNull DetailContract.View view) {
        super(repository, view);
    }

    @Override
    public void loadNews(String id) {
        getRepository().loadDetail(new OnResultCallback<NewsDetailResponse>() {
            @Override
            public void onSuccess(NewsDetailResponse resultValue, int code) {
                getView().showNews(resultValue);
            }

            @Override
            public void onFail(String errorMessage) {
                getView().showError(errorMessage);
            }
        }, id);
    }

    @Override
    public void loadFail(String errorMessage) {
        getView().showError(errorMessage);
    }

    @Override
    public void start() {

    }
}
