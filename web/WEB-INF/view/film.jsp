<div class="container">

    <div class="row">

        <div class="col-lg-3">
            <h1 class="my-4">Shop Name</h1>
            <div class="list-group">
                <a href="#" class="list-group-item active">Category 1</a>
                <a href="#" class="list-group-item">Category 2</a>
                <a href="#" class="list-group-item">Category 3</a>
            </div>
        </div>

        <div class="col-lg-9">

            <div class="card mt-4">
                <img class="card-img-top img-fluid" src="${film.slika}" alt="${film.naziv}">
                <div class="card-body">
                    <h3 class="card-title">${film.naziv}</h3>
                    <h5>Godina: ${film.godina}</h5>
                    <p class="card-text">${film.opis}</p>
                    <iframe width="420" height="315"
                            src="${film.trejler}">
                    </iframe>
                </div>
            </div>

        </div>

    </div>

</div>