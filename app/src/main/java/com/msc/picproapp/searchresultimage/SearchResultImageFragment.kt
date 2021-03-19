package com.msc.picproapp.searchresultimage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.msc.picproapp.R
import com.msc.picproapp.databinding.HomeFragmentBinding

class SearchResultImageFragment: Fragment() {

  override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
      return inflater.inflate(R.layout.search_result_fragment, container, false)
    }
}