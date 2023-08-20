package com.example.jm3x.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.jm3x.MainActivity
import com.example.jm3x.R
import com.example.jm3x.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    var binding: FragmentLoginBinding? = null
    var mBtnLogin: Button? = null
    var mBtnRegister: Button? = null
    var mEdtAccount: EditText? = null
    var mEdtPassword: EditText? = null
    var mTxtForgotPassword: TextView? = null
    var mLoading: ProgressBar? = null
    var navController: NavController? = null
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
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController(requireActivity(), R.id.fragmentContainerView)
        mBtnLogin = binding!!.btnLogin
        mBtnRegister = binding!!.btnRegister
        mEdtAccount = binding!!.edtAccount
        mEdtPassword = binding!!.edtPassword
        mTxtForgotPassword = binding!!.txtForgotPassword
        mLoading = binding!!.loading
        mBtnLogin!!.setOnClickListener { v: View? ->
            logIn(
                mEdtAccount!!.text.toString(), mEdtPassword!!.text.toString()
            )
        }
        mBtnRegister!!.setOnClickListener { v: View? -> navController!!.navigate(R.id.registerFragment) }
        mTxtForgotPassword!!.setOnClickListener { v: View? -> navController!!.navigate(R.id.forgotPasswordFragment) }
    }

    fun logIn(Email: String?, Password: String?) {
        mLoading!!.visibility = View.VISIBLE
        mLoading!!.setProgress(0, true)
        mFirebaseAuth!!.signInWithEmailAndPassword(Email!!, Password!!)
            .addOnCompleteListener(requireActivity()) { task ->
                mLoading!!.visibility = View.GONE
                mLoading!!.setProgress(0, false)
                if (task.isSuccessful) {
                    Toast.makeText(requireContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT)
                        .show()
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    mBtnLogin!!.text = ""
                    mEdtPassword!!.setText("")
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