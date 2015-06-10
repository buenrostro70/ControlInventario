package com.csi.inventario;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * 
 */
public class ImpresoraExcel implements Impresora{

    /**
     *
     * @param articulo
     */
    @Override
    public void imprimirArticulos(List<Articulo> articulo) {
        try {
            Map beans = new HashMap();
            beans.put("articulo", articulo);
            XLSTransformer transformer = new XLSTransformer();
            transformer.transformXLS("template.xls", beans, "ReporteArticulos.xls");
        } catch (ParsePropertyException | IOException | InvalidFormatException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
}
