
public class Association<Integer,V> { 
	public Integer getKeyFromValue(V value) {
		return (Integer) ((Palabra)value).getPrioridad();
	}
}
