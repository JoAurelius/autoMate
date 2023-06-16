package com.capstone.pathfinderapp.customview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.capstone.pathfinderapp.R

class LoginInputView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = android.R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {

    init {
        // set up your email format checker
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateEmail(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        background = ContextCompat.getDrawable(context, R.drawable.text_view_border)
    }

    private fun validateEmail(email: String) {
        if (email.isEmpty()) {
            error = null
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            error = "Invalid email format"
        } else {
            error = null
        }
    }

    fun getEmail(): String {
        return text.toString()
    }

    fun setEmail(email: String) {
        setText(email)
    }

    fun setError(errorMessage: String) {
        error = errorMessage
    }

    fun clearError() {
        error = null
    }
}
