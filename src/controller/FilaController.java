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

package controller;

import br.edu.fateczl.ingidcosme.filaint.Fila;

public class FilaController {
	
	private static int cont = 1;

	public FilaController() {
		super();
	}
	
	public void inserirSenha(Fila f) {
		//Insere uma senha na fila
		f.insert(f.size() + 100);
	}
	
	public String[] chamarSenha(Fila f, Fila fPri) throws Exception {
		//Chama uma senha de acordo com a regra de prioridade
		String senha[] = {"", ""};
		if(!fPri.isEmpty() && cont <= 3) {
			//Caso tenha alguma senha priorit�ria (limitada a 3 senhas consecutivas), chame-a
			senha[0] = String.valueOf(fPri.remove());
			senha[1] = "Priorit�rio";
			cont++;
		} else if(!f.isEmpty()) {
			//Caso contr�rio, chame uma senha dos n�o priorit�rios
			senha[0] = String.valueOf(f.remove());
			senha[1] = "N�o Priorit�rio";
			cont = 1;
		} else {
			//Caso n�o haja senhas para serem chamadas, avise
			senha[0] = "N�o h� pessoas na fila!";
		}
		return senha;
	}

}
