package model;

import java.util.Objects;

public class Genre {
	private String genreCode;
	private String nameOfGenre;
	
	
	public Genre() {
	}


	public Genre(String genreCode, String nameOfGenre) {
		this.genreCode = genreCode;
		this.nameOfGenre = nameOfGenre;
	}


	public String getGenreCode() {
		return genreCode;
	}


	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}


	public String getNameOfGenre() {
		return nameOfGenre;
	}


	public void setNameOfGenre(String nameOfGenre) {
		this.nameOfGenre = nameOfGenre;
	}


	@Override
	public int hashCode() {
		return Objects.hash(genreCode);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(genreCode, other.genreCode);
	}
	
	

}
