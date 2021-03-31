package com.msc.picproapp.searchresultimage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader.PreloadModelProvider
import com.bumptech.glide.ListPreloader.PreloadSizeProvider
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader
import com.bumptech.glide.util.FixedPreloadSizeProvider
import com.msc.picproapp.Constants
import com.msc.picproapp.data.http.Photo
import com.msc.picproapp.databinding.SearchResultFragmentBinding
import kotlinx.android.synthetic.main.search_result_fragment.view.*
import java.util.*

class SearchResultListFragment : Fragment(), SearchResultListContract.View {

    override lateinit var presenter: SearchResultListPresenter
    private var _binding: SearchResultFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = SearchResultFragmentBinding.inflate(inflater, container, false)
        presenter = SearchResultListPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.start()
    }

    override fun initList(photos: List<Photo>) {
        val view = binding.root!!
        val adapter = SearchResultAdapter(photos, this, { photo -> adapterOnClick(photo) })

        val sizeProvider: PreloadSizeProvider<String> =
                FixedPreloadSizeProvider<String>(
                        Constants.IMAGE_WIDTH_PIXELS,
                        Constants.IMAGE_HEIGHT_PIXELS
                )
        val modelProvider = ResultPreloadModelProvider(photos, this)
        val recyclerViewPreloader = RecyclerViewPreloader<String>(Glide.with(this), modelProvider, sizeProvider, 30)

        val recyclerView = view.rv_search_result
        recyclerView.addOnScrollListener(recyclerViewPreloader)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = adapter
    }

    fun adapterOnClick(photo: Photo) {
        //criar intent com a photo ou o id da photo
        //navegar para a tela de detalhe da photo
    }

    override fun setProgress(visible: Boolean) {
        val view = binding.root!!
        view.progress_search.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun showDataMessage(visible: Boolean) {
        val view = binding.root!!
        view.tv_no_result.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun getArgs() {
        var query = arguments?.getString(Constants.QUERY_EXTRA)
        query?.let { presenter.startSearch(it) }
    }

    override fun updateResultLabel(result: Int) {
        val resultStr = result.toString()
        binding.root!!.tv_number_result.text = "Result found: $resultStr"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    class ResultPreloadModelProvider(
            private val photos: List<Photo>,
            private val fragment: SearchResultListFragment
    ) : PreloadModelProvider<String> {


        override fun getPreloadItems(position: Int): MutableList<String> {
            val photoUrl = photos[position].urls.small
            return Collections.singletonList(photoUrl)
        }

        override fun getPreloadRequestBuilder(url: String): RequestBuilder<*>? {
            return Glide.with(fragment).load(url)
                    .override(Constants.IMAGE_WIDTH_PIXELS, Constants.IMAGE_HEIGHT_PIXELS)
        }

    }

}