package com.mltech.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Command {
	private ProcessBuilder _builder;
	private Process _process;
	private PrintStream _in;
	private BufferedReader _out;
	private BufferedReader _err;
	private static final String EOF = String.valueOf((char) 0);

	// TODO: handle _err stream
	public Command(Encoding encoding, String... command) throws CommandException {
		_builder = new ProcessBuilder(command);
		_builder.redirectErrorStream(true);

		try {
			_process = _builder.start();
		} catch (IOException e) {
			throw new CommandException("Unable to start process");
		}
		if (_process == null)
			throw new CommandException("No process");

		_out = new BufferedReader(new InputStreamReader(_process.getInputStream()));
		_err = new BufferedReader(new InputStreamReader(_process.getErrorStream()));
		try {
			_in = encoding == null ? new PrintStream(_process.getOutputStream()) : new PrintStream(_process.getOutputStream(), false, encoding.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		System.out.println("Command launched");
	}
	
	// TODO: handle _err stream
	public Command(String... command) throws CommandException {
		this(null, command);
	}

	public String exec(String input) throws CommandException {
		return exec(input, EOF);
	}
	
	public String exec(String input, String eofString) throws CommandException {
//		System.out.println("Exec");
			_in.println(input);
			_in.flush();

			String line;
			StringBuilder out = new StringBuilder();
			StringBuilder err = new StringBuilder();

			try {
				while ((line = _out.readLine()) != null && !line.equals(eofString)) {
					out.append(line + "\n");
//					System.out.println(":" + line);
				}
			} catch (IOException e) {
				throw new CommandException(e.getMessage());
			}
			if (out.length() > 0) out.deleteCharAt(out.length() - 1);
//			
//			try {
//				while ((line = _err.readLine()) != null && !line.equals(EOF)) {
//					err.append(line + "\n");
//				}
//				if (err.length() > 0) throw new CommandException(err.toString());
//			} catch (IOException e) {
//				throw new CommandException(e.getMessage());
//			}
			return out.toString();
	}
}
