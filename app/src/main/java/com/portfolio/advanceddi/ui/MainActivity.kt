package com.portfolio.advanceddi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.portfolio.advanceddi.R
import com.portfolio.advanceddi.model.Blog
import com.portfolio.advanceddi.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG: String  = "AppDebug"
    private val viewModel: MainViewModel   by viewModels()
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvents)
    }

    private fun subscribeObservers(){
        viewModel.dataState.observe(this, Observer { dataState ->
            when(dataState){
                is DataState.Success<List<Blog>> -> {
                    displayProgressBar(isDisplayed = false)
                    appendTitle(dataState.data)
                }

                is DataState.Error -> {
                    displayProgressBar(isDisplayed = false)
                    dataState.Exception.message?.let { displayError(it) }
                }

                is DataState.Loading -> {
                    displayProgressBar(isDisplayed = true)
                }
            }

        })
    }


    private fun displayError(message: String){
        if(message.isNotEmpty()){
            text.text = message
        }else {
            text.text= "Unknown Error"
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        if(isDisplayed){
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    private fun appendTitle(blogs: List<Blog>){
        val sb = StringBuilder()
        for (blog in blogs){
            sb.append(blog.title + "\n")
        }


        text.text = sb
    }
}