<div>
    <form action="registracija" method="post" style="margin-left: 40%; margin-top: 5%; margin-bottom: 10%; width: 40%;">
        <h2>${poruka}</h2>
        <div class="form-group">
            <label for="ime">Ime</label>
            <input type="text" class="form-control" id="ime" name="ime" style="width: 40%">
        </div>
        <div class="form-group">
            <label for="prezime">Prezime</label>
            <input type="text" class="form-control" id="prezime" name="prezime" style="width: 40%">
        </div>
        <div class="form-group">
            <label for="email">Email adresa</label>
            <input type="email" class="form-control" id="email" name="email" style="width: 40%">
        </div>
        <div class="form-group">
            <label for="brt">Telefon</label>
            <input type="text" class="form-control" id="password1" name="brt" style="width: 40%">
        </div>
        <div class="form-group">
            <label for="lozinka">Lozinka</label>
            <input type="password" class="form-control" id="password2" name="lozinka" style="width: 40%">
        </div>
        <button type="submit" name="DODAJ" class="btn btn-light btn-lg btn-block" style="width: 30%; text-align: center; margin-left: 5%;"><span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>   Registruj se</button>
    </form>
</div>