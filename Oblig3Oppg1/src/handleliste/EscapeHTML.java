package handleliste;

public class EscapeHTML {
	
	// Escaper noen html tegn, men ignorer norske bokstaver, ettersom dette ble feil når lagret i database
	// ved bruk av StringEscapeUtils
	public static String escape(String text) {
		text = text.replaceAll("<", "&lt;");
		text = text.replaceAll(">", "&gt;");
		text = text.replaceAll("=", "&#61;");
		text = text.replaceAll("\"", "&quot;");
		return text;
	}

}