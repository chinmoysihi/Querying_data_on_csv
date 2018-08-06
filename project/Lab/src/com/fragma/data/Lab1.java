package com.fragma.data;

import java.util.*;

public class Lab1 {

	private static final String CSV_deliveries= "D:\\Workplace\\project\\iplDataSet\\deliveries.csv";
	private static final String CSV_matches= "D:\\Workplace\\project\\iplDataSet\\matches.csv";
	static ArrayList darr=null;
	static ArrayList marr=null;
	
	public static void main(String[] args) {
		
		darr=ReadDeliveries.readDataLineByLine(CSV_deliveries);
        System.out.println(" Deliveries read Completed");
       
        marr=ReadMatches.readDataLineByLine(CSV_matches);
        System.out.println(" Matches read Completed");
        
        System.out.println();
        Top4TeamsFieldFirst.fieldFirst(marr);
        
        System.out.println();
        TotalFourSixScore.score(darr, marr);
        
        System.out.println();        
        TopTenEconomy.economy(darr, marr);
        
        System.out.println();
        TeamNetRunRate.netRunRate(darr, marr);
	}

}
