
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

class FileRecord{
	public void setData(persons obj)throws IOException,FileNotFoundException,ClassNotFoundException{
		var out_stream = new ObjectOutputStream(
			new FileOutputStream(
				"../user_info_file/javaDoc_1.txt"));
		out_stream.writeObject(obj);
	}
	public  persons getData()throws IOException,FileNotFoundException,ClassNotFoundException{
		var in_stream = new ObjectInputStream(
			new FileInputStream(
				"../user_info_file/javaDoc_1.txt"));
		var obj2 = (persons)in_stream.readObject();
		return obj2;
	}
	
	public static void main(String arhs[])throws IOException,FileNotFoundException,ClassNotFoundException {
		persons obj = new persons();
		FileRecord obj_x = new FileRecord();
		obj_x.setData(obj);
	}
}
