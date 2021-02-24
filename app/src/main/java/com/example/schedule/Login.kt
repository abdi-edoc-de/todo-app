package com.example.schedule

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.schedule.databinding.FragmentLoginBinding




//import com.hanks.passcodeview.PasscodeView


class Login : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // this is to bind the activity part and the layout
        val binding: FragmentLoginBinding =DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        val pin=binding.pin
        val check: TextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (filterLongEnough()==4) {
                    val db = Room.databaseBuilder(
                        requireActivity(), AppDatabase::class.java, "schedule-db"
                    ).allowMainThreadQueries().build()
                    val userDAO = db.userDao()
                    val user = userDAO.getAll().first()
                    if(pin.text.toString().toInt() == user.pin){
                        Log.e("LoginFragment", "LOGGING in")
                        Toast.makeText(activity,"Correct",Toast.LENGTH_LONG).show()
                        user.hasLoggedIn = true
                        userDAO.updateUser(user)
                        findNavController().navigate(LoginDirections.actionLogin2ToMainPage2("abdi"))
                    }else{
                        Toast.makeText(activity,"No correct",Toast.LENGTH_LONG).show()
                    }
                }
            }
            private fun filterLongEnough(): Int {
                return pin.text.toString().trim { it <= ' ' }.length
            }
        }
        pin.addTextChangedListener(check)

        //this is to return the view object
        return binding.root
    }


    fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

}
