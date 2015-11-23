	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class Mysql {
		private String url="jdbc:mysql://localhost/mydb";
		private String usuario="root";
		private String senha="";
		public Connection conexao=null;
		public String msg;
		public boolean con;
		
		
		
		public Mysql(){
			
			this.url="jdbc:mysql://localhost/mydb";
			this.usuario="root";
			this.senha="";
			this.Conectar();
			
		}
		
		public Mysql(String u, String user, String p){
			this.url=u;
			this.usuario=user;
			this.senha=p;
		}
		
		public boolean Conectar(){
			try{
				this.conexao = DriverManager.getConnection(this.url, this.usuario, this.senha);
				this.con=true;
				this.msg="Uhull!!";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				this.con=false;
				this.msg=e.getMessage();
				e.printStackTrace();
			}
			return this.con;
				
		}
		
		public boolean Desconectar(){
			try{
			this.conexao.close();
			return this.conexao.isClosed();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				this.con=false;
				this.msg=e.getMessage();
				e.printStackTrace();
				return false;
			}
			
		}

	}



