package database;

import java.util.ArrayList;

import model.Author;

public class Author_Inter_DAO implements Interface_DAO<Author> {
	private ArrayList<Author> data = new ArrayList<Author>();

	@Override
	public ArrayList<Author> selectAll() {
		return this.data;
	}

	@Override
	public Author selectById(Author t) {
		for (Author author : data) {
			if (data.equals(t))
				return author;
		}
		return null;
	}

	@Override
	public int insert(Author t) {
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Author> arr) {
		int count = 0;
		for (Author author : arr) {
			count += this.insert(author);
		}
		return count;
	}

	@Override
	public int delete(Author t) {
		if (this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Author> arr) {
		int count = 0;
		for (Author author : arr) {
			count += this.delete(author);
		}
		return count;
	}

	@Override
	public int update(Author t) {
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}
