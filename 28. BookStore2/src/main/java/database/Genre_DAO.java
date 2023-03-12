package database;

import java.util.ArrayList;

import model.Genre;

public class Genre_DAO {
	private ArrayList<Genre> data = new ArrayList<Genre>();

	public ArrayList<Genre> selectAll() {
		return data;
	}

	public Genre selectById(String id) {
		Genre search = new Genre();
		search.setGenreCode(id);
		
		for (Genre genre : data) {
			if (genre.equals(search)) {
				return genre;
			}
		}
		return null;
	}

	public int insert(Genre gen) {
		Genre existedCheck = this.selectById(gen.getGenreCode());
		if (existedCheck == null) {
			data.add(gen);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<Genre> list) {
		int count = 0;
		for (Genre genre : list) {
			count += this.insert(genre);
		}
		return count;
	}

	public int delete(Genre gen) {
		Genre existedCheck = this.selectById(gen.getGenreCode());
		if (existedCheck != null) {
			data.remove(gen);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int deleteAll(ArrayList<Genre> list) {
		int count = 0;
		for (Genre genre : list) {
			Genre existedCheck = this.selectById(genre.getGenreCode());
			if (existedCheck != null) {
				data.remove(genre);
				count++;
			}
		}
		return count;
	}

	public int update(Genre gen) {
		Genre existedCheck = this.selectById(gen.getGenreCode());
		if (existedCheck != null) {
			data.remove(existedCheck);
			data.add(gen);
			return 1;
		} else {
			return 0;
		}
	}

}
