package com.lypeer.zhihudaily.model.detail;

import android.support.annotation.NonNull;

import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.framework.BaseRepository;
import com.lypeer.zhihudaily.model.detail.bean.NewsDetailResponse;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Peng on 2017/2/15.
 */

public class DetailRepository extends BaseRepository implements DetailDataSource {
    private final DetailDataSource mDetailRemoteDS;

    private static DetailRepository INSTANCE = null;

    private DetailRepository(@NonNull DetailDataSource remoteDS) {
        mDetailRemoteDS = remoteDS;
    }

    public static DetailRepository getInstance(@NonNull DetailDataSource remoteDS) {
        Lock lock = new ReentrantLock();
        lock.lock();
        if (null == INSTANCE) {
            INSTANCE = new DetailRepository(remoteDS);
        }
        lock.unlock();

        return INSTANCE;
    }

    @Override
    public void loadDetail(OnResultCallback<NewsDetailResponse> resultCallback, String id) {
        mDetailRemoteDS.loadDetail(resultCallback, id);
    }
}
