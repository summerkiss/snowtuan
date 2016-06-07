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
			
            // 微信加密签名  
            String signature = request.getParameter("signature");  
            System.out.println("======signature======="+signature);
            // 时间戳  
            String timestamp = request.getParameter("timestamp");  
            // 随机数  
            String nonce = request.getParameter("nonce");  
            // 随机字符串  
            String echostr = request.getParameter("echostr");  
  
            PrintWriter out = response.getWriter();  
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
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
