package com.example.harryportter_01version.data

class BookRepository {
    val api = RetrofitInstance.getHarryPotter01versionApi()
    suspend fun getBooksList():List<BookData>? {
        return try {
            val response = api.getBooksList()
            if (response.isSuccessful) {
                response.body()?.data?.map { bookData ->
                    BookData(
                        id = bookData.id,
                        attributes = BookAttributes(
                            title = bookData.attributes?.title,
                            author = bookData.attributes?.author,
                            releaseDate = bookData.attributes?.releaseDate,
                            summary = bookData.attributes?.summary,
                            coverUrl = bookData.attributes?.coverUrl
                        )
                    )
                }
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }



    }
}
