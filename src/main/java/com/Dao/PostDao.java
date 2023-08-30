package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.User.Post;

public class PostDao {
	private Connection conn;

	public PostDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addNotes(String ti, String co, int ui) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Enotes2(title,content,uId) VALUES(?,?,?)");
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, ui);
			int ist = ps.executeUpdate();
			if (ist == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Post> getData(int id) {
		List<Post> list = new ArrayList<Post>();
		Post post = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM enotes2 WHERE uid=? order by id DESC");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				post = new Post();
				post.setId(rs.getInt(1));
				post.setTitle(rs.getString(2));
				post.setContent(rs.getString(3));
				post.setPdate(rs.getDate(4));
				list.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Post getDataById(int noteId) {
		Post p = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from enotes2 where id=?");
			ps.setInt(1, noteId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean PostUpdate(int nid, String ti, String co) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("update enotes2 set title=?, content=? where id=?");
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, nid);
			int it = ps.executeUpdate();
			if (it == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteNote(int nid) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from enotes2 where id=?");
			ps.setInt(1, nid);
			int ex = ps.executeUpdate();
			if (ex == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
