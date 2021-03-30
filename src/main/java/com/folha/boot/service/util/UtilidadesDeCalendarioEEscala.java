package com.folha.boot.service.util;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import org.springframework.stereotype.Component;

import com.folha.boot.domain.Escala;
import com.folha.boot.service.EscalaService;

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

    
    public String getDiaSemanaPorAnoMesEDia(String anoMes, int dia) {  
        //Algoritmo para descobrir o dia da semana  
    	int ano = Integer.parseInt(anoMes.substring(0, 4));
    	int mes = Integer.parseInt(anoMes.substring(4, 6));
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
    
    public double plantoesNaEscala(Escala escala) {
    	double resposta = 0.0;
    	
    	resposta = resposta + escala.getDia01Fk().getPlantoes(); 
    	resposta = resposta + escala.getDia02Fk().getPlantoes();
    	resposta = resposta + escala.getDia03Fk().getPlantoes();
    	resposta = resposta + escala.getDia04Fk().getPlantoes();
    	resposta = resposta + escala.getDia05Fk().getPlantoes();
    	resposta = resposta + escala.getDia06Fk().getPlantoes();
    	resposta = resposta + escala.getDia07Fk().getPlantoes();
    	resposta = resposta + escala.getDia08Fk().getPlantoes();
    	resposta = resposta + escala.getDia09Fk().getPlantoes();
    	resposta = resposta + escala.getDia10Fk().getPlantoes();
    	resposta = resposta + escala.getDia11Fk().getPlantoes();
    	resposta = resposta + escala.getDia12Fk().getPlantoes();
    	resposta = resposta + escala.getDia13Fk().getPlantoes();
    	resposta = resposta + escala.getDia14Fk().getPlantoes();
    	resposta = resposta + escala.getDia15Fk().getPlantoes();
    	resposta = resposta + escala.getDia16Fk().getPlantoes();
    	resposta = resposta + escala.getDia17Fk().getPlantoes();
    	resposta = resposta + escala.getDia18Fk().getPlantoes();
    	resposta = resposta + escala.getDia19Fk().getPlantoes();
    	resposta = resposta + escala.getDia20Fk().getPlantoes();
    	resposta = resposta + escala.getDia21Fk().getPlantoes();
    	resposta = resposta + escala.getDia22Fk().getPlantoes();
    	resposta = resposta + escala.getDia23Fk().getPlantoes();
    	resposta = resposta + escala.getDia24Fk().getPlantoes();
    	resposta = resposta + escala.getDia25Fk().getPlantoes();
    	resposta = resposta + escala.getDia26Fk().getPlantoes();
    	resposta = resposta + escala.getDia27Fk().getPlantoes();
    	resposta = resposta + escala.getDia28Fk().getPlantoes();
    	resposta = resposta + escala.getDia29Fk().getPlantoes();
    	resposta = resposta + escala.getDia30Fk().getPlantoes();
    	resposta = resposta + escala.getDia31Fk().getPlantoes();
    	
    	return resposta;
    }
    
    public int horasTotaisEscala(Escala escala) {
    	int resposta = 0;
    	
    	resposta = resposta + escala.getDia01Fk().getHorasManha()+escala.getDia01Fk().getHorasTarde()+escala.getDia01Fk().getHorasNoite(); 
    	resposta = resposta + escala.getDia02Fk().getHorasManha()+escala.getDia02Fk().getHorasTarde()+escala.getDia02Fk().getHorasNoite();
    	resposta = resposta + escala.getDia03Fk().getHorasManha()+escala.getDia03Fk().getHorasTarde()+escala.getDia03Fk().getHorasNoite();
    	resposta = resposta + escala.getDia04Fk().getHorasManha()+escala.getDia04Fk().getHorasTarde()+escala.getDia04Fk().getHorasNoite();
    	resposta = resposta + escala.getDia05Fk().getHorasManha()+escala.getDia05Fk().getHorasTarde()+escala.getDia05Fk().getHorasNoite();
    	resposta = resposta + escala.getDia06Fk().getHorasManha()+escala.getDia06Fk().getHorasTarde()+escala.getDia06Fk().getHorasNoite();
    	resposta = resposta + escala.getDia07Fk().getHorasManha()+escala.getDia07Fk().getHorasTarde()+escala.getDia07Fk().getHorasNoite();
    	resposta = resposta + escala.getDia08Fk().getHorasManha()+escala.getDia08Fk().getHorasTarde()+escala.getDia08Fk().getHorasNoite();
    	resposta = resposta + escala.getDia09Fk().getHorasManha()+escala.getDia09Fk().getHorasTarde()+escala.getDia09Fk().getHorasNoite();
    	resposta = resposta + escala.getDia10Fk().getHorasManha()+escala.getDia10Fk().getHorasTarde()+escala.getDia10Fk().getHorasNoite();
    	resposta = resposta + escala.getDia11Fk().getHorasManha()+escala.getDia11Fk().getHorasTarde()+escala.getDia11Fk().getHorasNoite();
    	resposta = resposta + escala.getDia12Fk().getHorasManha()+escala.getDia12Fk().getHorasTarde()+escala.getDia12Fk().getHorasNoite();
    	resposta = resposta + escala.getDia13Fk().getHorasManha()+escala.getDia13Fk().getHorasTarde()+escala.getDia13Fk().getHorasNoite();
    	resposta = resposta + escala.getDia14Fk().getHorasManha()+escala.getDia14Fk().getHorasTarde()+escala.getDia14Fk().getHorasNoite();
    	resposta = resposta + escala.getDia15Fk().getHorasManha()+escala.getDia15Fk().getHorasTarde()+escala.getDia15Fk().getHorasNoite();
    	resposta = resposta + escala.getDia16Fk().getHorasManha()+escala.getDia16Fk().getHorasTarde()+escala.getDia16Fk().getHorasNoite();
    	resposta = resposta + escala.getDia17Fk().getHorasManha()+escala.getDia17Fk().getHorasTarde()+escala.getDia17Fk().getHorasNoite();
    	resposta = resposta + escala.getDia18Fk().getHorasManha()+escala.getDia18Fk().getHorasTarde()+escala.getDia18Fk().getHorasNoite();
    	resposta = resposta + escala.getDia19Fk().getHorasManha()+escala.getDia19Fk().getHorasTarde()+escala.getDia19Fk().getHorasNoite();
    	resposta = resposta + escala.getDia20Fk().getHorasManha()+escala.getDia20Fk().getHorasTarde()+escala.getDia20Fk().getHorasNoite();
    	resposta = resposta + escala.getDia21Fk().getHorasManha()+escala.getDia21Fk().getHorasTarde()+escala.getDia21Fk().getHorasNoite();
    	resposta = resposta + escala.getDia22Fk().getHorasManha()+escala.getDia22Fk().getHorasTarde()+escala.getDia22Fk().getHorasNoite();
    	resposta = resposta + escala.getDia23Fk().getHorasManha()+escala.getDia23Fk().getHorasTarde()+escala.getDia23Fk().getHorasNoite();
    	resposta = resposta + escala.getDia24Fk().getHorasManha()+escala.getDia24Fk().getHorasTarde()+escala.getDia24Fk().getHorasNoite();
    	resposta = resposta + escala.getDia25Fk().getHorasManha()+escala.getDia25Fk().getHorasTarde()+escala.getDia25Fk().getHorasNoite();
    	resposta = resposta + escala.getDia26Fk().getHorasManha()+escala.getDia26Fk().getHorasTarde()+escala.getDia26Fk().getHorasNoite();
    	resposta = resposta + escala.getDia27Fk().getHorasManha()+escala.getDia27Fk().getHorasTarde()+escala.getDia27Fk().getHorasNoite();
    	resposta = resposta + escala.getDia28Fk().getHorasManha()+escala.getDia28Fk().getHorasTarde()+escala.getDia28Fk().getHorasNoite();
    	resposta = resposta + escala.getDia29Fk().getHorasManha()+escala.getDia29Fk().getHorasTarde()+escala.getDia29Fk().getHorasNoite();
    	resposta = resposta + escala.getDia30Fk().getHorasManha()+escala.getDia30Fk().getHorasTarde()+escala.getDia30Fk().getHorasNoite();
    	resposta = resposta + escala.getDia31Fk().getHorasManha()+escala.getDia31Fk().getHorasTarde()+escala.getDia31Fk().getHorasNoite();
    	
    	return resposta;
    }
    
    public int horasDiaEscala(Escala escala) {
    	int resposta = 0;
    	
    	resposta = resposta + escala.getDia01Fk().getHorasManha()+escala.getDia01Fk().getHorasTarde(); 
    	resposta = resposta + escala.getDia02Fk().getHorasManha()+escala.getDia02Fk().getHorasTarde();
    	resposta = resposta + escala.getDia03Fk().getHorasManha()+escala.getDia03Fk().getHorasTarde();
    	resposta = resposta + escala.getDia04Fk().getHorasManha()+escala.getDia04Fk().getHorasTarde();
    	resposta = resposta + escala.getDia05Fk().getHorasManha()+escala.getDia05Fk().getHorasTarde();
    	resposta = resposta + escala.getDia06Fk().getHorasManha()+escala.getDia06Fk().getHorasTarde();
    	resposta = resposta + escala.getDia07Fk().getHorasManha()+escala.getDia07Fk().getHorasTarde();
    	resposta = resposta + escala.getDia08Fk().getHorasManha()+escala.getDia08Fk().getHorasTarde();
    	resposta = resposta + escala.getDia09Fk().getHorasManha()+escala.getDia09Fk().getHorasTarde();
    	resposta = resposta + escala.getDia10Fk().getHorasManha()+escala.getDia10Fk().getHorasTarde();
    	resposta = resposta + escala.getDia11Fk().getHorasManha()+escala.getDia11Fk().getHorasTarde();
    	resposta = resposta + escala.getDia12Fk().getHorasManha()+escala.getDia12Fk().getHorasTarde();
    	resposta = resposta + escala.getDia13Fk().getHorasManha()+escala.getDia13Fk().getHorasTarde();
    	resposta = resposta + escala.getDia14Fk().getHorasManha()+escala.getDia14Fk().getHorasTarde();
    	resposta = resposta + escala.getDia15Fk().getHorasManha()+escala.getDia15Fk().getHorasTarde();
    	resposta = resposta + escala.getDia16Fk().getHorasManha()+escala.getDia16Fk().getHorasTarde();
    	resposta = resposta + escala.getDia17Fk().getHorasManha()+escala.getDia17Fk().getHorasTarde();
    	resposta = resposta + escala.getDia18Fk().getHorasManha()+escala.getDia18Fk().getHorasTarde();
    	resposta = resposta + escala.getDia19Fk().getHorasManha()+escala.getDia19Fk().getHorasTarde();
    	resposta = resposta + escala.getDia20Fk().getHorasManha()+escala.getDia20Fk().getHorasTarde();
    	resposta = resposta + escala.getDia21Fk().getHorasManha()+escala.getDia21Fk().getHorasTarde();
    	resposta = resposta + escala.getDia22Fk().getHorasManha()+escala.getDia22Fk().getHorasTarde();
    	resposta = resposta + escala.getDia23Fk().getHorasManha()+escala.getDia23Fk().getHorasTarde();
    	resposta = resposta + escala.getDia24Fk().getHorasManha()+escala.getDia24Fk().getHorasTarde();
    	resposta = resposta + escala.getDia25Fk().getHorasManha()+escala.getDia25Fk().getHorasTarde();
    	resposta = resposta + escala.getDia26Fk().getHorasManha()+escala.getDia26Fk().getHorasTarde();
    	resposta = resposta + escala.getDia27Fk().getHorasManha()+escala.getDia27Fk().getHorasTarde();
    	resposta = resposta + escala.getDia28Fk().getHorasManha()+escala.getDia28Fk().getHorasTarde();
    	resposta = resposta + escala.getDia29Fk().getHorasManha()+escala.getDia29Fk().getHorasTarde();
    	resposta = resposta + escala.getDia30Fk().getHorasManha()+escala.getDia30Fk().getHorasTarde();
    	resposta = resposta + escala.getDia31Fk().getHorasManha()+escala.getDia31Fk().getHorasTarde();
    	
    	return resposta;
    }
    
    public int horasNoiteEscala(Escala escala) {
    	int resposta = 0;
    	
    	resposta = resposta + escala.getDia01Fk().getHorasNoite(); 
    	resposta = resposta + escala.getDia02Fk().getHorasNoite();
    	resposta = resposta + escala.getDia03Fk().getHorasNoite();
    	resposta = resposta + escala.getDia04Fk().getHorasNoite();
    	resposta = resposta + escala.getDia05Fk().getHorasNoite();
    	resposta = resposta + escala.getDia06Fk().getHorasNoite();
    	resposta = resposta + escala.getDia07Fk().getHorasNoite();
    	resposta = resposta + escala.getDia08Fk().getHorasNoite();
    	resposta = resposta + escala.getDia09Fk().getHorasNoite();
    	resposta = resposta + escala.getDia10Fk().getHorasNoite();
    	resposta = resposta + escala.getDia11Fk().getHorasNoite();
    	resposta = resposta + escala.getDia12Fk().getHorasNoite();
    	resposta = resposta + escala.getDia13Fk().getHorasNoite();
    	resposta = resposta + escala.getDia14Fk().getHorasNoite();
    	resposta = resposta + escala.getDia15Fk().getHorasNoite();
    	resposta = resposta + escala.getDia16Fk().getHorasNoite();
    	resposta = resposta + escala.getDia17Fk().getHorasNoite();
    	resposta = resposta + escala.getDia18Fk().getHorasNoite();
    	resposta = resposta + escala.getDia19Fk().getHorasNoite();
    	resposta = resposta + escala.getDia20Fk().getHorasNoite();
    	resposta = resposta + escala.getDia21Fk().getHorasNoite();
    	resposta = resposta + escala.getDia22Fk().getHorasNoite();
    	resposta = resposta + escala.getDia23Fk().getHorasNoite();
    	resposta = resposta + escala.getDia24Fk().getHorasNoite();
    	resposta = resposta + escala.getDia25Fk().getHorasNoite();
    	resposta = resposta + escala.getDia26Fk().getHorasNoite();
    	resposta = resposta + escala.getDia27Fk().getHorasNoite();
    	resposta = resposta + escala.getDia28Fk().getHorasNoite();
    	resposta = resposta + escala.getDia29Fk().getHorasNoite();
    	resposta = resposta + escala.getDia30Fk().getHorasNoite();
    	resposta = resposta + escala.getDia31Fk().getHorasNoite();
    	
    	return resposta;
    }
    
    public int horasSemanaEscala(Escala escala) {
    	int resposta = 0;
    
    	int qtdDiasNoMes= quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
    	
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  1) == false) {resposta = resposta + escala.getDia01Fk().getHorasManha()+escala.getDia01Fk().getHorasTarde()+escala.getDia01Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  2) == false) {resposta = resposta + escala.getDia02Fk().getHorasManha()+escala.getDia02Fk().getHorasTarde()+escala.getDia02Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  3) == false) {resposta = resposta + escala.getDia03Fk().getHorasManha()+escala.getDia03Fk().getHorasTarde()+escala.getDia03Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  4) == false) {resposta = resposta + escala.getDia04Fk().getHorasManha()+escala.getDia04Fk().getHorasTarde()+escala.getDia04Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  5) == false) {resposta = resposta + escala.getDia05Fk().getHorasManha()+escala.getDia05Fk().getHorasTarde()+escala.getDia05Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  6) == false) {resposta = resposta + escala.getDia06Fk().getHorasManha()+escala.getDia06Fk().getHorasTarde()+escala.getDia06Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  7) == false) {resposta = resposta + escala.getDia07Fk().getHorasManha()+escala.getDia07Fk().getHorasTarde()+escala.getDia07Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  8) == false) {resposta = resposta + escala.getDia08Fk().getHorasManha()+escala.getDia08Fk().getHorasTarde()+escala.getDia08Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  9) == false) {resposta = resposta + escala.getDia09Fk().getHorasManha()+escala.getDia09Fk().getHorasTarde()+escala.getDia09Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 10) == false) {resposta = resposta + escala.getDia10Fk().getHorasManha()+escala.getDia10Fk().getHorasTarde()+escala.getDia10Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 11) == false) {resposta = resposta + escala.getDia11Fk().getHorasManha()+escala.getDia11Fk().getHorasTarde()+escala.getDia11Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 12) == false) {resposta = resposta + escala.getDia12Fk().getHorasManha()+escala.getDia12Fk().getHorasTarde()+escala.getDia12Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 13) == false) {resposta = resposta + escala.getDia13Fk().getHorasManha()+escala.getDia13Fk().getHorasTarde()+escala.getDia13Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 14) == false) {resposta = resposta + escala.getDia14Fk().getHorasManha()+escala.getDia14Fk().getHorasTarde()+escala.getDia14Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 15) == false) {resposta = resposta + escala.getDia15Fk().getHorasManha()+escala.getDia15Fk().getHorasTarde()+escala.getDia15Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 16) == false) {resposta = resposta + escala.getDia16Fk().getHorasManha()+escala.getDia16Fk().getHorasTarde()+escala.getDia16Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 17) == false) {resposta = resposta + escala.getDia17Fk().getHorasManha()+escala.getDia17Fk().getHorasTarde()+escala.getDia17Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 18) == false) {resposta = resposta + escala.getDia18Fk().getHorasManha()+escala.getDia18Fk().getHorasTarde()+escala.getDia18Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 19) == false) {resposta = resposta + escala.getDia19Fk().getHorasManha()+escala.getDia19Fk().getHorasTarde()+escala.getDia19Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 20) == false) {resposta = resposta + escala.getDia20Fk().getHorasManha()+escala.getDia20Fk().getHorasTarde()+escala.getDia20Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 21) == false) {resposta = resposta + escala.getDia21Fk().getHorasManha()+escala.getDia21Fk().getHorasTarde()+escala.getDia21Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 22) == false) {resposta = resposta + escala.getDia22Fk().getHorasManha()+escala.getDia22Fk().getHorasTarde()+escala.getDia22Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 23) == false) {resposta = resposta + escala.getDia23Fk().getHorasManha()+escala.getDia23Fk().getHorasTarde()+escala.getDia23Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 24) == false) {resposta = resposta + escala.getDia24Fk().getHorasManha()+escala.getDia24Fk().getHorasTarde()+escala.getDia24Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 25) == false) {resposta = resposta + escala.getDia25Fk().getHorasManha()+escala.getDia25Fk().getHorasTarde()+escala.getDia25Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 26) == false) {resposta = resposta + escala.getDia26Fk().getHorasManha()+escala.getDia26Fk().getHorasTarde()+escala.getDia26Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 27) == false) {resposta = resposta + escala.getDia27Fk().getHorasManha()+escala.getDia27Fk().getHorasTarde()+escala.getDia27Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 28) == false) {resposta = resposta + escala.getDia28Fk().getHorasManha()+escala.getDia28Fk().getHorasTarde()+escala.getDia28Fk().getHorasNoite();}
    		if(qtdDiasNoMes>=29) {if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 29) == false) {resposta = resposta + escala.getDia29Fk().getHorasManha()+escala.getDia29Fk().getHorasTarde()+escala.getDia29Fk().getHorasNoite();}}
    		if(qtdDiasNoMes>=30) {if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 30) == false) {resposta = resposta + escala.getDia30Fk().getHorasManha()+escala.getDia30Fk().getHorasTarde()+escala.getDia30Fk().getHorasNoite();}}
    		if(qtdDiasNoMes==31) {if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 31) == false) {resposta = resposta + escala.getDia31Fk().getHorasManha()+escala.getDia31Fk().getHorasTarde()+escala.getDia31Fk().getHorasNoite();}}
    	
    		return resposta;
    }
    
    public int horasFimDeSemanaEscala(Escala escala) {
    	int resposta = 0;
    
    	int qtdDiasNoMes= quantidadeDeDiasNoMes(escala.getIdAnoMesFk().getNomeAnoMes());
    	
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  1) == true) {resposta = resposta + escala.getDia01Fk().getHorasManha()+escala.getDia01Fk().getHorasTarde()+escala.getDia01Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  2) == true) {resposta = resposta + escala.getDia02Fk().getHorasManha()+escala.getDia02Fk().getHorasTarde()+escala.getDia02Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  3) == true) {resposta = resposta + escala.getDia03Fk().getHorasManha()+escala.getDia03Fk().getHorasTarde()+escala.getDia03Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  4) == true) {resposta = resposta + escala.getDia04Fk().getHorasManha()+escala.getDia04Fk().getHorasTarde()+escala.getDia04Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  5) == true) {resposta = resposta + escala.getDia05Fk().getHorasManha()+escala.getDia05Fk().getHorasTarde()+escala.getDia05Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  6) == true) {resposta = resposta + escala.getDia06Fk().getHorasManha()+escala.getDia06Fk().getHorasTarde()+escala.getDia06Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  7) == true) {resposta = resposta + escala.getDia07Fk().getHorasManha()+escala.getDia07Fk().getHorasTarde()+escala.getDia07Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  8) == true) {resposta = resposta + escala.getDia08Fk().getHorasManha()+escala.getDia08Fk().getHorasTarde()+escala.getDia08Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(),  9) == true) {resposta = resposta + escala.getDia09Fk().getHorasManha()+escala.getDia09Fk().getHorasTarde()+escala.getDia09Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 10) == true) {resposta = resposta + escala.getDia10Fk().getHorasManha()+escala.getDia10Fk().getHorasTarde()+escala.getDia10Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 11) == true) {resposta = resposta + escala.getDia11Fk().getHorasManha()+escala.getDia11Fk().getHorasTarde()+escala.getDia11Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 12) == true) {resposta = resposta + escala.getDia12Fk().getHorasManha()+escala.getDia12Fk().getHorasTarde()+escala.getDia12Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 13) == true) {resposta = resposta + escala.getDia13Fk().getHorasManha()+escala.getDia13Fk().getHorasTarde()+escala.getDia13Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 14) == true) {resposta = resposta + escala.getDia14Fk().getHorasManha()+escala.getDia14Fk().getHorasTarde()+escala.getDia14Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 15) == true) {resposta = resposta + escala.getDia15Fk().getHorasManha()+escala.getDia15Fk().getHorasTarde()+escala.getDia15Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 16) == true) {resposta = resposta + escala.getDia16Fk().getHorasManha()+escala.getDia16Fk().getHorasTarde()+escala.getDia16Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 17) == true) {resposta = resposta + escala.getDia17Fk().getHorasManha()+escala.getDia17Fk().getHorasTarde()+escala.getDia17Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 18) == true) {resposta = resposta + escala.getDia18Fk().getHorasManha()+escala.getDia18Fk().getHorasTarde()+escala.getDia18Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 19) == true) {resposta = resposta + escala.getDia19Fk().getHorasManha()+escala.getDia19Fk().getHorasTarde()+escala.getDia19Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 20) == true) {resposta = resposta + escala.getDia20Fk().getHorasManha()+escala.getDia20Fk().getHorasTarde()+escala.getDia20Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 21) == true) {resposta = resposta + escala.getDia21Fk().getHorasManha()+escala.getDia21Fk().getHorasTarde()+escala.getDia21Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 22) == true) {resposta = resposta + escala.getDia22Fk().getHorasManha()+escala.getDia22Fk().getHorasTarde()+escala.getDia22Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 23) == true) {resposta = resposta + escala.getDia23Fk().getHorasManha()+escala.getDia23Fk().getHorasTarde()+escala.getDia23Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 24) == true) {resposta = resposta + escala.getDia24Fk().getHorasManha()+escala.getDia24Fk().getHorasTarde()+escala.getDia24Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 25) == true) {resposta = resposta + escala.getDia25Fk().getHorasManha()+escala.getDia25Fk().getHorasTarde()+escala.getDia25Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 26) == true) {resposta = resposta + escala.getDia26Fk().getHorasManha()+escala.getDia26Fk().getHorasTarde()+escala.getDia26Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 27) == true) {resposta = resposta + escala.getDia27Fk().getHorasManha()+escala.getDia27Fk().getHorasTarde()+escala.getDia27Fk().getHorasNoite();}
    		if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 28) == true) {resposta = resposta + escala.getDia28Fk().getHorasManha()+escala.getDia28Fk().getHorasTarde()+escala.getDia28Fk().getHorasNoite();}
    		if(qtdDiasNoMes>=29) {if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 29) == true) {resposta = resposta + escala.getDia29Fk().getHorasManha()+escala.getDia29Fk().getHorasTarde()+escala.getDia29Fk().getHorasNoite();}}
    		if(qtdDiasNoMes>=30) {if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 30) == true) {resposta = resposta + escala.getDia30Fk().getHorasManha()+escala.getDia30Fk().getHorasTarde()+escala.getDia30Fk().getHorasNoite();}}
    		if(qtdDiasNoMes==31) {if(fimDeSemana(escala.getIdAnoMesFk().getNomeAnoMes(), 31) == true) {resposta = resposta + escala.getDia31Fk().getHorasManha()+escala.getDia31Fk().getHorasTarde()+escala.getDia31Fk().getHorasNoite();}}
    	
    		return resposta;
    }
    
    public boolean fimDeSemana(String anoMes, int dia) {
    	boolean resposta = false;
    	Date data = new Date(Integer.parseInt(anoMes.substring(0, 4))-1900 , Integer.parseInt(anoMes.substring(4, 6))-1, dia);	
    	int diaDaSemana = data.getDay();
    	if(diaDaSemana==0||diaDaSemana==6) {resposta=true;}
    	return resposta;
    }
    
    
    
}
