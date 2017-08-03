<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <title>Hello</title>
    <script type="text/javascript" src="/js/index.js"></script>
    <script type="text/javascript" src="/js/loading.js"></script>
    <script type="text/javascript" src="/js/date.js"></script>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/loading.css">
</head>
<body style="margin: 0px;" onload="loadPage();">
    <div id="head" style="z-index: 100; position: fixed; right: 0px; left: 0px; background: #383838; padding: 15px;">
        <div style="text-align: center; color: #fff;">News Aggregator</div>

        <c:forEach items="${rss}" var="element">
            <input type="button" value="${element}" onclick="downloadNews('${element}');">
        </c:forEach>

        <div style="text-align: center;">
            <span style="color: #fff;">Search news by Title</span> <input id="search_text" type="text"> <input type="button" value="Search" onclick="searchNews();">
        </div>
    </div>

    <div id="news" style="z-index: 0; position: absolute; top: 100px;">
        
    </div>

    <div id="loading" style="z-index: 200;">
        <div id="fountainG">
            <div id="fountainG_1" class="fountainG"></div>
            <div id="fountainG_2" class="fountainG"></div>
            <div id="fountainG_3" class="fountainG"></div>
            <div id="fountainG_4" class="fountainG"></div>
            <div id="fountainG_5" class="fountainG"></div>
            <div id="fountainG_6" class="fountainG"></div>
            <div id="fountainG_7" class="fountainG"></div>
            <div id="fountainG_8" class="fountainG"></div>
        </div>
    </div>
</body>
</html>