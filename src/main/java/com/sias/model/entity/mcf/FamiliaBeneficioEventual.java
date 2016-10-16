
package com.sias.model.entity.mcf;

import com.sias.model.base.entity.BaseEntity;
import com.sias.model.entity.mcb.BeneficioEventual;
import java.util.Date;

/**
 *
 * @author jaderhenrique
 */
public class FamiliaBeneficioEventual extends BaseEntity{
    
    private Familia familia;
    private BeneficioEventual beneficioEventual;
    private Date dataSolicitacao;
    private Date dataConcessao;

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public BeneficioEventual getBeneficioEventual() {
        return beneficioEventual;
    }

    public void setBeneficioEventual(BeneficioEventual beneficioEventual) {
        this.beneficioEventual = beneficioEventual;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataConcessao() {
        return dataConcessao;
    }

    public void setDataConcessao(Date dataConcessao) {
        this.dataConcessao = dataConcessao;
    }
    
    
}
