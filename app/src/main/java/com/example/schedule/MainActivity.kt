package com.example.schedule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.schedule.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var drawerLayout: DrawerLayout
//    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        val binding= DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main)


//        drawerLayout=binding.drawerLayout
//
//
//        val navController = this.findNavController(R.id.myNavHostFragment)
//        NavigationUI.setupActionBarWithNavController(this, navController,drawerLayout)
//        NavigationUI.setupWithNavController(binding.navView, navController)

    }
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.myNavHostFragment)
//
//        return NavigationUI.navigateUp( navController,drawerLayout)    }


}
