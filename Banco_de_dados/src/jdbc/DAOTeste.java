package jdbc;

public class DAOTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		
		System.out.println(dao.incluir(sql, "Teste7"));
		System.out.println(dao.incluir(sql, "Teste8"));
		System.out.println(dao.incluir(sql, "Teste9"));
		
		dao.close();
	}

}
