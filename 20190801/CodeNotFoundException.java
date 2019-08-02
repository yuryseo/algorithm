package Product;

public class CodeNotFoundException extends Exception {

	public CodeNotFoundException() {
		super("등록되지 않은 제품 번호입니다");
	}
	public CodeNotFoundException(String msg) {
		super(msg);
	}
}
