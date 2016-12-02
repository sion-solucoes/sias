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
                    <h2>Relat�rio Mensal de Atendimento</h2>
                </div>
                <br>
            </div>
            <div class="card-body card-padding">
                <div class="row form-group p-l-15">
                    <div class="col-md-3">
                        <label for="txtDataInicial">M�s de Refer�ncia</label>
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
                            <label for="txtEnderecoUnidadeAtendimento">Endere�o</label>
                            <div class="fg-line">
                                <input type="text" disabled="true" class="form-control input-sm" id="txtEnderecoUnidadeAtendimento" value="${relatorioMensalAtendimento.unidadeAtendimento.logradouroEndereco}, ${relatorioMensalAtendimento.unidadeAtendimento.numeroEndereco}, ${relatorioMensalAtendimento.unidadeAtendimento.bairroEndereco}"/>    
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label for="txtMunicipioUnidadeAtendimento">Munic�pio</label>
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
                            <h4 class="c-blue">Bloco I - Servi�o de Prote��o e Atendimento Especializado a Fam�lias e Indiv�duos - PAEFI</h4>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">A. Volume de fam�lias em acompanhamento pelo PAEFI</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>A.1.  Total de casos (fam�lias ou indiv�duos) em acompanhamento pelo PAEFI</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>A.2.  Novos casos (fam�lias ou indiv�duos) inseridos no acompanhamento do PAEFI, durante o m�s de refer�ncia</td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">B. Perfil dos novos casos inseridos no acompanhamento do PAEFI, no m�s de refer�ncia</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr><td>B.1.  Fam�lias benefici�rias do Programa Bolsa Fam�lia</td><td></td></tr>
                                    <tr><td>B.2.  Fam�lias com membros benefici�rios do BPC</td><td></td></tr>
                                    <tr><td>B.3.  Fam�lias com crian�as ou adolescentes em situa��o de trabalho infantil</td><td></td></tr>
                                    <tr><td>B.4.  Fam�lias com crian�as ou adolescentes em Servi�os de Acolhimento</td><td></td></tr>
                                    <tr><td>B.5.  Fam�lias cuja situa��o de viol�ncia/ viola��o esteja associada ao uso abusivo de subst�ncias psicoativas</td><td></td></tr>
                                </tbody>
                            </table>
                            <br>
                            <p class="c-red">* Aten��o! Os itens B1 a B5 buscam identificar apenas alguns "perfis" de fam�lias, portanto � normal que algumas fam�lias contadas
                             no item A2 n�o se enquadrem em nenhuma das condi��es acima, enquanto outras podem se enquadrar simultaneamente em mais de uma condi��o;
                            portanto a soma de B1 a B5 n�o ter�, necessariamente, o mesmo valor relatado em A2.</p>
                            <br>
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white" colspan="7">Quantidade e perfil das pessoas v�timas de viol�ncia ou viola��es de direitos que ingressaram no PAEFI, durante o m�s de refer�ncia (apenas novos casos)</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="3" width="600">B.6.  Quantidade de pessoas vitimadas, que ingressaram no PAEFI, durante o m�s de refer�ncia (apenas para os novos casos)</td> 
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
                            <p class="c-red">* Aten��o! O total informado em B6 n�o � necessariamente igual a A2, 
                                uma vez que em um novo caso (fam�lia/individuo) inserido no PAEFI poder� haver mais de uma pessoa vitimada.
                            </p>
                            <br>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="pull-left bgm-blue p-l-15">
                            <h4 class="c-white">Aten��o! Do item "C" ao item "I" devem ser informadas as situa��es de viol�ncia ou viola��es de direitos identificadas 
                                entre as pessoas que ingressaram no PAEFI no m�s de refer�ncia (novos casos). 
                                Uma mesma pessoa pode ter sido v�tima de m�ltiplas viol�ncias/viola��es
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
                                        <th class="bgm-blue c-white">C. Crian�as ou adolescentes em situa��es de viol�ncia ou viola��es, que ingressaram no PAEFI durante o m�s de refer�ncia</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white">Sexo</th>
                                        <th class="bgm-lightblue c-white">0 a 12 anos</th>
                                        <th class="bgm-lightblue c-white">13 a 17 anos</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">C.1. Crian�as ou adolescentes v�timas de viol�ncia intrafamiliar (f�sica ou psicol�gica)</td>
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
                                        <td rowspan="2">C.2. Crian�as ou adolescentes v�timas de abuso sexual</td>
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
                                        <td rowspan="2">C.3. Crian�as ou adolescentes v�timas de explora��o sexual</td>
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
                                        <td rowspan="2">C.4. Crian�as ou adolescentes v�timas de neglig�ncia ou abandono</td>
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
                                        <td class="bgm-blue c-white">Crian�as ou adolescentes em situa��o de Trabalho Infantil, que ingressaram no PAEFI durante o m�s de refer�ncia</td>
                                        <td class="bgm-lightblue c-white">Total</td>
                                        <td class="bgm-lightblue c-white">Sexo</td>
                                        <td class="bgm-lightblue c-white">0 a 12 anos</td>
                                        <td class="bgm-lightblue c-white">13 a 15 anos</td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">C.5. Crian�as ou adolescentes em situa��o de trabalho infantil (at� 15 anos)</td>
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
                                        <th class="bgm-blue c-white">D. Idosos - 60 anos ou mais - em situa��es de viol�ncia ou viola��es que ingressaram no PAEFI durante o m�s</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white">Sexo</th>
                                        <th class="bgm-lightblue c-white">60 anos ou mais</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">D.1.  Pessoas idosas v�timas de viol�ncia intrafamiliar (f�sica, psicol�gica ou sexual)</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">D.2.  Pessoas idosas v�timas de neglig�ncia ou abandono</td>
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
                                        <th class="bgm-blue c-white">E.	Pessoas com defici�ncia em situa��es de viol�ncia ou viola��es que ingressara no PAEFI durante o m�s</th>
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
                                        <td rowspan="2">E.1. Pessoas com defici�ncia v�timas de viol�ncia intrafamiliar (f�sica, psicol�gica ou sexual)</td>
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
                                        <td rowspan="2">E.2. Pessoas com defici�ncia v�timas de neglig�ncia ou abandono</td>
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
                                        <th class="bgm-blue c-white">F. Mulheres adultas v�timas de viol�ncia intrafamiliar que ingressara no PAEFI durante o m�s de refer�ncia</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>F.1.   Mulheres adultas (18 a 59 anos) v�timas de viol�ncia intrafamiliar (f�sica, psicol�gica ou sexual)</td>
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
                                        <th class="bgm-blue c-white">G. Pessoas v�timas de tr�ficos de seres humanos que ingressara no PAEFI durante o m�s de refer�ncia</th>
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
                                        <td rowspan="2">G.1.  Pessoas v�timas de tr�ficos de seres humanos</td>
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
                                        <th class="bgm-blue c-white">H. Pessoas v�timas de discrimina��o por orienta��o sexual que ingressara no PAEFI durante o m�s de refer�ncia</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>H.1. Pessoas v�timas de discrimina��o por orienta��o sexual</td>
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
                                        <th class="bgm-blue c-white">I. Pessoas em situa��o de rua que ingressara no PAEFI durante o m�s de refer�ncia</th>
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
                                        <td rowspan="2">I.1. Pessoas em situa��o de rua</td>
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
                            <h4 class="c-blue">Bloco II - Servi�o de Prote��o Social a Adolescente em Cumprimento de Medida Socioeducativa (LA/PSC)</h4>
                        </div>
                        <div class="pull-right">
                            <div class="checkbox m-l-15">
                                <label for="checkbox checkOfertaServico" class="c-blue">
                                    <input type="checkbox" name="ofertaServico" id="checkOfertaServico"/>
                                    <i class="input-helper"></i>
                                    N�o realiza oferta do servi�o
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
                                        <td>J.3. Quantidade de adolescentes em cumprimento de Presta��o de Servi�os � Comunidade - PSC</td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <p class="c-red">* Aten��o! Eventualmente um mesmo adolescente pode estar cumprindo, 
                            simultaneamente, as medidas de LA e de PSC, portanto pode ocorrer que a soma de J2 e J3 seja maior que o valor relatado em J1, 
                            entretanto a soma de J2 e J3 nunca pode ser menor que J1. O mesmo racioc�nio vale para o quadro abaixo (J4. J5 e J6).
                        </p>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">Quantidade e perfil dos novos adolescentes inseridos no Servi�o, no m�s de refer�ncia</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                        <th class="bgm-lightblue c-white" colspan="2">Sexo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td rowspan="2">J.4. Total de novos adolescentes em cumprimento de Medidas Socioeducativas (LA e/ou PSC), inseridos em acompanhamento no m�s de refer�ncia</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">J.5. Novos adolescentes em cumprimento de LA, inseridos em acompanhamento, no m�s de refer�ncia</td>
                                        <td rowspan="2"></td>
                                        <td>Masculino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Feminino</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">J.6. Novos adolescentes em cumprimento de PSC, inseridos em acompanhamento, no m�s de refer�ncia</td>
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
                            <h4 class="c-blue">Bloco III - Servi�o Especializado em Abordagem Social</h4>
                        </div>
                        <div class="pull-right">
                            <div class="checkbox m-l-15">
                                <label for="checkbox checkOfertaServico" class="c-blue">
                                    <input type="checkbox" name="ofertaServico" id="checkOfertaServico"/>
                                    <i class="input-helper"></i>
                                    N�o realiza oferta do servi�o
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
                                        <th class="bgm-blue c-white">K. Quantidade e perfil de pessoas abordadas pela equipe do Servi�o de Abordagem, no m�s de refer�ncia</th>
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
                                        <td rowspan="2">K.1. Pessoas abordadas pelo Servi�o de Abordagem Social, durante o m�s de refer�ncia</td>
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
                        <p class="c-red">* Aten��o! Em K1 cada pessoa deve ser contada uma �nica vez a cada m�s, 
                            mesmo que tenha sido abordada v�rias vezes no durante este mesmo m�s.
                        </p>
                        <br>
                        <div class="table-responsive" style="border: 1px solid #F5F5F5;">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th class="bgm-blue c-white">Situa��es identificadas pelo Servi�o Especializado em Abordagem Social, no m�s de refer�ncia</th>
                                        <th class="bgm-lightblue c-white">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>K.2. Crian�as ou adolescentes em situa��o de trabalho infantil (at� 15 anos)</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>K.3. Crian�as ou adolescentes em situa��o de explora��o sexual</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>K.4. Crian�as ou adolescentes usu�rias de crack ou outras drogas</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>K.5. Pessoas adultas usu�rias de crack ou outras drogas il�citas</td>
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
                        <p class="c-red">* Para chegar ao valor de L1, deve ser somado o n�mero de pessoas abordadas a cada dia, durante o m�s de refer�ncia. 
                            Dessa maneira, se uma mesma pessoa foi abordada quatro vezes (quatro dias) ao longo do m�s, 
                            devem ser contadas as quatro abordagens. Quando a abordagem � realizada a um grupo de pessoas, 
                            deve ser contabilizado para efeito deste registro o n�mero de pessoas existente no grupo, 
                            ainda que n�o se tenha estabelecido uma rela��o individualizada com cada uma das pessoas.
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