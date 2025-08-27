# Aplicativo Android - Ordem de Serviço

Um aplicativo Android moderno e completo para gerenciamento de ordens de serviço, desenvolvido com Jetpack Compose e Material Design 3.

## 📱 Funcionalidades

### ✅ Implementadas
- **Tela Principal de Ordem de Serviço**: Interface completa para criação e edição de ordens de serviço
- **Lista de Ordens**: Visualização de todas as ordens de serviço cadastradas
- **Dados do Cliente**: Formulário completo com nome, telefone, email, CPF/CNPJ e endereço
- **Informações do Serviço**: Cadastro de tipo de serviço, categoria e valores
- **Status da Ordem**: Sistema de status com chips coloridos (Aberta, Em Andamento, Concluída, etc.)
- **Sistema de Prioridades**: Classificação por prioridade (Baixa, Média, Alta, Urgente)
- **Cálculo de Valores**: Cálculo automático do valor total (serviço + peças)
- **Interface Moderna**: Design seguindo Material Design 3 com tema claro/escuro

### 🎨 Design e UX
- **Material Design 3**: Interface moderna e consistente
- **Componentes Reutilizáveis**: Arquitetura modular com componentes bem organizados
- **Navegação Intuitiva**: Fluxo de navegação simples e eficiente
- **Responsividade**: Layout adaptável para diferentes tamanhos de tela
- **Feedback Visual**: Estados visuais claros para diferentes situações

## 🏗️ Arquitetura

### Estrutura do Projeto
```
app/
├── src/main/java/com/example/ordemservico/
│   ├── MainActivity.kt                 # Atividade principal
│   ├── model/                         # Modelos de dados
│   │   └── OrdemServico.kt           # Classes de dados
│   └── ui/
│       ├── components/               # Componentes reutilizáveis
│       │   ├── StatusChip.kt        # Chip de status
│       │   ├── ClienteSection.kt    # Seção do cliente
│       │   ├── ServicoSection.kt    # Seção do serviço
│       │   ├── PrioridadeSelector.kt # Seletor de prioridade
│       │   └── ValoresSection.kt    # Seção de valores
│       ├── screens/                 # Telas da aplicação
│       │   ├── OrdemServicoScreen.kt      # Tela principal
│       │   └── OrdemServicoListScreen.kt  # Lista de ordens
│       └── theme/                   # Tema da aplicação
│           ├── Color.kt
│           ├── Theme.kt
│           └── Type.kt
```

### Tecnologias Utilizadas
- **Kotlin**: Linguagem principal
- **Jetpack Compose**: Framework de UI moderna
- **Material Design 3**: Sistema de design
- **Navigation Compose**: Navegação entre telas
- **ViewModel**: Gerenciamento de estado
- **Parcelize**: Serialização de objetos

## 🚀 Como Executar

### Pré-requisitos
- Android Studio Arctic Fox ou superior
- JDK 8 ou superior
- Android SDK API 24 ou superior

### Passos para Execução
1. Clone o repositório
2. Abra o projeto no Android Studio
3. Sincronize o projeto com os arquivos Gradle
4. Execute o aplicativo em um dispositivo ou emulador Android

### Configuração do Ambiente
```bash
# Instalar dependências (executado automaticamente pelo Gradle)
./gradlew build

# Executar testes
./gradlew test

# Gerar APK
./gradlew assembleDebug
```

## 📊 Modelos de Dados

### OrdemServico
- **id**: Identificador único
- **numero**: Número da ordem de serviço
- **cliente**: Dados do cliente
- **servico**: Informações do serviço
- **descricaoProblema**: Descrição do problema
- **observacoes**: Observações adicionais
- **dataAbertura**: Data de abertura
- **dataPrevista**: Data prevista para conclusão
- **status**: Status atual da ordem
- **prioridade**: Nível de prioridade
- **valores**: Valores do serviço e peças

### Status Disponíveis
- 🔵 **Aberta**: Ordem recém-criada
- 🟠 **Em Andamento**: Serviço sendo executado
- ⚪ **Aguardando Peça**: Aguardando chegada de peças
- ⚪ **Aguardando Cliente**: Aguardando retorno do cliente
- 🟢 **Concluída**: Serviço finalizado
- 🔴 **Cancelada**: Ordem cancelada

### Níveis de Prioridade
- 🔘 **Baixa**: Sem urgência
- 🔵 **Média**: Prioridade normal
- 🟠 **Alta**: Requer atenção
- 🔴 **Urgente**: Máxima prioridade

## 🎯 Próximas Funcionalidades

### Planejadas para Implementação
- **Banco de Dados Local**: Persistência com Room Database
- **Busca e Filtros**: Sistema de busca e filtros avançados
- **Relatórios**: Geração de relatórios em PDF
- **Notificações**: Lembretes e alertas
- **Backup na Nuvem**: Sincronização com Google Drive
- **Assinatura Digital**: Captura de assinatura do cliente
- **Fotos**: Anexar fotos do equipamento/problema
- **Histórico**: Log de alterações na ordem
- **Multi-usuário**: Sistema de login e permissões

### Melhorias Técnicas
- **Testes Unitários**: Cobertura completa de testes
- **Testes de UI**: Testes automatizados da interface
- **CI/CD**: Pipeline de integração contínua
- **Otimização**: Melhorias de performance
- **Acessibilidade**: Suporte completo para acessibilidade

## 📱 Screenshots

O aplicativo possui uma interface moderna e intuitiva:

- **Tela Principal**: Formulário completo para criação de ordens de serviço
- **Lista de Ordens**: Visualização em cards com informações resumidas
- **Design Responsivo**: Adaptável a diferentes tamanhos de tela
- **Tema Claro/Escuro**: Suporte automático baseado nas configurações do sistema

## 🤝 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 📞 Suporte

Para suporte ou dúvidas, entre em contato através dos issues do GitHub.

---

**Desenvolvido com ❤️ usando Android e Jetpack Compose**