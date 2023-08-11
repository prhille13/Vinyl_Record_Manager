package edu.cscc.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class VinylRecord {
	public VinylRecord() {}
	
	public VinylRecord(long id, String title, String artist, String label, int releaseYear, int numTracks, int size, boolean isDamaged) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.label = label;
		this.releaseYear = releaseYear;
		this.numTracks = numTracks;
		this.size = size;
		this.isDamaged = isDamaged;	
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getNumTracks() {
		return numTracks;
	}

	public void setNumTracks(int numTracks) {
		this.numTracks = numTracks;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean getIsDamaged() {
		return isDamaged;
	}

	public void setIsDamaged(boolean isDamaged) {
		this.isDamaged = isDamaged;
	}
	
	@Size(min=2, max=50, message="Title must be between 2-50 characters.")
	@NotEmpty(message="This field cannot be left empty.")
	public String title;
	
	@Size(min=2, max=40, message="Artist must be between 2-40 characters.")
	@NotEmpty(message="This field cannot be left empty.")
	public String artist;
	
	@Size(min=2, max=40, message="Label must be between 2-40 characters.")
	@NotEmpty(message="This field cannot be left empty.")
	public String label;
	
	@Min(value=1930, message="Release date must be on or after 1930")
	public int releaseYear;
	
	@Min(value=1, message="The number of tracks must be 1 or greater")
	@Max(value=20, message="The number of tracks must be 20 or less")
	public int numTracks;
	
	public int size;
	public boolean isDamaged;
	
}
