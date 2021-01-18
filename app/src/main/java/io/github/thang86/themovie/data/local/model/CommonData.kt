package io.github.thang86.themovie.data.local.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *
 * Created by Thang86
 */
class CommonData<T: Any> {
    @SerializedName("data")
    @Expose
    var data: T? = null
    @SerializedName("status_code")
    @Expose
    var code: Int = 0
    @SerializedName("message")
    @Expose
    lateinit var message: String
}
