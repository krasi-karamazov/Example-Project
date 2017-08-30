package com.mentormate.tcos.presentation.navigation.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mentormate.tcos.R;
import com.mentormate.tcos.presentation.adapters.base.HeaderFooterAdapter;
import com.mentormate.tcos.presentation.navigation.NavigationDrawerController;
import com.mentormate.tcos.presentation.navigation.NavigationItemClickListener;
import com.mentormate.tcos.presentation.navigation.models.SlidingMenuItemModel;
import com.mentormate.tcos.utils.RoundedTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NavigationAdapter extends HeaderFooterAdapter {

    private NavigationItemClickListener mListener;
    private SharedPreferences mPrefs;
    private List<SlidingMenuItemModel> mData;
    public static final int HEADER_ITEM_TYPE = 12;
    public static final int CONTENT_ITEM_TYPE = 13;


    public NavigationAdapter(List<SlidingMenuItemModel> data, NavigationItemClickListener listener, SharedPreferences prefs, Context context) {
        super(context);
        mData = data;
        mListener = listener;
        mPrefs = prefs;
    }

    @Override
    protected int getHeaderItemCount() {
        return 1;
    }

    @Override
    protected int getFooterItemCount() {
        return 0;
    }

    @Override
    protected int getContentItemCount() {
        return mData.size();
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderItemViewHolder(ViewGroup parent, int headerViewType) {
        View headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main_menu_header, parent, false);
        return new HeaderItemViewHolder(headerView);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateFooterItemViewHolder(ViewGroup parent, int footerViewType) {

        return null;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateContentItemViewHolder(ViewGroup parent, int contentViewType) {
        View contentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main_menu, parent, false);
        return new ContentItemViewHolder(contentView);
    }

    @Override
    protected void onBindHeaderItemViewHolder(RecyclerView.ViewHolder headerViewHolder, int position) {
        Picasso.with(getContext())
                .load(R.drawable.avatar).resize((int) getContext().getResources().getDimension(R.dimen.profile_avatar_width), (int) getContext().getResources().getDimension(R.dimen.profile_avatar_width)).centerCrop()
                .transform(new RoundedTransformation((int) getContext().getResources().getDimension(R.dimen.profile_avatar_width)))
                .into(((HeaderItemViewHolder) headerViewHolder).avatar);
    }

    @Override
    protected void onBindFooterItemViewHolder(RecyclerView.ViewHolder footerViewHolder, int position) {

    }

    @Override
    protected void onBindContentItemViewHolder(RecyclerView.ViewHolder contentViewHolder, int position) {
        SlidingMenuItemModel item = mData.get(position);
        ((ContentItemViewHolder) contentViewHolder).txtView.setText(item.getLabel());
        if (item.getIcon() == SlidingMenuItemModel.NO_ICON) {
            ((ContentItemViewHolder) contentViewHolder).imgIconView.setVisibility(View.GONE);
        } else {
            //TODO display icon
        }
    }

    @Override
    protected int getHeaderItemViewType(int position) {
        return HEADER_ITEM_TYPE;
    }

    @Override
    protected int getContentItemViewType(int position) {
        return CONTENT_ITEM_TYPE;
    }

    class ContentItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.img_icon)
        ImageView imgIconView;

        @Bind(R.id.txt_title)
        TextView txtView;

        public ContentItemViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    class HeaderItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.header_avatar)
        ImageView avatar;

        public HeaderItemViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}

