package com.example.brainviretest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.example.brainviretest.repository.LocalPrefrances
import com.example.brainviretest.ui.home.HomeFragment
import com.example.brainviretest.ui.login.LoginFragment

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {


    private lateinit var navController :NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
       navController    = navHostFragment.navController


        if(!LocalPrefrances(this).logout){

            navController.navigate(R.id.homeFragment)
        }else{
            navController.navigate(R.id.loginFragment)
        }


    }

    override fun onResume() {
        super.onResume()

        navController.addOnDestinationChangedListener(this)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?) {

        invalidateOptionsMenu()

        if(controller.currentDestination?.id == R.id.homeFragment){

            supportActionBar?.title ="Home"
        }else{

            supportActionBar?.title ="Login"


        }
    }


    override fun onBackPressed() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()

        navController.removeOnDestinationChangedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.menu,menu)

        menu?.getItem(0)?.isVisible = navController.currentDestination?.id == R.id.homeFragment
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.logout -> {
                LocalPrefrances(this).logout = true
                navController.navigate(R.id.loginFragment)
            }
        }

        return true
    }
}