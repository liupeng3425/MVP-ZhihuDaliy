package com.lypeer.zhihudaily.feature.detail;

import android.support.annotation.NonNull;

import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.framework.BasePresenter;
import com.lypeer.zhihudaily.model.news.NewsRepository;
import com.lypeer.zhihudaily.model.news.bean.NewsDetailResponse;

/**
 * Created by Peng on 2017/2/15.
 */
public class DetailPresenter extends BasePresenter<DetailContract.View, NewsRepository> implements DetailContract.Presenter {
    public DetailPresenter(@NonNull NewsRepository repository, @NonNull DetailContract.View view) {
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
