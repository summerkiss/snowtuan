package com.jxin.snow.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import com.jxin.snow.wechat.SignUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WechatServlet
 */
@WebServlet("/WechatServlet")
public class WechatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WechatServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {  
			
            // ΢�ż���ǩ��  
            String signature = request.getParameter("signature");  
            System.out.println("======signature======="+signature);
            // ʱ���  
            String timestamp = request.getParameter("timestamp");  
            // �����  
            String nonce = request.getParameter("nonce");  
            // ����ַ���  
            String echostr = request.getParameter("echostr");  
  
            PrintWriter out = response.getWriter();  
            // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��  
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
                out.print(echostr);  
            }  
            out.close();  
            out = null;  
  
        } catch (Exception e) {  
        }  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
