package com.example.ordemservico.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ordemservico.model.Prioridade
import com.example.ordemservico.ui.theme.*

@Composable
fun PrioridadeSelector(
    prioridade: Prioridade,
    onPrioridadeChange: (Prioridade) -> Unit
) {
    Column {
        Text(
            text = "Prioridade",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Prioridade.values().forEach { prioridadeOption ->
                val isSelected = prioridade == prioridadeOption
                val (backgroundColor, textColor, text) = when (prioridadeOption) {
                    Prioridade.BAIXA -> Triple(ServiceGray, Color.White, "Baixa")
                    Prioridade.MEDIA -> Triple(ServiceBlue, Color.White, "Média")
                    Prioridade.ALTA -> Triple(ServiceOrange, Color.White, "Alta")
                    Prioridade.URGENTE -> Triple(ServiceRed, Color.White, "Urgente")
                }
                
                FilterChip(
                    onClick = { onPrioridadeChange(prioridadeOption) },
                    label = { Text(text) },
                    selected = isSelected,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = backgroundColor,
                        selectedLabelColor = textColor
                    ),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}