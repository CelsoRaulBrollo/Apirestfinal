package com.info.apirest.services;

import com.info.apirest.dto.CarritoDto;
import com.info.apirest.models.Carrito;
import com.info.apirest.models.Detalle;
import com.info.apirest.models.Usuario;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

   /*
    *  savePreparation -> prepare data for cart and purchase detail save
    *     - Set detail unit price
    *  @param Cart requestCart
    * */
   public void savePreparation(Usuario usuario, Carrito requestCart) {
      requestCart.setUsuario(usuario);
      for (Detalle detalle: requestCart.getDetalle()) {
         detalle.defaultPrecioUnitario();
         detalle.setCarrito(requestCart);
      }
      usuario.addCarrito(requestCart);
   }

   /* 
    *  updatePreparation -> prepare data for cart update
    *  @param Cart cart
    *  @param CartDTO requestCart
    *     - List<PurchaseDetail> details
    * */
   public void updatePreparation(Carrito carrito, CarritoDto requestCart) {
      for (Detalle detalle: requestCart.getDetalle()) {
         detalle.defaultPrecioUnitario();
         detalle.setCarrito(carrito);
         if (detalle.getMonto().equals(0)) { requestCart.getDetalle().remove(detalle); }
      }
      carrito.setDetalle(requestCart.getDetalle());
   }
}
