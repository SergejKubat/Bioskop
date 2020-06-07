<div>
    <c:forEach var="klub" items="${klubovi}">
        <div class="clearfix">
            <img class="img2" src="${klub.SLIKA_KLUBA}" alt="${klub.KLUB_NAZIV}" width="170" height="170" style="float:left;">
            <p style="margin-left: 1%;">${klub.KLUB_POGODNOSTI}</p>
            <a href="clanstvo?id=${klub.KLUB_ID}" class="card-link"><button class="btn btn-primary">Postani clan</button></a>
        </div>
    </c:forEach>
</div>
