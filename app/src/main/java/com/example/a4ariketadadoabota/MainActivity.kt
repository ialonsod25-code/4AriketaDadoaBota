package com.example.a4ariketadadoabota

import android.R.attr.start
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a4ariketadadoabota.ui.theme._4AriketaDadoaBotaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4AriketaDadoaBotaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DadoaBota(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun DadoaBota(modifier: Modifier = Modifier) {
    var emaitza by remember { mutableStateOf(1) }

    val irudia = when (emaitza) {
        1 -> R.drawable.dadoa_1
        2 -> R.drawable.dadoa_2
        3 -> R.drawable.dadoa_3
        4 -> R.drawable.dadoa_4
        5 -> R.drawable.dadoa_5
        else -> R.drawable.dadoa_6
    }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.casino),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Egin klik dadoa botatzeko",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 80.dp, top = 150.dp)
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 220.dp)
                .size(200.dp)
                .background(Color.DarkGray.copy(0.5f), RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = irudia),
                contentDescription = "Dadoa: $emaitza",
                modifier = Modifier.size(150.dp)
            )
        }
        Text(
            text = "Zenbakia: $emaitza",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 80.dp, top = 450.dp)
        )
        Button(
            onClick = { emaitza = (1..6).random() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 500.dp)
        ) {
            Text("Dadoak bota")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DadoaBotaPreview() {
    _4AriketaDadoaBotaTheme {
       DadoaBota()
    }
}