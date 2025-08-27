package com.example.ordemservico.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.ordemservico.model.Servico

@Composable
fun ServicoSection(
    servico: Servico,
    onServicoChange: (Servico) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Tipo de Serviço",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                IconButton(
                    onClick = { /* TODO: Implementar seleção de serviço */ }
                ) {
                    Icon(Icons.Default.List, contentDescription = "Selecionar serviço")
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedTextField(
                value = servico.nome,
                onValueChange = { onServicoChange(servico.copy(nome = it)) },
                label = { Text("Nome do Serviço") },
                leadingIcon = { Icon(Icons.Default.Build, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = servico.categoria,
                    onValueChange = { onServicoChange(servico.copy(categoria = it)) },
                    label = { Text("Categoria") },
                    leadingIcon = { Icon(Icons.Default.Category, contentDescription = null) },
                    modifier = Modifier.weight(1f)
                )
                
                OutlinedTextField(
                    value = if (servico.valorPadrao > 0) servico.valorPadrao.toString() else "",
                    onValueChange = { 
                        val valor = it.toDoubleOrNull() ?: 0.0
                        onServicoChange(servico.copy(valorPadrao = valor))
                    },
                    label = { Text("Valor Padrão") },
                    leadingIcon = { Icon(Icons.Default.AttachMoney, contentDescription = null) },
                    modifier = Modifier.weight(1f),
                    keyboardType = KeyboardType.Decimal
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = servico.descricao,
                onValueChange = { onServicoChange(servico.copy(descricao = it)) },
                label = { Text("Descrição do Serviço") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 2,
                maxLines = 3
            )
        }
    }
}