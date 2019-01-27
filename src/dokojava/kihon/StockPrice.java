package kihon;

import java.util.*;
import java.util.Map.Entry;

public class StockPrice {

	public static void main(String[] args) {
		String maxDate = "",minDate="";
		Float maxPrice = Float.MIN_VALUE;
		Float minPrice = Float.MAX_VALUE;
		Map<String,Float>m = new HashMap<>();
		m.put("2002-04-19",1092.3f);
		m.put("2002-04-22",1105.91f);
		m.put("2002-04-23",1104.5f);
		m.put("2002-04-24",1098.72f);
		m.put("2002-04-25",1098.32f);

//		Set<String> ks = m.keySet();
//		for(String dt : ks) {
//			Float price =m.get(dt);
//			if(maxPrice < price) {
//				maxPrice = price;
//				maxDate = dt;
//			}
//			if(price < minPrice) {
//				minPrice = price;
//				minDate = dt;
//			}
//		}
//		System.out.println("最高値　=　"+maxDate+" , "+maxPrice);
//		System.out.println("最小値　=　"+minDate+" , "+minPrice);

		Set<Map.Entry<String, Float>> me = m.entrySet();
		for(Map.Entry<String, Float> it : me) {
			Float price = it.getValue();
			if(maxPrice < price) {
				maxDate = it.getKey();
			}
			if(price < minPrice) {
				minPrice = price;
				minDate =it.getKey();
			}
		}
		System.out.println("最高値　=　"+maxDate+" , "+maxPrice);
		System.out.println("最小値　=　"+minDate+" , "+minPrice);

	}

}
