package com.capstone.pathfinderapp.model

import com.google.gson.annotations.SerializedName

data class LessonResponse(

	@field:SerializedName("data")
	val data: DataLesson? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataLesson(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
