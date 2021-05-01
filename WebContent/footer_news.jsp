<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="footer_news">  
  <form name="newsletter_email" method="post" action="LsbServlet?command=newsemail_add">
    RECEIVE OUR NEWSLETTER <input type="text" placeholder="email" name="newsletter_email"/>
     <input type="submit" value="submit"/>
    </form>
</div>
