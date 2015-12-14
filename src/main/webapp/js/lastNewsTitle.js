function getLastNewsTitle() {
    var timeout = 5000;
    setInterval(
        function lastNewsTitle() {
            var span = document.getElementById("lastNews");

            function reqListener() {
                // console.log(this.responseText);
                span.innerHTML = "Last News: <span class=\"indicator\">"
                    + this.responseText
                    + "</span>";
            }

            var httpRequest = new XMLHttpRequest();
            httpRequest.addEventListener("load", reqListener);
            httpRequest.open("GET", "/lastNews", true);
            httpRequest.send();
        },
        timeout
    );
}

function getLastNewsTitleViaJQuery() {
    var timeout = 5000;
    setInterval(
        function () {
            // $("#lastNews").load("/lastNews");
            $.ajax({
                url: "/lastNews",
                dataType: "html",
                success: function (data) {
                    $("#lastNews").html("Last News: <span class=\"indicator\">"
                        + data
                        + "</span>")
                }
            });
        },
        timeout
    );
}
