<div class="container">
    <div class="row m-5">

        <c:forEach var="film" items="${filmovi}">
            <div class="col">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="${film.slika}" alt="${film.naziv}">
                    <div class="card-body">
                        <h5 class="card-title">${film.naziv}</h5>
                        <p class="card-text">${film.opis}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">${film.godina}</li>
                    </ul>
                    <div class="card-body">
                        <a href="${film.trejler}" class="card-link">Trejler</a>
                        <a href="film?id=${film.id}" class="card-link">Detalji</a>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>
</div>
