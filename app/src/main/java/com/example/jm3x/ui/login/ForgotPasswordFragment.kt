package com.example.jm3x.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.jm3x.databinding.FragmentForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordFragment : Fragment() {
    var mEmail: EditText? = null
    var mReset: Button? = null
    var mLoading: ProgressBar? = null
    var binding: FragmentForgotPasswordBinding? = null
    var mFirebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirebaseAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mReset = binding!!.btnRegisterAccept
        mEmail = binding!!.edtRegisterEmail
        mLoading = binding!!.loading
        mReset!!.setOnClickListener { v: View? ->
            forgotPassword(
                mEmail!!.text.toString()
            )
        }
    }

    fun forgotPassword(Email: String?) {
        mLoading!!.visibility = View.VISIBLE
        mLoading!!.setProgress(0, true)
        mFirebaseAuth!!.sendPasswordResetEmail(Email!!)
            .addOnCompleteListener(requireActivity()) { task ->
                mLoading!!.visibility = View.GONE
                mLoading!!.setProgress(0, false)
                if (task.isSuccessful) {
                    Toast.makeText(
                        requireContext(),
                        "Vui lòng kiểm tra hộp thư của email " + mEmail!!.text,
                        Toast.LENGTH_SHORT
                    ).show()
                    requireActivity().onBackPressed()
                } else {
                    Toast.makeText(
                        requireContext(),
                        task.exception!!.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}