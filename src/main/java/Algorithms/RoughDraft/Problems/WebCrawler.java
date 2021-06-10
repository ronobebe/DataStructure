package Algorithms.RoughDraft.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

  Queue<String> stringQueue;
  LinkedList<String> visitedList;

  public WebCrawler() {
    this.stringQueue = new LinkedList<>();
    this.visitedList = new LinkedList<>();
  }

  public void getData(String url) {
    crawlWeb(url);
  }

  private void crawlWeb(String url) {
    stringQueue.add(url);
    visitedList.add(url);
    while (!stringQueue.isEmpty()) {
      String actualUrl = stringQueue.poll();
      System.out.println("Web URL is : " + actualUrl);
      matchURLPattern(actualUrl);
    }
  }

  private boolean isAlreadyVisited(String url) {
    for (String s : visitedList) if (s.equals(url)) return false;
    visitedList.add(url);
    return true;
  }

  private void matchURLPattern(String root) {
    String rawHTML = createConnection(root);
    String regex = "https?://(\\w+\\.)*(\\w+)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(rawHTML);
    while (matcher.find()) {
      String find = matcher.group();
      if (isAlreadyVisited(find))
        stringQueue.add(find);
      }
  }

  private String createConnection(String root) {
    StringBuilder rawHTML = new StringBuilder("");

    try {
      URL url = new URL(root);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
      String lines = "";
      while ((lines = bufferedReader.readLine()) != null) {
        rawHTML.append(lines);
      }
      bufferedReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return rawHTML.toString();
  }

  public static void main(String[] args) {
    WebCrawler webCrawler = new WebCrawler();
    webCrawler.crawlWeb("https://www.google.com");
  }
}
