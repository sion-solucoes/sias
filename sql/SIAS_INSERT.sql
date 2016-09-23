INSERT INTO pais ( pais_sigla, pais_descricao, pais_codigo_bacen ) VALUES ( 'BRA', 'BRASIL', 1058 );
INSERT INTO uf ( uf_sigla, uf_descricao, uf_codigo_ibge, uf_pais_id ) VALUES ( 'MG', 'MINAS GERAIS', 31, 1 );
INSERT INTO municipio ( municipio_descricao, municipio_codigo_ibge, municipio_uf_id ) VALUES ( 'SANTA RITA DO SAPUCAÍ', 3159605, 1 );
INSERT INTO cep ( cep_codigo, cep_logradouro, cep_bairro, cep_municipio_id ) VALUES ( '37540-000', 'ALAMEDA JOSÉ CLETO DUARTE', 'CENTRO', 1 );

INSERT INTO unidade_atendimento 
(
unidade_atendimento_codigo, 
unidade_atendimento_descricao, 
unidade_atendimento_tipo, 
unidade_atendimento_cep_endereco_id, 
unidade_atendimento_logradouro_endereco, 
unidade_atendimento_numero_endereco, 
unidade_atendimento_bairro_endereco
) 
VALUES 
(
1, 
'CREAS - SANTA RITA DO SAPUCAÍ', 
2, 
1,
'ALAMEDA JOSÉ CLETO DUARTE',
'10', 
'CENTRO'
 );
 
INSERT INTO usuario ( usuario_unidade_atendimento_id, usuario_tipo, usuario_email, usuario_senha, usuario_nome, usuario_sobrenome ) VALUES ( 1, 1, 'sias@sias.com', MD5('sias@sias.com'), 'MASTER', 'MASTER' );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );
INSERT INTO usuario_seguranca ( usuario_seguranca_codigo, usuario_seguranca_usuario_id ) VALUES ( 'XXXXX', 1 );

 
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Por demanda espontânea' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Em decorrência de busca ativa realizada pela equipe da unidade' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Em decorrência de encaminhamento realizado por outros serviços/unidades da Proteção Social Básica' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Em decorrência de encaminhamento realizado por outros serviços/unidades da Proteção Social Especial' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Em decorrência de encaminhamento realizado pela área de Saúde' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Em decorrência de encaminhamento realizado pela área de Educação' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Em decorrência de encaminhamento realizado outras políticas setoriais' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Em decorrência de encaminhamento realizado pelo Conselho Tutelar' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Em decorrência de encaminhamento realizado pelo Poder Judiciário' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Em decorrência de encaminhamento realizado pelo Sistema de Garantia de Direitos (Defensoria Pública, Ministério Público, Delegacias)' );
INSERT INTO forma_ingresso ( forma_ingresso_descricao ) VALUES ( 'Outros encaminhamentos' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 1, 'Pessoa de Referência' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 2, 'Cônjuge/companheiro(a)' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 3, 'Filho(a)' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 4, 'Enteado(a)' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 5, 'Neto(a)/Bisneto(a)' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 6, 'Pai/Mãe' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 7, 'Sogro(a)' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 8, 'Irmão/Irmã' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 9, 'Genro/Nora' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 10, 'Outro Parente' );
INSERT INTO grau_parentesco ( grau_parentesco_codigo, grau_parentesco_descricao ) VALUES ( 11, 'Não parente' );
INSERT INTO documento_providenciavel ( documento_providenciavel_codigo, documento_providenciavel_descricao ) VALUES ( 'CN', 'Certidão de Nascimento' );
INSERT INTO documento_providenciavel ( documento_providenciavel_codigo, documento_providenciavel_descricao ) VALUES ( 'RG', 'Carteira de Identidade' );
INSERT INTO documento_providenciavel ( documento_providenciavel_codigo, documento_providenciavel_descricao ) VALUES ( 'CTPS', 'Carteira de Trabalho e Previdência Social' );
INSERT INTO documento_providenciavel ( documento_providenciavel_codigo, documento_providenciavel_descricao ) VALUES ( 'CPF', 'Cadastro de Pessoa Física' );
INSERT INTO documento_providenciavel ( documento_providenciavel_codigo, documento_providenciavel_descricao ) VALUES ( 'TE', 'Título de Eleitor' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '00', 'Nunca frequentou escola' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '01', 'Creche' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '02', 'Educação Infantil' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '11', '1º ano E. Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '12', '2º ano E. Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '13', '3º ano E. Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '14', '4º ano E. Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '15', '5º ano E. Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '16', '6º ano E. Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '17', '7º ano E. Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '18', '8º ano E. Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '19', '9º ano E. Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '21', '1º ano E. Médio' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '22', '2º ano E. Médio' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '23', '3º ano E. Médio' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '30', 'Superior Incompleto' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '31', 'Superior Completo' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '40', 'EJA - Ensino Fundamental' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '41', 'EJA - Ensino Médio' );
INSERT INTO escolaridade ( escolaridade_codigo, escolaridade_descricao ) VALUES ( '99', 'Outros' );
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 0, 'Não Trabalha');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 1, 'Trabalhador por conta própria(bico, autônomo)');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 2, 'Trabalhador temporário em área rural');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 3, 'Empregado sem carteira de trabalho assinada');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 4, 'Empregado com carteira de trabalho assinada');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 5, 'Trabalhador doméstico sem carteira de trabalho assinada');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 6, 'Trabalhador doméstico com carteira de trabalho assinada');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 7, 'Trabalhador não-remunerado');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 8, 'Militar ou servidor público');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 9, 'Empregador');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 10, 'Estagiário');
INSERT INTO condicao_ocupacao ( condicao_ocupacao_codigo, condicao_ocupacao_descricao ) VALUES ( 11, 'Aprendiz(em condição legal)');
INSERT INTO deficiencia ( deficiencia_codigo, deficiencia_descricao ) VALUES ( 1, 'Cegueira');
INSERT INTO deficiencia ( deficiencia_codigo, deficiencia_descricao ) VALUES ( 2, 'Baixa Visão');
INSERT INTO deficiencia ( deficiencia_codigo, deficiencia_descricao ) VALUES ( 3, 'Surdez severa/profunda');
INSERT INTO deficiencia ( deficiencia_codigo, deficiencia_descricao ) VALUES ( 4, 'Surdez leve/moderada');
INSERT INTO deficiencia ( deficiencia_codigo, deficiencia_descricao ) VALUES ( 5, 'Deficiência física');
INSERT INTO deficiencia ( deficiencia_codigo, deficiencia_descricao ) VALUES ( 6, 'Deficiência mental ou intelectual');
INSERT INTO deficiencia ( deficiencia_codigo, deficiencia_descricao ) VALUES ( 7, 'Síndrome de Down');
INSERT INTO deficiencia ( deficiencia_codigo, deficiencia_descricao ) VALUES ( 8, 'Transtorno/doença mental');

INSERT INTO beneficio_eventual (beneficio_eventual_codigo, beneficio_eventual_descricao)
	VALUES ( 1, 'Auxilio Natalidade');
INSERT INTO beneficio_eventual (beneficio_eventual_codigo, beneficio_eventual_descricao)
	VALUES ( 2, 'Auxilio Funeral');
INSERT INTO beneficio_eventual (beneficio_eventual_codigo, beneficio_eventual_descricao)
	VALUES ( 3, 'Item/Kit especifico para enfrentamento de situações de Emergência ou Calamidade Pública');
INSERT INTO beneficio_eventual (beneficio_eventual_codigo, beneficio_eventual_descricao)
	VALUES ( 4, 'Cesta Básica');
INSERT INTO beneficio_eventual (beneficio_eventual_codigo, beneficio_eventual_descricao)
	VALUES ( 5, 'Aluguel Social/Pagamento de aluguel');
INSERT INTO beneficio_eventual (beneficio_eventual_codigo, beneficio_eventual_descricao)
	VALUES ( 6, 'Outros');

INSERT INTO familia 
(
familia_unidade_atendimento_id, 
familia_forma_ingresso_id,
familia_endereco_localizacao,
familia_endereco_abrigo,
familia_cep_endereco_id, 
familia_logradouro_endereco,
familia_numero_endereco, 
familia_bairro_endereco
) 
VALUES 
(
1,
1,
0,
false,
1,
'ALAMEDA JOSÉ CLETO DUARTE',
'10', 
'CENTRO'
);

INSERT INTO familia_membro 
(
familia_membro_familia_id, 
familia_membro_grau_parentesco_id,
familia_membro_nome, 
familia_membro_sexo, 
familia_membro_data_nascimento, 
familia_membro_apelido,
familia_membro_nome_mae,
familia_membro_nis,
familia_membro_cpf,
familia_membro_rg,
familia_membro_rg_orgao_expedidor,
familia_membro_rg_uf_emissao,
familia_membro_rg_data_emissao,
familia_membro_escolaridade_id,
familia_membro_sabe_ler_escrever,
familia_membro_frequenta_escola_atualmente,
familia_membro_possui_carteira_trabalho,
familia_membro_condicao_ocupacao_id,
familia_membro_possui_qualificacao_profissional,
familia_membro_renda_mensal,
familia_membro_necessita_cuidados_especiais,
familia_membro_usuario_remedios_controlados,
familia_membro_usuario_bebidas_alcoolicas,
familia_membro_usuario_entorpecentes,
familia_membro_gestante
)
VALUES 
(
1,
1,
'MARIA DA SILVA',
0,
'01-01-2000',
'MARIA',
'JOANA DA SILVA',
'123456789',
'123456789',
'123456789',
'SSP',
'MG',
'01-01-2000',
1,
false,
false,
false,
1,
false,
100,
false,
false,
false,
false,
false
);



