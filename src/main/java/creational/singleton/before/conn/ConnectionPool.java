package creational.singleton.before.conn;

import java.util.ArrayList;
import java.util.List;

// Classe pra simular pool de conexões com o banco de dados
public class ConnectionPool {
	
	// pra cada nova instancia da classe, cria-se mais 2 novas conexões com o banco de dados
	private final static int POOL_SIZE = 2; 

	private List<Connection> connectionsPool;
	
	public ConnectionPool() {
		System.out.println("Criando pool de conexões");
		connectionsPool = new ArrayList<Connection>();
		for(int i = 0; i < POOL_SIZE; i++) {
			connectionsPool.add(new Connection());
		}
	}
	
	public Connection getConnection() {
		Connection avaiable = null;
		for(Connection conn: connectionsPool) {
			if(!conn.isInUse()) { // se a conexão não estiver em uso
				avaiable = conn;
				break;
			}
		}
		if(avaiable == null) {
			System.out.println("Nenhuma conexão disponível");
			return null;
		}
		avaiable.setInUse(true);
		return avaiable;
	}
	
	public void leaveConnection(Connection conn) {
		conn.setInUse(false); // libera a conexão
	}
}