package database;

import java.util.ArrayList;

import model.Genre;

public class Genre_Inter_DAO implements Interface_DAO<Genre> {
	private ArrayList<Genre> data = new ArrayList<Genre>();

	@Override
	public ArrayList<Genre> selectAll() {
		return this.data;
	}

	@Override
	public Genre selectById(Genre t) {
		for (Genre genre : data) {
			if (data.equals(t))
				return genre;
		}
		return null;
	}

	@Override
	public int insert(Genre t) {
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Genre> arr) {
		int count = 0;
		for (Genre genre : arr) {
			count += this.insert(genre);
		}
		return count;
	}

	@Override
	public int delete(Genre t) {
		if (this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Genre> arr) {
		int count = 0;
		for (Genre genre : arr) {
			count += this.delete(genre);
		}
		return count;
	}

	@Override
	public int update(Genre t) {
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}
