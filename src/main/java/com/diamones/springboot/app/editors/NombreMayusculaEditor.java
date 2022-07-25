package com.diamones.springboot.app.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusculaEditor extends PropertyEditorSupport {

	public void setAsText(String text) throws IllegalArgumentException{
		
		setValue(text.toUpperCase().trim());
	}
}
