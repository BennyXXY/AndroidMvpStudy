package com.allen.mvpdemo.main.presenter;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.allen.mvpdemo.R;
import com.allen.mvpdemo.main.model.UserModel;
import com.allen.mvpdemo.main.view.IMainView;
import com.allen.mvpdemo.utli.CommonAdapter;
import com.allen.mvpdemo.utli.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务逻辑实现类
 * Created by ChenRan on 2016-2-25.
 */
public class MainPresenterCompl implements IMainPresenter {

	private IMainView mIMainView;
	private List<UserModel> mIUserList;
	private Handler mHandler;

	public MainPresenterCompl(IMainView iMainView){
		this.mIMainView = iMainView;
		initUserList();
		mHandler = new Handler(Looper.getMainLooper());
	}

	@Override
	public void loadData() {
		mIMainView.getListView().setAdapter(new CommonAdapter<UserModel>(mIMainView.getContext(),mIUserList, R.layout.activity_main_item) {
			@Override
			public void convert(ViewHolder helper, UserModel item) {
				helper.setText(R.id.main_item_name,item.getName());
				helper.setText(R.id.main_item_age,String.valueOf(item.getAge()));
			}
		});

		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				setListVisiblity();
				setProgressBarVisiblity(View.INVISIBLE);
			}
		}, 2000);
	}

	@Override
	public void setListVisiblity() {
		mIMainView.onShowList();
	}

	@Override
	public void setProgressBarVisiblity(int visiblity) {
		mIMainView.onSetProgressBarVisibility(visiblity);
	}

	private void initUserList(){
		mIUserList = new ArrayList<UserModel>();

		mIUserList.add(new UserModel("陈一",20));
		mIUserList.add(new UserModel("田二",21));
		mIUserList.add(new UserModel("张三",22));
		mIUserList.add(new UserModel("李四",23));
		mIUserList.add(new UserModel("王五",24));
		mIUserList.add(new UserModel("赵六",25));
		mIUserList.add(new UserModel("吴七",26));
		mIUserList.add(new UserModel("唐八",27));
		mIUserList.add(new UserModel("黄九",28));
		mIUserList.add(new UserModel("叶十",29));

		mIUserList.add(new UserModel("A1",30));
		mIUserList.add(new UserModel("A2",31));
		mIUserList.add(new UserModel("A3",32));
		mIUserList.add(new UserModel("A4",33));
		mIUserList.add(new UserModel("A5",34));
		mIUserList.add(new UserModel("A6",35));

		mIUserList.add(new UserModel("B1",36));
		mIUserList.add(new UserModel("B2",37));
		mIUserList.add(new UserModel("B3",38));
		mIUserList.add(new UserModel("B4",39));
		mIUserList.add(new UserModel("B5",40));
		mIUserList.add(new UserModel("B6",41));

	}
}
