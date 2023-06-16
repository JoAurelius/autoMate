package com.capstone.pathfinderapp.view


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Observer
import com.capstone.pathfinderapp.api.ApiConfig
import com.capstone.pathfinderapp.databinding.ActivityLoginBinding
import com.capstone.pathfinderapp.model.LoginResponse
import com.capstone.pathfinderapp.model.TokenPreferences
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore(name = "settings")
    private var token: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
//            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(intent)
        }

        val tokenManager = TokenPreferences(this)

        val existToken = tokenManager.getToken()
        if (existToken != null) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MainActivity.EXTRA_TOKEN, existToken)
            startActivity(intent)
        }

        val passwordInputView = binding.edLoginPassword
        passwordInputView.errorObserver.observe(this, Observer { hasError ->
            binding.btnLogin.isEnabled = !hasError
        })

        binding.btnLogin.setOnClickListener {
            val email = binding.edLoginEmail.text.toString()
            val password = binding.edLoginPassword.text.toString()
            val client = ApiConfig.getApiService().loginAPI(email, password)
            client.enqueue(object : Callback, retrofit2.Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val token = response.body()?.user?.stsTokenManager?.accessToken
                        if (token != null) {
                            tokenManager.saveToken(token)
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            Log.d("LoginActivityToken", "onResponse: $token")
                            intent.putExtra(MainActivity.EXTRA_TOKEN, token)
                            startActivity(intent)
                        }
                    } else {
                        Log.e("LoginActivity", "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e("LoginActivity", "onFailure: ${t.message}")
                }
            })
        }
    }
}