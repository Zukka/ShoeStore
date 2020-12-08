package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel

class LoginFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

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
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.buttonLogin.setOnClickListener   {
            login()
        }

        binding.buttonSignup.setOnClickListener {
            login()
        }

        return binding.root
    }

    private fun login() {
        viewModel.login()
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }
}