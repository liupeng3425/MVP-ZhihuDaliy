package com.lypeer.zhihudaily.utils;

import com.lypeer.zhihudaily.model.detail.DetailRepository;
import com.lypeer.zhihudaily.model.detail.remote.DetailRemoteDS;
import com.lypeer.zhihudaily.model.news.NewsRepository;
import com.lypeer.zhihudaily.model.news.local.NewsLocalDS;
import com.lypeer.zhihudaily.model.news.remote.NewsRemoteDS;

/**
 * Inject repository .
 * <p>
 * Created by lypeer on 2017/2/9.
 */

public class Injection {

    public static NewsRepository provideTasksRepository() {
        return NewsRepository.getInstance(
                NewsLocalDS.getInstance(),
                NewsRemoteDS.getInstance()
        );
    }

    public static DetailRepository provideDetailRepository() {
        return DetailRepository.getInstance(DetailRemoteDS.getInstance());
    }
}
