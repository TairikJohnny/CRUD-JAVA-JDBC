package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o codigo para deletar o registro: ");
		int codigo = entrada.nextInt();
		
		Connection conexao = FabricaConexao.getConexao();
		String deleteSQL = "DELETE FROM pessoas WHERE codigo = ?";
		
		PreparedStatement stmt = conexao.prepareStatement(deleteSQL);
		stmt.setInt(1, codigo);
		
		// VERIFICA SE HOUVE ALTERAÇÃO,
		// > 0 SIGINIFICA QUE HOUVE ALTERAÇÃO
		if(stmt.executeUpdate() > 0) {
			System.out.println("Codigo " + codigo + " excluido com sucesso!!!");
		}
		else {
			System.out.print("Nenhuma alteração realizada.");
		}
		
		conexao.close();
		entrada.close();
	}

}
