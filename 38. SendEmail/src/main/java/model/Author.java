package model;

import java.sql.Date;
import java.util.Objects;

public class Author {
	private String authorCode;
	private String fullName;
	private Date dateOfBirth;
	private String bio;

	public Author() {
	}

	public Author(String authorCode, String fullName, Date dateOfBirth, String bio) {
		this.authorCode = authorCode;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.bio = bio;
	}

	public String getAuthorCode() {
		return authorCode;
	}

	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(authorCode, other.authorCode);
	}

	@Override
	public String toString() {
		return "Author [authorCode=" + authorCode + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", bio="
				+ bio + "]";
	}
}
