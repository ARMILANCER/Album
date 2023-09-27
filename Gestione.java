package GestioneAlbum;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;
public class Gestione {
	private byte[] buffer;
	private Vector<Integer> valueVec;
	public void insertData(Album album) {
		valueVec = album.getValueVec();
		try (RandomAccessFile raf = new RandomAccessFile("dati.dat","w")){	
			raf.seek(raf.length());
			raf.writeBytes(album.getSB());
			album.getValueVec();
			valueVec.forEach(e->{
				try {
					raf.writeInt(e);
					for(int i=0;i<(20-Integer.BYTES);i++){
						raf.writeByte('\0');
					}
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			});
			raf.writeByte('\n');
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	// index[0] -> element, index[1] operation 
 	public void extractData(int[] index){
		try (RandomAccessFile raf = new RandomAccessFile("dati.dat","r")){
		buffer = new byte[20];
		moveIndex(index);
		raf.read(buffer);
		String text = new String(buffer, "UTF-8");
		System.out.println(text);
		raf.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 	
 	public void moveIndex(int[] index) {
 		if(index[0] == 0) {
 			
 		}else if(index[0] == 1) {
 			
 		}
 	}
 	
	public void readAll() {
		String[] data = {"NOME ALBUM: ","NOME GRUPPO/ARTISTA: ","ANNO USCITA: ","NUMERO TRACCE: ","COSTO: "};

	}
}
