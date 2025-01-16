package com.example.formulariocontacto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formulariocontacto.ui.theme.FormularioContactoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormularioContactoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormularioContacto(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormularioContacto(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Formulario de Contacto",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(text = "Nombre:")
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Ingresa tu nombre") }
        )

        Text(text = "Teléfono:")
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Ingresa tu teléfono") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            )
        )


        Text(text = "Mensaje:")
        OutlinedTextField(
            value = mensaje,
            onValueChange = { mensaje = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            placeholder = { Text("Escribe tu mensaje aquí") },
            maxLines = 5
        )

        Button(onClick = {/*TODO*/ } ) {
            Text(text = "Subir")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioContactoPreview() {
    FormularioContactoTheme {
        FormularioContacto()
    }
}
