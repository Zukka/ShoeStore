package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.udacity.shoestore.viewmodel.ShoeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        Timber.plant(Timber.DebugTree())
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        viewModel.isLogged.observe(this, Observer { logged ->
            if (logged)
                Navigation.findNavController(this, R.id.main_navigation).navigate(R.id.action_loginFragment_to_welcomeFragment)
        })
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
     }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
         return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                viewModel.logout()
                 navController.navigate(R.id.loginFragment)

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
