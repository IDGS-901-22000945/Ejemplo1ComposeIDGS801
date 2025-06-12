package com.example.ejemplo1composeidgs901

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku","El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla. Sin embargo, el caer por un barranco le proporcionó un brutal golpe que si bien casi lo mata, este alteró su memoria y anuló todos los instintos violentos de su especie, lo que lo hizo crecer con un corazón puro y bondadoso, pero conservando todos los poderes de su raza."),
    PersonajeTarjeta("Vegeta","ríncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z."),
    PersonajeTarjeta("Piccolo","s un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación."),
    PersonajeTarjeta("Bulma","Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es hija del Dr. Brief y su esposa Panchy, hermana menor de Tights y una gran amiga de Son Goku con quien inicia la búsqueda de las Esferas del Dragón."),
    PersonajeTarjeta("Freezer","Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("zarbon","Zarbon es uno de los secuaces de Freezer y un luchador poderoso."),
    PersonajeTarjeta("dodoria","Dodoria es otro secuaz de Freezer conocido por su brutalidad."),
    PersonajeTarjeta("gohan","on Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("krilin","Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball. Es uno de los principales discípulos de Kame-Sen'nin, Guerrero Z, y el mejor amigo de Son Goku."),
    PersonajeTarjeta("tenshinhan","Maestro de las artes marciales y miembro de los Z Fighters.  Es un personaje que aparece en el manga y en el anime de Dragon Ball, Dragon Ball Z, Dragon Ball GT y posteriormente en Dragon Ball Super.")
)

data class PersonajeTarjeta(val title: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1ComposeIDGS901Theme {
                SaludoCard(name = "Android", datosCard = "Personaje")
                Tarjeta(tarjetas)
            }
        }
    }
}

@Composable
fun SaludoCard(name: String, datosCard: String) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.logo_dragonballapi),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
                .clip(CircleShape)
        )
        Column {
            Text(
                text = "Nombre: $name",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = "Datos Card: $datosCard")
        }
    }
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta){
    LazyColumn {
        items(personajes){personaje ->
            MyPersonaje(personaje)
        }
    }
}

@Composable
fun MyPersonaje(personaje: PersonajeTarjeta){
   Row {
       ImagenPersonaje(personaje.title.lowercase())
       Personajes(personaje)
   }

}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Personajes(personaje.title)
        Personajes(personaje.body)

    }
    @Composable
    fun Personaje(datos: String){
        Text(datos)

    }
}



@Composable
fun ImagenPersonaje(name: String){
    Row {
        Image(
            painter = painterResource(id = R.drawable.logo_dragonballapi),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
                .clip(CircleShape)
                .size(100.dp)
                .background(MaterialTheme)
        )
    }
}

@Preview
@Composable
fun PreviewSaludoCard() {
    Ejemplo1ComposeIDGS901Theme {
        SaludoCard(name = "Jaqueline", datosCard = "Personaje")
    }
}