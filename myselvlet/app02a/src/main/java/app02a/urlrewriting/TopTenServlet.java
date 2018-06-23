package app02a.urlrewriting;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fatcat
 */
@WebServlet(name = "TopTenServlet", urlPatterns = { "/top10" })
public class TopTenServlet extends HttpServlet {

	private static final long serialVersionUID = -8684705064315205883L;
	private static final int PAGE_SIZE = 5;
	private static final int MAX_PAGE = 2;
	private static final String LONDON ="london";
	private static final String PARIS = "paris";

	private List<String> londonAttractions;
	private List<String> parisAttractions;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		if(city==null )
		{
			city="";
		}
		switch (city) {
		case LONDON:
		case PARIS:
			showAttractions(request, response, city);
			break;
		default:
			showMainPage(request, response);
			break;
		}

	}

	private void showAttractions(HttpServletRequest request, HttpServletResponse response, String city)
			throws IOException {
		int page = 1;
		String pageParameter = request.getParameter("page");
		if (pageParameter != null) {
			try {
				page = Integer.parseInt(pageParameter);
			} catch (NumberFormatException e) {
				// do nothing and retain default value for page
			}
			if (page > MAX_PAGE) {
				page = 1;
			}
		}
		List<String> attractions = null;
	
		switch (city) {
		case LONDON:
			attractions = londonAttractions;
			break;
		case PARIS:
			attractions=parisAttractions;
			break;
		default:
			break;
		}
		
		response.setContentType("text/html");
        response.setHeader("Content-type", "text/html;charset=UTF-8");  

		PrintWriter writer = response.getWriter();
		writer.println("<html><head>" + "<title>Top 10 Tourist Attractions</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "</head><body>");
		writer.println("<a href='top10'>Select City</a> ");
		writer.println("<hr/>Page " + page + "<hr/>");
		int start = page * PAGE_SIZE - PAGE_SIZE;
		for (int i = start; i < start + PAGE_SIZE; i++) {
			writer.println(attractions.get(i) + "<br/>");
		}
		writer.print("<hr style='color:blue'/>" + "<a href='?city=" + city + "&page=1'>Page 1</a>");
		writer.println("&nbsp; <a href='?city=" + city + "&page=2'>Page 2</a>");
		writer.println("</body></html>");
	}

	private void showMainPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head>" + "<title>Top 10 Tourist Attractions</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "</head><body>"
				+ "Please select a city:" + "<br/><a href='?city=london'>London</a>"
				+ "<br/><a href='?city=paris'>Paris</a>" + "</body></html>");
	}

	@Override
	public void init() throws ServletException {
		londonAttractions = new ArrayList<String>(10);
		londonAttractions.add("Buckingham Palace（白金汉宫）");
		londonAttractions.add("London Eye（伦敦眼）");
		londonAttractions.add("British Museum（不列颠博物馆，大英博物馆）");
		londonAttractions.add("National Gallery（英国伦敦国家美术馆）");
		londonAttractions.add("Big Ben（大本钟）");
		londonAttractions.add("Tower of London（伦敦塔）");
		londonAttractions.add("Natural History Museum（自然历史博物馆）");
		londonAttractions.add("Canary Wharf（伦敦金融区金丝雀码头）");
		londonAttractions.add("2012 Olympic Park（奥林匹克公园）");
		londonAttractions.add("St Paul's Cathedral（圣保罗大教堂）");
		parisAttractions = new ArrayList<String>(10);
		parisAttractions.add("Eiffel Tower（艾菲尔铁塔）");
		parisAttractions.add("Notre Dame（巴黎圣母院）");
		parisAttractions.add("The Louvre（卢浮宫）");
		parisAttractions.add("Champs Elysees（香榭丽舍大道）");
		parisAttractions.add("Arc de Triomphe（凯旋门）");
		parisAttractions.add("Sainte Chapelle Church（圣堂教堂，圣礼拜教堂，桑镇教堂）");
		parisAttractions.add("Les Invalides（巴黎荣军院）");
		parisAttractions.add("Musee d'Orsay（法国巴黎奥赛美术馆）");
		parisAttractions.add("Montmarte（蒙马特）");
		parisAttractions.add("Sacre Couer Basilica（圣坛）");
	}

}
