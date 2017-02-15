package com.lypeer.zhihudaily.model.detail;

import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.model.detail.bean.NewsDetailResponse;

/**
 * Created by Peng on 2017/2/15.
 */

public interface DetailDataSource {
    void loadDetail(OnResultCallback<NewsDetailResponse> resultCallback, String id);
}
