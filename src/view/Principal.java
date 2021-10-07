/*
 * Criar um projeto Java (ChamadoSim) e importe a biblioteca FilaInt. Esse novo 
 * projeto simular� uma necessidade de muitas empresas e institui��es que aten_
 * dem pessoas, que � criar um canal de gera��o de senhas para pessoas com algu_
 * ma prioridade e pessoas que n�o tem nenhuma prioridade. A classe Principal, 
 * no package view, deve ter na Main, a cria��o de 2 filas, a fila e a 
 * filaPrioritarios, a inicializa��o das senhas dos priorit�rios e dos n�o prio_
 * rit�rios e, por fim, deve dar ao usu�rio a possibilidade de inserir uma nova 
 * senha na fila, uma nova senha na fila de priorit�rios ou chamar uma pessoa 
 * para o atendimento. Um menu deve ser criado.
 * A classe FilaController deve ter os m�todos de valida��o das opera��es ofere_
 * cidas na Main da Classe Principal. Todos os m�todos devem receber a fila cria_
 * da no m�todo Main como par�metro.
 * � O m�todo de inserir um novo elemento na fila;
 * � O m�todo de remover o primeiro elemento da fila, que ser� atendido. A fila 
 * n�o pode estar vazia;
 * � O m�todo de chamado que deve seguir a seguinte regra:
 * o Fazer 3 chamadas priorit�rias para 1 da fila n�o priorit�ria;
 * o Se n�o houver priorit�rios, j� se deve chamar dos n�o priorit�rios;
 * o Se n�o houver ningu�m nas 2 filas, deve-se gerar um aviso.
 */

package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.ingidcosme.filaint.Fila;
import controller.FilaController;

public class Principal {

	public static void main(String[] args) {
		Fila fila = new Fila();  //Fila de n�o priorit�rios
		Fila filaPrioritarios = new Fila();  //Fila de priorit�rios
		FilaController fCont = new FilaController();

		int opc=0;
        do{
        	StringBuffer buffer = new StringBuffer();
        	buffer.append("Fila de Atendimento\n");
        	buffer.append("O que voc� gostaria de fazer?");
        	buffer.append("\n------------------------------------------------");
        	buffer.append("\n1 - Inserir uma senha na fila de N�o Priorit�rios");
        	buffer.append("\n2 - Inserir uma senha na fila de Priorit�rios");
        	buffer.append("\n3 - Chamar uma senha");
        	buffer.append("\n9 - Finalizar a aplica��o");
        	String opcStr = JOptionPane.showInputDialog(buffer.toString());
        	opc = Integer.parseInt(opcStr);
        	
            switch(opc){
                case 1: fCont.inserirSenha(fila);
                        break;
                case 2: fCont.inserirSenha(filaPrioritarios);
						break;
                case 3: try {
							String[] senha = fCont.chamarSenha(fila, filaPrioritarios);
							if(senha[0].contains("pessoas")) {
	                			JOptionPane.showMessageDialog(null, senha[0]);
	                		} else {
	                			JOptionPane.showMessageDialog(null, "Senha: "+senha[0]
	                									+" - Atendimento "+senha[1]);
	                		}
						} catch (Exception e) {
							e.printStackTrace();
						}
                		break;
                case 9: System.out.print("\n\nAplica��o Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Op��o inv�lida!", 
                							"ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opc != 9);
	}

}
