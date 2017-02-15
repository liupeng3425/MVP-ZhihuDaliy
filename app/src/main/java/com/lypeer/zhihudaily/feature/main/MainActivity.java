package com.lypeer.zhihudaily.feature.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.lypeer.zhihudaily.api.OnItemClickListener;
import com.lypeer.zhihudaily.feature.detail.DetailActivity;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;
import com.lypeer.zhihudaily.utils.Injection;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.framework.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> {

    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;
    @BindView(R.id.view_main)
    MainView mViewMain;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mViewMain.getAdapter().setOnClickListener(new OnItemClickListener<LatestNewsResponse.StoriesBean>() {
            @Override
            public void onItemClick(LatestNewsResponse.StoriesBean itemValue, int viewID, int position) {
                switch (viewID) {
                    case R.id.item:
                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        intent.putExtra(DetailActivity.ID, String.valueOf(itemValue.getId()));
                        startActivity(intent);
                        break;
                }
            }
        });;
    }

    @NonNull
    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(
                Injection.provideTasksRepository(),
                mViewMain
        );
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.main_act;
    }
}
