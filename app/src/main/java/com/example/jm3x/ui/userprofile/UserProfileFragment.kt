package com.example.jm3x.ui.userprofile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.jm3x.LoginActivity
import com.example.jm3x.databinding.FragmentUserProfileBinding
import com.google.firebase.auth.FirebaseAuth

class UserProfileFragment : Fragment() {
    var binding: FragmentUserProfileBinding? = null
    var txtLogout: TextView? = null
    var mFirebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtLogout = binding!!.txtLogout
        txtLogout!!.setOnClickListener { v: View? -> logOut() }
    }

    fun logOut() {
        mFirebaseAuth!!.signOut()
        startActivity(Intent(requireContext(), LoginActivity::class.java))
        requireActivity().finish()
    }
}