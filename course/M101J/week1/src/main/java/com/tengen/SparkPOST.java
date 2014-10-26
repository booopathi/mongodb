package com.tengen;

import java.io.File;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkPOST
{
	public static void main(String args[])
	{
		final Configuration config = new Configuration();
		Spark.get("/", new Route() {
			public Object handle(Request arg0, Response arg1) {
				StringWriter writter = new StringWriter();
				try{
					config.setDirectoryForTemplateLoading(new File("F:/progs/mongodb/samples/workspace/M101J/src/main/java/resources"));
					Template quizeTemp = config.getTemplate("quize.ftl");
					Map<String, Object> quizeMap = new HashMap<String, Object>();
					quizeMap.put("opts", Arrays.asList("opt1", "opt2"));
					quizeTemp.process(quizeMap, writter);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return writter;
			}
		});
		Spark.get("/result", new Route() {
			public Object handle(Request arg0, Response arg1) {
				String selValue = arg0.queryParams("opts");
				return selValue;
			}
		});
	}
}