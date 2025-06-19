package com.example.ejemplo1composeidgs901

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Lista de personajes
private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable..."),
    PersonajeTarjeta("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters..."),
    PersonajeTarjeta("Piccolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre..."),
    PersonajeTarjeta("Bulma", "Bulma es la protagonista femenina de la serie manga Dragon Ball..."),
    PersonajeTarjeta("Freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("Zarbon", "Zarbon es uno de los secuaces de Freezer y un luchador poderoso."),
    PersonajeTarjeta("Dodoria", "Dodoria es otro secuaz de Freezer conocido por su brutalidad."),
    PersonajeTarjeta("Gohan", "Son Gohan es uno de los personajes principales de Dragon Ball Z, Super y GT."),
    PersonajeTarjeta("Krilin", "Amigo cercano de Goku y guerrero valiente..."),
    PersonajeTarjeta("Tenshinhan", "Maestro de las artes marciales y miembro de los Z Fighters.")
)

data class PersonajeTarjeta(val title: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1ComposeIDGS901Theme {
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
            modifier = Modifier
                .size(100.dp)
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
fun Tarjeta(personajes: List<PersonajeTarjeta>) {
    LazyColumn {
        items(personajes) { personaje ->
            MyPersonaje(personaje)
        }
    }
}

@Composable
fun MyPersonaje(personaje: PersonajeTarjeta) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row {
            ImagenPersonaje(personaje.title.lowercase())
            PersonajeDetalle(personaje)
        }
    }
}

@Composable
fun PersonajeTexto(name: String, color: Color, style: androidx.compose.ui.text.TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(
        text = name,
        style = style,
        color = color,
        maxLines = lines
    )
}

@Composable
fun PersonajeDetalle(personaje: PersonajeTarjeta) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(start = 8.dp)
            .clickable { expanded = !expanded }
    ) {
        PersonajeTexto(
            personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium
        )
        PersonajeTexto(
            personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun ImagenPersonaje(name: String){
    val context = LocalContext.current
    val ImageResId = remember(name) {
        context.resources.getIdentifier(name.lowercase(),
            "drawable", context.packageName)
    }
    Image(
        painter = painterResource(id = ImageResId),
        contentDescription = null,
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}


@Preview
@Composable
fun PreviewSaludoCard() {
    Ejemplo1ComposeIDGS901Theme {
        SaludoCard(name = "Jaqueline", datosCard = "Personaje")
    }
}