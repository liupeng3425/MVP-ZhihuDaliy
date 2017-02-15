package com.lypeer.zhihudaily.feature.main;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.api.OnItemClickListener;
import com.lypeer.zhihudaily.framework.BaseViewHolder;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;
import com.lypeer.zhihudaily.utils.BaseUtil;

import butterknife.BindView;

/**
 * Created by lypeer on 2017/2/6.
 */

public class MainVH extends BaseViewHolder<LatestNewsResponse.StoriesBean> {
    @BindView(R.id.iv_image)
    ImageView mIvImage;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.item)
    CardView mItem;

    public MainVH(Context context, ViewGroup root) {
        super(context, root, R.layout.main_item);
    }

    @Override
    protected void bindData(final LatestNewsResponse.StoriesBean itemValue, final int position, final OnItemClickListener listener) {
        if (itemValue.getImages().size() != 0) {
            BaseUtil.load(itemValue.getImages().get(0)).into(mIvImage);
            mIvImage.setVisibility(View.VISIBLE);
        } else {
            mIvImage.setVisibility(View.GONE);
        }

        mTvContent.setText(itemValue.getTitle());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(itemValue, view.getId(), position);
            }
        };

        mItem.setOnClickListener(onClickListener);
    }
}
