package Algorithms.RoughDraft.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

  Queue<String> queue;
  List<String> visitedSites;

  public WebCrawler() {
    this.queue = new LinkedList<>();
    this.visitedSites = new ArrayList<>();
  }

  private void search(String root) {
    this.queue.add(root);
    this.visitedSites.add(root);
    while (!queue.isEmpty()) {
        String q=queue.remove();
      String rawHTML = readHTML(q);
      String regex = "https?://(\\w+\\.)*(\\w+)";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(rawHTML);

      while (matcher.find())
      {
          String actualURL=matcher.group();
          if(!this.visitedSites.contains(actualURL))
          {
              this.visitedSites.add(actualURL);
              System.out.println("Website is : "+actualURL);
              queue.add(actualURL);
          }
      }
    }
  }

  private String readHTML(String root) {

    String rawHTML = "";
    try {
      URL url = new URL(root);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
      String addLines = "";
      while ((addLines = bufferedReader.readLine()) != null) {
        rawHTML += addLines;
      }
      bufferedReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return rawHTML;
  }

  public static void main(String[] args) {
    WebCrawler webCrawler=new WebCrawler();
    webCrawler.search("https://www.fotmob.com");

  }
}
