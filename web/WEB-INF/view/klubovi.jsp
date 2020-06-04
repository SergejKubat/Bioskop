<div>
    <c:forEach var="klub" items="${klubovi}">
        <div class="clearfix">
            <img class="img2" src="${klub.klub_naziv}" alt="${k.klub_slika}" width="170" height="170" style="float:left;">
            <p style="margin-left: 1%;">${k.klub_pogodnosti}</p>
            <p style="margin-left: 1%;">${film.clanarina}</p>
            <a href="k?id=${k.klub_id}" class="card-link">Detalji</a>
        </div>
    </c:forEach>
</div>
