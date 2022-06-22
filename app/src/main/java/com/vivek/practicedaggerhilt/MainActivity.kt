package com.vivek.practicedaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vivek.practicedaggerhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mBinding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()
    //lateinit var mCryptoList:List<Cryptocurrency>
    //lateinit var cryptoAdapter:CryptoCurrencyAdapter
    lateinit var recyclerView: RecyclerView
    private lateinit var cryptocurrencyList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        //mBinding.recyclerviewCryptocurrencyList.layoutManager = LinearLayoutManager(this)
        //mCryptoList = listOf()
        //cryptoAdapter = CryptoCurrencyAdapter(mCryptoList)

        cryptocurrencyList = findViewById(R.id.recyclerview_cryptocurrency_list)
        cryptocurrencyList.layoutManager = LinearLayoutManager(this)

        observeCryptoCurrency()

    }

    private fun observeCryptoCurrency(){
        viewModel.cryptoCurrency.observe(this){
            //mBinding.recyclerviewCryptocurrencyList.adapter = CryptoCurrencyAdapter(it)
            cryptocurrencyList.adapter = CryptoCurrencyAdapter(it)

        }
    }
}