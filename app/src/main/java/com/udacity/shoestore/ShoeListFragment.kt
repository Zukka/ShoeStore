package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ViewShoeItemBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.fabGoToDetails.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailsFragment())
        }

        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel

        viewModel.shoe.observe(viewLifecycleOwner, {shoeList ->
            binding.shoeItemsLayout.removeAllViews()
            shoeList.forEach { shoeItem ->
                val shoeBinding: ViewShoeItemBinding = DataBindingUtil.inflate(inflater, R.layout.view_shoe_item, container, false)
                shoeBinding.shoeItem = shoeItem
                shoeBinding.executePendingBindings()
                binding.shoeItemsLayout.addView(shoeBinding.root)
            }
        })
        return binding.root
    }
}