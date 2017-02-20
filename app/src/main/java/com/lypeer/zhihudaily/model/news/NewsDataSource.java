package com.lypeer.zhihudaily.model.news;

import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;
import com.lypeer.zhihudaily.model.news.bean.NewsDetailResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/6.
 */

public interface NewsDataSource {

    void loadLatestNews(OnResultCallback<List<LatestNewsResponse.StoriesBean>> resultCallback);

    void loadDetail(OnResultCallback<NewsDetailResponse> resultCallback, String id);
}
