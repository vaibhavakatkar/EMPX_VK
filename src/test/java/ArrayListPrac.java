import java.util.ArrayList;
import java.util.*;

public class ArrayListPrac {

	public static void main(String []args)
	{
		List<String> al=new ArrayList<String>();
		
		al.add("ABC");
		al.add("XYZ");
		al.add(1,"VAibhav");
		al.set(2,"LLL");

		List<String> a2=new ArrayList<String>();
		a2.add("ABasdC");
		a2.add("XasdsdYZ");
		a2.add(1,"VAadawdhav");
		a2.set(2,"LdasadasLL");
	//	al.remove(2);
		Collections.sort(al);
		Collections.copy(al,a2);
		
		System.out.println(al);
		System.out.println(a2);
	}
	
	
}
