package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Author;
import model.Customer;
import model.Genre;

public class Genre_Inter_DAO implements Interface_DAO<Genre> {

	@Override
	public ArrayList<Genre> selectAll() {
		ArrayList<Genre> result = new ArrayList<Genre>();
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from genre";
			PreparedStatement pst = con.prepareStatement(sql);

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String genreCode = rs.getString("genre_code");
				String nameOfGenre = rs.getString("name_of_genre");

				Genre genre = new Genre(genreCode, nameOfGenre);
				result.add(genre);
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
	public Genre selectById(Genre t) {
		Genre result = null;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from genre where genre_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getGenreCode());

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String genreCode = rs.getString("genre_code");
				String nameOfGenre = rs.getString("name_of_genre");

				result = new Genre(genreCode, nameOfGenre);
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
	public int insert(Genre t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "insert into genre (genre_code, name_of_genre)" + "value (?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getGenreCode());
			pst.setString(2, t.getNameOfGenre());

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
	public int insertAll(ArrayList<Genre> arr) {
		int count = 0;
		for (Genre genre : arr) {
			count += this.insert(genre);
		}
		return count;
	}

	@Override
	public int delete(Genre t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "delete from genre where genre_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getGenreCode());

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
	public int deleteAll(ArrayList<Genre> arr) {
		int count = 0;
		for (Genre genre : arr) {
			count += this.delete(genre);
		}
		return count;
	}

	@Override
	public int update(Genre t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "update genre " 
				+ " set " 
				+ " name_of_genre = ?"
				+ " where genre_code = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getGenreCode());
			pst.setString(2, t.getNameOfGenre());

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

}
