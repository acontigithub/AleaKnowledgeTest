<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alea Knowledge Test</title>
    </head>
    <body>
        <h1>Alea Knowledge Test</h1>
        <form class="filter-form" method="GET" name="filter" action="${pageContext.request.contextPath}/weight.html">
            <button class="insert-button" type="submit">The 5 heaviest Pokémons</button>
        </form>
        <br>
        <form class="filter-form" method="GET" name="filter" action="${pageContext.request.contextPath}/height.html">
            <button class="insert-button" type="submit">The 5 highest Pokémons</button>
        </form>
        <br>
        <form class="filter-form" method="GET" name="filter" action="${pageContext.request.contextPath}/baseExperience.html">
            <button class="insert-button" type="submit">The 5 Pokémons with more base experience</button>
        </form>
        <br>
        <b style="color:red; font-size: 16px">1st</b>
        <div class="pokemon-div" style="display:inline-block; border: 1px solid black; height:50vh; width:17vw; overflow:auto">
            ${pokemon0}
        </div>
        <b style="color:red; font-size: 16px">2nd</b>
        <div class="pokemon-div" style="display:inline-block; border: 1px solid black; height:50vh; width:17vw; overflow:auto">
            ${pokemon1}
        </div>
        <b style="color:red; font-size: 16px">3rd</b>
        <div class="pokemon-div" style="display:inline-block; border: 1px solid black; height:50vh; width:17vw; overflow:auto">
            ${pokemon2}
        </div>
        <b style="color:red; font-size: 16px">4th</b>
        <div class="pokemon-div" style="display:inline-block; border: 1px solid black; height:50vh; width:17vw; overflow:auto">
            ${pokemon3}
        </div>
        <b style="color:red; font-size: 16px">5th</b>
        <div class="pokemon-div" style="display:inline-block; border: 1px solid black; height:50vh; width:17vw; overflow:auto">
            ${pokemon4}
        </div>
    </body>
</html>
