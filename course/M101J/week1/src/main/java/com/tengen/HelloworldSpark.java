package com.tengen;

import java.net.UnknownHostException;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;


public class HelloworldSpark {

    public static void main(String[] args) throws UnknownHostException {
        Spark.get("/", new Route() {
			public Object handle(Request arg0, Response arg1) {
				// TODO Auto-generated method stub
				return "Hello World!";
			}
		});
    }
}
