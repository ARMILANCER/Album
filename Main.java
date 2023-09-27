package GestioneAlbum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
	private static Album album;
	private static BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	private static Gestione gestione = new Gestione();
	public static void main(String[] args) {
		int choice;
		while(true){
			try {
				System.out.println("[0] REGISTRARE UN ALBUM");
				System.out.println("[1] LEGGERE TUTTI GLI ALBUM");
				System.out.println("[2] GLI ALBUM CON PIù TRACCE");
				System.out.println("[3] CAMBIARE IL COSTO RIDUCENDOLO DEL 15% DI TUTTI GLI ALBUM");

				System.out.println("Choice: ");
				choice = Integer.parseInt(buff.readLine());
				switch (choice){
					case 0:
						newAlbum();
						break;
					case 1:
						readAll();
						break;
					case 2:
						theLongest();
						break;
					case 3:
						onSale();
						break;
				};
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public static void newAlbum() {
		album = new Album();
		String[] data = {"NOME ALBUM: ","NOME GRUPPO/ARTISTA: ","ANNO USCITA: ","NUMERO TRACCE: ","COSTO: "};
		boolean another = false;
		try {
			while(!another) {
				for(int i=0;i<data.length;i++) {
					System.out.print(data[i]);
					if(i<2) {
						album.addName(buff.readLine());
					}else album.addValue(Integer.valueOf(buff.readLine()));
				}
				System.out.print("Another(click) or '#' to exit: ");
				if(Objects.equals(buff.readLine(), "#")) {
					another = true;
				}
			}
			gestione.insertData(album);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void readAll() {

	}
	public static void theLongest() {
	}
	public static void onSale() {
	}
}

