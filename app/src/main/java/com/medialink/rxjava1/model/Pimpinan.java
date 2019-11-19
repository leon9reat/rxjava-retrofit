package com.medialink.rxjava1.model;

import com.google.gson.annotations.SerializedName;

public class Pimpinan{

	@SerializedName("id_pimpinan")
	private int idPimpinan;

	@SerializedName("nm_pimpinan")
	private String nmPimpinan;

	@SerializedName("jabatan")
	private String jabatan;

	public void setIdPimpinan(int idPimpinan){
		this.idPimpinan = idPimpinan;
	}

	public int getIdPimpinan(){
		return idPimpinan;
	}

	public void setNmPimpinan(String nmPimpinan){
		this.nmPimpinan = nmPimpinan;
	}

	public String getNmPimpinan(){
		return nmPimpinan;
	}

	public void setJabatan(String jabatan){
		this.jabatan = jabatan;
	}

	public String getJabatan(){
		return jabatan;
	}

	@Override
 	public String toString(){
		return 
			"Pimpinan{" + 
			"id_pimpinan = '" + idPimpinan + '\'' + 
			",nm_pimpinan = '" + nmPimpinan + '\'' + 
			",jabatan = '" + jabatan + '\'' + 
			"}";
		}
}