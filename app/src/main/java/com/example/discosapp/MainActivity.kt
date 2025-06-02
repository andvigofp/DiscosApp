package com.example.discosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.discosapp.ui.DiscoViewModelFactory
import com.example.discosapp.ui.navigation.ListaDiscosApp
import com.example.discosapp.ui.state.DiscoViewModel
import com.example.discosapp.ui.theme.DiscosAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: DiscoViewModel = viewModel(
                factory = DiscoViewModelFactory(application)
            )
            DiscosAppTheme {
                ListaDiscosApp(viewModel = viewModel)
            }
        }
    }
}
