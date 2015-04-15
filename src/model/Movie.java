package model;

public class Movie {
	
	private int id, year, rtAudienceScore;
	private String title, imdbPictureUrl, rtPictureUrl, directorId;
	
	// getter and setter methods for properties used for injection

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRtAudienceScore() {
		return rtAudienceScore;
	}

	public void setRtAudienceScore(int rtAudienceScore) {
		this.rtAudienceScore = rtAudienceScore;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImdbPictureUrl() {
		return imdbPictureUrl;
	}

	public void setImdbPictureUrl(String imdbPictureUrl) {
		this.imdbPictureUrl = imdbPictureUrl;
	}

	public String getRtPictureUrl() {
		return rtPictureUrl;
	}

	public void setRtPictureUrl(String rtPictureUrl) {
		this.rtPictureUrl = rtPictureUrl;
	}

	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}
	
	public String toString(){
		return title;
	}
}
