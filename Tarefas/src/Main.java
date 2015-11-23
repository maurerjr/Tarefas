import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int op=0;
		Scanner tc= new Scanner(System.in);
		do{
			System.out.println("\n 1- Adicionar tarefa");
		
			System.out.println("\n 2- Mostrar tarefa por Ordem de data a fim");
			System.out.println("\n 3- Mostrar tarefaS atrasadas");
			System.out.println("\n 4- Mostrar tarefas ordenadas pela maior urgencia");
			System.out.println("\n 5- Sair");
			
			op = tc.nextInt();
			switch (op) {
			case 1:
			{
				Tarefas c = new Tarefas();
				c.ler();
				c.salvar();
				
				break;
			}
			
			case 2:
			{ 
				Tarefas p = new Tarefas();
				p.mostrar(1);
				break;
				
			}
			case 3:
			{
				
				Tarefas p = new Tarefas();
				p.mostrar(2);
				
				break;
			}
			case 4:
			{
				Tarefas p = new Tarefas();
				p.mostrar(3);
				break;
			}
			case 5: 
			{
				System.out.println("Volte sempre!!");
				break;
			}
			
			}
			
		}while(op!=5);

	}

}
