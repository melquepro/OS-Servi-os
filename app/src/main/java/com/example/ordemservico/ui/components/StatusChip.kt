package com.example.ordemservico.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ordemservico.model.StatusOrdem
import com.example.ordemservico.ui.theme.*

@Composable
fun StatusChip(status: StatusOrdem) {
    val (backgroundColor, textColor, text) = when (status) {
        StatusOrdem.ABERTA -> Triple(ServiceBlue, Color.White, "Aberta")
        StatusOrdem.EM_ANDAMENTO -> Triple(ServiceOrange, Color.White, "Em Andamento")
        StatusOrdem.AGUARDANDO_PECA -> Triple(ServiceGray, Color.White, "Aguardando Peça")
        StatusOrdem.AGUARDANDO_CLIENTE -> Triple(ServiceGray, Color.White, "Aguardando Cliente")
        StatusOrdem.CONCLUIDA -> Triple(ServiceGreen, Color.White, "Concluída")
        StatusOrdem.CANCELADA -> Triple(ServiceRed, Color.White, "Cancelada")
    }
    
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
    }
}