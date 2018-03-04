package cf.android666.wanandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cf.android666.wanandroid.R
import cf.android666.wanandroid.adapter.DiscoverNaviAdapter
import cf.android666.wanandroid.api.WanAndroidApiHelper
import cf.android666.wanandroid.api.WanAndroidService
import cf.android666.wanandroid.base.BaseFragment
import cf.android666.wanandroid.bean.DiscoverNaviBean
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_discover_tree.view.*

/**
 * Created by jixiaoyong on 2018/2/25.
 */
class DiscoverNaviFragment : BaseFragment() {

    private var mData: ArrayList<DiscoverNaviBean.DataBean> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_discover_tree, container, false)

        var service: WanAndroidService = WanAndroidApiHelper.getInstance()

        var observable : Observable<DiscoverNaviBean> = service.getNavi()

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{

                    mData.clear()

                    mData.addAll(it.data)

                    view.expandable_layout.setAdapter(DiscoverNaviAdapter(context,mData))
                }


        return view
    }
}