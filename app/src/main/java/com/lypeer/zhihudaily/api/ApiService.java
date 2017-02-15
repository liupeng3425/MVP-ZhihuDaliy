package com.lypeer.zhihudaily.api;

import com.lypeer.zhihudaily.model.detail.bean.NewsDetailResponse;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lypeer on 2017/2/9.
 */

public interface ApiService {

    @GET("news/latest")
    Call<LatestNewsResponse> loadLatestNews();

    @GET("news/{id}")
    Call<NewsDetailResponse> loadDetail(@Path("id") String id);
}
