package com.example.ordemservico.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ordemservico.model.*
import com.example.ordemservico.ui.components.*
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdemServicoScreen(
    ordemServico: OrdemServico = OrdemServico(),
    onSave: (OrdemServico) -> Unit = {},
    onCancel: () -> Unit = {}
) {
    var ordem by remember { mutableStateOf(ordemServico) }
    var showDatePicker by remember { mutableStateOf(false) }
    var datePickerType by remember { mutableStateOf("abertura") }
    
    val scrollState = rememberScrollState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // Header
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
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
                        text = "Ordem de Serviço",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    StatusChip(status = ordem.status)
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                OutlinedTextField(
                    value = ordem.numero,
                    onValueChange = { ordem = ordem.copy(numero = it) },
                    label = { Text("Número da OS") },
                    leadingIcon = { Icon(Icons.Default.Numbers, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Cliente Section
        ClienteSection(
            cliente = ordem.cliente,
            onClienteChange = { ordem = ordem.copy(cliente = it) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Serviço Section
        ServicoSection(
            servico = ordem.servico,
            onServicoChange = { ordem = ordem.copy(servico = it) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Descrição do Problema
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Descrição do Problema",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                OutlinedTextField(
                    value = ordem.descricaoProblema,
                    onValueChange = { ordem = ordem.copy(descricaoProblema = it) },
                    label = { Text("Descreva o problema relatado") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3,
                    maxLines = 5
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                OutlinedTextField(
                    value = ordem.observacoes,
                    onValueChange = { ordem = ordem.copy(observacoes = it) },
                    label = { Text("Observações adicionais") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 2,
                    maxLines = 4
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Datas e Prioridade
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Datas e Prioridade",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(ordem.dataAbertura),
                        onValueChange = { },
                        label = { Text("Data Abertura") },
                        readOnly = true,
                        leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                        modifier = Modifier.weight(1f)
                    )
                    
                    OutlinedTextField(
                        value = ordem.dataPrevista?.let { 
                            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(it) 
                        } ?: "",
                        onValueChange = { },
                        label = { Text("Data Prevista") },
                        readOnly = true,
                        leadingIcon = { Icon(Icons.Default.Schedule, contentDescription = null) },
                        modifier = Modifier.weight(1f),
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    datePickerType = "prevista"
                                    showDatePicker = true
                                }
                            ) {
                                Icon(Icons.Default.Edit, contentDescription = "Editar data")
                            }
                        }
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                PrioridadeSelector(
                    prioridade = ordem.prioridade,
                    onPrioridadeChange = { ordem = ordem.copy(prioridade = it) }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Valores
        ValoresSection(
            valorServico = ordem.valorServico,
            valorPecas = ordem.valorPecas,
            onValorServicoChange = { ordem = ordem.copy(valorServico = it) },
            onValorPecasChange = { ordem = ordem.copy(valorPecas = it) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Técnico Responsável
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                OutlinedTextField(
                    value = ordem.tecnicoResponsavel,
                    onValueChange = { ordem = ordem.copy(tecnicoResponsavel = it) },
                    label = { Text("Técnico Responsável") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Default.Cancel, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Cancelar")
            }
            
            Button(
                onClick = { onSave(ordem) },
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Salvar")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
    }
}