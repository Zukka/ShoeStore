package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    @Override
    override fun onPrepareOptionsMenu(menu: Menu) {
        val item = menu.findItem(R.id.logout)
        if (item != null)
            item.setVisible(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel
        binding.shoe = Shoe()
        viewModel.cancel.observe(viewLifecycleOwner, { isCancel ->
            if (isCancel) {
                navigateToShoeList()
                viewModel.eventCancelComplete()
            }
        })

        viewModel.save.observe(viewLifecycleOwner, { isSave ->
            if (isSave) {
                navigateToShoeList()
                viewModel.eventSaveComplete()
            }
        })

        viewModel.showSnackBarError.observe(viewLifecycleOwner, { onError ->
            if (onError) {
                Snackbar.make(binding.tvShoeCompany, getString(R.string.incomplete_details), Snackbar.LENGTH_SHORT).show()
                viewModel.eventSnackBarCompleted()
            }
        })

        return binding.root
    }

    private fun navigateToShoeList() {
        findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
    }

}