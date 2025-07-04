package airaaparecida.listagemdefilmes.network

import airaaparecida.listagemdefilmes.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TmbdApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Header("Authorization") authorization: String,
        @Header("accept") accept: String = "application/json"
    ): MovieResponse
}

