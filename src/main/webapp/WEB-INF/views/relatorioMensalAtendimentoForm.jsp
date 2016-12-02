<%-- 
    Document   : defienciaForm
    Created on : 01/09/2015, 20:33:10
    Author     : Fernando Laranjo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<section id="content">
    <div class="container">
        <div class="card">
            <div class="card-header bgm-blue">
                <div class="pull-left">
                    <h2>Relatório Mensal de Atendimento</h2>
                </div>
                <br>
            </div>
            <div class="card-body card-padding">
                <div class="row form-group p-l-15">
                    <div class="col-md-3">
                        <label for="txtDataInicial">Mês de Referência</label>
                        <div class="fg-line">
                            <input type="date" disabled="true" pattern="mm/yyyy" class="form-control input-sm" id="txtDataInicial" value="${relatorioMensalAtendimento.dataInicial}"/>    
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group p-l-15">
                        <div class="col-md-4">
                            <label for="txtUnidadeAtendimento">Unidade de Atendimento</label>
                            <div class="fg-line">
                                <input type="text" disabled="true" class="form-control input-sm" id="txtUnidadeAtendimento" value="${relatorioMensalAtendimento.unidadeAtendimento.codigo} - ${relatorioMensalAtendimento.unidadeAtendimento.descricao}"/>    
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label for="txtEnderecoUnidadeAtendimento">Endereço</label>
                            <div class="fg-line">
                                <input type="text" disabled="true" class="form-control input-sm" id="txtEnderecoUnidadeAtendimento" value="${relatorioMensalAtendimento.unidadeAtendimento.logradouroEndereco}, ${relatorioMensalAtendimento.unidadeAtendimento.numeroEndereco}, ${relatorioMensalAtendimento.unidadeAtendimento.bairroEndereco}"/>    
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label for="txtMunicipioUnidadeAtendimento">Município</label>
                            <div class="fg-line">
                                <input type="text" disabled="true" class="form-control input-sm" id="txtMunicipioUnidadeAtendimento" value="${relatorioMensalAtendimento.unidadeAtendimento.cepEndereco.municipio.descricao} - ${relatorioMensalAtendimento.unidadeAtendimento.cepEndereco.municipio.unidadeFederacao.descricao}"/>    
                            </div>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="pull-left">
                            <h4 class="c-blue">Bloco I - Serviço de Proteção e Atendimento Especializado a Famílias e Indivíduos - PAEFI</h4>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">A. Volume de famílias em acompanhamento pelo PAEFI</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>A.1.  Total de casos (famílias ou indivíduos) em acompanhamento pelo PAEFI</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>A.2.  Novos casos (famílias ou indivíduos) inseridos no acompanhamento do PAEFI, durante o mês de referência</td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">B. Perfil dos novos casos inseridos no acompanhamento do PAEFI, no mês de referência</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr><td>B.1.  Famílias beneficiárias do Programa Bolsa Família</td><td></td></tr>
                                    <tr><td>B.2.  Famílias com membros beneficiários do BPC</td><td></td></tr>
                                    <tr><td>B.3.  Famílias com crianças ou adolescentes em situação de trabalho infantil</td><td></td></tr>
                                    <tr><td>B.4.  Famílias com crianças ou adolescentes em Serviços de Acolhimento</td><td></td></tr>
                                    <tr><td>B.5.  Famílias cuja situação de violência/ violação esteja associada ao uso abusivo de substâncias psicoativas</td><td></td></tr>
                                </tbody>
                            </table>
                            <br>
                            <p class="c-red">* Atenção! Os itens B1 a B5 buscam identificar apenas alguns "perfis" de famílias, portanto é normal que algumas famílias contadas
                             no item A2 não se enquadrem em nenhuma das condições acima, enquanto outras podem se enquadrar simultaneamente em mais de uma condição;
                            portanto a soma de B1 a B5 não terá, necessariamente, o mesmo valor relatado em A2.</p>
                            <br>
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white" colspan="7">Quantidade e perfil das pessoas vítimas de violência ou violações de direitos que ingressaram no PAEFI, durante o mês de referência (apenas novos casos)</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="3" width="600">B.6.  Quantidade de pessoas vitimadas, que ingressaram no PAEFI, durante o mês de referência (apenas para os novos casos)</td> 
                                        <td>Total</td>
                                        <td>Sexo</td>
                                        <td>0 a 12 anos</td>
                                        <td>13 a 17 anos</td>
                                        <td>18 a 59 anos</td>
                                        <td>60 anos ou mais</td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                            <br>
                            <p class="c-red">* Atenção! O total informado em B6 não é necessariamente igual a A2, 
                                uma vez que em um novo caso (família/individuo) inserido no PAEFI poderá haver mais de uma pessoa vitimada.
                            </p>
                            <br>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="pull-left bgm-blue p-l-15">
                            <h4 class="c-white">Atenção! Do item "C" ao item "I" devem ser informadas as situações de violência ou violações de direitos identificadas 
                                entre as pessoas que ingressaram no PAEFI no mês de referência (novos casos). 
                                Uma mesma pessoa pode ter sido vítima de múltiplas violências/violações
                            </h4>
                        </div>                        
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">C. Crianças ou adolescentes em situações de violência ou violações, que ingressaram no PAEFI durante o mês de referência</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white">Sexo</th>
                                        <th class="bgm-lightblue c-white">0 a 12 anos</th>
                                        <th class="bgm-lightblue c-white">13 a 17 anos</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">C.1. Crianças ou adolescentes vítimas de violência intrafamiliar (física ou psicológica)</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">C.2. Crianças ou adolescentes vítimas de abuso sexual</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">C.3. Crianças ou adolescentes vítimas de exploração sexual</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">C.4. Crianças ou adolescentes vítimas de negligência ou abandono</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td class="bgm-blue c-white">Crianças ou adolescentes em situação de Trabalho Infantil, que ingressaram no PAEFI durante o mês de referência</td>
                                        <td class="bgm-lightblue c-white">Total</td>
                                        <td class="bgm-lightblue c-white">Sexo</td>
                                        <td class="bgm-lightblue c-white">0 a 12 anos</td>
                                        <td class="bgm-lightblue c-white">13 a 15 anos</td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">C.5. Crianças ou adolescentes em situação de trabalho infantil (até 15 anos)</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">D. Idosos - 60 anos ou mais - em situações de violência ou violações que ingressaram no PAEFI durante o mês</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white">Sexo</th>
                                        <th class="bgm-lightblue c-white">60 anos ou mais</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">D.1.  Pessoas idosas vítimas de violência intrafamiliar (física, psicológica ou sexual)</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">D.2.  Pessoas idosas vítimas de negligência ou abandono</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">E.	Pessoas com deficiência em situações de violência ou violações que ingressara no PAEFI durante o mês</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white">Sexo</th>
                                        <th class="bgm-lightblue c-white">0 a 12 anos</th>
                                        <th class="bgm-lightblue c-white">13 a 17 anos</th>
                                        <th class="bgm-lightblue c-white">18 a 59 anos</th>
                                        <th class="bgm-lightblue c-white">60 anos ou mais</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">E.1. Pessoas com deficiência vítimas de violência intrafamiliar (física, psicológica ou sexual)</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">E.2. Pessoas com deficiência vítimas de negligência ou abandono</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">F. Mulheres adultas vítimas de violência intrafamiliar que ingressara no PAEFI durante o mês de referência</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>F.1.   Mulheres adultas (18 a 59 anos) vítimas de violência intrafamiliar (física, psicológica ou sexual)</td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">G. Pessoas vítimas de tráficos de seres humanos que ingressara no PAEFI durante o mês de referência</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white">Sexo</th>
                                        <th class="bgm-lightblue c-white">0 a 12 anos</th>
                                        <th class="bgm-lightblue c-white">13 a 17 anos</th>
                                        <th class="bgm-lightblue c-white">18 a 59 anos</th>
                                        <th class="bgm-lightblue c-white">60 anos ou mais</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">G.1.  Pessoas vítimas de tráficos de seres humanos</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">H. Pessoas vítimas de discriminação por orientação sexual que ingressara no PAEFI durante o mês de referência</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>H.1. Pessoas vítimas de discriminação por orientação sexual</td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">I. Pessoas em situação de rua que ingressara no PAEFI durante o mês de referência</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white">Sexo</th>
                                        <th class="bgm-lightblue c-white">0 a 12 anos</th>
                                        <th class="bgm-lightblue c-white">13 a 17 anos</th>
                                        <th class="bgm-lightblue c-white">18 a 59 anos</th>
                                        <th class="bgm-lightblue c-white">60 anos ou mais</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">I.1. Pessoas em situação de rua</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="pull-left">
                            <h4 class="c-blue">Bloco II - Serviço de Proteção Social a Adolescente em Cumprimento de Medida Socioeducativa (LA/PSC)</h4>
                        </div>
                        <div class="pull-right">
                            <div class="checkbox m-l-15">
                                <label for="checkbox checkOfertaServico" class="c-blue">
                                    <input type="checkbox" name="ofertaServico" id="checkOfertaServico"/>
                                    <i class="input-helper"></i>
                                    Não realiza oferta do serviço
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">J. Volume de adolescentes em cumprimento de Medidas Socioeducativas</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>J.1. Total de adolescentes em cumprimento de Medidas Socioeducativas (LA e/ou PSC)</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>J.2. Quantidade de adolescentes em cumprimento de Liberdade Assistida - LA</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>J.3. Quantidade de adolescentes em cumprimento de Prestação de Serviços à Comunidade - PSC</td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <p class="c-red">* Atenção! Eventualmente um mesmo adolescente pode estar cumprindo, 
                            simultaneamente, as medidas de LA e de PSC, portanto pode ocorrer que a soma de J2 e J3 seja maior que o valor relatado em J1, 
                            entretanto a soma de J2 e J3 nunca pode ser menor que J1. O mesmo raciocínio vale para o quadro abaixo (J4. J5 e J6).
                        </p>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">Quantidade e perfil dos novos adolescentes inseridos no Serviço, no mês de referência</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white" colspan="2">Sexo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">J.4. Total de novos adolescentes em cumprimento de Medidas Socioeducativas (LA e/ou PSC), inseridos em acompanhamento no mês de referência</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">J.5. Novos adolescentes em cumprimento de LA, inseridos em acompanhamento, no mês de referência</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">J.6. Novos adolescentes em cumprimento de PSC, inseridos em acompanhamento, no mês de referência</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="pull-left">
                            <h4 class="c-blue">Bloco III - Serviço Especializado em Abordagem Social</h4>
                        </div>
                        <div class="pull-right">
                            <div class="checkbox m-l-15">
                                <label for="checkbox checkOfertaServico" class="c-blue">
                                    <input type="checkbox" name="ofertaServico" id="checkOfertaServico"/>
                                    <i class="input-helper"></i>
                                    Não realiza oferta do serviço
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">K. Quantidade e perfil de pessoas abordadas pela equipe do Serviço de Abordagem, no mês de referência</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white">Sexo</th>
                                        <th class="bgm-lightblue c-white">0 a 12 anos</th>
                                        <th class="bgm-lightblue c-white">13 a 17 anos</th>
                                        <th class="bgm-lightblue c-white">18 a 59 anos</th>
                                        <th class="bgm-lightblue c-white">60 anos ou mais</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">K.1. Pessoas abordadas pelo Serviço de Abordagem Social, durante o mês de referência</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <p class="c-red">* Atenção! Em K1 cada pessoa deve ser contada uma única vez a cada mês, 
                            mesmo que tenha sido abordada várias vezes no durante este mesmo mês.
                        </p>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">Situações identificadas pelo Serviço Especializado em Abordagem Social, no mês de referência</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>K.2. Crianças ou adolescentes em situação de trabalho infantil (até 15 anos)</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>K.3. Crianças ou adolescentes em situação de exploração sexual</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>K.4. Crianças ou adolescentes usuárias de crack ou outras drogas</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>K.5. Pessoas adultas usuárias de crack ou outras drogas ilícitas</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>K.6. Migrantes</td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <p class="c-red">* Para chegar ao valor de L1, deve ser somado o número de pessoas abordadas a cada dia, durante o mês de referência. 
                            Dessa maneira, se uma mesma pessoa foi abordada quatro vezes (quatro dias) ao longo do mês, 
                            devem ser contadas as quatro abordagens. Quando a abordagem é realizada a um grupo de pessoas, 
                            deve ser contabilizado para efeito deste registro o número de pessoas existente no grupo, 
                            ainda que não se tenha estabelecido uma relação individualizada com cada uma das pessoas.
                        </p>
                        <br>
                    </div>
                </div>
                <br><br>
                <div class="row form-group p-l-15">
                    <div class="col-lg-12">
                        <label for="txtNomeCoordenador" class="c-blue">Nome do Coordenador do CREAS</label>
                        <div class="fg-line">
                            <input type="text" class="form-control input-sm" id="txtNomeCoordenador" value=""/>    
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group p-l-15">
                        <div class="col-md-8">
                            <label for="txtAssinatura" class="c-blue">Assinatura</label>
                            <div class="fg-line">
                                <input type="text" class="form-control input-sm" id="txtAssinatura" value=""/>    
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label for="txtCPF" class="c-blue">CPF</label>
                            <div class="fg-line">
                                <input type="text" class="form-control input-sm" id="txtCPF" value=""/>    
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
<script src="<c:url value="/js/deficienciaController.js"/>" type="text/javascript"></script>