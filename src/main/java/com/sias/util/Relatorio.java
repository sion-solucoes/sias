/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Fernando Laranjo
 */
public class Relatorio {

    public static byte[] imprimir(InputStream jasper, Map parametros, JRBeanCollectionDataSource colecao) throws JRException, FileNotFoundException {
        JasperPrint p = JasperFillManager.fillReport(jasper, parametros, colecao);
        return JasperExportManager.exportReportToPdf(p);
    }

}
