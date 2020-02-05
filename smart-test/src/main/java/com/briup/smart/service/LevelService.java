package com.briup.smart.service;

public class LevelService {
	public static String[] levelJudge(int jq, int pm, int wd, int sd, int sq, int co2) {
       String[] levels = new String[6];
       String s1 = jqlevel(jq);
       String s2 = pmlevel(pm);
       String s3 = wdlevel(wd);
       String s4 = sdlevel(sd);
       String s5 = sqlevel(sq);
       String s6 = co2level(co2);
       levels[0] = s1;
       levels[1] = s2;
       levels[2] = s3;
       levels[3] = s4;
       levels[4] = s5;
       levels[5] = s6;
	   return levels;
       
	}

	public static String jqlevel(int jq) {
		if(jq<10) {
			return "合格";
		}else if(jq<20) {
			return "轻度污染";
		}else if(jq<30) {
			return "中度污染";
		}else {
			return "重度污染";
		}
	}

	public static String pmlevel(int pm) {
		if(pm<50) {
			return "优";
		}else if(pm<100) {
			return "良";
		}else if(pm<150) {
			return "轻度污染";
		}else if(pm<200){
			return "中度污染";
		}else if(pm<300) {
			return "重度污染";
		}else {
			return "严重污染";
		}

	}

	public static String wdlevel(int wd) {
		if(wd<4.9) {
			return "微寒";
		}else if(wd<9.9) {
			return "凉";
		}else if(wd<15.9) {
			return "温和";
		}else if(wd<21.9) {
			return "温暖";
		}else if(wd<27.9) {
			return "炎热";
		}else{
			return "酷热";
		}
	}

	public static String sdlevel(int sd) {
		if(sd<40) {
			return "湿度过低";
		}else if(sd<50) {
			return "湿度适宜";
		}else {
			return "湿度过高";
		}
	}

	public static String sqlevel(int sq) {
		if(sq<50) {
			return "优";
		}else if(sq<100) {
			return "良";
		}else if(sq<150) {
			return "轻度污染";
		}else if(sq<200){
			return "中度污染";
		}else if(sq<300) {
			return "重度污染";
		}else {
			return "严重污染";
		}
	}

	public static String co2level(int co2) {
		if(co2<1000) {
			return "优";
		}else if(co2<2000) {
			return "良";
		}else if(co2<5000) {
			return "差";
		}else {
			return "危险";
		}
	}

}
