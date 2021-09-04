package com.info.apirest.services;

import com.info.apirest.dto.DetalleDto;
import com.info.apirest.models.Detalle;
import org.springframework.stereotype.Service;

@Service
public class DetalleService {


   /*
   *  savePreparation -> prepare data for detail save
   *     - Set unit price
   *  @param PurchaseDetail requestDetail
   * */
   public void savePreparation(Detalle requestDetail) {
      requestDetail.defaultPrecioUnitario();
   }

   /*
   *  updatePreparation -> prepare data for detail update
   *  @param PurchaseDetail detail
   *  @param PurchaseDetailDTO requestDetail
   *     - Product product
   *     - Integer amount
   *     - BigDecimal unitPrice 
   * */
   public void updatePreparation(Detalle detalle, DetalleDto requestDetail) {
      detalle.setProducto(requestDetail.getProducto());
      detalle.defaultPrecioUnitario();
      detalle.setMonto(requestDetail.getMonto());
   }
}
