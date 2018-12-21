package com.apachepoi.utils;

import java.io.File;
import java.nio.file.Files;

public class ReadFile {
	
	/*
	 *
	 *	Arquivo Notas.xls em Resources
	 *
	 */
	public static File getFile() throws Exception{
		String fileName = "Notas.xls";
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		 
		File file = new File(classLoader.getResource(fileName).getFile());
		
		return file;
	}
}
