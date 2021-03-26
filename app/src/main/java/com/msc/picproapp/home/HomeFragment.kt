package com.msc.picproapp.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.msc.picproapp.data.ItemViewModel
import com.msc.picproapp.databinding.HomeFragmentBinding
import com.msc.picproapp.searchresultimage.FavoriteImagesFragment
import com.msc.picproapp.searchimagehistory.SearchImageHistoryFragment

class HomeFragment : Fragment(), HomeContract.View {

    override lateinit var presenter: HomePresenter
    private lateinit var homePagerAdapter: HomePagerAdapter
    private lateinit var viewPager: ViewPager2
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        presenter = HomePresenter(this)
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        presenter.start()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homePagerAdapter = HomePagerAdapter(this)
        viewPager = binding.pager
        viewPager.adapter = homePagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = if (position == 0) "Pesquisa" else "Favoritos"
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun navigateTo(resId: Int, argument: String) {
        val result = Bundle()
        result.putString("query_extra", argument)
        findNavController().navigate(resId,result)
    }

    override fun setViewModelObserver() {
        val viewModel: ItemViewModel by activityViewModels()
        viewModel.argument.observe(this, Observer { argument ->
            presenter.argumentSet(argument) })
    }

}

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val NUM_PAGES = 2
    private val POS_SEARCH_IMAGES_HISTORY = 0

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        var fragment =
                if (position == POS_SEARCH_IMAGES_HISTORY) SearchImageHistoryFragment() else FavoriteImagesFragment()
        fragment.arguments = Bundle().apply {
            putInt("object", position + 1)
        }
        return fragment
    }

}