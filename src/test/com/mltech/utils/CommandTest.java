package com.mltech.utils;

import com.mltech.utils.Command;

public class CommandTest {
	public static void main(String[] args) throws Exception {

		//Command c = new Command("perl",	"/data/projects/mlt_alignment/Aligner/lib/perl/align.pl");
		Command c = new Command("sh");
		//Command c = new Command("/data/moses/src/software/smt_moses/trunk/build/apps/MosesApp", "-f", "/data/projects/smt_web_service/conf/moses/moses_zh-en.ini");
//		System.out.println(c.exec("将 成 发 展 障 碍"));
//		System.out.println(c.exec("sss s"));
		System.out.println(c.exec("ls"));
		System.out.println(c.exec("pwd"));
	}
}
