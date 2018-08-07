package proxy;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Pagination implements Proxy {
	int pageNumber, pageSize, blockSize, 
		count, pageCount, blockCount, 
		beginRow, endRow, beginPage, 
		endPage, prevBlock,	nextBlock;
	boolean existPrev, existNext;

	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow); // int - > Integer로 바뀜
		map.put("endRow", endRow);
		return map;
	}
}
