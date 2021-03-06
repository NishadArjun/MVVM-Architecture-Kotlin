package com.example.mvvm


import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.db.SubscriberDatabase
import com.example.mvvm.db.SubscriberRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dao= SubscriberDatabase.getInstance(application)!!.subscriberDAO
        val repository=SubscriberRepository(dao)
        val factory=SubscriberViewModelFactory(repository)

        subscriberViewModel=ViewModelProvider(this,factory).get(SubscriberViewModel::class.java)
        binding.myViewModel=subscriberViewModel
        binding.lifecycleOwner=this
        initRecyclerView()
    }


    private fun initRecyclerView(){
    binding.subscriberRecyclerView.layoutManager= LinearLayoutManager(this)
    displaySubscriberList()
    }

    private fun displaySubscriberList()
    {
        subscriberViewModel.subscribers.observe(this, Observer {

            Log.i("MyTag",it.toString())

            binding.subscriberRecyclerView.adapter=MyRecyclerViewAdapter(it)
        })
    }
}