package com.example.ordemservico.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.text.NumberFormat
import java.util.*

@Composable
fun ValoresSection(
    valorServico: Double,
    valorPecas: Double,
    onValorServicoChange: (Double) -> Unit,
    onValorPecasChange: (Double) -> Unit
) {
    val valorTotal = valorServico + valorPecas
    val currencyFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Valores",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = if (valorServico > 0) valorServico.toString() else "",
                    onValueChange = { 
                        val valor = it.toDoubleOrNull() ?: 0.0
                        onValorServicoChange(valor)
                    },
                    label = { Text("Valor do Serviço") },
                    leadingIcon = { Icon(Icons.Default.AttachMoney, contentDescription = null) },
                    modifier = Modifier.weight(1f),
                    keyboardType = KeyboardType.Decimal,
                    prefix = { Text("R$ ") }
                )
                
                OutlinedTextField(
                    value = if (valorPecas > 0) valorPecas.toString() else "",
                    onValueChange = { 
                        val valor = it.toDoubleOrNull() ?: 0.0
                        onValorPecasChange(valor)
                    },
                    label = { Text("Valor das Peças") },
                    leadingIcon = { Icon(Icons.Default.AttachMoney, contentDescription = null) },
                    modifier = Modifier.weight(1f),
                    keyboardType = KeyboardType.Decimal,
                    prefix = { Text("R$ ") }
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Valor Total:",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = currencyFormat.format(valorTotal),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}