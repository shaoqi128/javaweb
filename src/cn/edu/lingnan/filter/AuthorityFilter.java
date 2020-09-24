package cn.edu.lingnan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns="/admin/*")
public class AuthorityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//�õ��û��ĵ�¼Ȩ��
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession s = req.getSession();
		Integer flag = (Integer)s.getAttribute("usersuper");	
		System.out.println("usersuper   "+flag);
		//���ݵ�¼Ȩ��ȥ����Ӧ��ҳ��
		if(flag!=null) {
			if(flag==1)
				arg2.doFilter(arg0, arg1);
			else
				resp.sendRedirect(req.getContextPath()+"/authority.html");
		}else {
			resp.sendRedirect(req.getContextPath()+"/index.html");
		}	
	}

}
