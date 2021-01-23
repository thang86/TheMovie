package io.github.thang86.themovie.data.local.model.detail

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


/**
 *
 * Created by Thang86
 */
class SpokenLanguage(
    @SerializedName("english_name")
    @Expose
    var englishName: String? = null,

    @SerializedName("iso_639_1")
    @Expose
    var iso6391: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
)