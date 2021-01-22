package com.example.brainviretest.ui.home

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import com.example.brainviretest.databinding.HomeFragmentBinding
import com.example.brainviretest.model.Rates
import com.example.brainviretest.ui.ListExpandableAdapter
import com.example.brainviretest.utils.Status
import com.example.brainviretest.utils.showToast

class HomeFragment : Fragment() {


    private lateinit var activity :AppCompatActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)

        activity =context as AppCompatActivity
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit  var viewModel: HomeViewModel
    private lateinit var  viewBind: HomeFragmentBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBind = HomeFragmentBinding.inflate(inflater)
        return viewBind.root;
    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        setupObservers()
    }


    private fun setupObservers() {
        viewModel.getData().observe(activity, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        viewBind.progressbar.visibility = View.GONE
                        resource.data?.let { it ->

                            val entry  = it.rates;
                            val adapter = ListExpandableAdapter(context= activity, entrySet = entry)
                            viewBind.recyclerView.adapter = adapter

                        }
                    }
                    Status.ERROR -> {

                        viewBind.progressbar.visibility = View.GONE
                        it.message?.let { it1 -> activity.showToast(it1) }
                    }
                    Status.LOADING -> {
                        viewBind.progressbar.visibility = View.VISIBLE

                    }
                }
            }
        })
    }



}