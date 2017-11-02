<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <link rel='stylesheet' 
        href='${pageContext.servletContext.contextPath}/css/common.css'>
<%--
다음 EL(Expression Language) 문법을 자바 코드를 표현하면,
  ${pageContext.servletContext.contextPath}
  => pageContext.getServletContext().getContextPath()
getContextPath()는 현재 웹애플리케이션의 URL 경로를 리턴한다.
즉 "/web01"을 리턴한다.
 
--%>