package Product;

public class DuplicateException extends Exception {

	public DuplicateException() {
		super("이미 등록된 제품번호 입니다");
	}
	public DuplicateException(String msg) {
		super(msg);
	}
}
