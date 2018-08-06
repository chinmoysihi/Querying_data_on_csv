package com.fragma.data;

import java.util.*;
import java.util.Map.Entry;

public class TotalFourSixScore {
	
	public static void score(ArrayList<Deliveries> darr,ArrayList<Matches> marr) {
		LinkedHashMap<String,String> map= new LinkedHashMap<>();
		int four=0,six=0,tot=0;
		for(Matches m : marr) {
			map.put(m.getMATCH_ID()	, m.getSEASON());
		}
		LinkedHashMap<String,String> smap= new LinkedHashMap<>();
		Set<Entry<String,String>> set= map.entrySet();
		for(Entry<String,String> entry:set) {
			for(Deliveries d:darr) {
				if(entry.getKey().toString().equals(d.getMATCH_ID())) {
					String key= entry.getValue().toString()+","+d.getBATTING_TEAM();
					if(!smap.containsKey(key)) {
						int r=Integer.parseInt(d.getBATSMAN_RUNS());
						tot=r;
						if(r==4)
							four=1;
						if(r==6)
							six=1;
						smap.put(key, ""+four+","+six+","+tot);
					}else {
						int r= Integer.parseInt(d.getBATSMAN_RUNS());
						String arr[]=smap.get(key).toString().split(",");
						four=Integer.parseInt(arr[0]);
						six=Integer.parseInt(arr[1]);
						tot=Integer.parseInt(arr[2]);
						tot+=r;
						if(r==4)
							four+=1;
						if(r==6)
							six+=1;
						smap.put(key, ""+four+","+six+","+tot);
					}
				}
			}
		}
		//System.out.println(smap);
		Set<Entry<String,String>> sset=smap.entrySet();
		System.out.println("Year"+"  "+"Team_Name"+"  "+"Fours_Count"+" "+"Sixes_Count"+" "+"Total_Score");
		for(Entry<String,String> entry : sset) {
			String key=entry.getKey();
			String val=entry.getValue();
			String karr[]=key.split(",");
			String varr[]=val.split(",");
			System.out.println(karr[0]+" "+karr[1]+" "+varr[0]+" "+varr[1]+" "+varr[2]);
		}
	}
}
