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

@WebServlet("/AddMemberServlet")
public class AddMemberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        String sql = "INSERT INTO 会員マスタ (会員ID, 氏名, 電話番号) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);

            pstmt.executeUpdate();
            // メッセージをリクエストに設定してJSPに渡す
            request.setAttribute("message", "会員が正常に追加されました。");
            request.getRequestDispatcher("result_member.jsp").forward(request, response);
        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) {
                request.setAttribute("message", "エラー: 会員IDが既に登録されています。");
                request.getRequestDispatcher("result_member.jsp").forward(request, response);
            } else {
                throw new ServletException("データベースエラーが発生しました。", e);
            }
        }
    }
}
