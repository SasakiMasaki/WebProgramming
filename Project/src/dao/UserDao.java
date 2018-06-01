package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;

public class UserDao {

	public User findByLoginInfo(String loginId, String prePassword){
		Connection con = null;
		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";
		String password = null;
		try {
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(prePassword.getBytes(charset));
			password = DatatypeConverter.printHexBinary(bytes);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}

		try {
			con = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
			}
		}
	}


	public List<User> findAll(){
		Connection con = null;
		List<User> userList = new ArrayList<User>();

		try {
			con = DBManager.getConnection();

			String sql = "select * from user where id != 1";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");

				User user = new User(id,loginId,name,birthDate,password,createDate,updateDate);
				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public List<User> serchUser(String preLoginId, String preName, String firstDate, String lastDate){
		Connection con = null;
		List<User> userList = new ArrayList<User>();

		try {
			con = DBManager.getConnection();

			String sql = "select * from user where ";
			List<String> key = new ArrayList<String>();

			if(!preLoginId.equals("")) {
				sql = sql + "login_id = ?";
				key.add(preLoginId);
			}
			if(!preName.equals("")) {
				if(key != null) {
					sql = sql + "and";
				}
				sql = sql + "name = ?";
				key.add(preName);
			}
			if(!firstDate.equals("")) {
				if(key != null) {
					sql = sql + "and";
				}
				sql = sql + "birth_date >= ?";
				key.add(firstDate);
			}
			if(!lastDate.equals("")) {
				if(key != null) {
					sql = sql + "and";
				}
				sql = sql + "birth_date <= ?";
				key.add(lastDate);
			}

			PreparedStatement pStmt = con.prepareStatement(sql);

			for(int i = 0; i < key.size();i++) {
				pStmt.setString(i + 1, key.get(i));
			}

			ResultSet rs = pStmt.executeQuery();


			while(rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");

				User user = new User(id,loginId,name,birthDate,password,createDate,updateDate);
				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}


	public User findListByLoginId(String LoginId){
		Connection con = null;
		User user = null;

		try {
			con = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ?";

			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, LoginId);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			int id = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");

			user = new User(id,loginId,name,birthDate,password,createDate,updateDate);

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return user;
	}



	public List<User> findListByName(String Name){
		Connection con = null;
		List<User> userList = new ArrayList<User>();

		try {
			con = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE name like ?";

			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, "%" + Name + "%");
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");

				User user = new User(loginId,name,birthDate);
				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public List<User> findListByDate(String firstDate, String lastDate){
		Connection con = null;
		List<User> userList = new ArrayList<User>();

		try {
			con = DBManager.getConnection();

			String sql;
			PreparedStatement pStmt;

			if(!firstDate.equals("")) {
				sql = "select * from user where birth_date >= ?";
				pStmt = con.prepareStatement(sql);
				pStmt.setString(1, firstDate);
				if(!lastDate.equals("")) {
					sql = "select * from user where birth_date >= ? and birth_date <= ?";
					pStmt = con.prepareStatement(sql);
					pStmt.setString(1, firstDate);
					pStmt.setString(2, lastDate);
				}
			}else {
				sql = "select * from user where birth_date <= ?";
				pStmt = con.prepareStatement(sql);
				pStmt.setString(1, lastDate);
				if(lastDate.equals("")) {
					return null;
				}
			}

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");

				User user = new User(loginId,name,birthDate);
				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public int addUser(String loginId, String name, String birthDate, String prePassword){
		Connection con = null;

		try {
			con = DBManager.getConnection();
			Charset charset = StandardCharsets.UTF_8;
			String algorithm = "MD5";
			String password = null;
			try {
				byte[] bytes = MessageDigest.getInstance(algorithm).digest(prePassword.getBytes(charset));
				password = DatatypeConverter.printHexBinary(bytes);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}


			String sql = "insert into user(login_id,name,birth_date,password,create_date,update_date) values(?,?,?,?,now(),now())";

			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, name);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, password);
			int result = pStmt.executeUpdate();


			return result;

		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return -1;
                }
			}
		}
	}
	public int updateUser(String loginId, String name, String birthDate, String password){
		Connection con = null;

		try {
			con = DBManager.getConnection();

			if(password.equals("")) {
				String sql = "update user set name = ?, birth_date = ?, update_date = now() where login_id = ?";

				PreparedStatement pStmt = con.prepareStatement(sql);
				pStmt.setString(1, name);
				pStmt.setString(2, birthDate);
				pStmt.setString(3, loginId);
				int result = pStmt.executeUpdate();

				return result;
			}

			String sql = "update user set name = ?, birth_date = ?, password = ?, update_date = now() where login_id = ?";

			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birthDate);
			pStmt.setString(3, convertMd5(password));
			pStmt.setString(4, loginId);
			int result = pStmt.executeUpdate();


			return result;

		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return -1;
                }
			}
		}
	}





	public void deleteUser(String loginId){
		Connection con = null;

		try {
			con = DBManager.getConnection();

			String sql = "delete from user where login_id = ?";

			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, loginId);
			int result = pStmt.executeUpdate();


		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
			}
		}
	}

	private String convertMd5(String password) {
		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";
		String result = null;
		try {
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
			result = DatatypeConverter.printHexBinary(bytes);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		return result;
	}
}
