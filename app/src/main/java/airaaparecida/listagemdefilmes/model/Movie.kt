package airaaparecida.listagemdefilmes.model

data class Movie(
        val id: Int,
        val title: String, 
        val imageUrl: String 
)

data class MovieResponse(
        val results: List<Movie>
)