package com.example.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.util.DBUtil;

@WebServlet("/AddTitleServlet")
public class AddTitleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String mediaType = request.getParameter("mediaType");
        String newFlagParam = request.getParameter("newFlag");
        boolean newFlag = "true".equals(newFlagParam);

        String sql = "INSERT INTO タイトルマスタ (タイトルID, タイトル, ジャンル, メディアタイプ, 新作フラグ) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, genre);
            pstmt.setString(4, mediaType);
            pstmt.setBoolean(5, newFlag);

            pstmt.executeUpdate();
            request.setAttribute("message", "タイトルが正常に追加されました。");
        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) {
                request.setAttribute("message", "エラー: タイトルIDが既に登録されています。");
            } else {
                throw new ServletException("データベースエラーが発生しました。", e);
            }
        }

        // 結果ページにリダイレクト
        request.getRequestDispatcher("result_media.jsp").forward(request, response);
    }
}
