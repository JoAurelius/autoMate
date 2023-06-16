package com.capstone.pathfinderapp.model

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: RegUser? = null
)

data class JsonMember0(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

data class Metadata(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("lastLoginAt")
	val lastLoginAt: String? = null
)

data class StsTokenManager(

	@field:SerializedName("expirationTime")
	val expirationTime: Long? = null,

	@field:SerializedName("accessToken")
	val accessToken: String? = null,

	@field:SerializedName("refreshToken")
	val refreshToken: String? = null
)

data class ProviderDataItem(

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("photoURL")
	val photoURL: Any? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: Any? = null,

	@field:SerializedName("providerId")
	val providerId: String? = null,

	@field:SerializedName("displayName")
	val displayName: Any? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class ProactiveRefresh(

	@field:SerializedName("isRunning")
	val isRunning: Boolean? = null,

	@field:SerializedName("errorBackoff")
	val errorBackoff: Int? = null,

	@field:SerializedName("user")
	val user: RegUser? = null,

	@field:SerializedName("timerId")
	val timerId: Any? = null
)

data class ReloadUserInfo(

	@field:SerializedName("emailVerified")
	val emailVerified: Boolean? = null,

	@field:SerializedName("passwordUpdatedAt")
	val passwordUpdatedAt: Long? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("validSince")
	val validSince: String? = null,

	@field:SerializedName("lastLoginAt")
	val lastLoginAt: String? = null,

	@field:SerializedName("providerUserInfo")
	val providerUserInfo: List<ProviderUserInfoItem?>? = null,

	@field:SerializedName("customAuth")
	val customAuth: Boolean? = null,

	@field:SerializedName("localId")
	val localId: String? = null,

	@field:SerializedName("lastRefreshAt")
	val lastRefreshAt: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("passwordHash")
	val passwordHash: String? = null
)

data class Auth(

	@field:SerializedName("currentUser")
	val currentUser: CurrentUser? = null,

	@field:SerializedName("apiKey")
	val apiKey: String? = null,

	@field:SerializedName("appName")
	val appName: String? = null,

	@field:SerializedName("authDomain")
	val authDomain: String? = null
)

data class RegUser(

	@field:SerializedName("reloadUserInfo")
	val reloadUserInfo: ReloadUserInfo? = null,

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("auth")
	val auth: Auth? = null,

	@field:SerializedName("providerData")
	val providerData: List<ProviderDataItem?>? = null,

	@field:SerializedName("displayName")
	val displayName: Any? = null,

	@field:SerializedName("accessToken")
	val accessToken: String? = null,

	@field:SerializedName("0")
	val jsonMember0: JsonMember0? = null,

	@field:SerializedName("1")
	val jsonMember1: Boolean? = null,

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("emailVerified")
	val emailVerified: Boolean? = null,

	@field:SerializedName("photoURL")
	val photoURL: Any? = null,

	@field:SerializedName("stsTokenManager")
	val stsTokenManager: StsTokenManager? = null,

	@field:SerializedName("isAnonymous")
	val isAnonymous: Boolean? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: Any? = null,

	@field:SerializedName("providerId")
	val providerId: String? = null,

	@field:SerializedName("tenantId")
	val tenantId: Any? = null,

	@field:SerializedName("reloadListener")
	val reloadListener: Any? = null,

	@field:SerializedName("proactiveRefresh")
	val proactiveRefresh: ProactiveRefresh? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("lastLoginAt")
	val lastLoginAt: String? = null,

	@field:SerializedName("apiKey")
	val apiKey: String? = null,

	@field:SerializedName("appName")
	val appName: String? = null
)

data class CurrentUser(

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("emailVerified")
	val emailVerified: Boolean? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("isAnonymous")
	val isAnonymous: Boolean? = null,

	@field:SerializedName("stsTokenManager")
	val stsTokenManager: StsTokenManager? = null,

	@field:SerializedName("lastLoginAt")
	val lastLoginAt: String? = null,

	@field:SerializedName("apiKey")
	val apiKey: String? = null,

	@field:SerializedName("providerData")
	val providerData: List<ProviderDataItem?>? = null,

	@field:SerializedName("appName")
	val appName: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class ProviderUserInfoItem(

	@field:SerializedName("providerId")
	val providerId: String? = null,

	@field:SerializedName("federatedId")
	val federatedId: String? = null,

	@field:SerializedName("rawId")
	val rawId: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
