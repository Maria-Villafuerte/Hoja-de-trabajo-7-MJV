public class PrioridadComparador<Integer> {
	public int compare(Integer o1, Integer o2) {
		if (o1 == o2) {
			return 0;
		} else if ((int)o1 > (int)o2) {
			return 1;
		} else {
			return -1;
		}
	}
}
