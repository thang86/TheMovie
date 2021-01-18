package io.github.thang86.themovie.data.local.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




/**
 *
 * Created by Thang86
 */
data class NowMovie (
    @SerializedName("dates")
    @Expose
    var dates: Dates? = null,

    @SerializedName("page")
    @Expose
    var page: Int? = null,

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null,

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null,

    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
)