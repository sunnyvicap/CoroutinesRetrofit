package com.example.brainviretest.ui.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.brainviretest.R
import com.example.brainviretest.databinding.LoginFragmentBinding
import com.example.brainviretest.repository.LocalPrefrances
import com.example.brainviretest.utils.showToast

class LoginFragment : Fragment() {

    private lateinit var  viewBind:LoginFragmentBinding
    private lateinit var navController: NavController

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var activity:AppCompatActivity ;

    override fun onAttach(context: Context) {
        super.onAttach(context)

        activity = context as AppCompatActivity
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBind = LoginFragmentBinding.inflate(inflater)
        return viewBind.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


       viewBind.mButtonSignIn.setOnClickListener{

           loginUser()
       }

    }

    private fun loginUser() {
        val email = viewBind.mEditTextEmail.text!!.trim()
        val password = viewBind.mEditTextPassword.text!!.trim()

        if(email.isBlank() ){
            viewBind.mEditInputFieldEmail.error = "Please Enter email Id"
        }else if(password.isBlank()){
            viewBind.mEditInputFieldPassword.error = "Please Enter password"
        }else{

            Log.e("Email",email.toString())
            Log.e("Email",password.toString())


            if(email.toString() == "test@android.com" && password.toString() == "123456"){

                LocalPrefrances(activity).logout = false

                activity.showToast("Login Successfull")

                navController.navigate(R.id.action_loginFragment_to_homeFragment)

            }else{

                activity.showToast("Please Enter Correct Email and Password")

            }
        }
    }

}