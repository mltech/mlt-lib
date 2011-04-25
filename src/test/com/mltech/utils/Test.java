package com.mltech.utils;

import java.io.*;

public class Test {
	public static void main(String[] sArgs) throws Exception {
		// Process process = (Runtime.getRuntime()).exec("xterm"); //linux
		Process process = (Runtime.getRuntime()).exec("perl /data/projects/mlt_alignment/Aligner/lib/perl/align.pl"); // windows

		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		PrintStream printer = new PrintStream(process.getOutputStream());

		printer.println("ls");
		printer.flush();

		String line;
		boolean ready = true;
		while (ready && (line = reader.readLine()) != null)
		{
			System.out.println("# " + reader.ready());
			System.out.println(line);
			//ready = reader.ready();
		}

		
		printer.println("xx");
		printer.flush();
		ready = true;
		while (ready && (line = reader.readLine()) != null)
		{
			System.out.println("# " + reader.ready());
			System.out.println(line);
			//ready = reader.ready();
		}

System.out.println("llllllllllllll");
	}
}