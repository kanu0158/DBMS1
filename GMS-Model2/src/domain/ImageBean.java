package domain;

import lombok.Data;

@Data
public class ImageBean {
	private String  imgSeq,
					imgName, 
					extension,//확장자
					userId; // 폴인키
}
