package com.msc.picproapp.searchresultimage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.msc.picproapp.R
import com.msc.picproapp.databinding.HomeFragmentBinding

class SearchResultImageFragment : Fragment(), SearchResultImageContract.View {

    override lateinit var presenter: SearchResultImagePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = SearchResultImagePresenter(this)
        presenter.start()
        return inflater.inflate(R.layout.search_result_fragment, container, false)
    }

    override fun setProgress(visible: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showNoDataMessage() {
        TODO("Not yet implemented")
    }

    override fun getArgs() {
        var query = arguments?.getString("query_extra")
        query?.let { presenter.startSearch(it) }
    }

}