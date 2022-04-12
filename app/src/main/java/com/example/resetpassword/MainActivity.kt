package com.example.resetpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )
        btnReset.setOnClickListener{
            if (editPhone.text.trim().isNotEmpty() || editSmsCode.text.trim().isNotEmpty() || editTxtPassword.text.trim().isNotEmpty()|| editNewPassword.text.trim().isNotEmpty()){
                Toast.makeText(this,"დაელოდეთ კოდს", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this,"შეავსეთ ფორმა", Toast.LENGTH_LONG).show()
            }
        }
        editPhone.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(PhoneValidate(editPhone.text.toString()))
                    btnReset.isEnabled = true
                else{
                    btnReset.isEnabled = false
                    editPhone.setError("Araswori Nomeri")
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if(PhoneValidate(editPhone.text.toString()))
                    editPhone.isEnabled = true
                else{
                    editPhone.isEnabled = false
                    editPhone.setText("GEORGIA")
                }
            }


        })

    }
    private fun PhoneValidate(text: String?): Boolean {
        var p = Pattern.compile("[0-9] [5-9] {9}")
        var m = p.matcher(text)
        return m.matches()
    }
    //private fun validPhone(): String?
    //    {
    //        val phoneText = .phoneEditText.text.toString()
    //        if(!phoneText.matches(".*[5-9} {9}].*".toRegex()))
    //        {
    //            return "Must be all Digits"
    //        }
    //        if(phoneText.length != 10)
    //        {
    //            return "Must be 9 Digits"
    //        }
    //        return null
    //    }

}