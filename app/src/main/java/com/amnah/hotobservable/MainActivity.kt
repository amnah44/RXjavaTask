package com.amnah.hotobservable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amnah.hotobservable.databinding.ActivityMainBinding
import com.amnah.hotobservable.fragment.BottomFragment

class MainActivity : AppCompatActivity(),DataObserve{
    private lateinit var mainBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


    }

    override fun getData(text: String) {
        val bottomFragment = BottomFragment()
        val bundle = Bundle()
        bundle.putString("TEXT", text)
        bottomFragment.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottom_container, bottomFragment).commit()
    }
}