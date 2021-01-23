package io.github.thang86.themovie.data.local.model.detail

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


/**
 *
 * Created by Thang86
 */
data class ProductionCountry(
    @SerializedName("iso_3166_1")
    @Expose
    var iso31661: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
)