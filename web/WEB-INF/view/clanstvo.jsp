<h1>${klub.KLUB_NAZIV}</h1>
<p>Clanarina: ${klub.KLUB_CLANARINA}</p>
<h3>${korisnik.KORISNIK_IME} ${korisnik.KORISNIK_PREZIME}</h3>
<form action="/uclanjenje" method="POST">
    <input type="hidden" name="korisnikId" value="${korisnik.KORISNIK_ID}">
    <input type="hidden" name="klubId" value="${klub.KLUB_ID}">
    <button class="btn btn-light">Uclani se</button>
</form>
