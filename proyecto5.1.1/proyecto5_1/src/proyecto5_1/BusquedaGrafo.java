package proyecto5_1;

import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaGrafo {
	
	public BusquedaGrafo() {}
	public static void main (String[] args) {
		Scanner  Scan= new Scanner (System.in);
		int nodoi = 0;
		int matrizAdy[][]= {{0, 1, 0, 1, 0, 1, 1},
						{1, 0, 1, 0, 0, 0, 1},
						{1, 1, 0, 1, 0, 0, 1},
						{1, 0, 1, 0, 1, 0, 0},
						{0, 0, 0, 1, 0, 1, 1},
						{1, 0, 0, 0, 1, 0, 0},
						{0, 0, 0, 1, 0, 0, 1},
			};
		
		boolean[] BAnchura = new boolean[matrizAdy.length];
		boolean[] BProfundidad = new boolean[matrizAdy.length];	
		ArrayList<Integer> recorridosA = new ArrayList<Integer>();
		BAnchura [nodoi] = true;
		ArrayList<Integer> cola = new ArrayList<Integer>();
		recorridosA.add(nodoi);
		cola.add(nodoi);
		while (!cola.isEmpty()) {
			int j = cola.remove(0);
			for (int i = 0; i < matrizAdy.length; i++) {
				if (matrizAdy[j][i] == 1 && !BAnchura[i]) {
					cola.add(1);
					recorridosA.add(i);
					BAnchura[i]= true;
			}
		}
	}		
	ArrayList<Integer> recorridosP = new ArrayList<Integer>();
	recorridosP = recorridoProfundidad(nodoi, BProfundidad, matrizAdy);	
	System.out.print("En Anchura  es : ");
	for(int u = 0; u <recorridosA.size();u++){
			System.out.print(recorridosA.get(u).toString());
	}
	System.out.print("\n");
	System.out.print("En Profunidad  es : ");
	for(int u=0; u<recorridosP.size();u++){
		System.out.print(recorridosP.get(u).toString());
	}
	}
	public static ArrayList<Integer> recorridoProfundidad (int nodo, boolean[] BProfundida, int matrizAdy[][]){
		
		ArrayList<Integer> recorridos = new ArrayList<Integer>();
		BProfundida[nodo] = true;
		
		ArrayList<Integer> cola2 = new ArrayList<Integer>();
		recorridos.add(nodo);
		cola2.add(nodo);
		while (!cola2.isEmpty()) {
			int j = cola2.remove(0);
			
			for (int i = 0; i<matrizAdy.length; i++) {
				if (matrizAdy[j][i] == 1 && !BProfundida[i]) {
					cola2.add(i);
					recorridos.addAll(recorridoProfundidad(i, BProfundida, matrizAdy));
					
				}
			}
		}
		return recorridos;
	}
}
