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
import com.example.ordemservico.model.Cliente

@Composable
fun ClienteSection(
    cliente: Cliente,
    onClienteChange: (Cliente) -> Unit
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
                    text = "Dados do Cliente",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                IconButton(
                    onClick = { /* TODO: Implementar busca de cliente */ }
                ) {
                    Icon(Icons.Default.Search, contentDescription = "Buscar cliente")
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedTextField(
                value = cliente.nome,
                onValueChange = { onClienteChange(cliente.copy(nome = it)) },
                label = { Text("Nome do Cliente") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = cliente.telefone,
                    onValueChange = { onClienteChange(cliente.copy(telefone = it)) },
                    label = { Text("Telefone") },
                    leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                    modifier = Modifier.weight(1f),
                    keyboardType = KeyboardType.Phone
                )
                
                OutlinedTextField(
                    value = cliente.cpfCnpj,
                    onValueChange = { onClienteChange(cliente.copy(cpfCnpj = it)) },
                    label = { Text("CPF/CNPJ") },
                    leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null) },
                    modifier = Modifier.weight(1f),
                    keyboardType = KeyboardType.Number
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = cliente.email,
                onValueChange = { onClienteChange(cliente.copy(email = it)) },
                label = { Text("E-mail") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Email
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = cliente.endereco,
                onValueChange = { onClienteChange(cliente.copy(endereco = it)) },
                label = { Text("Endereço") },
                leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                minLines = 2
            )
        }
    }
}