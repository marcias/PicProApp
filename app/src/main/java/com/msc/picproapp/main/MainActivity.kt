package com.msc.picproapp.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.msc.picproapp.R
import com.msc.picproapp.databinding.MainAcitivityBinding
import kotlinx.android.synthetic.main.main_acitivity.view.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter
    private lateinit var binding: MainAcitivityBinding
    private lateinit var host: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainAcitivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(view.toolbar)

//        host = supportFragmentManager
//                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
//
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        view.toolbar_search.setOnSearchClickListener {
            presenter.startSearch()
            Log.v("MainActivity", ">>> listener")
        }

        (view.toolbar_search as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            view.toolbar_search.setIconifiedByDefault(false)
        }
        //presenter.start()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        binding.root.toolbar.setupWithNavController(host.navController)
        Log.v("MainActivity", ">>> new Intent")
    }

    override fun changeFragment(fragment: Fragment) {
        TODO("Not yet implemented")
    }
}