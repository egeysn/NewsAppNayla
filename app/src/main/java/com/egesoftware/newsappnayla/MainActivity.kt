package com.egesoftware.newsappnayla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.BuildConfig
import androidx.fragment.app.Fragment
import com.egesoftware.newsappnayla.databinding.ActivityMainBinding
import com.egesoftware.newsappnayla.ui.favorites.FavoritesFragment
import com.egesoftware.newsappnayla.ui.news.NewsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber

class MainActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.favorites -> {
                    setCurrentFragment(FavoritesFragment())


                    return@OnNavigationItemSelectedListener true
                }
                R.id.main -> {
                   setCurrentFragment(NewsFragment())

                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val firstFragment = NewsFragment()
        if (savedInstanceState == null) {

           setCurrentFragment(firstFragment)
        }
        //setCurrentFragment(firstFragment)
        //Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

       binding.executePendingBindings()
    }




   private fun setCurrentFragment(fragment: Fragment) =
      supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
}