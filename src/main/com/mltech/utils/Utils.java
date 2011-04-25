package com.mltech.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public final class Utils {
	public static String cwd() {
		String cwd = null;
		File dir = new File(".");
		try {
			cwd = dir.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cwd;
	}

	public static String fileToString(URL path) {
		BufferedReader br;
		String text = "";
		try {
			br = new BufferedReader(new FileReader(path.getPath()));
			String line;
			while ((line = br.readLine()) != null) {
				text += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
}
