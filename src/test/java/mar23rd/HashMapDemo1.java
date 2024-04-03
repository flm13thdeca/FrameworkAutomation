package mar23rd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo1 {

	public static void main(String[] args) {
		
		Map<String, Integer> hMap=new HashMap<String, Integer>();
		
		hMap.put("Ram", 101);
		hMap.put("Sam", 102);
		hMap.put("Ravi", 103);
		hMap.put("Gopi", 104);
		
		System.out.println(hMap.get("Ram"));
		
		Set<Entry<String, Integer>> entries=hMap.entrySet();
		
		//for-each 
		
		for(Entry<String, Integer> entry:entries)
		{
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
		
		//iterator 
		
		Iterator<Entry<String, Integer>> it=entries.iterator();
		
		Entry<String, Integer> entry=null;
		
		while(it.hasNext())
		{
			entry=it.next();
			
			System.out.println(entry.getKey()+"----"+entry.getValue());
			
		}
		
		

	}

}
