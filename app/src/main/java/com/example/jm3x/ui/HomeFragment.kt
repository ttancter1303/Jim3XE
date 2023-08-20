package com.example.jm3x.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.jm3x.R
import com.example.jm3x.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    var binding: FragmentHomeBinding? = null
    var mUserProfile: TextView? = null
    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        navController = findNavController(requireActivity(), R.id.fragmentContainerView)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mUserProfile = binding!!.UserProfile
        moveToUserProfile()
    }

    fun moveToUserProfile() {
        mUserProfile!!.setOnClickListener { v: View? -> navController!!.navigate(R.id.userProfileFragment) }
    }
}