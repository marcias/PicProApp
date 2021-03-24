package com.msc.picproapp.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import com.msc.picproapp.R
import com.msc.picproapp.databinding.MainAcitivityBinding
import kotlinx.android.synthetic.main.main_acitivity.view.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override lateinit var presenter: MainPresenter
    private lateinit var binding: MainAcitivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        binding = MainAcitivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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
        presenter.start()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) {
            Log.v("MainActivity", ">>> New Intent not null")
            if (Intent.ACTION_SEARCH == intent.action) {
                intent.getStringExtra(SearchManager.QUERY)
                    ?.also { query -> presenter.startSearch(query) }
            }
        }
    }

    override fun navigateTo(resId: Int) {
        findNavController(R.id.nav_host_fragment).navigate(resId)
    }

    override fun setArguments() {
        //Mandar argumentos para fragment
    }
}