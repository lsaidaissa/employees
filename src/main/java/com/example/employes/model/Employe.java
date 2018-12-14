package com.example.employes.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Employe {
	private Long id;
	private String nom;
	private String prenom;
	private double salaire;
	
	public Employe() {
		super();
	}
	public Employe(Long id, String nom, String prenom, double salaire) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
	         return false;
	     }
	     Employe employe = (Employe) obj;
	     if (this == employe) {
	         return true;
	     } else {
	    	 if (Criteria.criteria.equals("id"))
	    		 return (this.id == employe.id);
	    	 else if (Criteria.criteria.equals("nom"))
	    		 return (this.nom.equals(employe.nom));
	    	 else if (Criteria.criteria.equals("prenom"))
	    		 return (this.prenom.equals(employe.prenom));
	    	 else if (Criteria.criteria.equals("salaire"))
	    		 return (this.salaire == employe.salaire );
	     }
	     return false;
	}
	
	@Override
    public int hashCode() {
      int hashno = 7;
      if (Criteria.criteria.equals("id"))
    	  hashno = 13 * hashno + (id == 0 ? 0 : new Long(id).hashCode());
      else if (Criteria.criteria.equals("nom"))
    	  hashno = 13 * hashno + (nom == null ? 0 : nom.hashCode());
      else if (Criteria.criteria.equals("prenom"))
    	  hashno = 13 * hashno + (prenom == null ? 0 : prenom.hashCode());
      if (Criteria.criteria.equals("salaire"))
    	  hashno = 13 * hashno + (salaire == 0 ? 0 : new Double(salaire).hashCode());
      return hashno;
    }
	
	
}
