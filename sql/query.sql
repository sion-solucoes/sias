SELECT 
(SELECT COUNT(DISTINCT(familia_id)) FROM familia WHERE familia_unidade_atendimento_id = 1 ) total_familias,
(SELECT COUNT(DISTINCT(familia_membro_id)) FROM familia_membro LEFT JOIN familia ON familia_membro_familia_id = familia_id WHERE familia_unidade_atendimento_id = 1 ) total_individuos,
(SELECT COUNT(DISTINCT(familia_id)) FROM familia WHERE familia_unidade_atendimento_id = 1 AND familia_data_inclusao > '01/11/2016' AND familia_data_inclusao < '30/11/2016' ) novas_familias,
(SELECT COUNT(DISTINCT(familia_membro_id)) FROM familia_membro LEFT JOIN familia ON familia_membro_familia_id = familia_id WHERE familia_unidade_atendimento_id = 1 AND familia_membro_data_inclusao > '01/11/2016' AND familia_membro_data_inclusao < '30/11/2016' ) novos_individuos,
0::bigint familia_bolsa_familia,
0::bigint familia_bpc,
(SELECT COUNT(DISTINCT(familia_id)) FROM familia LEFT JOIN familia_membro ON familia_id = familia_membro_familia_id WHERE familia_unidade_atendimento_id = 1 AND familia_data_inclusao > '01/11/2016' AND familia_data_inclusao < '30/11/2016' AND familia_membro_trabalho_infantil IS TRUE)  familia_trabalho_infantil,
0::bigint familia_servico_acolhimento,
0::bigint familia_violencia_uso_substancia_psicoativas,

