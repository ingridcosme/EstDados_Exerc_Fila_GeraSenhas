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
			//Caso tenha alguma senha prioritária (limitada a 3 senhas consecutivas), chame-a
			senha[0] = String.valueOf(fPri.remove());
			senha[1] = "Prioritário";
			cont++;
		} else if(!f.isEmpty()) {
			//Caso contrário, chame uma senha dos não prioritários
			senha[0] = String.valueOf(f.remove());
			senha[1] = "Não Prioritário";
			cont = 1;
		} else {
			//Caso não haja senhas para serem chamadas, avise
			senha[0] = "Não há pessoas na fila!";
		}
		return senha;
	}

}
