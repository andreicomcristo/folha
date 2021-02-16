package com.folha.boot.service.util;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Component;

@Component
public class UtilidadesDeCalendarioEEscala {

	//UTILIDADES DE CALENDÁRIO E ESCALA      
    public static Date converteStringEmDate(String data) { 
		if (data == null || data.equals(""))
			return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (java.util.Date)formatter.parse(data);
        } catch (ParseException e) {JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        return date;
	}
    
    public String getDiaSemana(int ano, int mes, int dia) {  
        //Algoritmo para descobrir o dia da semana  
        int a = ((12 - mes) / 10);  
        int b = ano - a;  
        int c = mes + (12 * a);  
        int d = b / 100;  
        int e = d / 4;  
        int f = 2 - d + e;  
        int g = (int) (365.25 * b);  
        int h = (int) (30.6001 * (c + 1));  
        int i = (int) ((f + g) + (h + dia) + 5);  
        int j = (int) (i % 7); //Resto de I por 7, onde 0=SAB, 1=DOM, 2=SEG, 3=TER, 4=QUA, 5=QUI, 6=SEX  
    
        
        switch (j) {  
            case 0:  
                return "SABADO";  
            case 1:  
                return "DOMINGO";  
            case 2:  
                return "SEGUNDA";  
            case 3:  
                return "TERCA";  
            case 4:  
                return "QUARTA";  
            case 5:  
                return "QUINTA";  
            case 6:  
                return "SEXTA";  
            default:  
                return "ERRO DIA DA SEMANA";  
        }
        
        
        
        
        
        
        
        
        
        
    
    
}

    public boolean anoBisexto (int ano){
    boolean bisexto = false;
    if((ano % 4 == 0) && ( (ano % 100 != 0) || (ano % 400 == 0) ))  {
    bisexto = true;
    }
    return bisexto;
    }
    
    public int qtdDiasDoMes (boolean bisexto, int mes){
    
        int diasDoMes = 0;
        
        if(bisexto == true && mes == 2){diasDoMes = 29;}else{
            if(bisexto == false && mes == 2){diasDoMes = 28;}else{
                if((mes==1) || (mes==3) || (mes==5) || (mes==7) || (mes==8) || (mes==10) || (mes==12) ){diasDoMes = 31;}else{
                    if((mes==4) || (mes==6) || (mes==9) || (mes==11) ){diasDoMes = 30;}
                }
            }
        }
        
        return diasDoMes;
        
    }
    
    public int quantidadeDeDiasNoMes(String mesDaEscala){
    
        int resposta = 0;

            boolean bisexto = anoBisexto(Integer.parseInt(mesDaEscala.substring(0, 4)));
            int mes = Integer.parseInt(mesDaEscala.substring(4, 6));

            if(bisexto==true && mes == 2){resposta = 29;}
            if(bisexto==false && mes == 2){resposta = 28;}
            if(mes == 1){resposta = 31;}
            if(mes == 3){resposta = 31;}
            if(mes == 5){resposta = 31;}
            if(mes == 7){resposta = 31;}
            if(mes == 8){resposta = 31;}
            if(mes == 10){resposta = 31;}
            if(mes == 12){resposta = 31;}
            if(mes == 4){resposta = 30;}
            if(mes == 6){resposta = 30;}
            if(mes == 9){resposta = 30;}
            if(mes == 11){resposta = 30;}

        return resposta;
    
    }
    
    public int quantidadeDeDiasNoMesAnterior(String mesDaEscala){
    
        int resposta = 0;

        int anoAtual = Integer.parseInt(mesDaEscala.substring(0, 4));
        int mesAtual = Integer.parseInt(mesDaEscala.substring(4, 6));
        
        if(mesAtual==1){anoAtual = anoAtual-1; mesAtual = 12;}else{mesAtual = mesAtual-1;}
        
        String anoAnterior = String.valueOf(anoAtual);
        String mesAnterior = String.valueOf(mesAtual);
        
        if(mesAnterior.length()==1){mesAnterior = "0"+mesAnterior;}
        
        mesDaEscala = anoAnterior+""+mesAnterior;
        
            boolean bisexto = anoBisexto(Integer.parseInt(mesDaEscala.substring(0, 4)));
            int mes = Integer.parseInt(mesDaEscala.substring(4, 6));

            if(bisexto==true && mes == 2){resposta = 29;}
            if(bisexto==false && mes == 2){resposta = 28;}
            if(mes == 1){resposta = 31;}
            if(mes == 3){resposta = 31;}
            if(mes == 5){resposta = 31;}
            if(mes == 7){resposta = 31;}
            if(mes == 8){resposta = 31;}
            if(mes == 10){resposta = 31;}
            if(mes == 12){resposta = 31;}
            if(mes == 4){resposta = 30;}
            if(mes == 6){resposta = 30;}
            if(mes == 9){resposta = 30;}
            if(mes == 11){resposta = 30;}

        return resposta;
    
    }
    
    public int quantidadeDeDiasDeSemanaNoMes(String mesDaEscala, int quantidadeDeDiasNoMes){
        int resposta = 0;
        for(int i=0;i<quantidadeDeDiasNoMes;i++){
            int dia = (i+1);
            int mes = Integer.parseInt(mesDaEscala.substring(4, 6))-1;
            int ano = Integer.parseInt(mesDaEscala.substring(0, 4))-1900;
            java.sql.Date data = new java.sql.Date(ano, mes, dia);
            int DIA = data.getDay();
            if(DIA!=0 && DIA!=6 ){resposta = resposta+1;}
        }
        return resposta;
    }
    
    public String corrigeAnagramaEscala(String dadoInicial){
    
        String resposta = dadoInicial;

        
        
            if(dadoInicial.equalsIgnoreCase("M")){resposta = "M";}
            if(dadoInicial.equalsIgnoreCase("T")){resposta = "T";}
            if(dadoInicial.equalsIgnoreCase("N")){resposta = "N";}

            
            if(dadoInicial.equalsIgnoreCase("MT")){resposta = "MT";}
            if(dadoInicial.equalsIgnoreCase("TM")){resposta = "MT";}
            
            if(dadoInicial.equalsIgnoreCase("MN")){resposta = "MN";}
            if(dadoInicial.equalsIgnoreCase("NM")){resposta = "MN";}
            
            if(dadoInicial.equalsIgnoreCase("TN")){resposta = "TN";}
            if(dadoInicial.equalsIgnoreCase("NT")){resposta = "TN";}
            
            
            if(dadoInicial.equalsIgnoreCase("MTN")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("MNT")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("TMN")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("TNM")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("NMT")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("NTM")){resposta = "MTN";}
            
            if(dadoInicial.equalsIgnoreCase("MTX")){resposta = "MT";}
            if(dadoInicial.equalsIgnoreCase("MTXX")){resposta = "MT";}
            
            if(dadoInicial.equalsIgnoreCase("X")){resposta = "";}
            if(dadoInicial.equalsIgnoreCase("NX")){resposta = "N";}
            if(dadoInicial.equalsIgnoreCase("NXX")){resposta = "N";}
            if(dadoInicial.equalsIgnoreCase("NXXX")){resposta = "N";}
            if(dadoInicial.equalsIgnoreCase("NXXXX")){resposta = "N";}
            if(dadoInicial.equalsIgnoreCase("NXXXXX")){resposta = "N";}
            
            
            
            
            
            for(int i=0;i< resposta.length()-1  ;i++){
            String letra = resposta.substring(i, (i+1));
            
            if(letra.equalsIgnoreCase(" ")){resposta = resposta.substring(0, i); break;}
            
            }
            
            
            if(dadoInicial.equalsIgnoreCase("M")){resposta = "M";}
            if(dadoInicial.equalsIgnoreCase("T")){resposta = "T";}
            if(dadoInicial.equalsIgnoreCase("N")){resposta = "N";}

            
            if(dadoInicial.equalsIgnoreCase("MT")){resposta = "MT";}
            if(dadoInicial.equalsIgnoreCase("TM")){resposta = "MT";}
            
            if(dadoInicial.equalsIgnoreCase("MN")){resposta = "MN";}
            if(dadoInicial.equalsIgnoreCase("NM")){resposta = "MN";}
            
            if(dadoInicial.equalsIgnoreCase("TN")){resposta = "TN";}
            if(dadoInicial.equalsIgnoreCase("NT")){resposta = "TN";}
            
            
            if(dadoInicial.equalsIgnoreCase("MTN")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("MNT")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("TMN")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("TNM")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("NMT")){resposta = "MTN";}
            if(dadoInicial.equalsIgnoreCase("NTM")){resposta = "MTN";}
            
            //TATANDO HORAS C
            if(dadoInicial.equalsIgnoreCase("MC")){resposta = "MC";}
            if(dadoInicial.equalsIgnoreCase("CM")){resposta = "MC";}
            
            if(dadoInicial.equalsIgnoreCase("TC")){resposta = "TC";}
            if(dadoInicial.equalsIgnoreCase("CT")){resposta = "TC";}
            
            if(dadoInicial.equalsIgnoreCase("MTC")){resposta = "MTC";}
            if(dadoInicial.equalsIgnoreCase("MCT")){resposta = "MTC";}
            if(dadoInicial.equalsIgnoreCase("TMC")){resposta = "MTC";}
            if(dadoInicial.equalsIgnoreCase("TCM")){resposta = "MTC";}
            if(dadoInicial.equalsIgnoreCase("CMT")){resposta = "MTC";}
            if(dadoInicial.equalsIgnoreCase("CTM")){resposta = "MTC";}
            
            
            
            

        return resposta;
    
    }
    
    public String retiraLetraDaEscala(String escalaOriginal, String letraATirar){
    
        String resposta = "";
        String interseccao = "";
        boolean jaAchou = false;    
        
        if(letraATirar == null){letraATirar = "";}
        
        escalaOriginal = escalaOriginal.trim();
        letraATirar = letraATirar.trim();
        
        // retirando espacos
        for(int i=0;i< escalaOriginal.length()-1  ;i++){
            String letra = escalaOriginal.substring(i, (i+1));
            if(letra.equalsIgnoreCase(" ")){escalaOriginal = escalaOriginal.substring(0, i); break;}
        }
        
        for(int i=0;i< letraATirar.length()-1  ;i++){
            String letra = letraATirar.substring(i, (i+1));
            if(letra.equalsIgnoreCase(" ")){letraATirar = letraATirar.substring(0, i); break;}
        }
        
        
       
        
        
        
        if(escalaOriginal.equalsIgnoreCase("") || letraATirar.equalsIgnoreCase("")){resposta = escalaOriginal; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("M") && letraATirar.equalsIgnoreCase("M")){resposta = ""; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("T") && letraATirar.equalsIgnoreCase("T")){resposta = ""; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("N") && letraATirar.equalsIgnoreCase("N")){resposta = ""; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("MTNN") && letraATirar.equalsIgnoreCase("T")){resposta = "MNN"; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("MTMT") && letraATirar.equalsIgnoreCase("M")){resposta = "MTT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTMT") && letraATirar.equalsIgnoreCase("N")){resposta = "MMTT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTNT") && letraATirar.equalsIgnoreCase("T")){resposta = "MTN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTMT") && letraATirar.equalsIgnoreCase("T")){resposta = "MMT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTMT") && letraATirar.equalsIgnoreCase("MT")){resposta = "MT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTNMTN") && letraATirar.equalsIgnoreCase("MT")){resposta = "MTNN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("NNMT") && letraATirar.equalsIgnoreCase("N")){resposta = "MTN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTNN") && letraATirar.equalsIgnoreCase("N")){resposta = "MTN"; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("MTNX") && letraATirar.equalsIgnoreCase("N")){resposta = "MT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MXXX") && letraATirar.equalsIgnoreCase("X")){resposta = "M"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTMTN") && letraATirar.equalsIgnoreCase("X")){resposta = "MTMTN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTNMTX") && letraATirar.equalsIgnoreCase("MT")){resposta = "MTN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTMT") && letraATirar.equalsIgnoreCase("X")){resposta = "MTMT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTMTN") && letraATirar.equalsIgnoreCase("N")){resposta = "MTMT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTNX") && letraATirar.equalsIgnoreCase("X")){resposta = "MTN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTNMTX") && letraATirar.equalsIgnoreCase("X")){resposta = "MTMTN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTTN") && letraATirar.equalsIgnoreCase("T")){resposta = "MTN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTTN") && letraATirar.equalsIgnoreCase("N")){resposta = "MTT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MNMT") && letraATirar.equalsIgnoreCase("N")){resposta = "MMT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MXMXX") && letraATirar.equalsIgnoreCase("X")){resposta = "MM"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTMTMTMT") && letraATirar.equalsIgnoreCase("MT")){resposta = "MTMTMT"; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("MTNMT") && letraATirar.equalsIgnoreCase("N")){resposta = "MTMT"; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("MTNMTN") && letraATirar.equalsIgnoreCase("N")){resposta = "MTNMT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("TNTN") && letraATirar.equalsIgnoreCase("T")){resposta = "TNN"; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("MMTT") && letraATirar.equalsIgnoreCase("M")){resposta = "MTT"; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("NNNN") && letraATirar.equalsIgnoreCase("N")){resposta = "NNN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MNMN") && letraATirar.equalsIgnoreCase("N")){resposta = "MMN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("TNTN") && letraATirar.equalsIgnoreCase("N")){resposta = "TTN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MNMN") && letraATirar.equalsIgnoreCase("M")){resposta = "MNN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("NNTT") && letraATirar.equalsIgnoreCase("N")){resposta = "TTN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTMTMTMT") && letraATirar.equalsIgnoreCase("T")){resposta = "MTMTMTM"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("NNMTMT") && letraATirar.equalsIgnoreCase("N")){resposta = "MTMTN"; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("MTNMTN") && letraATirar.equalsIgnoreCase("M")){resposta = "MTTNN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTTNN") && letraATirar.equalsIgnoreCase("T")){resposta = "MTNN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTMTMT") && letraATirar.equalsIgnoreCase("MT")){resposta = "MTMT"; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("NNMTMT") && letraATirar.equalsIgnoreCase("MT")){resposta = "MTNN"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MMTT") && letraATirar.equalsIgnoreCase("T")){resposta = "MMT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTTM") && letraATirar.equalsIgnoreCase("M")){resposta = "MTT"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("MTNM") && letraATirar.equalsIgnoreCase("N")){resposta = "MMT"; jaAchou = true;}
        
        if(escalaOriginal.equalsIgnoreCase("TNMC") && letraATirar.equalsIgnoreCase("T")){resposta = "MNC"; jaAchou = true;}
        if(escalaOriginal.equalsIgnoreCase("TMTN") && letraATirar.equalsIgnoreCase("M")){resposta = "TTN"; jaAchou = true;}
        
        
        
        if(letraATirar.equalsIgnoreCase(" ")){resposta = escalaOriginal; jaAchou = true;}
        
        System.out.println("ORIGINAL:"+escalaOriginal);
        System.out.println("A TIRAR:"+letraATirar);
        
        if(jaAchou == false){
        
            if(escalaOriginal.length()>letraATirar.length()){
            
                for(int i=0;i<(escalaOriginal.length()-letraATirar.length());i++){
                    interseccao = "";
                                                           
                    interseccao = escalaOriginal.substring(i, letraATirar.length());
                        
                    if(interseccao.equalsIgnoreCase(letraATirar)){
                    
                    if(i==0){resposta = escalaOriginal.substring(letraATirar.length(), escalaOriginal.length());}
                    if(i>0){resposta = escalaOriginal.substring(0, i) + escalaOriginal.substring((i+letraATirar.length()), escalaOriginal.length()) ;}
                    
                    
                    
                    }

                }
                
            }
            
    }

        // Limpando espacos
        for(int i=0;i< resposta.length()-1  ;i++){
            String letra = resposta.substring(i, (i+1));
            if(letra.equalsIgnoreCase(" ")){resposta = resposta.substring(0, i); break;}
        }
        
        
        
        return resposta;
    
    }
    
}
