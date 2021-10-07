/*
 * Criar um projeto Java (ChamadoSim) e importe a biblioteca FilaInt. Esse novo 
 * projeto simulará uma necessidade de muitas empresas e instituições que aten_
 * dem pessoas, que é criar um canal de geração de senhas para pessoas com algu_
 * ma prioridade e pessoas que não tem nenhuma prioridade. A classe Principal, 
 * no package view, deve ter na Main, a criação de 2 filas, a fila e a 
 * filaPrioritarios, a inicialização das senhas dos prioritários e dos não prio_
 * ritários e, por fim, deve dar ao usuário a possibilidade de inserir uma nova 
 * senha na fila, uma nova senha na fila de prioritários ou chamar uma pessoa 
 * para o atendimento. Um menu deve ser criado.
 * A classe FilaController deve ter os métodos de validação das operações ofere_
 * cidas na Main da Classe Principal. Todos os métodos devem receber a fila cria_
 * da no método Main como parâmetro.
 * • O método de inserir um novo elemento na fila;
 * • O método de remover o primeiro elemento da fila, que será atendido. A fila 
 * não pode estar vazia;
 * • O método de chamado que deve seguir a seguinte regra:
 * o Fazer 3 chamadas prioritárias para 1 da fila não prioritária;
 * o Se não houver prioritários, já se deve chamar dos não prioritários;
 * o Se não houver ninguém nas 2 filas, deve-se gerar um aviso.
 */

package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.ingidcosme.filaint.Fila;
import controller.FilaController;

public class Principal {

	public static void main(String[] args) {
		Fila fila = new Fila();  //Fila de não prioritários
		Fila filaPrioritarios = new Fila();  //Fila de prioritários
		FilaController fCont = new FilaController();

		int opc=0;
        do{
        	StringBuffer buffer = new StringBuffer();
        	buffer.append("Fila de Atendimento\n");
        	buffer.append("O que você gostaria de fazer?");
        	buffer.append("\n------------------------------------------------");
        	buffer.append("\n1 - Inserir uma senha na fila de Não Prioritários");
        	buffer.append("\n2 - Inserir uma senha na fila de Prioritários");
        	buffer.append("\n3 - Chamar uma senha");
        	buffer.append("\n9 - Finalizar a aplicação");
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
                case 9: System.out.print("\n\nAplicação Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida!", 
                							"ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opc != 9);
	}

}
