package creational.singleton.after.conn;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static ConnectionPool singleton = new ConnectionPool();
	public final static int POOL_SIZE = 2;
	private List<Connection> connectionsPool;
	
	public static ConnectionPool getInstance() {
		return singleton;
	}
	
	private ConnectionPool() { 
		System.out.println("Creating Connection Pool");
		connectionsPool = new ArrayList<Connection>();
		for(int i = 0; i < POOL_SIZE; i++) {     // criando as conexoes com o banco limitadas pelo POOL_SIZE 
			connectionsPool.add(new Connection());
		}
	}
	
	public Connection getConnection() {
		Connection avaiable = null;
		for(Connection conn: connectionsPool) { // percorre a lista pra pegar uma conexao disponivel
			if(!conn.isInUse()) {
				avaiable = conn;
				break;
			}
		}
		if(avaiable == null) {
			System.out.println("No Connections avaiable");
			return null;
		}
		avaiable.setInUse(true);
		return avaiable;
	}
	
	public void leaveConnection(Connection conn) { // libera a conexao 
		conn.setInUse(false);
	}
}

