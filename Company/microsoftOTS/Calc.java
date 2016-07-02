package microsoftOTS;

public class Calc {

	int question (int x){
		int i=0;
		while (x == 1){
		x=x&(x-1);
		i++;
		}
		return i;
		}
}
