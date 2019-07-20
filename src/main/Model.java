package main;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

class Model {

	private MongoCollection<org.bson.Document> collectionPhong;
	private MongoCollection<org.bson.Document> collectionNguoiThue;
	private MongoClient mongo;

	public Model() {
		this.mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("QL_PhongTro");

		this.collectionPhong = database.getCollection("phong");
		this.collectionNguoiThue = database.getCollection("nguoithue");
	}

	
	public MongoCollection<org.bson.Document> getCollectionPhong() {
		return collectionPhong;
	}


	public void setCollectionPhong(MongoCollection<org.bson.Document> collectionPhong) {
		this.collectionPhong = collectionPhong;
	}


	public MongoCollection<org.bson.Document> getCollectionNguoiThue() {
		return collectionNguoiThue;
	}


	public void setCollectionNguoiThue(MongoCollection<org.bson.Document> collectionNguoiThue) {
		this.collectionNguoiThue = collectionNguoiThue;
	}


	public MongoClient getMongo() {
		return mongo;
	}


	public void setMongo(MongoClient mongo) {
		this.mongo = mongo;
	}


	public void close() {
		mongo.close();
	}
	

}

class Phong {
	private String id_phong;
	private String ten;
	private String loai;
	private Model model = new Model();

	public Phong() {
		Model model = new Model();
		MongoCursor<Document> cursor = model.getCollectionPhong().find().iterator();
		try {
		    while (cursor.hasNext()) {
		        System.out.println(cursor.next().get("loai"));
		    }
		} finally {
		    cursor.close();
		}
	}
	
	public String getPhong() {
		return "";
	}
}
