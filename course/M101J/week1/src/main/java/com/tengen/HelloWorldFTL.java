package com.tengen;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldFTL
{
	public static void main(String args[])
	{
		Configuration config = new Configuration();
		try{
			config.setDirectoryForTemplateLoading(new File("F:/progs/mongodb/samples/workspace/M101J/src/main/java/resources"));
			Template helloTemp = config.getTemplate("hello.ftl");
			StringWriter writter = new StringWriter();
			Map<String, Object> helloMap = new HashMap<String, Object>();
			helloMap.put("name", "From FreeMarker");
			helloTemp.process(helloMap, writter);
			System.out.println(writter);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}