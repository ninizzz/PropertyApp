package com.guet.community.supply.details;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.guet.base.activity.MvvmBaseActivity;
import com.guet.common.adapter.ScreenAutoAdapter;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.utils.TitleBarUtils;
import com.guet.community.R;
import com.guet.community.databinding.CommunityActivitySupplyDetailsBinding;
import com.guet.community.supply.bean.SupplyCustomViewModel;

/**
 *
 *
 * @author dhxstart
 * @date 2022/4/14 22:56
 */
@Route(path = RouterActivityPath.Community.PAGE_SUPPLY_DETAILS)
public class SupplyDetailsActivity extends MvvmBaseActivity<CommunityActivitySupplyDetailsBinding, SupplyDetailsViewModel>
        implements ISupplyDetailsDetailsView {
    private static final String TAG = "NoticeActivity";

    @Autowired(name = "supplyCustomViewModel")
    public SupplyCustomViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.community_activity_supply_details;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScreenAutoAdapter.match(this, 375.0f);
        super.onCreate(savedInstanceState);
        // ARouter inject 注入
        ARouter.getInstance().inject(this);
        if (viewModel != null) {
            viewDataBinding.setViewModel(viewModel);
            LogUtils.dTag(TAG, "title：" + viewModel.title);
        }
        viewDataBinding.included.titleBar.setTitle("供求商品详情");
        TitleBarUtils.clickLeftBack(viewDataBinding.included.titleBar, this);
    }

    @Override
    protected SupplyDetailsViewModel getViewModel() {
        return ViewModelProviders.of(this).get(SupplyDetailsViewModel.class);
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
