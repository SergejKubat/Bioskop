<c:forEach var="bioskop" items="${bioskopi}">
    <h3>${bioskop.BIOSKOP_NAZIV}</h3>
    <p>${bioskop.BIOSKOP_ADRESA}</p>
    <p>${bioskop.BIOSKOP_BR_TEL}</p>
</c:forEach>
