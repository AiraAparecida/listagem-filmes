package airaaparecida.listagemdefilmes

import airaaparecida.listagemdefilmes.network.TmbdApi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import airaaparecida.listagemdefilmes.ui.theme.ListagemDeFilmesTheme
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaunchedEffect(Unit) {
               launch(Dispatchers.IO) {
                   val retrofit = Retrofit.Builder()
                       .baseUrl("https://api.themoviedb.org/3/")
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();

                   val service = retrofit.create(TmbdApi::class.java);
                   val response = service.getPopularMovies(
                       page = 1,
                       authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YTEyYzBjNDgzYTExOGZhNWVjMzVlZWFmNzE5MWRmMiIsIm5iZiI6MTc1MTI4NjQxMy4zMzUsInN1YiI6IjY4NjI4MjhkYzBiNzlkOWUxNzRkMjQxNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3VgWAyND_nQg27IKIoC3V_VK7Ob6NMnAv65AA7mVxHk",
                       accept = "application/json"
                   )
               }
            }

            ListagemDeFilmesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListagemDeFilmesTheme {
        Greeting("Android")
    }
}
