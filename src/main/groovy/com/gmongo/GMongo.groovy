

/*
Copyright 2010 Paulo Poiati

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.gmongo

import java.util.List;

import com.mongodb.MongoOptions
import com.mongodb.ServerAddress
import com.mongodb.Mongo
import com.mongodb.DB
import com.mongodb.DBAddress
import com.mongodb.MongoURI

import com.gmongo.internal.DBPatcher

class GMongo extends Mongo {
	
/*  @Delegate
  Mongo mongo*/
	
	static DB connect(DBAddress addr) {
println "here"	  
	  def db = Mongo.connect(addr)
		patchAndReturn db
	}

	GMongo(Mongo mongo) {
	  throw new RuntimeException("not really supported")
//		this.mongo = mongo
	}
	
	GMongo() {
		super()
	}
	
	GMongo(ServerAddress addr) {
		super(addr)	  
//		this.mongo = new Mongo(addr)
	}
	
	GMongo(MongoURI uri) {
	  super(uri)
	}  
	
	GMongo(ServerAddress addr, MongoOptions opts) {
	  super(addr,opts)
//		this.mongo = new Mongo(addr, opts)
	}
	
	GMongo(ServerAddress left, ServerAddress right) {
	  super(left, right)
//		this.mongo = new Mongo(left, right)
	}
	
	GMongo(ServerAddress left, ServerAddress right, MongoOptions opts) {
	  super(left, right, opts)
//		this.mongo = new Mongo(left, right, opts)
	}
	
	GMongo(String host) {
	  super(host)
//		this.mongo = new Mongo(host)
	}
	
	GMongo(String host, Integer port) {
	  super(host,port)
//		this.mongo = new Mongo(host, port)
	}
	
	GMongo(String host, MongoOptions opts) {
	  super(host, opts)
	//	this.mongo = new Mongo(host, opts)
	}
	
	GMongo(List<ServerAddress> replicaSetSeeds, MongoOptions options ) {
	  super(replicaSetSeeds, options)
//		this.mongo = new Mongo(replicaSetSeeds, opts)
	}
	
	GMongo( List<ServerAddress> replicaSetSeeds) {
	  super(replicaSetSeeds)
//		this.mongo = new Mongo(replicaSetSeeds)
	}
	
	DB getDB(String name) {
	  def db = super.getDB(name)
	  patchAndReturn db
		//patchAndReturn mongo.getDB(name)
	}
	
	static private patchAndReturn(db) {
		DBPatcher.patch(db); return db
	}
}