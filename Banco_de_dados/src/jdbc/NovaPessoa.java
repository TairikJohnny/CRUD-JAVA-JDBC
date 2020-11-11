package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o nome: ");
		String nome = entrada.nextLine();
		
		Connection conexao = FabricaConexao.getConexao();
		
		// INSERINDO VALORES NA TABELA PESSOAS
		// METODO DA CONCATENAÇÃO QUE PODE GERAR ATAQUES SQL INJECTION 
		//String sql = "INSERT INTO pessoas (nome) VALUES ('" + nome + "')";
		// METODO SEGURO DE INSERÇÃO
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		// SETANDO O NOME NO PARAMETRO ? DA INSERÇÃO SQL
		stmt.setString(1, nome);
		
		stmt.execute();
		
		System.out.println("Pessoa incluida com sucesso!!!");
		
		entrada.close();
		conexao.close();
	}

}
