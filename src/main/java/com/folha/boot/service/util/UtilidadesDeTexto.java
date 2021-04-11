package com.folha.boot.service.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Component;

@Component
public class UtilidadesDeTexto {


	// UTILIDADES DE TEXTO
	
	public static String limpaPontosETracosCpf (String cpf) {
		
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		cpf = cpf.replace("_", "");
		cpf = cpf.trim();
		
		return cpf;
	}

	
	public static boolean validaCpfCompleto (String cpf) {
		boolean resposta = true;
		
		if(cpf.length()!=11) {resposta = false;}else {
			
			String d1=cpf.substring(0, 1);
			String d2=cpf.substring(1, 2);
			String d3=cpf.substring(2, 3);
			String d4=cpf.substring(3, 4);
			String d5=cpf.substring(4, 5);
			String d6=cpf.substring(5, 6);
			String d7=cpf.substring(6, 7);
			String d8=cpf.substring(7, 8);
			String d9=cpf.substring(8, 9);
			String d10=cpf.substring(9, 10);
			String d11=cpf.substring(10, 11);
			resposta = validaCpf(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11);
		}
		
		return resposta;
	}
	
	
	public static boolean validaCpf(String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8,
			String d9, String d10, String d11) {

		boolean resposta = false;

		int D1 = Integer.parseInt(d1);
		int D2 = Integer.parseInt(d2);
		int D3 = Integer.parseInt(d3);
		int D4 = Integer.parseInt(d4);
		int D5 = Integer.parseInt(d5);
		int D6 = Integer.parseInt(d6);
		int D7 = Integer.parseInt(d7);
		int D8 = Integer.parseInt(d8);
		int D9 = Integer.parseInt(d9);
		int D10 = Integer.parseInt(d10);
		int D11 = Integer.parseInt(d11);
		int DV1 = 0;
		int DV2 = 0;
		int soma1 = (D1 * 10 + D2 * 9 + D3 * 8 + D4 * 7 + D5 * 6 + D6 * 5 + D7 * 4 + D8 * 3 + D9 * 2);
		int resto1 = soma1 % 11;

		if (resto1 < 2) {
			DV1 = 0;
		} else {
			DV1 = 11 - resto1;
		}

		int soma2 = (D1 * 11 + D2 * 10 + D3 * 9 + D4 * 8 + D5 * 7 + D6 * 6 + D7 * 5 + D8 * 4 + D9 * 3 + DV1 * 2);

		int resto2 = soma2 % 11;

		if (resto2 < 2) {
			DV2 = 0;
		} else {
			DV2 = 11 - resto2;
		}

		if (D10 == DV1 && D11 == DV2) {
			resposta = true;
		}

		return resposta;
	}

	public boolean validaTexto(String texto) {

		boolean resposta = true;

		if (texto.length() > 0) {

			if (texto.length() >= 1 && texto.substring(0, 1).equalsIgnoreCase(" ")) {
				resposta = false;
			}

			if (texto.length() >= 1 && texto.substring(texto.length() - 1, texto.length()).equalsIgnoreCase(" ")) {
				resposta = false;
			}

			if (texto.length() >= 2) {
				String subTexto = "";
				int j = 0;
				for (int i = 0; i < texto.length() - 1; i++) {
					subTexto = texto.substring(texto.length() - j - 2, texto.length() - j);

					if (subTexto.equalsIgnoreCase("  ")) {
						resposta = false;
					}
					j++;
				}
			}
		}
		return resposta;

	}

	public boolean textoLocalizado(String texto, String textoProcurado) {

		boolean resposta = false;

		if (texto.length() > 0) {

			if (texto.length() >= textoProcurado.length()) {

				if (texto.length() >= 2) {
					String subTexto = "";
					int j = 0;
					for (int i = 0; i < texto.length() - textoProcurado.length(); i++) {

						subTexto = texto.substring(j, textoProcurado.length() + j);

						if (subTexto.equalsIgnoreCase(textoProcurado)) {
							resposta = true;
						}
						j++;
					}
				}

				String subTexto = texto.substring(texto.length() - textoProcurado.length(), texto.length());
				if (subTexto.equalsIgnoreCase(textoProcurado)) {
					resposta = true;
				}
				if (textoProcurado.equalsIgnoreCase("") && !texto.equalsIgnoreCase("")) {
					resposta = false;
				}
				if (!textoProcurado.equalsIgnoreCase("") && texto.equalsIgnoreCase("")) {
					resposta = false;
				}

			}
		}

		return resposta;

	}

	public void escreverTexto(String texto) {
		Robot robo;

		try {

			robo = new Robot();

			if (texto.length() > 0) {

				for (int i = 0; i < texto.length(); i++) {

					String caracter = texto.substring(i, i + 1);

					if (caracter.equals("a")) {
						robo.keyPress(KeyEvent.VK_A);
						robo.keyRelease(KeyEvent.VK_A);
					}

					if (caracter.equals("A")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_A);
						robo.keyRelease(KeyEvent.VK_A);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("b")) {
						robo.keyPress(KeyEvent.VK_B);
						robo.keyRelease(KeyEvent.VK_B);
					}

					if (caracter.equals("B")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_B);
						robo.keyRelease(KeyEvent.VK_B);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("c")) {
						robo.keyPress(KeyEvent.VK_C);
						robo.keyRelease(KeyEvent.VK_C);
					}

					if (caracter.equals("C")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_C);
						robo.keyRelease(KeyEvent.VK_C);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("ç")) {
						robo.keyPress(KeyEvent.VK_C);
						robo.keyRelease(KeyEvent.VK_C);
					}

					if (caracter.equals("Ç")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_C);
						robo.keyRelease(KeyEvent.VK_C);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("d")) {
						robo.keyPress(KeyEvent.VK_D);
						robo.keyRelease(KeyEvent.VK_D);
					}

					if (caracter.equals("D")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_D);
						robo.keyRelease(KeyEvent.VK_D);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("e")) {
						robo.keyPress(KeyEvent.VK_E);
						robo.keyRelease(KeyEvent.VK_E);
					}

					if (caracter.equals("E")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_E);
						robo.keyRelease(KeyEvent.VK_E);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("f")) {
						robo.keyPress(KeyEvent.VK_F);
						robo.keyRelease(KeyEvent.VK_F);
					}

					if (caracter.equals("F")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_F);
						robo.keyRelease(KeyEvent.VK_F);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("g")) {
						robo.keyPress(KeyEvent.VK_G);
						robo.keyRelease(KeyEvent.VK_G);
					}

					if (caracter.equals("G")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_G);
						robo.keyRelease(KeyEvent.VK_G);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("h")) {
						robo.keyPress(KeyEvent.VK_H);
						robo.keyRelease(KeyEvent.VK_H);
					}

					if (caracter.equals("H")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_H);
						robo.keyRelease(KeyEvent.VK_H);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("i")) {
						robo.keyPress(KeyEvent.VK_I);
						robo.keyRelease(KeyEvent.VK_I);
					}

					if (caracter.equals("I")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_I);
						robo.keyRelease(KeyEvent.VK_I);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("j")) {
						robo.keyPress(KeyEvent.VK_J);
						robo.keyRelease(KeyEvent.VK_J);
					}

					if (caracter.equals("J")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_J);
						robo.keyRelease(KeyEvent.VK_J);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("k")) {
						robo.keyPress(KeyEvent.VK_K);
						robo.keyRelease(KeyEvent.VK_K);
					}

					if (caracter.equals("K")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_K);
						robo.keyRelease(KeyEvent.VK_K);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("l")) {
						robo.keyPress(KeyEvent.VK_L);
						robo.keyRelease(KeyEvent.VK_L);
					}

					if (caracter.equals("L")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_L);
						robo.keyRelease(KeyEvent.VK_L);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("m")) {
						robo.keyPress(KeyEvent.VK_M);
						robo.keyRelease(KeyEvent.VK_M);
					}

					if (caracter.equals("M")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_M);
						robo.keyRelease(KeyEvent.VK_M);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("n")) {
						robo.keyPress(KeyEvent.VK_N);
						robo.keyRelease(KeyEvent.VK_N);
					}

					if (caracter.equals("N")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_N);
						robo.keyRelease(KeyEvent.VK_N);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("o")) {
						robo.keyPress(KeyEvent.VK_O);
						robo.keyRelease(KeyEvent.VK_O);
					}

					if (caracter.equals("O")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_O);
						robo.keyRelease(KeyEvent.VK_O);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("p")) {
						robo.keyPress(KeyEvent.VK_P);
						robo.keyRelease(KeyEvent.VK_P);
					}

					if (caracter.equals("P")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_P);
						robo.keyRelease(KeyEvent.VK_P);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("q")) {
						robo.keyPress(KeyEvent.VK_Q);
						robo.keyRelease(KeyEvent.VK_Q);
					}

					if (caracter.equals("Q")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_Q);
						robo.keyRelease(KeyEvent.VK_Q);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("r")) {
						robo.keyPress(KeyEvent.VK_R);
						robo.keyRelease(KeyEvent.VK_R);
					}

					if (caracter.equals("R")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_R);
						robo.keyRelease(KeyEvent.VK_R);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("s")) {
						robo.keyPress(KeyEvent.VK_S);
						robo.keyRelease(KeyEvent.VK_S);
					}

					if (caracter.equals("S")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_S);
						robo.keyRelease(KeyEvent.VK_S);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("t")) {
						robo.keyPress(KeyEvent.VK_T);
						robo.keyRelease(KeyEvent.VK_T);
					}

					if (caracter.equals("T")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_T);
						robo.keyRelease(KeyEvent.VK_T);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("u")) {
						robo.keyPress(KeyEvent.VK_U);
						robo.keyRelease(KeyEvent.VK_U);
					}

					if (caracter.equals("U")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_U);
						robo.keyRelease(KeyEvent.VK_U);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("v")) {
						robo.keyPress(KeyEvent.VK_V);
						robo.keyRelease(KeyEvent.VK_V);
					}

					if (caracter.equals("V")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_V);
						robo.keyRelease(KeyEvent.VK_V);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("w")) {
						robo.keyPress(KeyEvent.VK_W);
						robo.keyRelease(KeyEvent.VK_W);
					}

					if (caracter.equals("W")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_W);
						robo.keyRelease(KeyEvent.VK_W);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("x")) {
						robo.keyPress(KeyEvent.VK_X);
						robo.keyRelease(KeyEvent.VK_X);
					}

					if (caracter.equals("X")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_X);
						robo.keyRelease(KeyEvent.VK_X);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("y")) {
						robo.keyPress(KeyEvent.VK_Y);
						robo.keyRelease(KeyEvent.VK_Y);
					}

					if (caracter.equals("Y")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_Y);
						robo.keyRelease(KeyEvent.VK_Y);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equals("z")) {
						robo.keyPress(KeyEvent.VK_Z);
						robo.keyRelease(KeyEvent.VK_Z);
					}

					if (caracter.equals("Z")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_Z);
						robo.keyRelease(KeyEvent.VK_Z);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equalsIgnoreCase("0")) {
						robo.keyPress(KeyEvent.VK_0);
						robo.keyRelease(KeyEvent.VK_0);
					}

					if (caracter.equalsIgnoreCase("1")) {
						robo.keyPress(KeyEvent.VK_1);
						robo.keyRelease(KeyEvent.VK_1);
					}

					if (caracter.equalsIgnoreCase("2")) {
						robo.keyPress(KeyEvent.VK_2);
						robo.keyRelease(KeyEvent.VK_2);
					}

					if (caracter.equalsIgnoreCase("3")) {
						robo.keyPress(KeyEvent.VK_3);
						robo.keyRelease(KeyEvent.VK_3);
					}

					if (caracter.equalsIgnoreCase("4")) {
						robo.keyPress(KeyEvent.VK_4);
						robo.keyRelease(KeyEvent.VK_4);
					}

					if (caracter.equalsIgnoreCase("5")) {
						robo.keyPress(KeyEvent.VK_5);
						robo.keyRelease(KeyEvent.VK_5);
					}

					if (caracter.equalsIgnoreCase("6")) {
						robo.keyPress(KeyEvent.VK_6);
						robo.keyRelease(KeyEvent.VK_6);
					}

					if (caracter.equalsIgnoreCase("7")) {
						robo.keyPress(KeyEvent.VK_7);
						robo.keyRelease(KeyEvent.VK_7);
					}

					if (caracter.equalsIgnoreCase("8")) {
						robo.keyPress(KeyEvent.VK_8);
						robo.keyRelease(KeyEvent.VK_8);
					}

					if (caracter.equalsIgnoreCase("9")) {
						robo.keyPress(KeyEvent.VK_9);
						robo.keyRelease(KeyEvent.VK_9);
					}

					if (caracter.equalsIgnoreCase(".")) {
						robo.keyPress(KeyEvent.VK_PERIOD);
						robo.keyRelease(KeyEvent.VK_PERIOD);
					}

					if (caracter.equalsIgnoreCase(",")) {
						robo.keyPress(KeyEvent.VK_COMMA);
						robo.keyRelease(KeyEvent.VK_COMMA);
					}

					if (caracter.equalsIgnoreCase("-")) {
						robo.keyPress(KeyEvent.VK_SUBTRACT);
						robo.keyRelease(KeyEvent.VK_SUBTRACT);
					}

					if (caracter.equalsIgnoreCase("_")) {
						robo.keyPress(KeyEvent.VK_UNDERSCORE);
						robo.keyRelease(KeyEvent.VK_UNDERSCORE);
					}

					if (caracter.equalsIgnoreCase("+")) {
						robo.keyPress(KeyEvent.VK_PLUS);
						robo.keyRelease(KeyEvent.VK_PLUS);
					}

					if (caracter.equalsIgnoreCase(":")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_SEMICOLON);
						robo.keyRelease(KeyEvent.VK_SEMICOLON);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

					if (caracter.equalsIgnoreCase(";")) {
						robo.keyPress(KeyEvent.VK_SEMICOLON);
						robo.keyRelease(KeyEvent.VK_SEMICOLON);
					}

					if (caracter.equalsIgnoreCase("/")) {
						robo.keyPress(KeyEvent.VK_SLASH);
						robo.keyRelease(KeyEvent.VK_SLASH);
					}

					if (caracter.equalsIgnoreCase("\\")) {
						robo.keyPress(KeyEvent.VK_BACK_SLASH);
						robo.keyRelease(KeyEvent.VK_BACK_SLASH);
					}

					if (caracter.equalsIgnoreCase("*")) {
						robo.keyPress(KeyEvent.VK_MULTIPLY);
						robo.keyRelease(KeyEvent.VK_MULTIPLY);
					}

					if (caracter.equalsIgnoreCase(" ")) {
						robo.keyPress(KeyEvent.VK_SPACE);
						robo.keyRelease(KeyEvent.VK_SPACE);
					}

					if (caracter.equalsIgnoreCase("@")) {
						robo.keyPress(KeyEvent.VK_SHIFT);
						robo.keyPress(KeyEvent.VK_2);
						robo.keyRelease(KeyEvent.VK_2);
						robo.keyRelease(KeyEvent.VK_SHIFT);
					}

				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public void teclarEnter(int quantidade) {

		Robot robo;

		try {

			robo = new Robot();

			for (int i = 0; i < quantidade; i++) {

				{
					robo.keyPress(KeyEvent.VK_ENTER);
					robo.keyRelease(KeyEvent.VK_ENTER);
				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public void teclarTab(int quantidade) {

		Robot robo;

		try {

			robo = new Robot();

			for (int i = 0; i < quantidade; i++) {

				{
					robo.keyPress(KeyEvent.VK_TAB);
					robo.keyRelease(KeyEvent.VK_TAB);
				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public void teclarSetaParaBaixo(int quantidade) {

		Robot robo;

		try {

			robo = new Robot();

			for (int i = 0; i < quantidade; i++) {

				{
					robo.keyPress(KeyEvent.VK_DOWN);
					robo.keyRelease(KeyEvent.VK_DOWN);
				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public void teclarSetaParaCima(int quantidade) {

		Robot robo;

		try {

			robo = new Robot();

			for (int i = 0; i < quantidade; i++) {

				{
					robo.keyPress(KeyEvent.VK_UP);
					robo.keyRelease(KeyEvent.VK_UP);
				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public static String retiraEspacosDuplosAcentosEConverteEmMaiusculo(String textoInicial) {

		String resposta = "";

		String semDuplos = "";

		int tamanho = textoInicial.length();

		String ultimaLetraLida = "";

		// retirando espacos duplos

		if (tamanho >= 2) {

			for (int i = 0; i < tamanho; i++) {

				String caracter = textoInicial.substring(i, i + 1);

				if ((!(ultimaLetraLida.equalsIgnoreCase(" ") && caracter.equalsIgnoreCase(" ")))) {
					semDuplos = semDuplos + caracter;
				}

				ultimaLetraLida = caracter;

			}

			ultimaLetraLida = "";

		} else {
			semDuplos = textoInicial;
		}

		// retirando Acentos

		if (semDuplos.length() > 0) {

			for (int i = 0; i < semDuplos.length(); i++) {

				String caracter = semDuplos.substring(i, i + 1);

				if (caracter.equalsIgnoreCase("á")) {
					caracter = "A";
				}

				if (caracter.equalsIgnoreCase("à")) {
					caracter = "A";
				}

				if (caracter.equalsIgnoreCase("ã")) {
					caracter = "A";
				}

				if (caracter.equalsIgnoreCase("â")) {
					caracter = "A";
				}

				if (caracter.equalsIgnoreCase("ç")) {
					caracter = "C";
				}

				if (caracter.equalsIgnoreCase("é")) {
					caracter = "E";
				}

				if (caracter.equalsIgnoreCase("è")) {
					caracter = "E";
				}

				if (caracter.equalsIgnoreCase("ê")) {
					caracter = "E";
				}

				if (caracter.equalsIgnoreCase("í")) {
					caracter = "I";
				}

				if (caracter.equalsIgnoreCase("ì")) {
					caracter = "I";
				}

				if (caracter.equalsIgnoreCase("î")) {
					caracter = "I";
				}

				if (caracter.equalsIgnoreCase("ñ")) {
					caracter = "N";
				}

				if (caracter.equalsIgnoreCase("ó")) {
					caracter = "O";
				}

				if (caracter.equalsIgnoreCase("ò")) {
					caracter = "O";
				}

				if (caracter.equalsIgnoreCase("õ")) {
					caracter = "O";
				}

				if (caracter.equalsIgnoreCase("ô")) {
					caracter = "O";
				}

				if (caracter.equalsIgnoreCase("ú")) {
					caracter = "U";
				}

				if (caracter.equalsIgnoreCase("ù")) {
					caracter = "U";
				}

				if (caracter.equalsIgnoreCase("û")) {
					caracter = "U";
				}

				if (caracter.equalsIgnoreCase("ü")) {
					caracter = "U";
				}

				caracter = caracter.toUpperCase();

				resposta = resposta + caracter;
			}

		}
		resposta = resposta.trim();

		return resposta;

	}

}
