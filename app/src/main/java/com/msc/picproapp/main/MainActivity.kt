package com.msc.picproapp.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.msc.picproapp.R
import com.msc.picproapp.data.ItemViewModel
import com.msc.picproapp.databinding.MainAcitivityBinding
import com.msc.picproapp.home.HomeFragment
import kotlinx.android.synthetic.main.main_acitivity.view.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override lateinit var presenter: MainPresenter
    private lateinit var binding: MainAcitivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        binding = MainAcitivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.start()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) {
            if (Intent.ACTION_SEARCH == intent.action) {
                intent.getStringExtra(SearchManager.QUERY)
                        ?.also { query ->
                            presenter.queryReceived(query)
                        }
            }
        }
    }

    override fun setSearchView() {
        val view = binding.root
        setSupportActionBar(view.toolbar)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        view.toolbar_search.setOnSearchClickListener {
//            view.toolbar_search
//            presenter.startSearch()
//        }

        (view.toolbar_search as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            view.toolbar_search.setIconifiedByDefault(false)
        }
    }

    override fun setArguments(argument: String) {
        val viewModel: ItemViewModel by viewModels()
        viewModel.argument(argument)
    }

}