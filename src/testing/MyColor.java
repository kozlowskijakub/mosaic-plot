package testing;

import java.awt.Color;

public class MyColor {
	private Color color;
	private String colorName;
	
	public MyColor(Color c, String cn) {
		this.color = c;
		this.colorName = cn;
		getColorName();
	}
	
	public Color getC() {
		return color;
	}
	public void setC(Color c) {
		this.color = c;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
}
