package com.example.admin.mytestgit.brvahdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.admin.mytestgit.R;
import com.example.admin.mytestgit.brvahdemo.entity.ClassroomEntity;
import com.example.admin.mytestgit.brvahdemo.entity.ClassroomsEntity;
import com.example.admin.mytestgit.brvahdemo.entity.Level0Item;
import com.example.admin.mytestgit.brvahdemo.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LgAdmin511 on 2018/6/26.
 */

public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_PERSON = 1;
    private final Context mContext;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ExpandableItemAdapter(List<MultiItemEntity> data, Context context) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
        addItemType(TYPE_PERSON, R.layout.item_expandable_lv2);
        mContext = context;
    }

    @Override
    protected void convert(final BaseViewHolder holder, MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                final Level0Item lv0 = (Level0Item) item;
                holder.setText(R.id.title, lv0.title)
                        .setText(R.id.tv_nums, lv0.subTitle)
                        .setImageResource(R.id.iv_head, lv0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        Log.d(TAG, "Level 0 item pos: " + pos);
                        if (lv0.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });

                break;
            case TYPE_PERSON:
                final ClassroomsEntity classroomsEntity = (ClassroomsEntity) item;
                ConvenientBanner<ArrayList<ClassroomEntity>> banner = holder.getView(R.id.convenient_banner);
                banner.setPages(new CBViewHolderCreator() {
                    @Override
                    public Holder createHolder(View itemView) {
                        return new LocalClassroomHolderView(itemView, mContext);
                    }

                    @Override
                    public int getLayoutId() {
                        return R.layout.item_local_classroom;
                    }
                }, classroomsEntity.getOnePageClassroom())
                        .setCanLoop(false);

                if (classroomsEntity.getOnePageClassroom().size() >= 2) {
                    banner.setPageIndicator(new int[]{R.drawable.shape_ic_page_indicator, R.drawable.shape_ic_page_indicator_focused})
                            .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
                } else {

                }
                break;
        }
    }
}
