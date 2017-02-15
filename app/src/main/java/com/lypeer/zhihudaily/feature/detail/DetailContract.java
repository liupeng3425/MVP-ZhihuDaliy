package com.lypeer.zhihudaily.feature.detail;

import com.lypeer.zhihudaily.feature.main.MainContract;
import com.lypeer.zhihudaily.framework.BasePresenterApi;
import com.lypeer.zhihudaily.framework.BaseViewApi;
import com.lypeer.zhihudaily.model.detail.bean.NewsDetailResponse;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by Peng on 2017/2/15.
 */

public class DetailContract {
    interface View extends BaseViewApi<DetailContract.Presenter> {
        void showNews(NewsDetailResponse news);
        void showError(String errorMessage);
    }

    interface Presenter extends BasePresenterApi {
        void loadNews(String id);
        void loadFail(String errorMessage);
    }
}