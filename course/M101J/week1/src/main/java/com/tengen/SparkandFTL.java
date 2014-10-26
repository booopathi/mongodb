package com.tengen;

import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class SparkandFTL
{
	public static void main(String args[])
	{
		
			final Configuration config = new Configuration();
			Spark.get("/", new Route() {
				public Object handle(Request arg0, Response arg1) {
					StringWriter writter = new StringWriter();
					try{
						config.setDirectoryForTemplateLoading(new File("F:/progs/mongodb/samples/workspace/M101J/src/main/java/resources"));
						Template helloTemp = config.getTemplate("hello.ftl");
						Map<String, Object> helloMap = new HashMap<String, Object>();
						helloMap.put("name", "FTL and Spark");
						helloTemp.process(helloMap, writter);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					return writter;
				}
			});

	}
}