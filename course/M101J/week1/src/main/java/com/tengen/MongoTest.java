package com.tengen;


import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MongoTest {
	public static void main(String arg[]) throws UnknownHostException 
	{
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
		DB database = client.getDB("course");
		DBCollection coll = database.getCollection("collection");
		DBObject document = coll.findOne();
		System.out.println(document);
	}

}