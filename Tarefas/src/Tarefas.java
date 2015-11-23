import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Tarefas {
	Scanner tc = new Scanner(System.in);

	private String nome;
	private String dInicio;
	private String dFim;
	private int pronta;
	private int urgencia;

	private int id;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getdInicio() {
		return dInicio;
	}
	public void setdInicio(String dInicio) {
		this.dInicio = dInicio;
	}
	public String getdFim() {
		return dFim;
	}
	public void setdFim(String dFim) {
		this.dFim = dFim;
	}
	public int isPronta() {
		return pronta;
	}
	public void setPronta(int pronta) {
		this.pronta = pronta;
	}
	public int getUrgencia() {
		return urgencia;
	}
	public void setUrgencia(int urgencia) {
		this.urgencia = urgencia;
	}
	
	public void ler (){		
		System.out.println("Nome: ");
		String nome=tc.next();
		
		System.out.println("Data de inicio: ");
		String dInicio=tc.next();
		LocalDate dI = LocalDate.parse(dInicio);
		
		
		
		System.out.println("Data de finalização? ");
		String dFinal=tc.next();
		LocalDate dF = LocalDate.parse(dFinal);
		
		
		
		int urgencia=0;
		while(urgencia <1 || urgencia>3){
		System.out.println("Urgencia? 1 2 3 ");
		urgencia=tc.nextInt();
		}
		
		
		int op=10;
		String pronta;
		
		while(op <0 || op>1){
		System.out.println("Está concluída? 1 sim 0 nao"); 
		 op= tc.nextInt();
		}
		
		
		
		
		
		
		setNome(nome);
		setdInicio(dI.toString());
		setdFim(dF.toString());
		setUrgencia(urgencia);
		setPronta(op);
		
	}
	

	
	public boolean salvar(){
		Mysql m = new Mysql();
		
	
	 try {		
			String sql = "INSERT INTO tarefas (nome, dInicio, dFim, urgencia, pronta)VALUES(?,?,?,?,?);";
			PreparedStatement comandoSQl = (PreparedStatement) m.conexao.prepareStatement(sql);
			comandoSQl.setString(1, this.nome);
			comandoSQl.setString(2, this.dInicio);
			comandoSQl.setString(3, this.dFim);
			comandoSQl.setInt(4, this.urgencia);
			comandoSQl.setInt(5, this.pronta);


			
			comandoSQl.execute();
			
			
			comandoSQl.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.msg =e.getMessage();
			return false;
		}	

	 
 }
	public boolean mostrar(int funcao){
		 Mysql m = new Mysql();
		 String sql = null;
		 
		 switch(funcao)
		 {
		 case 1: sql= "SELECT * FROM tarefas ORDER BY dFim ASC";
		 break;
		 case 2: sql= "SELECT * FROM tarefas WHERE CURRENT_DATE < dFim";
		 break;
		 case 3: sql="SELECT * FROM tarefas ORDER BY urgencia ASC";
		 }
		 
		 try {
			 
			 PreparedStatement comandoSql= m.conexao.prepareStatement(sql);
			 
			 ResultSet rs =comandoSql.executeQuery();
			 while (rs.next()) {
				 
				 this.id= rs.getInt("idTarefas");
				 this.nome= rs.getString("nome");		
				 this.dInicio = rs.getString("dInicio");
				 this.dFim = rs.getString("dFim");
				 this.urgencia = rs.getInt("urgencia");
				 this.pronta = rs.getInt("pronta");
				System.out.println( this.toString());
				 
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			m.msg = e.getMessage();
			return false;
		}
		 return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cadastro [nome=" + nome + ", dInicio=" + dInicio + ", dFim=" + dFim + ", pronta=" + pronta
				+ ", urgencia=" + urgencia + ", id=" + id + "]";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
