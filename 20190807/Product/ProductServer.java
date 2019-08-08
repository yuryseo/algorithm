package Product;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProductServer {

	public static void main(String[] args) {
		//private Socket socket;
		List<Product> list = new ArrayList<>();

		ServerSocket ss = null;
		try {
			ss = new ServerSocket(1234);
			while (true) {
				Socket s = ss.accept();
				String fileName = s.getInetAddress().toString().substring(1) + "Object.txt";
				System.out.println("클라이언트" + s.getInetAddress() + "접속");
				FileOutputStream fos = null;
				ObjectOutputStream oos = null;
				ObjectInputStream ois = null;

				try {
					ois = new ObjectInputStream(s.getInputStream());
					fos = new FileOutputStream(fileName);

					oos = new ObjectOutputStream(fos);
					list = (ArrayList<Product>) ois.readObject();
					oos.writeObject(list);
					for(Product p:list) {
						System.out.println(list);
					}
					//System.out.println(list);
					// System.out.println(ois.readObject());

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					IOUtil.close(ois);
					IOUtil.close(fos);
					IOUtil.close(oos);
					IOUtil.close(s);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			IOUtil.close(ss);
		}
	}

}
