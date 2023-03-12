package database;

import java.util.ArrayList;

import model.Author;

public class Author_DAO {
	private ArrayList<Author> data = new ArrayList<Author>();

	public ArrayList<Author> selectAll() {
		return data;
	}

	public Author selectById(String id) {
		Author search = new Author();
		search.setAuthorCode(id);

		for (Author author : data) {
			if (author.equals(search)) {
				return author;
			}
		}
		return null;
	}

	public int insert(Author au) {
		Author existedCheck = this.selectById(au.getAuthorCode());
		if (existedCheck == null) {
			data.add(au);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<Author> list) {
		int count = 0;
		for (Author author : list) {
			count += this.insert(author);
		}
		return count;
	}

	public int delete(Author au) {
		Author existedCheck = this.selectById(au.getAuthorCode());
		if (existedCheck != null) {
			data.remove(au);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int deleteAll(ArrayList<Author> list) {
		int count = 0;
		for (Author author : list) {
			Author existedCheck = this.selectById(author.getAuthorCode());
			if (existedCheck != null) {
				data.remove(author);
				count++;
			}
		}
		return count;
	}

	public int update(Author au) {
		Author existedCheck = this.selectById(au.getAuthorCode());
		if (existedCheck != null) {
			data.remove(existedCheck);
			data.add(au);
			return 1;
		} else {
			return 0;
		}
	}

}
