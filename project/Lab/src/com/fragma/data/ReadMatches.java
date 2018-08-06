package com.fragma.data;

import java.io.*;
import java.util.*;

import org.apache.commons.csv.*;

public class ReadMatches {
public static ArrayList<Matches> marr= new ArrayList<>();
	
	public static ArrayList readDataLineByLine(String csvFileInput){
		int i=0,j=0;
		Matches m=null;
		String MATCH_ID=null;
		String SEASON=null;
		String CITY=null;
		String DATE=null;
		String TEAM1=null;
		String TEAM2=null;
		String TOSS_WINNER=null;
		String TOSS_DECISION=null;
		String RESULT=null;
		String WINNER=null;
	
		try {
			Reader in = new FileReader( csvFileInput );
	        CSVParser parser = new CSVParser( in, CSVFormat.DEFAULT );
	        List<CSVRecord> list = parser.getRecords();
	        for( CSVRecord row : list ) {
	        	if(j>0) {
	        		for( String entry : row ) {
		        		//System.out.print(entry +" " );
		        		i++;
		        		if(i==1) 
		        			MATCH_ID=entry;
		        		else if(i==2) 
		        			SEASON=entry;
		        		else if(i==3)
		        			CITY=entry;
		        		else if(i==4)
		        			DATE=entry;
		        		else if(i==5)
		        			TEAM1=entry;
		        		else if(i==6)
		        			TEAM2=entry;
		        		else if(i==7)
		        			TOSS_WINNER=entry;
		        		else if(i==8)
		        			TOSS_DECISION=entry;
		        		else if(i==9)
		        			RESULT=entry;
		        		else if(i==10)
		        			WINNER=entry;
		        	}
	        		m= new Matches(MATCH_ID, SEASON, CITY, DATE, TEAM1, TEAM2, TOSS_WINNER, TOSS_DECISION, RESULT, WINNER);
	        		marr.add(m);
	        	}
	        	i=0;
	        	j++;
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return marr;
    }
}
