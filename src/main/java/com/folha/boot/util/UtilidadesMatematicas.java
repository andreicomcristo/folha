package com.folha.boot.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilidadesMatematicas {

    // UTILIDADES MATEMATICAS
    public double arredondar(double valor, int casas, int ceilOrFloor) {
      double arredondado = valor;
      arredondado *= (Math.pow(10, casas));
      if (ceilOrFloor == 0) {
         arredondado = Math.ceil(arredondado);
      } else {
         arredondado = Math.floor(arredondado);
      }
      arredondado /= (Math.pow(10, casas));
      return arredondado;
   }

    public static double ajustaValorDecimal(double valor,int casas) {
    
        double resposta = 0.0;
        
        if(valor!=0){
        BigDecimal bd = BigDecimal.valueOf(valor);
        resposta =  bd.setScale(casas,RoundingMode.HALF_UP).doubleValue();}
        
        return resposta;
}
    
    public double parteInteiraDeDouble (double valor) {  
    if (valor >= 0.0) {  
        return Math.floor (valor);  
    } else {  
        return Math.ceil (valor);  
    }  
}  
    
    public double parteFracionariaDeDouble (double valor) {  
    if (valor >= 0.0) {  
        return valor - Math.floor (valor);  
    } else {  
        return valor - Math.ceil (valor);  
    }  
}  
    

}
