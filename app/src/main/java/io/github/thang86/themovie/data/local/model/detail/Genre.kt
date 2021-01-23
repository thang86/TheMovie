package io.github.thang86.themovie.data.local.model.detail

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


/**
 *
 * Created by Thang86
 */
data class Genre(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
)