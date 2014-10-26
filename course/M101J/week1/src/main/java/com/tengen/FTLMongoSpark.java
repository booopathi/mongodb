package com.tengen;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.UnknownHostException;

import spark.HaltException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FTLMongoSpark {
	public static void main(String args[])
	{
		try
		{
			MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
			DB database = client.getDB("hello");
			final DBCollection coll = database.getCollection("hello");
			final StringWriter writter = new StringWriter();
			final Configuration config = new Configuration();
			config.setDirectoryForTemplateLoading(new File("F:/progs/mongodb/samples/workspace/M101J/src/main/java/resources"));
			Spark.get("/", new Route() {
				public Object handle(Request arg0, Response arg1) {
					try{
						DBObject helloModal = coll.findOne();
						Template helloTemp = config.getTemplate("hello.ftl");
						helloTemp.process(helloModal, writter);
						
					}
					catch(IOException ex)
					{
						ex.printStackTrace();
					}
					catch(TemplateException tex)
					{
						tex.printStackTrace();
					}
					return writter;
				}
			});
		}
		catch(UnknownHostException uhex)
		{
			uhex.printStackTrace();
		}
		catch(IOException uhex)
		{
			uhex.printStackTrace();
		}
	}
}
