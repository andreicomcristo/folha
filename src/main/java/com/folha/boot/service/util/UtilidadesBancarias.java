package com.folha.boot.service.util;

import org.springframework.stereotype.Component;

@Component
public class UtilidadesBancarias {

	//UTILIDADES DE BANCARIAS
    public String retornaDigitoVerificadorDaAgencia(String agenciaSemDigito, String codigoDoBanco){
    
    String resposta = "";
    boolean acaoValida = true;
        
    if(agenciaSemDigito.length()!=4){acaoValida = false;}
    
    if(acaoValida == true){
    
                // para banco do brasil
                if(codigoDoBanco.equalsIgnoreCase("001")){
                    int D1 = Integer.parseInt(agenciaSemDigito.substring(0, 1));
                    int D2 = Integer.parseInt(agenciaSemDigito.substring(1, 2));
                    int D3 = Integer.parseInt(agenciaSemDigito.substring(2, 3));
                    int D4 = Integer.parseInt(agenciaSemDigito.substring(3, 4));

                    int PESO1 = 5;
                    int PESO2 = 4;
                    int PESO3 = 3;
                    int PESO4 = 2;

                    int M1 = D1*PESO1;
                    int M2 = D2*PESO1;
                    int M3 = D3*PESO1;
                    int M4 = D4*PESO1;

                    int MT = M1+M2+M3+M4;

                    int resto = MT%11;

                    int digito = 11-resto;

                    String DV = String.valueOf(digito);

                    if(resto==10){DV = "X";}
                    if(resto==11){DV = "0";}

                    resposta = DV;
                }
    
                
                
                
                // para banco BRADESCO
                if(codigoDoBanco.equalsIgnoreCase("237")){
                    int D1 = Integer.parseInt(agenciaSemDigito.substring(0, 1));
                    int D2 = Integer.parseInt(agenciaSemDigito.substring(1, 2));
                    int D3 = Integer.parseInt(agenciaSemDigito.substring(2, 3));
                    int D4 = Integer.parseInt(agenciaSemDigito.substring(3, 4));

                    int PESO1 = 5;
                    int PESO2 = 4;
                    int PESO3 = 3;
                    int PESO4 = 2;

                    int M1 = D1*PESO1;
                    int M2 = D2*PESO1;
                    int M3 = D3*PESO1;
                    int M4 = D4*PESO1;

                    int MT = M1+M2+M3+M4;

                    int resto = MT%11;

                    int digito = 11-resto;

                    String DV = String.valueOf(digito);

                    if(resto==10){DV = "P";}
                    if(resto==11){DV = "0";}

                    resposta = DV;
                }
                
    
    }
    
    
    return resposta;
    
    }
    
    
}
