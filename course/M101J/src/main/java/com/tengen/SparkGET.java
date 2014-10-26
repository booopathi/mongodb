package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkGET
{
	public static void main(String args[])
	{
		Spark.get("/", new Route() {
			
			public Object handle(Request arg0, Response arg1) {
				return "/";
			}
		});
		
		Spark.get("/test", new Route() {
			
			public Object handle(Request arg0, Response arg1) {
				return "/test";
			}
		});
		Spark.get("/echo/:id", new Route() {
			public Object handle(Request arg0, Response arg1) {
				String id = arg0.params(":id"); 
				return id;
			}
		});
	}
}