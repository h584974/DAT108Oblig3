package handleliste;

public class EscapeHTML {
	
	public static String escape(String text) {
		text = text.replaceAll("<", "&lt;");
		text = text.replaceAll(">", "&gt;");
		text = text.replaceAll("=", "&#61;");
		text = text.replaceAll("\"", "&quot;");
		return text;
	}

}