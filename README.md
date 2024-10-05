Thread+Socket ứng dụng client- server đơn giản
=======================


# Thread
Thread= chạy song song (có nhiều kiểu song song)
[Điện toán song song – Wikipedia tiếng Việt](https://en.wikipedia.org/wiki/Parallel_computing#Granularity)

# Khởi tạo thread

- khởi tạo bằng "extends Thread"
	- không ghi ở đây
- khởi tạo bằng "implements Runnable"


```java
/*ở file ThreadDocDuLieuBanPhimVaGuiClient*/
public class ThreadDocDuLieuBanPhimVaGuiClient implements Runnable{
	ThreadDocDuLieubanPhimVaGuiClient(){
		//...
	}

	@Override
	public void run(){
		while(1==1){
			System.out.println("hello");
		}
	}
}

/*ở file main*/
public class ServerSock{
	public static void main(String[] args){
		Thread threadDocDuLieuBanPhimVaGuiClient = new Thread( new ThreadDocDuLieuBanPhimVaGuiClient() );
		while(1==1){
			threadDocDuLieuBanPhimVaGuiClient.start();
		}
	}
}
```


# khởi tạo thread có tham số


```java
/*ở file ThreadDocDuLieuBanPhimVaGuiClient*/
public class ThreadDocDuLieuBanPhimVaGuiClient implements Runnable{
	int thamSo1;
	int thamSo2;
	ThreadDocDuLieubanPhimVaGuiClient(int thamSo1, int thamSo2){
		this.thamSo1= thamSo1;
		this.thamSo2= thamSo2;
	}

	@Override
	public void run(){
		while(1==1){
			System.out.println("hello"+ thamSo1+ " "+ thamSo2);
		}
	}
}

/*ở file main*/
public class ServerSock{
	public static void main(String[] args){
		int thamSo1 = 50;
		int thamSo2 = 99;
		Thread threadDocDuLieuBanPhimVaGuiClient = new Thread( new ThreadDocDuLieuBanPhimVaGuiClient(50, 99) );
		while(1==1){
			threadDocDuLieuBanPhimVaGuiClient.start();
		}
	}
}
```


# khởi tạo kết nối với server và client

```java
/*ở file ServerSock*/
	ServerSocket manager1OfServer1Socket = new ServerSocket(9999);
	
	Socket server1Socket1= manager1OfServer1Socket.accept(); 
	

/*ở file ClientSock*/
	Socket client1Socket1= new Socket("127.0.0.1", 9999);
		
```


# Chạy thread

```java
/*ở file ServerSock*/
	while(true){
		// thread đọc dữ liệu client gửi về
		// thread đọc bàn phím và gửi Client
	}

/*ở file ClientSock*/
	while(true){
		// thread đọc bàn phím và gửi server
		// thread đọc dữ liệu server gửi về
	}
```


# khởi tạo luồng đọc ghi

```java
/*
	- Server có 3 luồng
		* luồng nhận dữ liệu từ client
		* đọc bàn phím và gửi
			+ luồng đọc dữ liệu từ bàn phím
			+ luồng gửi dữ liệu tới client
	- Client có 3 luồng
		* ...
		* ...
			+ ...
			+ ...
*/
```


# cấu tạo của thread đọc dữ liệu Client gửi về


```java
String idClient = server1Socket1.getInetAddress().getHostAddress();
while(true){
	String str1 = docDuLieuClientGuiVe1.readUTF();
	System.out.println("id : "+ idClient+ "; said= "+ str1);
}
```

# cấu tạo của thread đọc bàn phím và gửi Client


```java
while(true){
	String str1 = docDuLieuBanPhim1.nextLine();
	ghiDuLieuToiClient1.writeUTF(str1);
	System.out.println("ban da gui= "+ str1);
}
```
