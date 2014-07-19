package org.dario.morracinese.platform;

import java.awt.Image;

public class Element {
//	PIETRA, CARTA, FORBICI, LUCERTOLA, SPOCK
	
	private String name;
	private Image icon;
	
	public Element(String name){
		this.name=name;
	}
	
	public Element(String name, Image icon){
		this(name);
		setIcon(icon);
	}
	
	public void setIcon(Image icon){
		this.icon=icon;
	}
	
	public Image getIcon(){
		return icon;
	}
	
	public String toString(){
		return name;
	}
	
}
