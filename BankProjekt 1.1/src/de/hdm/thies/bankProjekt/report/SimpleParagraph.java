package de.hdm.thies.bankProjekt.report;

import java.io.Serializable;

/**
 * Diese Klasse stellt einzelne Absätze dar. Der Absatzinhalt wird als String
 * gespeichert. Der Anwender sollte in diesem Strinig keinerlei Formatierungssymbole
 * einfügen, da diese in der Regel zielformatspezifisch sind.
 * 
 * @author Thies
 */
public class SimpleParagraph extends Paragraph implements Serializable {

	/**
	 * Inhalt des Absatzes.
	 */
	private String text = "";

	/**
	 * Dieser Konstruktor ermöglicht es, bereits bei Instantiierung von 
	 * <code>SimpleParagraph</code>-Objekten deren Inhalt angeben zu können.
	 * 
	 * @param value der Inhalt des Absatzes
	 */
	public SimpleParagraph(String value) {
		this.text = value;
	}

	/**
	 * Auslesen des Inhalts.
	 * 
	 * @return Inhalt als String
	 */
	public String getText() {
		return text;
	}

	/**
	 * Überschreiben des Inhalts.
	 * 
	 * @param text der neue Inhalt des Absatzes.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Umwandeln des <code>SimpleParagraph</code>-Objekts in einen String.
	 */
	public String toString() {
		return this.text;
	}
}
