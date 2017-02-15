package com.lypeer.zhihudaily.model.detail.remote;

import com.lypeer.zhihudaily.App;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.api.ApiService;
import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.model.RetrofitClient;
import com.lypeer.zhihudaily.model.detail.DetailDataSource;
import com.lypeer.zhihudaily.model.detail.bean.NewsDetailResponse;
import com.lypeer.zhihudaily.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Peng on 2017/2/15.
 */

public class DetailRemoteDS implements DetailDataSource {
    private static class SingletonHolder {
        private static final DetailRemoteDS INSTANCE = new DetailRemoteDS();
    }

    private DetailRemoteDS() {
    }

    public static DetailRemoteDS getInstance() {
        return DetailRemoteDS.SingletonHolder.INSTANCE;
    }

    @Override
    public void loadDetail(final OnResultCallback<NewsDetailResponse> resultCallback, String id) {
        RetrofitClient.buildService(ApiService.class)
                .loadDetail(id)
                .enqueue(new Callback<NewsDetailResponse>() {
                    @Override
                    public void onResponse(Call<NewsDetailResponse> call, Response<NewsDetailResponse> response) {
                        if (response == null || response.body() == null) {
                            resultCallback.onFail(App.getAppContext().getString(R.string.error_data_null));
                            return;
                        }

                        NewsDetailResponse detail = response.body();
                        resultCallback.onSuccess(detail, Constants.ResultCode.REMOTE);
                    }

                    @Override
                    public void onFailure(Call<NewsDetailResponse> call, Throwable t) {
                        resultCallback.onFail(null == t ? App.getAppContext().getString(R.string.error_network) : t.getMessage());
                    }
                });
    }
}
