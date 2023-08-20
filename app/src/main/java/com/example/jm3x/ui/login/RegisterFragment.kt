package com.example.jm3x.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.jm3x.R
import com.example.jm3x.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterFragment : Fragment() {
    var firebaseAuth: FirebaseAuth? = null
    private val mEmail: String? = null
    private val mPassword: String? = null
    var binding: FragmentRegisterBinding? = null
    var mEdtRegisterName: EditText? = null
    var mEdtRegisterEmail: EditText? = null
    var mEdtRegisterPassword: EditText? = null
    var mBtnRegisterAccept: Button? = null
    var mLoading: ProgressBar? = null
    var navController: NavController? = null
    var mFirebaseAuth: FirebaseAuth? = null
    var mFirestore: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirebaseAuth = FirebaseAuth.getInstance()
        mFirestore = FirebaseFirestore.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        mEdtRegisterEmail = binding!!.edtRegisterEmail
        mEdtRegisterName = binding!!.edtRegisterName
        mEdtRegisterPassword = binding!!.edtRegisterPassword
        mBtnRegisterAccept = binding!!.btnRegisterAccept
        mLoading = binding!!.loading
        navController = findNavController(requireActivity(), R.id.fragmentContainerView)
        mBtnRegisterAccept!!.setOnClickListener { v: View? ->
            regist(
                mEdtRegisterEmail!!.text.toString(),
                mEdtRegisterPassword!!.text.toString(),
                mEdtRegisterName!!.text.toString()
            )
        }
    }

    fun regist(Email: String?, Password: String?, Name: String?) {
        mLoading!!.visibility = View.VISIBLE
        mLoading!!.setProgress(0, true)
        mFirebaseAuth!!.createUserWithEmailAndPassword(Email!!, Password!!)
            .addOnCompleteListener(requireActivity()) { task ->
                mLoading!!.setProgress(0, false)
                mLoading!!.visibility = View.GONE
                if (task.isSuccessful) {
                    addUserToDB(Email, Name)
                    Toast.makeText(requireContext(), "Đăng ký thành công", Toast.LENGTH_SHORT)
                        .show()
                    requireActivity().onBackPressed()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Bạn nhập sai tài khoản hoặc là chưa đăng ký",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun addUserToDB(Email: String?, Name: String?) {
        val dataMap: MutableMap<String, Any?> = HashMap()
        dataMap["trait"] = ""
        dataMap["birth"] = ""
        dataMap["email"] = Email
        dataMap["name"] = Name
        dataMap["image"] = "user_image/149071.png"
        val firebaseUser = mFirebaseAuth!!.currentUser
        if (firebaseUser != null) {
            mFirestore!!.collection("users")
                .add(dataMap)
                .addOnSuccessListener { documentReference ->
                    Log.d(
                        "ttan",
                        "DocumentSnapshot added with ID: " + documentReference.id
                    )
                }
                .addOnFailureListener { e -> Log.w("ttan", "Error adding document", e) }
        }
    }
}