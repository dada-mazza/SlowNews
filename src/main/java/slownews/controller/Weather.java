package slownews.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import slownews.single.NewsSingletone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

@WebServlet("/weather")
public class Weather extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String city = request.getParameter("enterCity");

        if (city == null || city.isEmpty()) {
            city = "Kyiv";
        }

        StringBuilder url = new StringBuilder();
        url.append("http://api.openweathermap.org/data/2.5/weather?q=")
                .append(city)
                .append("&appid=2de143494c0b295cca9337e1e96b00e0&lang=ua&units=metric");

        String responseEntity = ClientBuilder.newClient()
                .target(url.toString())
                .request().get(String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readValue(responseEntity, JsonNode.class);

        System.out.println(node);


        if (node.get("cod").toString().equals("200")) {

            request.setAttribute("weatherCode", true);

            String nameCity = nodeToString(node.get("name"));
            request.setAttribute("city", nameCity);
            String nameCountry = nodeToString(node.get("sys").get("country"));
            request.setAttribute("country", nameCountry);

            String image = nodeToString(node.get("weather").get(0).get("icon"));
            request.setAttribute("image", "http://openweathermap.org/img/w/" + image + ".png");

            String temperature = nodeToString(node.get("main").get("temp"));
            request.setAttribute("temperature", temperature);

            String weatherMain = nodeToString(node.get("weather").get(0).get("main"));
            request.setAttribute("weatherMain", weatherMain);

            String getWeather = new SimpleDateFormat("dd.MM.yyyy HH:mm")
                    .format(new Date(Long.parseLong(nodeToString(node.get("dt"))) * 1000));
            request.setAttribute("getWeather", getWeather);

            String wind = nodeToString(node.get("wind").get("speed"));
            request.setAttribute("wind", wind);

            String cloudiness = nodeToString(node.get("weather").get(0).get("description"));
            request.setAttribute("cloudiness", cloudiness);

            String pressure = nodeToString(node.get("main").get("pressure"));
            request.setAttribute("pressure", pressure);

            String humidity = nodeToString(node.get("main").get("humidity"));
            request.setAttribute("humidity", humidity);

            String sunrise = new SimpleDateFormat("HH:mm")
                    .format(new Date(Long.parseLong(nodeToString(node.get("sys").get("sunrise"))) * 1000));
            request.setAttribute("sunrise", sunrise);

            String sunset = new SimpleDateFormat("HH:mm")
                    .format(new Date(Long.parseLong(nodeToString(node.get("sys").get("sunset"))) * 1000));
            request.setAttribute("sunset", sunset);

            String coord = new StringBuilder()
                    .append("[")
                    .append(nodeToString(node.get("coord").get("lon")))
                    .append(", ")
                    .append(nodeToString(node.get("coord").get("lat")))
                    .append("]")
                    .toString();
            request.setAttribute("coord", coord);
        } else {
            request.setAttribute("weatherCode", false);
            request.setAttribute("errorCity", "City not found");
        }

        request.getRequestDispatcher("/WEB-INF/view/weather.jsp").forward(request, response);
    }


    private String nodeToString(JsonNode node) {
        return node.toString().replaceAll("\"", "");
    }

}
