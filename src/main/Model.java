package main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
		System.out.println("---------------------------------------------------------- END \n");
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
	
	public void insertPhong(String ten, String loai) {
		
		Map<String, Object> phong =  new HashMap< String, Object>(); 
		phong.put("ten", ten); 
		phong.put("loai", loai); 
		
		
		
		Document doc = new Document(phong);
		this.collectionPhong.insertOne(doc);
	}
	
	public void insertNguoiThue(String id_phong, String  ten, String namSinh, String queQuan, String cmt, int soNguoi, boolean wifi) {
		Map<String, Object> nguoiThue =  new HashMap< String, Object>();
		nguoiThue.put("id_phong", id_phong);
		nguoiThue.put("ten", ten);
		nguoiThue.put("namsinh", namSinh);
		nguoiThue.put("quequan", queQuan);
		nguoiThue.put("cmt", cmt);
		nguoiThue.put("songuoi", soNguoi);
		nguoiThue.put("wifi", wifi);
		
		Document doc = new Document(nguoiThue);
		this.collectionPhong.insertOne(doc);
		
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

	public Phong(String ten) {
		Model model = new Model();
		Bson bsonFilter = Filters.eq("ten", ten);
		FindIterable<Document> phong = model.getCollectionPhong().find(bsonFilter);
		if (phong.first() != null) {
			this.id_phong = phong.first().get("_id").toString();
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
	public void close() {
		this.model.close();
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
	private Model model;

	@SuppressWarnings("deprecation")
	public NguoiThue(String id_phong) {
		model = new Model();
		Bson bsonFilter = Filters.eq("id_phong", id_phong);
		FindIterable<Document> nguoiThue = model.getCollectionNguoiThue().find(bsonFilter);
		
		if (nguoiThue.first() != null) {

			this.ten = nguoiThue.first().get("ten").toString();
			this.queQuan = nguoiThue.first().get("quequan").toString();
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
	public void close() {
		this.model.close();
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

	public void setData(String ten) {
		Phong phong = new Phong(ten);
		NguoiThue nguoiThue = new NguoiThue(phong.getId_phong());

		this.idPhong = phong.getId_phong();
		this.tenPhong = phong.getTen();
		this.loai = phong.getLoai();
		this.tenNguoiThue = nguoiThue.getTen();
		this.queQuan = nguoiThue.getQueQuan();
		this.namSinh = nguoiThue.getNamSinh();
		this.cmt = nguoiThue.getCmt();
		this.soNguoi = nguoiThue.getSoNguoi();
		this.wifi = nguoiThue.isWifi();
		phong.close();
		nguoiThue.close();
	}

	public String[] getListTenPhong() {

		List<String> list = new ArrayList<String>();

		MongoCursor<Document> cursor = model.getCollectionPhong().find().iterator();
		try {
			while (cursor.hasNext()) {
				list.add((String) cursor.next().get("ten"));
			}
		} finally {
			cursor.close();
		}

		String[] a = list.toArray(new String[0]);
		Arrays.parallelSort(a);
		return a;
	}
	
	public String[] getListCmt() {

		List<String> list = new ArrayList<String>();

		MongoCursor<Document> cursor = model.getCollectionNguoiThue().find().iterator();
		try {
			while (cursor.hasNext()) {
				list.add((String) cursor.next().get("cmt"));
			}
		} finally {
			cursor.close();
		}

		String[] a = list.toArray(new String[0]);
		Arrays.parallelSort(a);
		return a;
	}
	
	public String[] getNotExistUserListTenPhong() {
		List<String> list = new ArrayList<String>();

		MongoCursor<Document> cursor = model.getCollectionPhong().find().iterator();
		try {
			while (cursor.hasNext()) {
				String ten = (String) cursor.next().get("ten");
				Data data = new Data();
				data.setData(ten);
				if (data.getTenNguoiThue() == null)
					list.add(ten);
			}
		} finally {
			cursor.close();
		}
		String[] a = list.toArray(new String[0]);
		Arrays.parallelSort(a);
		return a;
	}
	public void insertPhong(String ten, String loai) {
		model.insertPhong(ten, loai);
	}
	
	public void insertNguoiThue(String id_phong, String  ten, String namSinh, String queQuan, String cmt, int soNguoi, boolean wifi) {
		model.insertNguoiThue(id_phong, ten, namSinh, queQuan, cmt, soNguoi, wifi);
	}
	
	public void close() {
		this.model.close();
	}
	
	private boolean distinct(String a[], String b) {
		int i = 0;
		while (i < a.length) {
			if (a[i].equals(b))
				return false;
			i++;
		}
		
		return true;
	}
	
	public String[] getListLoaiPhong() {

		List<String> list = new ArrayList<String>();

		MongoCursor<Document> cursor = model.getCollectionPhong().find().iterator();
		try {
			while (cursor.hasNext()) {
				String[] a = list.toArray(new String[0]);
				String b = (String) cursor.next().get("loai");
				
				if (distinct(a, b))
					list.add(b);
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
