package com.example.ordemservico.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ordemservico.model.OrdemServico
import com.example.ordemservico.ui.components.StatusChip
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdemServicoListScreen(
    ordensServico: List<OrdemServico>,
    onNovaOrdem: () -> Unit,
    onEditarOrdem: (OrdemServico) -> Unit
) {
    val currencyFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "Ordens de Serviço",
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(onClick = { /* TODO: Implementar filtros */ }) {
                        Icon(Icons.Default.FilterList, contentDescription = "Filtros")
                    }
                    IconButton(onClick = { /* TODO: Implementar busca */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Buscar")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNovaOrdem,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Nova Ordem")
            }
        }
    ) { paddingValues ->
        if (ordensServico.isEmpty()) {
            // Estado vazio
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.Assignment,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Nenhuma ordem de serviço encontrada",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Toque no botão + para criar uma nova ordem",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(ordensServico) { ordem ->
                    OrdemServicoCard(
                        ordem = ordem,
                        onEdit = { onEditarOrdem(ordem) },
                        currencyFormat = currencyFormat,
                        dateFormat = dateFormat
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdemServicoCard(
    ordem: OrdemServico,
    onEdit: () -> Unit,
    currencyFormat: NumberFormat,
    dateFormat: SimpleDateFormat
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onEdit
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "OS #${ordem.numero}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                StatusChip(status = ordem.status)
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Cliente:",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = ordem.cliente.nome.ifEmpty { "Não informado" },
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Valor Total:",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = currencyFormat.format(ordem.valorTotal),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Abertura:",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = dateFormat.format(ordem.dataAbertura),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                
                if (ordem.dataPrevista != null) {
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "Previsão:",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = dateFormat.format(ordem.dataPrevista),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
            
            if (ordem.descricaoProblema.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = ordem.descricaoProblema,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2
                )
            }
        }
    }
}