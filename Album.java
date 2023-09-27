package GestioneAlbum;
import java.util.Vector;
public class Album {
	private final static int DIM_MAX_INFO = 20;
	// 56 length
	private final static int DIM_RECORD = 2*(DIM_MAX_INFO+Character.BYTES)+3*Integer.BYTES;
	private StringBuilder SB = new StringBuilder();
	private Vector<Integer> valueVec = new Vector<>();
	public boolean addName(String name) {
		if(name.length() <= DIM_RECORD) {
			SB.append(name);
			for(int i=0;i<(DIM_MAX_INFO-name.length());i++)
				SB.append('\0');
			// buffer.substring(5, 12);
		}else return false;
		return true;
	}
	public void addValue(Integer value) {
		valueVec.add(value);
	}
	public String getSB() {
		return SB.toString();
	}
	public Vector<Integer> getValueVec() {
		return valueVec;
	}

}
