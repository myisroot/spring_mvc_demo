<html>
<body>
<h2>Hello World!</h2>

    <a href="hello/test/ant"> Test AntPath</a>
    <br>
    <br>
    <a href="hello/testMap"> Test Map</a>
    <br>
    <br>
    <a href="hello/testServletAPI">Test ServletAPI</a>
    <br>
    <br>
    <a href="hello/testSessionAttributes">Test SessionAttributes</a>
    <br>
    <br>
    <a href="hello/testPathVariable/1"> Test PathVariable</a>
    <br>
    <br>
    <%--testCookValue--%>
    <a href="hello/testCookValue"> Test CookValue</a>
    <br>
    <br>
    <a href="hello/testREST/1"> Test GET</a>
    <br>
    <br>
    <a href="hello/testModelAndView"> Test ModelAndView</a>
    <br>
    <br>
    <form action="hello/testREST">
        <input type="submit" value="Test POST">
    </form>
    <br>
    <form action="hello/testREST">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="Test DELETE">
    </form>
    <br>
    <form action="hello/testREST">
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="Test PUT">
    </form>


</body>
</html>
