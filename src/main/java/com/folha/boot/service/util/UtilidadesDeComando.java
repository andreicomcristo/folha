package com.folha.boot.service.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class UtilidadesDeComando {

	//UTILIDADES DE COMANDO
    public void abrirThunderbird(){
      try
      {
         Runtime.getRuntime().exec("cmd.exe /c start thunderbird.exe ");
      }
      catch(IOException iOException)
      {
         iOException.printStackTrace();
      }
   }
    
    public boolean imprimeArquivo(String caminhoDoArquivo){
   
        boolean imprimiu = true;
        Desktop desktop = Desktop.getDesktop();
        try {
            File arquivo = new File(caminhoDoArquivo);
            desktop.print(arquivo);
        } catch (Exception e) { imprimiu = false; JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    return imprimiu;
    }
    
    
}
