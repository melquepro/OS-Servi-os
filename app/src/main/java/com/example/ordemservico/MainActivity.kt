package com.example.ordemservico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ordemservico.model.OrdemServico
import com.example.ordemservico.ui.screens.OrdemServicoListScreen
import com.example.ordemservico.ui.screens.OrdemServicoScreen
import com.example.ordemservico.ui.theme.OrdemServicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrdemServicoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OrdemServicoApp()
                }
            }
        }
    }
}

@Composable
fun OrdemServicoApp() {
    val navController = rememberNavController()
    var ordensServico by remember { mutableStateOf(listOf<OrdemServico>()) }
    
    NavHost(
        navController = navController,
        startDestination = "lista"
    ) {
        composable("lista") {
            OrdemServicoListScreen(
                ordensServico = ordensServico,
                onNovaOrdem = {
                    navController.navigate("nova")
                },
                onEditarOrdem = { ordem ->
                    // TODO: Implementar navegação para edição
                    navController.navigate("nova")
                }
            )
        }
        
        composable("nova") {
            OrdemServicoScreen(
                onSave = { novaOrdem ->
                    ordensServico = ordensServico + novaOrdem.copy(
                        id = (ordensServico.maxOfOrNull { it.id } ?: 0) + 1
                    )
                    navController.popBackStack()
                },
                onCancel = {
                    navController.popBackStack()
                }
            )
        }
    }
}