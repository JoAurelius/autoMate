package com.capstone.pathfinderapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.capstone.pathfinderapp.R
import com.capstone.pathfinderapp.api.ApiConfigModel
import com.capstone.pathfinderapp.databinding.ActivityCommentBinding
import com.capstone.pathfinderapp.model.*
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener() {
            getRating(binding.commentInput.getTextString(), binding.nimInput.getTextString(), binding.nidnInput.getTextString(), binding.lessonInput.getTextString())
        }
    }

    private fun getRating(comment: String, nim: String, nidn: String, lesson: String) {

        val requestBody = Gson().toJson(
            PredictReq(
                data(
                    listOf(
                        details(lesson, nidn, nim, comment)
                    )
                )
            )
        ).toRequestBody("application/json".toMediaType())
        Log.d("request", requestBody.toString())
        val client = ApiConfigModel.getApiService().predictSentiment(requestBody)
        client.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(
                call: Call<ResponseModel>,
                response: Response<ResponseModel>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()
                    val resultSentiment = result?.Result?.get(0)
                    binding.sentimentLabel.visibility = android.view.View.VISIBLE
                    binding.sentimentLabel.text = resultSentiment
                } else {
                    Log.d("Response", response.code().toString())
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}