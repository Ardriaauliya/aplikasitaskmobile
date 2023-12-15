package com.d121211001.aplikasitask.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.d121211001.aplikasitask.ui.theme.AplikasiTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiTaskTheme {
                // Aplikasi Compose di sini
                QuoteApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun QuoteApp(viewModel: QuoteViewModel) {
    val quotes = viewModel.quotes.collectAsState()

    MaterialTheme {
        // Tambahkan tampilan daftar dan detail di sini
        // QuoteList(quotes.value)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQuoteApp() {
    AplikasiTaskTheme {
        // QuoteApp preview di sini
    }
}
