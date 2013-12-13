package br.unb.vvs.uiautomator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StringGetter {

    public static String getString(String property) {
    	Properties props = new Properties();
    	
    	String language = java.util.Locale.getDefault().getLanguage();
    	String contry = java.util.Locale.getDefault().getCountry();
    	
    	String fileName = "strings_" + language + "-" + contry + ".properties";
    	
    	File temp = new File("/data/local/tmp/" + fileName);
    	InputStream input = null;
		
    	try {
			input = new FileInputStream(temp);
			props.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("Erro leitura do arquivo de propriedades: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro leitura do arquivo de propriedades: " + e.getMessage());
		}
    	
    	return props.getProperty(property);
    }
}