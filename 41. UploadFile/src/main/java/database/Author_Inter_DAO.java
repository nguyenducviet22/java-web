package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Author;

public class Author_Inter_DAO implements Interface_DAO<Author> {

	@Override
	public ArrayList<Author> selectAll() {
		ArrayList<Author> result = new ArrayList<Author>();
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from author";
			PreparedStatement pst = con.prepareStatement(sql);

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String authorCode = rs.getString("author_code");
				String fullName = rs.getString("full_name");
				Date dateOfBirth = rs.getDate("date_of_birth");
				String bio = rs.getString("bio");

				Author author = new Author(authorCode, fullName, dateOfBirth, bio);
				result.add(author);
			}

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Author selectById(Author t) {
		Author result = null;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from author where author_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getAuthorCode());

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String authorCode = rs.getString("author_code");
				String fullName = rs.getString("full_name");
				Date dateOfBirth = rs.getDate("date_of_birth");
				String bio = rs.getString("bio");

				result = new Author(authorCode, fullName, dateOfBirth, bio);
				break;
			}

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(Author t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "insert into author (author_code, full_name, date_of_birth, bio)" + "value (?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getAuthorCode());
			pst.setString(2, t.getFullName());
			pst.setDate(3, t.getDateOfBirth());
			pst.setString(4, t.getBio());

			// #3 conduct SQL command
			System.out.println(sql);
			result = pst.executeUpdate();

			// #4
			System.out.println("sql was conducted:" + sql);
			System.out.println(result + " line(s) changed");

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertAll(ArrayList<Author> arr) {
		int count = 0;
		for (Author tacGia : arr) {
			count+=this.insert(tacGia);
		}
		return count;
	}

	@Override
	public int delete(Author t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "delete from author where author_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getAuthorCode());

			// #3 conduct SQL command
			System.out.println(sql);
			result = pst.executeUpdate();

			// #4
			System.out.println("sql was conducted:" + sql);
			System.out.println(result + " line(s) changed");

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteAll(ArrayList<Author> arr) {
		int count = 0;
		for (Author tacGia : arr) {
			count+=this.delete(tacGia);
		}
		return count;
	}

	@Override
	public int update(Author t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "update author " 
				+ " set " 
				+ " full_name = ?"
				+ ", date_of_birth = ?"
				+ ", bio = ?"
				+ " where author_code = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getFullName());
			pst.setDate(2, t.getDateOfBirth());
			pst.setString(3, t.getBio());
			pst.setString(4, t.getAuthorCode());

			// #3 conduct SQL command
			System.out.println(sql);
			result = pst.executeUpdate();

			// #4
			System.out.println("sql was conducted:" + sql);
			System.out.println(result + " line(s) changed");

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		Author_Inter_DAO aid = new Author_Inter_DAO();
//		ArrayList<Author> authorRs = aid.selectAll();
//		for (Author author : authorRs) {
//			System.out.println(author.toString());
//		}
//
//		Author author = aid.selectById(new Author("A2", "", null, ""));
//		System.out.println(author);

//		Author newAuthor = new Author("A4", "Pham Van D", new Date(2001 - 1900, 04, 04), "He is an author");
//		aid.insert(newAuthor);
		
//		Author newAuthor = new Author("A4", "", null, "");
//		aid.delete(newAuthor);
		
		Author author = aid.selectById(new Author("A2", "", null, ""));
		System.out.println(author);
		author.setBio("Bio has been changed");
		aid.update(author);
		
	}
}
