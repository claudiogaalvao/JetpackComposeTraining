package com.cgcreativesolutions.jetpackcomposetraining.model

data class ProposalModel(
    val id: String,
    val title: String,
    val type: ProposalType,
    val description: String
)

val mockProposals = listOf(
    ProposalModel(
        id = "1",
        title = "Requerimento de Sessão Extraordinária",
        type = ProposalType.REQ,
        description = "Solicita sessão extraordinária para discussão de pauta urgente."
    ),
    ProposalModel(
        id = "2",
        title = "Projeto de Lei da Mobilidade Urbana",
        type = ProposalType.PL,
        description = "Institui diretrizes para incentivo ao transporte coletivo sustentável."
    ),
    ProposalModel(
        id = "3",
        title = "Requerimento de Audiência Pública",
        type = ProposalType.REQ,
        description = "Convoca especialistas para debater a situação da educação básica."
    ),
    ProposalModel(
        id = "4",
        title = "Projeto de Lei de Incentivo à Cultura",
        type = ProposalType.PL,
        description = "Dispõe sobre benefícios fiscais para produtores culturais."
    ),
    ProposalModel(
        id = "5",
        title = "Requerimento de Informação",
        type = ProposalType.REQ,
        description = "Solicita dados atualizados sobre investimentos em saúde pública."
    ),
    ProposalModel(
        id = "6",
        title = "Projeto de Lei do Meio Ambiente",
        type = ProposalType.PL,
        description = "Estabelece metas para redução de emissão de carbono até 2030."
    ),
    ProposalModel(
        id = "7",
        title = "Requerimento de Homenagem",
        type = ProposalType.REQ,
        description = "Propõe moção de aplauso a profissionais de saúde."
    ),
    ProposalModel(
        id = "8",
        title = "Projeto de Lei de Proteção de Dados",
        type = ProposalType.PL,
        description = "Cria regras complementares à LGPD para dados sensíveis no setor público."
    ),
    ProposalModel(
        id = "9",
        title = "Requerimento de Visita Técnica",
        type = ProposalType.REQ,
        description = "Solicita visita técnica às obras de infraestrutura da cidade."
    ),
    ProposalModel(
        id = "10",
        title = "Projeto de Lei de Inclusão Digital",
        type = ProposalType.PL,
        description = "Dispõe sobre a criação de centros de acesso gratuito à internet em áreas carentes."
    )
)
