package com.lypeer.zhihudaily.feature.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.framework.BaseActivity;
import com.lypeer.zhihudaily.utils.Injection;

import butterknife.BindView;

public class DetailActivity extends BaseActivity<DetailPresenter> {

    public static final String ID = "ID";

    @BindView(R.id.view_detail)
    DetailView mViewDetail;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        String id = intent.getStringExtra(ID);
        mViewDetail.getDetail(id);
    }

    @NonNull
    @Override
    protected DetailPresenter createPresenter() {
        return new DetailPresenter(Injection.provideTasksRepository(), mViewDetail);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.detail_act;
    }

}
