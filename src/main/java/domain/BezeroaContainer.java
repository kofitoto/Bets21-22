package domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType; 

@XmlAccessorType(XmlAccessType.FIELD) 
public class BezeroaContainer {
	
	private Bezeroa bezeroa; 
	private ArrayList<ArretaElkarrizketa> elkarrizketak; 
	
	public BezeroaContainer(Bezeroa b) {
		bezeroa=b;
		elkarrizketak=b.getArretaElkarrizketak(); 
    }
	
	public BezeroaContainer() {
		bezeroa=null;
		elkarrizketak=new ArrayList<>();
	}

	public Bezeroa getBezeroa() {
		return bezeroa;
	}

	public void setBezeroa(Bezeroa bezeroa) {
		this.bezeroa = bezeroa;
	}

	public ArrayList<ArretaElkarrizketa> getElkarrizketak() {
		return elkarrizketak;
	}

	public void setElkarrizketak(ArrayList<ArretaElkarrizketa> elkarrizketa) {
		this.elkarrizketak = elkarrizketa;
	}

	
}
