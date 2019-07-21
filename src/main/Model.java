package main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

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
	}

	public Phong(String loai) {
		Model model = new Model();
		Bson bsonFilter = Filters.eq("loai", loai);
		FindIterable<Document> phong = model.getCollectionPhong().find(bsonFilter);
		System.out.println(phong.first());
		if (phong.first() != null) {
			this.id_phong = phong.first().get("id_phong").toString();
			this.ten = phong.first().get("ten").toString();
			this.loai = phong.first().get("loai").toString();
		}
	}
 
	public String getId_phong() {
		return id_phong;
	}

	public void setId_phong(String id_phong) {
		this.id_phong = id_phong;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}

class NguoiThue {
	private String id_phong;
	private String ten;
	private String queQuan;
	private int namSinh;
	private String cmt;
	private int soNguoi;
	private boolean wifi;

	@SuppressWarnings("deprecation")
	public NguoiThue(String id_phong) {
		Model model = new Model();
		Bson bsonFilter = Filters.eq("id_phong", id_phong);
		FindIterable<Document> nguoiThue = model.getCollectionNguoiThue().find(bsonFilter);
		Document hihi = model.getCollectionNguoiThue().find().first();

		// this.id_phong = (String) nguoiThue.first().get("id_phong");

		if (nguoiThue.first() != null) {

			this.ten = nguoiThue.first().get("ten").toString();
			this.queQuan = nguoiThue.first().get("quequan").toString();
			System.out.println(nguoiThue.first().get("namsinh"));
			
			
			this.namSinh = (int) nguoiThue.first().get("namsinh");
			
			this.cmt = nguoiThue.first().get("cmt").toString();
			this.soNguoi = Integer.parseInt(nguoiThue.first().get("songuoi").toString());
			this.wifi = Boolean.parseBoolean(nguoiThue.first().get("wifi").toString());
		}

	}

	public String getId_phong() {
		return id_phong;
	}

	public void setId_phong(String id_phong) {
		this.id_phong = id_phong;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public int getSoNguoi() {
		return soNguoi;
	}

	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
}

class Data {
	private String idPhong;
	private String tenPhong;
	private String loai;
	private String tenNguoiThue;
	private String queQuan;
	private int namSinh;
	private String cmt;
	private int soNguoi;
	private boolean wifi;
	public Model model;

	public Data() {
		model = new Model();
	}

	public void getData(String loai) {
		Phong phong = new Phong(loai);
		NguoiThue nguoiThue = new NguoiThue(phong.getId_phong());
		
		System.out.println(phong.getId_phong());
		this.idPhong = phong.getId_phong();
		this.tenPhong = phong.getTen();
		this.loai = phong.getLoai();
		this.tenNguoiThue = nguoiThue.getTen();
		this.queQuan = nguoiThue.getQueQuan();
		this.namSinh = nguoiThue.getNamSinh();
		this.cmt = nguoiThue.getCmt();
		this.soNguoi = nguoiThue.getSoNguoi();
		this.wifi = nguoiThue.isWifi();
		
		System.out.println(this.idPhong + " lhihi");
		System.out.println(this.getTenPhong());
		System.out.println(this.getLoai());
		System.out.println(this.getTenNguoiThue());
		System.out.println(this.getQueQuan());
		System.out.println(this.getNamSinh());
		System.out.println(this.getNamSinh());
		System.out.println(this.getCmt());
		System.out.println(this.getSoNguoi());
		System.out.println(this.isWifi());
		
	}

	public String[] getPhong() {

		List<String> list = new ArrayList<String>();

		MongoCursor<Document> cursor = model.getCollectionPhong().find().iterator();
		try {
			while (cursor.hasNext()) {
				list.add((String) cursor.next().get("loai"));
			}
		} finally {
			cursor.close();
		}

		String[] a = list.toArray(new String[0]);
		Arrays.parallelSort(a);
		return a;
	}

	public String getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(String idPhong) {
		this.idPhong = idPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getTenNguoiThue() {
		return tenNguoiThue;
	}

	public void setTenNguoiThue(String tenNguoiThue) {
		this.tenNguoiThue = tenNguoiThue;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public int getSoNguoi() {
		return soNguoi;
	}

	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

}
