package enums;

public enum Mission {
	IMG, MEMBER;
	
	@Override
	public String toString() {
		String misson = "";
		switch (this) {
		case IMG:
			misson = "img";
			break;
		case MEMBER:
			misson = "member";
			break;
		}
		return misson;
	}
}
