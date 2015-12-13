function lastNewsTitle() {
    var span = document.getElementById("lastNews");

    function reqListener() {
        console.log(this.responseText);
        span.innerHTML = "Last News: <span class=\"indicator\">"
            + this.responseText
            + "</span>";
    }

    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", reqListener);
    oReq.open("GET", "/lastNews");
    oReq.send();
}

function getLastNewsTitle() {
    var timeout = 5000;
    setInterval("lastNewsTitle()", timeout);
}