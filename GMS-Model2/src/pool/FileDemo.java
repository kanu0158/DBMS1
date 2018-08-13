package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



//lombok이 이너클래스에 잘 안 먹는 버그가 있어 주의!
public class FileDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String PATH = "C:\\Users\\1027\\Documents\\sample.txt";//업로드할 파일 위치
												//파일 업로드하고 나면 경로 앞부분은 의미없으니 
												//DB에는 sample 하고 txt만 쪼개서 저장됨
		try {
			File file = new File(PATH);
			FileWriter fw = new FileWriter(file, true);//true면 이어쓰기, false면 덮어쓰기
			FileReader fr = new FileReader(file);//true면 이어쓰기, false면 덮어쓰기
			
			BufferedWriter writer = new BufferedWriter(fw);
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				System.out.println("[메뉴] 1.전송 2.읽기 0.종료");
				switch (sc.next()) {
				case "1":
					System.out.println("메시지 입력");
					writer.write(sc.next());
					writer.newLine();
					writer.flush();
					break;
				case "2":
					System.out.println("메시지 보기");
					String msg = "";
					while((msg = reader.readLine()) != null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				case "0":
					System.out.println("종료되었습니다.");
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {e.printStackTrace();}
		
		
		FileName fn = new FileName(PATH);
		System.out.println("파일명 : " + fn.getfileName());
		System.out.println("확장자 : " + fn.getExt());
	}
}

class FileName {// inner클래스, 안드로이드에선 이걸로 코딩을 많이 해(트렌드가 one클래스로 끝내는 것)
	// inner클래스는 public을 갖지 않는다. 이유는 이 클래스 내부에서만 사용하고자 함이다.
	// 만약 다른 곳에서 계속 사용한다면 독립시켜야 한다.
	// 1회용 사용 클래스라고 생각하면 된다.
	private String path,
			sep, // / 리눅스에선 / \ 이런게 깨지는 경우가 있어서(환경에 따라) 변수로 처리해
			ext, // .
			fileName; 

	public FileName(String path) {// 특수기능들은 디폴트생성자를 따로 안쓴다?
		this.path = path;
		this.sep = File.separator;  // 현재 윈도우상에서 서버 올리니 "\"
		//this.fileName = "?";							// 리눅스에선 또 다른값이 나옴
		this.fileName = path.substring(path.lastIndexOf(sep)+1,path.lastIndexOf("."));
		this.ext = path.substring(path.lastIndexOf(".")+1);
		//indexOf(".")은 ./1027/document/...  이렇게 상대경로로 마주칠수있어서 lastIndexOf를 사용해라
		//방어코드, 방지코드
		//this.ext = path.split("\\.")[1]; 
	}
	public String getfileName() {
		return this.fileName;
	}

	public String getPath() {
		return this.path;
	}
	public String getExt() {
		return this.ext;
	}
}
