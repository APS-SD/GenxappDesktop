package model;

public class TargetScanModel implements Model {    
    private String mirna;
    private String gene_id;
	private String gene_name;
    private String score;
    private String specie;
    
	public String getMirna() {
		return mirna;
	}
	public void setMirna(String mirna) {
		this.mirna = mirna;
	}
	public String getGene_id() {
		return gene_id;
	}
	public void setGene_id(String gene_id) {
		this.gene_id = gene_id;
	}
	public String getGene_name() {
		return gene_name;
	}
	public void setGene_name(String gene_name) {
		this.gene_name = gene_name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	@Override
	public String toString() {
		return "TargetScanModel [mirna=" + mirna + ", gene_id=" + gene_id + ", gene_name=" + gene_name + ", score="
				+ score + ", specie=" + specie + "]";
	}
	public TargetScanModel(String mirna, String gene_id, String gene_name, String score, String specie) {
		super();
		this.mirna = mirna;
		this.gene_id = gene_id;
		this.gene_name = gene_name;
		this.score = score;
		this.specie = specie;
	}
            
}
