package com.example.harryportter_01version.data

import com.google.gson.annotations.SerializedName

//datdata class BooksList(
//    val results : List <BookItem>?,
//) {
//
//    data class BookItem(
//        val title: String?,
//        val author: String?,
//        val releaseDate: String?,
//        val summary: String? = "",
//        val coverUrl: String?
//    )
//}a





data class BookAttributes(
    val title: String?,
    val author: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val summary: String? = "",
    @SerializedName("cover")
    val coverUrl: String?
)

data class BookData(
    val id: String?,
    val attributes: BookAttributes?
)

data class BookDataWrapper(
    val data: BookData?
)

data class BooksList(
    val data: List<BookData>
)