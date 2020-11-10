package model;

public class miRDBModel implements Model {    
    private String mirna;
    private String geneName;
	private String score;
    private String species;
	public String getMirna() {
		return mirna;
	}
	public void setMirna(String mirna) {
		this.mirna = mirna;
	}
	public String getGeneName() {
		return geneName;
	}
	public void setGeneName(String geneName) {
		this.geneName = geneName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	@Override
	public String toString() {
		return "miRDBModel [mirna=" + mirna + ", geneName=" + geneName + ", score=" + score + ", species=" + species
				+ "]";
	}
	public miRDBModel(String mirna, String geneName, String score, String species) {
		super();
		this.mirna = mirna;
		this.geneName = geneName;
		this.score = score;
		this.species = species;
	}
            

    }
